package org.rahner.maintain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.rahner.exceptions.CharacterInfoException;
import org.rahner.exceptions.CharacterMaintainanceException;
import org.rahner.exceptions.CharacterNotInDbException;
import org.rahner.exceptions.ItemNotInDatabaseException;
import org.rahner.exceptions.NotEnoughItemsException;
import org.rahner.exceptions.ProcessTalentException;
import org.rahner.exceptions.TalentAlreadyKnownException;
import org.rahner.exceptions.TalentConditionException;
import org.rahner.exceptions.TalentNotInDbException;
import org.rahner.info.AttributeInfo;
import org.rahner.info.CharacterClassInfo;
import org.rahner.info.CharacterInfo;
import org.rahner.info.RaceInfo;
import org.rahner.validation.Validation;

import entities.Character;
import entities.CharacterCharacterClass;
import entities.CharacterItem;
import entities.CharacterLanguage;
import entities.CharacterSkill;
import entities.CharacterSpecialAbility;
import entities.CharacterTalent;
import entities.CharacterTransitionDetail;
import entities.CombatStat;
import entities.Item;
import entities.Language;
import entities.Skill;
import entities.SpecialAbility;
import entities.Status;
import entities.Talent;
import entities.TalentCondition;
import services.CampaignService;
import services.CharacterCharacterClassService;
import services.CharacterClassService;
import services.CharacterItemService;
import services.CharacterLanguageService;
import services.CharacterService;
import services.CharacterSkillService;
import services.CharacterSpecialAbilityService;
import services.CharacterTalentService;
import services.CharacterTransitionDetailsService;
import services.CombatStatsService;
import services.ItemService;
import services.SkillService;
import services.TalentService;
import services.UserCampaignService;
import services.UserService;

public class CharacterMaintanance {

	private EntityManagerFactory entityManagerFactory;

	private EntityManager entityManager;

	private CharacterService characterService;

	private CharacterTalentService characterTalentService;

	private CharacterItemService characterItemService;

	private Character character;

	private Skill skill;

	private Talent talent;

	private TalentService talentService;

	private Item item;

	private ItemService itemService;

	private Status status;

	public CharacterMaintanance() {
		this.entityManagerFactory = javax.persistence.Persistence.createEntityManagerFactory("PathfinderProject");
		this.entityManager = entityManagerFactory.createEntityManager();
		this.characterService = new CharacterService();
		this.characterService.setEm(entityManager);
	}

	public CharacterMaintanance(Character dbCharacter) throws CharacterNotInDbException, TalentNotInDbException,
			TalentAlreadyKnownException, TalentConditionException, ProcessTalentException, ItemNotInDatabaseException,
			CharacterMaintainanceException, NotEnoughItemsException {

		this.entityManagerFactory = javax.persistence.Persistence.createEntityManagerFactory("PathfinderProject");
		this.entityManager = entityManagerFactory.createEntityManager();
		this.characterService = new CharacterService();
		this.characterService.setEm(entityManager);
		this.character = characterService.findCharacterByName(dbCharacter.getName());
		if (character == null) {
			throw new CharacterNotInDbException();
		}
	}

	public CharacterMaintanance(String characterName) throws CharacterNotInDbException {

		this.entityManagerFactory = javax.persistence.Persistence.createEntityManagerFactory("PathfinderProject");
		this.entityManager = entityManagerFactory.createEntityManager();
		this.characterService = new CharacterService();
		this.characterService.setEm(entityManager);
		this.character = characterService.findCharacterByName(characterName);
		if (character == null) {
			throw new CharacterNotInDbException();
		}
	}

	public void setCharacter(String characterName) throws CharacterNotInDbException {

		this.character = characterService.findCharacterByName(characterName);
		if (character == null) {
			throw new CharacterNotInDbException();
		}
	}

	public Character createNewCharacter(String characterName, String race, String homeland, String alignment,
			String hair, String eyes, String gender, String deity, int age, String userName, String campaignName,
			String isNpc, double weight, double height) throws CharacterInfoException {

		UserService userService = new UserService();
		userService.setEm(entityManager);

		CampaignService campaignService = new CampaignService();
		campaignService.setEm(entityManager);

		character = new Character();
		character.setTotLevel(1);
		character.setAlignment(alignment);

		if (deity.equals("")) {
			character.setDeity("None");
		} else {
			character.setDeity(deity);
		}
		character.setAge(age);
		character.setHeight(height);
		character.setWeight(weight);
		character.setEye(eyes);
		character.setGender(gender);
		character.setHair(hair);

		if (homeland.equals("")) {
			character.setHomeland("Unknown");
		} else {
			character.setHomeland(homeland);
		}
		character.setInCombat("N");
		character.setInLevelUp("N");
		character.setLevelUpPhase(1);
		character.setIsNpc(isNpc);
		character.setName(characterName);
		character.setRace(race);
		character.setUser(userService.findOneByName(userName));

		UserCampaignService userCampaignService = new UserCampaignService();
		userCampaignService.setEm(entityManager);

		character.setCampaign(userCampaignService
				.findUserCampaignForUser(userService.findOneByName(userName), campaignName).getCampaign());
		characterService.create(character);

		return character;
	}

	public void applyRace(CharacterTransitionDetail characterTransitionDetail) {

		try {
			RaceInfo raceInfo = new RaceInfo(character.getRace());

			// Size
			character.setCharacterSize(raceInfo.getSize());
			characterService.update(character);

			// Speed
			CombatStatsService combatStatsService = new CombatStatsService();
			combatStatsService.setEm(entityManager);

			CombatStat combatStat = new CombatStat();
			combatStat.setSpeedGroundWa(raceInfo.getSpeedGroundInMeters());
			combatStatsService.create(combatStat);

			character.setCombatStat(combatStat);
			characterService.update(character);

			// Languages
			learnNativeLanguages();

			// Special Abilities
			gainRaceSkills();

			// Attributes
			CharacterTransitionDetailsService characterTransitionDetailsService = new CharacterTransitionDetailsService();
			characterTransitionDetailsService.setEm(entityManager);

			CharacterTransitionDetail ctdsToUpdate = characterTransitionDetailsService
					.findOne(characterTransitionDetail.getId());

			ctdsToUpdate.setStr(raceInfo.getStrBonus());
			ctdsToUpdate.setDex(raceInfo.getDexBonus());
			ctdsToUpdate.setCon(raceInfo.getConBonus());
			ctdsToUpdate.setInte(raceInfo.getIntBonus());
			ctdsToUpdate.setWis(raceInfo.getWisBonus());
			ctdsToUpdate.setCha(raceInfo.getChaBonus());

			if (raceInfo.hasRandomAttribute()) {
				ctdsToUpdate.setRandomAttributes(2);
			}

			characterTransitionDetailsService.update(ctdsToUpdate);

		} catch (CharacterInfoException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method links a CharacterClass to a Character and initializes the
	 * CharacterSkills and HP.
	 * 
	 * @param characterClassString
	 */

	public void linkMainCharacterClassToCharacter(String characterClassString) {

		CharacterClassService characterClassService = new CharacterClassService();
		characterClassService.setEm(entityManager);

		CharacterCharacterClassService characterCharacterClassService = new CharacterCharacterClassService();
		characterCharacterClassService.setEm(entityManager);

		CharacterCharacterClass newCharacterCharacterClass = new CharacterCharacterClass();
		newCharacterCharacterClass.setCharacter(character);
		newCharacterCharacterClass.setCharacterClass(characterClassService.findOneByName(characterClassString));
		newCharacterCharacterClass.setLevel(1);
		newCharacterCharacterClass.setIsMain("Y");
		characterCharacterClassService.create(newCharacterCharacterClass);
		initializeSkills();

		CharacterTransitionDetailsService characterTransitionDetailsService = new CharacterTransitionDetailsService();
		characterTransitionDetailsService.setEm(entityManager);
		CharacterClassInfo characterClassInfo = new CharacterClassInfo(characterClassString, 1);

		CharacterTransitionDetail characterTransitionDetail = characterTransitionDetailsService
				.findForUserAndCharacter(character.getUser(), character);
		characterTransitionDetail.setHp(characterClassInfo.getBaseHP());

		AttributeInfo attributeInfo = new AttributeInfo();

		if (characterTransitionDetail.getInte() >= 10) {
			characterTransitionDetail.setSkillPoints(characterClassInfo.getBaseAmountOfSkillPointsPerLevel()
					+ attributeInfo.getModi(characterTransitionDetail.getInte()));
		} else {

			characterTransitionDetail.setSkillPoints(characterClassInfo.getBaseAmountOfSkillPointsPerLevel());
		}

		characterTransitionDetail.setTalentPoints(1);

		if (character.getRace().equals("Human")) {
			characterTransitionDetail.setTalentPoints(characterTransitionDetail.getTalentPoints() + 1);
			characterTransitionDetail.setSkillPoints(characterTransitionDetail.getSkillPoints() + 1);
		}
		characterTransitionDetailsService.update(characterTransitionDetail);

	}

	public void gainAttributes(int STR, int DEX, int CON, int INT, int WIS, int CHA) throws CharacterInfoException {

		AttributeInfo attributeInfo = new AttributeInfo();

		character.setStr(STR);
		character.setDex(DEX);
		character.setCon(CON);
		character.setInte(INT);
		character.setWis(WIS);
		character.setCha(CHA);
		character.setSTR_mod(attributeInfo.getModi(STR));
		character.setDEX_mod(attributeInfo.getModi(DEX));
		character.setCON_mod(attributeInfo.getModi(CON));
		character.setINT_mod(attributeInfo.getModi(INT));
		character.setWIS_mod(attributeInfo.getModi(WIS));
		character.setCHA_mod(attributeInfo.getModi(CHA));
		character.setSTR_temp(STR);
		character.setINT_temp(INT);
		character.setDEX_temp(DEX);
		character.setCON_temp(CON);
		character.setWIS_temp(WIS);
		character.setCHA_temp(CHA);
		character.setSTR_temp_mod(attributeInfo.getModi(STR));
		character.setDEX_temp_mod(attributeInfo.getModi(DEX));
		character.setCON_temp_mod(attributeInfo.getModi(CON));
		character.setINT_temp_mod(attributeInfo.getModi(INT));
		character.setWIS_temp_mod(attributeInfo.getModi(WIS));
		character.setCHA_temp_mod(attributeInfo.getModi(CHA));

		characterService.update(character);

	}

	public void learnNativeLanguages() {

		try {
			RaceInfo raceInfo = new RaceInfo(character.getRace());

			for (Language language : raceInfo.getNativeLanguages()) {
				linkLanguageToCharacter(language);
			}

		} catch (CharacterInfoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void linkLanguageToCharacter(Language language) {

		CharacterLanguageService characterLanguageService = new CharacterLanguageService();
		characterLanguageService.setEm(entityManager);

		CharacterLanguage characterLanguage = new CharacterLanguage();

		characterLanguage.setLanguage(language);
		characterLanguage.setCharacter(character);
		characterLanguageService.create(characterLanguage);
	}

	/**
	 * 
	 * This method is checking whether an characterSkill is already linked to the
	 * character and has at least one rank. It returns the id of the corresponding
	 * characterSkill. If the skill does not fulfill the check it returns 0.
	 * 
	 * @param skillName
	 * @return
	 */

	private int alreadyLearned(String skillName) {

		for (CharacterSkill characterSkill : this.character.getCharacterSkills()) {
			if (characterSkill.getSkill().getName().equals(skillName) && characterSkill.getRang() != 0) {
				return characterSkill.getId();
			}
		}
		return 0;
	}

	/**
	 * This method checks whether the skill is already linked to the character. It
	 * returns the characterSkillId. It returns 0 if its not linked.
	 * 
	 * @param skillName
	 * @return
	 */

	private int allreadyKnows(String skillName) {

		for (CharacterSkill characterSkill : this.character.getCharacterSkills()) {
			if (characterSkill.getSkill().getName().equals(skillName)) {
				return characterSkill.getId();
			}
		}
		return 0;
	}

	public void learnSkill(String skillName) {

		SkillService skillService = new SkillService();
		skillService.setEm(entityManager);
		this.skill = skillService.findSkillByName(skillName);

		int skillId = alreadyLearned(skillName);

		if (skillId != 0) {
			improveSkill(skillName, skillId);
		} else if (allreadyKnows(skillName) == 0) {
			CharacterSkill newCharacterSkill = new CharacterSkill();
			newCharacterSkill.setCharacter(character);
			newCharacterSkill.setSkill(skill);
			newCharacterSkill.setRang(1);

			List<CharacterCharacterClass> characterCharacterClasses = character.getCharacterCharacterClasses();
			ArrayList<String> characterClasses = new ArrayList<String>();

			for (CharacterCharacterClass characterCharacterClass : characterCharacterClasses) {
				characterClasses.add(characterCharacterClass.getCharacterClass().getName());
			}

			for (String className : characterClasses) {

				CharacterClassInfo characterClassInfo = new CharacterClassInfo(className, 1);

				if (characterClassInfo.getClassSkills().contains(skill.getName())) {
					newCharacterSkill.setIsClassSkill("Y");
				}
			}

			if (newCharacterSkill.getIsClassSkill() == null) {
				newCharacterSkill.setIsClassSkill("N");
			}

			int modValue = 0;

			if (skill.getPrimaryAttribute().equals("STR")) {
				modValue = character.getSTR_mod();
			} else if (skill.getPrimaryAttribute().equals("DEX")) {
				modValue = character.getDEX_mod();
			} else if (skill.getPrimaryAttribute().equals("CON")) {
				modValue = character.getCON_mod();
			} else if (skill.getPrimaryAttribute().equals("INT")) {
				modValue = character.getINT_mod();
			} else if (skill.getPrimaryAttribute().equals("WIS")) {
				modValue = character.getWIS_mod();
			} else if (skill.getPrimaryAttribute().equals("CHA")) {
				modValue = character.getCHA_mod();
			}

			if (newCharacterSkill.getIsClassSkill().equals("Y")) {
				newCharacterSkill.setFullBonus(newCharacterSkill.getRang() + 3 + modValue);
				newCharacterSkill.setOtherMod(newCharacterSkill.getOtherMod() + 3);
			} else {
				newCharacterSkill.setFullBonus(newCharacterSkill.getRang() + modValue);
			}

			CharacterSkillService characterSkillService = new CharacterSkillService();
			characterSkillService.setEm(entityManager);
			characterSkillService.create(newCharacterSkill);
		} else {

			CharacterSkillService characterSkillService = new CharacterSkillService();
			characterSkillService.setEm(entityManager);

			CharacterSkill characterSkillToUpdate = characterSkillService.findOne(allreadyKnows(skillName));
			characterSkillToUpdate.setRang(1);

			if (characterSkillToUpdate.getIsClassSkill().equals("Y")) {
				characterSkillToUpdate.setFullBonus(characterSkillToUpdate.getFullBonus() + 4);
				characterSkillToUpdate.setOtherMod(characterSkillToUpdate.getOtherMod() + 3);
			} else {
				characterSkillToUpdate.setFullBonus(characterSkillToUpdate.getFullBonus() + 1);
			}

			characterSkillService.update(characterSkillToUpdate);
		}
	}

	private void improveSkill(String skillName, int characterSkillId) {

		CharacterSkillService characterSkillService = new CharacterSkillService();
		characterSkillService.setEm(entityManager);

		CharacterSkill characterSkillToImprove = characterSkillService.findOne(characterSkillId);
		characterSkillToImprove.setRang(characterSkillToImprove.getRang() + 1);
		characterSkillToImprove.setFullBonus(characterSkillToImprove.getFullBonus() + 1);
		characterSkillService.update(characterSkillToImprove);
	}

	private void gainRaceSkills() {

		try {
			RaceInfo raceInfo = new RaceInfo(character.getRace());
			for (SpecialAbility specialAbility : raceInfo.getRaceSkills()) {
				linkSpecialAbilityToCharacter(specialAbility);
			}

		} catch (CharacterInfoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// TODO: implementieren
	private void applyRaceSkillAction(SpecialAbility raceSkill) {

		if (raceSkill.getTrig().equals("instantly")) {

			if (raceSkill.getName().equals("")) {

			}
		}
	}

	/**
	 * This method links an instance of SpecialAbility to a Character. <Strong>There
	 * is no validation</Strong>
	 * 
	 * @param specialAbility
	 */

	private void linkSpecialAbilityToCharacter(SpecialAbility specialAbility) {

		CharacterSpecialAbilityService characterSpecialAbilityService = new CharacterSpecialAbilityService();
		characterSpecialAbilityService.setEm(entityManager);

		CharacterSpecialAbility characterSpecialAbility = new CharacterSpecialAbility();
		characterSpecialAbility.setCharacter(character);
		characterSpecialAbility.setSpecialAbility(specialAbility);
		characterSpecialAbilityService.create(characterSpecialAbility);
	}

	public void learnTalent(int talentId) throws TalentNotInDbException, TalentAlreadyKnownException,
			TalentConditionException, ProcessTalentException {

		this.talentService = new TalentService();
		talentService.setEm(entityManager);
		this.talent = talentService.findOne(talentId);
		this.characterTalentService = new CharacterTalentService();
		characterTalentService.setEm(entityManager);

		if (talent != null) {

			if (characterTalentService.knowsTalent(character, talent)) {
				throw new TalentAlreadyKnownException("Talent is already known");
			} else {
				if (talent.getTalentConditions().size() == 0) {
					linkTalentToCharacter();
				} else {
					handleTalentConditions();
				}
			}
		} else {
			throw new TalentNotInDbException("Talent not in Database");
		}
	}

	public void goToNextPhase() {

		character.setLevelUpPhase(character.getLevelUpPhase() + 1);
		characterService.update(character);

	}

	private void handleTalentConditions() throws TalentConditionException, ProcessTalentException {

		boolean satisfiesCondition = false;

		for (TalentCondition talentCondition : talent.getTalentConditions()) {

			if (talentCondition.getKind().equals("Total Level: ")) {

				satisfiesCondition = (character.getTotLevel() >= Integer.parseInt(talentCondition.getValue())) ? true
						: false;
				System.out.println("cond 1");
			} else if (talentCondition.getKind().equals("BAB: ")) {

				satisfiesCondition = (character.getCombatStat().getBab1() >= Integer
						.parseInt(talentCondition.getValue())) ? true : false;
				System.out.println("cond 2");

			} else if (talentCondition.getKind().equals("STR: ")) {

				satisfiesCondition = (character.getStr() >= Integer.parseInt(talentCondition.getValue())) ? true
						: false;
				System.out.println("cond 3");

			} else if (talentCondition.getKind().equals("DEX: ")) {

				satisfiesCondition = (character.getDex() >= Integer.parseInt(talentCondition.getValue())) ? true
						: false;
				System.out.println("cond 4");

			} else if (talentCondition.getKind().equals("WIS: ")) {

				satisfiesCondition = (character.getWis() >= Integer.parseInt(talentCondition.getValue())) ? true
						: false;
				System.out.println("cond 5");

			} else if (talentCondition.getKind().equals("Talent: ")) {

				CharacterTalentService characterTalentService = new CharacterTalentService();
				characterTalentService.setEm(entityManager);
				satisfiesCondition = characterTalentService.knowsTalent(character,
						talentService.findTalentByName(talentCondition.getValue()));
				System.out.println("cond 6");

			} else {
				throw new TalentConditionException("Unknown Talent Condition");
			}
			if (satisfiesCondition == false) {

				break;
			}
		}

		if (satisfiesCondition == true) {
			linkTalentToCharacter();
		} else {
			System.out.println("DARF ER NICH AETSCH");
		}
	}

	private void linkTalentToCharacter() throws ProcessTalentException {

		CharacterTalent characterTalentToLearn = new CharacterTalent();
		characterTalentToLearn.setCharacter(character);
		characterTalentToLearn.setTalent(talent);
		characterTalentService.create(characterTalentToLearn);

		if (talent.getAppearsAt().contains("instantly")) {
			processTalent(characterTalentToLearn);
		}

		System.out.println("link yea");
	}

	private void processTalent(CharacterTalent characterTalentToProcess) throws ProcessTalentException {

		if (talent.getName().equals("Abhärtung")) { // talent_id = 1

			if (character.getTotLevel() == 1 || character.getTotLevel() <= 3) {
				character.getCombatStat().setMaxHp(character.getCombatStat().getMaxHp() + 3);
			} else {
				character.getCombatStat().setMaxHp(character.getCombatStat().getMaxHp() + character.getTotLevel() - 1);
			}

			characterService.update(character);
		} else if (talent.getName().equals("Akrobat")) { // talent_id = 2

			CharacterSkillService characterSkillService = new CharacterSkillService();
			characterSkillService.setEm(entityManager);

			for (CharacterSkill characterSkill : character.getCharacterSkills()) {

				if (characterSkill.getSkill().getName().equals("Fly")
						|| characterSkill.getSkill().getName().equals("Acrobatics")) {
					characterSkill.setFullBonus(characterSkill.getFullBonus() + 2);
					characterSkillService.update(characterSkill);
				}
			}
		} else {
			characterTalentService.remove(characterTalentToProcess);
			entityManager.getTransaction().rollback();
			throw new ProcessTalentException("Talent not yet handled");

		}

	}

	public void alterItem(int itemId, int amount)
			throws ItemNotInDatabaseException, CharacterMaintainanceException, NotEnoughItemsException {

		this.itemService = new ItemService();
		this.itemService.setEm(entityManager);
		alterItem(itemService.findOne(itemId).getName(), amount);
	}

	public void buyItem(int itemId, int amount)
			throws ItemNotInDatabaseException, CharacterMaintainanceException, NotEnoughItemsException {

		itemService = new ItemService();
		itemService.setEm(entityManager);
		character.setMoney(character.getMoney() - itemService.findOne(itemId).getPrize() * amount);
		characterService.update(character);
		alterItem(itemId, amount);
	}

	public void alterItem(String itemName, int amount)
			throws ItemNotInDatabaseException, CharacterMaintainanceException, NotEnoughItemsException {

		if (amount == 0) {
			throw new CharacterMaintainanceException("Item amount must not be zero");
		}

		this.itemService = new ItemService();
		this.itemService.setEm(entityManager);
		this.item = itemService.findItemByName(itemName);

		if (this.item == null) {
			throw new ItemNotInDatabaseException();
		}

		this.characterItemService = new CharacterItemService();
		this.characterItemService.setEm(entityManager);

		CharacterItem characterItemToAlter = characterItemService.findCharacterItemByItem(character, item);

		if (characterItemToAlter == null && amount > 0) {

			CharacterItem newCharacterItemToReceive = new CharacterItem();
			newCharacterItemToReceive.setAmount(amount);
			newCharacterItemToReceive.setCharacter(character);
			newCharacterItemToReceive.setItem(item);
			if (item.getIsCommon().equals("Y")) {
				newCharacterItemToReceive.setEstimatedPrize(item.getPrize());
			}
			characterItemService.create(newCharacterItemToReceive);
		} else if (characterItemToAlter != null && amount > 0) {

			characterItemToAlter.setAmount(characterItemToAlter.getAmount() + amount);
			characterItemService.update(characterItemToAlter);
		} else if (characterItemToAlter == null && amount < 0) {

			throw new NotEnoughItemsException("No item found to remove");

		} else if (characterItemToAlter != null && amount < 0) {

			if ((amount + characterItemToAlter.getAmount()) >= 0) {
				if (Math.abs(amount) == characterItemToAlter.getAmount()) {

					characterItemService.remove(characterItemToAlter);

				} else {

					characterItemToAlter.setAmount(characterItemToAlter.getAmount() + amount);
					characterItemService.update(characterItemToAlter);

				}

			} else {

				throw new NotEnoughItemsException("Not enough items found to remove");
			}
		}

		processWeight(amount);
	}

	private void processWeight(int amount) {

		character.setTotWeight((character.getTotWeight() + amount * item.getWeight()));
		characterService.update(character);
	}

	private void updatePayloadValues(int str) {

		CharacterInfo characterInfo = new CharacterInfo();
		int[] payloadInfo = characterInfo.getPayload(str);

		character.setLl(payloadInfo[0]);
		character.setMl(payloadInfo[1]);
		character.setHl(payloadInfo[2]);
		character.setLoh(payloadInfo[3]);
		character.setLog(payloadInfo[4]);
		character.setDop(payloadInfo[5]);
		characterService.update(character);
	}

	public void setRandomAge(CharacterCharacterClass characterCharacterClass) throws CharacterInfoException {

		RaceInfo raceInfo = new RaceInfo(character.getRace());
		character.setAge(raceInfo.getAge(characterCharacterClass.getCharacterClass().getName()));
		characterService.update(character);
	}

	public void setRandomHeightAndWeight() throws CharacterInfoException {

		RaceInfo raceInfo = new RaceInfo(character.getRace());
		double[] heightAndWeight = raceInfo.getHeightAndWeight(character.getGender());
		character.setHeight(heightAndWeight[0]);
		character.setWeight(heightAndWeight[1]);
		characterService.update(character);
	}

	public void initiateMoney() throws CharacterInfoException {

		CharacterCharacterClassService cccs = new CharacterCharacterClassService();
		cccs.setEm(entityManager);

		CharacterClassInfo characterClassInfo = new CharacterClassInfo(
				cccs.findMainCharacterCharacterClass(character).getCharacterClass().getName(), 1);
		character.setMoney(characterClassInfo.getStartMoneyInGold() * 100);
		characterService.update(character);
	}

	public void initateHp() {

		CombatStatsService combatStatsService = new CombatStatsService();
		combatStatsService.setEm(entityManager);
		CombatStat combatStat = combatStatsService.findOne(character.getCombatStat().getId());

		CharacterCharacterClassService characterCharacterClassService = new CharacterCharacterClassService();
		characterCharacterClassService.setEm(entityManager);

		CharacterClassInfo characterClassInfo = new CharacterClassInfo(
				characterCharacterClassService.findMainCharacterCharacterClass(character).getCharacterClass().getName(),
				1);

		combatStat.setMaxHp(characterClassInfo.getBaseHP());
		combatStatsService.update(combatStat);

	}

	public void updateBABWilRefFor(String characterClassString) {

		CombatStatsService combatStatsService = new CombatStatsService();
		CharacterCharacterClassService cccs = new CharacterCharacterClassService();
		cccs.setEm(entityManager);
		combatStatsService.setEm(entityManager);

		CombatStat combatStat = combatStatsService.findOne(character.getCombatStat().getId());

		CharacterClassInfo characterClassInfo = new CharacterClassInfo(characterClassString,
				cccs.findCharacterCharacterClassByName(character, characterClassString).getLevel());

		int[] BAB = characterClassInfo.getBAB();

		combatStat.setBab1(combatStat.getBab1() + BAB[0]);
		combatStat.setBab2(combatStat.getBab2() + BAB[1]);
		combatStat.setBab3(combatStat.getBab3() + BAB[2]);
		combatStat.setBab4(combatStat.getBab4() + BAB[3]);
		combatStat.setReflex(combatStat.getReflex() + characterClassInfo.getReflex());
		combatStat.setWill(combatStat.getWill() + characterClassInfo.getWill());
		combatStat.setFortitude(combatStat.getFortitude() + characterClassInfo.getFortitude());

		combatStatsService.update(combatStat);
	}

	private void initializeSkills() {

		SkillService skillService = new SkillService();
		skillService.setEm(entityManager);

		CharacterSkillService characterSkillService = new CharacterSkillService();
		characterSkillService.setEm(entityManager);

		for (Skill skill : skillService.findAll()) {

			CharacterSkill newCharacterSkill = new CharacterSkill();

			if (skill.getTrainedOnly().equals("Y")) {

				newCharacterSkill.setCharacter(character);
				newCharacterSkill.setSkill(skill);

				newCharacterSkill.setOtherMod(0);
				newCharacterSkill.setRang(0);

				int modValue = getAttributeModValue(skill);

				newCharacterSkill.setAttributeMod(modValue);
				newCharacterSkill.setFullBonus(modValue);

				for (CharacterCharacterClass characterCharacterClass : character.getCharacterCharacterClasses()) {
					CharacterClassInfo characterClassInfo = new CharacterClassInfo(
							characterCharacterClass.getCharacterClass().getName(), 1);

					if (characterClassInfo.getClassSkills().contains(skill.getName())) {
						newCharacterSkill.setIsClassSkill("Y");
					} else {
						newCharacterSkill.setIsClassSkill("N");
					}
				}
				characterSkillService.create(newCharacterSkill);
				continue;
			}

			newCharacterSkill.setCharacter(character);
			newCharacterSkill.setSkill(skill);
			newCharacterSkill.setRang(0);

			for (CharacterCharacterClass characterCharacterClass : character.getCharacterCharacterClasses()) {
				CharacterClassInfo characterClassInfo = new CharacterClassInfo(
						characterCharacterClass.getCharacterClass().getName(), 1);

				if (characterClassInfo.getClassSkills().contains(skill.getName())) {
					newCharacterSkill.setIsClassSkill("Y");
				} else {
					newCharacterSkill.setIsClassSkill("N");
				}
			}

			int modValue = getAttributeModValue(skill);

			newCharacterSkill.setFullBonus(modValue);
			newCharacterSkill.setAttributeMod(modValue);
			characterSkillService.create(newCharacterSkill);
		}

	}

	/**
	 * This method returns a characters attribute mod value for a given Skill
	 * 
	 * @param skill
	 *            no validation of Skill
	 * @return
	 */

	private int getAttributeModValue(Skill skill) {

		int modValue = 0;

		if (skill.getPrimaryAttribute().equals("STR")) {
			modValue = character.getSTR_mod();
		} else if (skill.getPrimaryAttribute().equals("DEX")) {
			modValue = character.getDEX_mod();
		} else if (skill.getPrimaryAttribute().equals("CON")) {
			modValue = character.getCON_mod();
		} else if (skill.getPrimaryAttribute().equals("INT")) {
			modValue = character.getINT_mod();
		} else if (skill.getPrimaryAttribute().equals("WIS")) {
			modValue = character.getWIS_mod();
		} else if (skill.getPrimaryAttribute().equals("CHA")) {
			modValue = character.getCHA_mod();
		}

		return modValue;
	}

	/**
	 * This method adds experience to this character. It will also check if the
	 * character is ready for level up:
	 * <p>
	 * It will set <Strong>inLevelUp</Strong> to 'Y' and
	 * <Strong>levelUpPhase</Strong> to -1 if necessary
	 * 
	 * @param experience
	 */

	public void addExperienceToCharacter(int experience) {

		character.setExperience(character.getExperience() + experience);

		if (Validation.isReadyForLevelUp(character)) {
			character.setInLevelUp("Y");
			character.setLevelUpPhase(-1);
		}
		characterService.update(character);
	}
}
