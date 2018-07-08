package org.rahner.validation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.rahner.info.CharacterInfo;

import entities.Campaign;
import entities.Character;
import entities.CharacterSkill;
import entities.User;
import services.CampaignService;
import services.CharacterSkillService;
import services.ItemService;
import services.UserCampaignService;
import services.UserService;

public class Validation {

	private static EntityManagerFactory entityManagerFactory = javax.persistence.Persistence
			.createEntityManagerFactory("PathfinderProject");

	private static EntityManager entityManager = entityManagerFactory.createEntityManager();

	public static boolean rankEqualsTotLvl(Character character, String skillName) {

		CharacterSkillService characterSkillService = new CharacterSkillService();
		characterSkillService.setEm(entityManager);

		CharacterSkill characterSkill = characterSkillService.findCharacterSkillForCharacterAndName(character,
				skillName);

		if (character.getTotLevel() == characterSkill.getRang()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean verifyPassword(String pw, String pwv) {

		if (pw.equals(pwv)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean usernameInDatabase(String username) {

		UserService userService = new UserService();
		userService.setEm(entityManager);

		if (userService.findOneByName(username) == null) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean passwordMatchingUsernamme(String username, String password) {

		UserService us = new UserService();
		us.setEm(entityManager);

		if (us.findOneByName(username).getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean allEnhancementPointsConsumed(int STR, int DEX, int CON, int INT, int WIS, int CHA,
			int enhancementPoints) {

		if (STR + DEX + CON + INT + WIS + CHA - 60 == enhancementPoints) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean characterHasEnoughMoneyToBuy(int itemId, Character character, int amount) {

		ItemService itemService = new ItemService();
		itemService.setEm(entityManager);

		if (itemService.findOne(itemId).getPrize() * amount > character.getMoney()) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean emailIsVerified(User user) {

		UserService userService = new UserService();
		userService.setEm(entityManager);
		User dbUser = userService.findOneByName(user.getName());
		entityManager.refresh(dbUser);

		if (dbUser.getPermission() != null
				&& (dbUser.getPermission().equals("U") || dbUser.getPermission().equals("A"))) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean userIsNotGmOfUserCampaign(int userId, String campaignId) {

		CampaignService campaignService = new CampaignService();
		campaignService.setEm(entityManager);
		// TODO:Finish method
		// Campaign campaign = campaignService.findOne(primaryKey)

		return true;
	}

	public static boolean userHasAlreadyThatUserCampaign(User user, Campaign campaign) {

		UserCampaignService userCampaignService = new UserCampaignService();
		userCampaignService.setEm(entityManager);

		return userCampaignService.campaignBelongsToUser(user, campaign);

	}

	/**
	 * This method checks whether this Character has enough experience for level up
	 * 
	 * @param character
	 * @return
	 */

	public static boolean isReadyForLevelUp(Character character) {

		int nextLvl = character.getTotLevel() + 1;

		if (character.getExperience() >= CharacterInfo.getRequiredExpForLevel(nextLvl,
				character.getCampaign().getLevelUpSpeed())) {
			return true;
		} else {
			return false;
		}
	}
}
