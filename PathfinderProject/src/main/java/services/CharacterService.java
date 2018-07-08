package services;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import entities.Character;
import entities.CharacterSkill;
import entities.Skill;

public class CharacterService extends GenericService<entities.Character> {

	public CharacterService() {

		super(entities.Character.class);
	}

	public CharacterService(EntityManager entityManager) {

		super(Character.class, entityManager);
	}

	public Character findCharacterByName(String name) {

		TypedQuery<Character> query = em.createQuery("SELECT c FROM Character c WHERE c.name LIKE :name",
				Character.class);
		query.setParameter("name", name);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public int getBonusOfSkill(String CharacterName, String skillname) {

		CharacterService characterService = new CharacterService();
		characterService.setEm(em);

		SkillService skillService = new SkillService();
		skillService.setEm(em);

		Character dbCharacter = characterService.findCharacterByName(CharacterName);
		Skill dbSkill = skillService.findSkillByName(skillname);

		CharacterSkillService characterSkillService = new CharacterSkillService();
		characterSkillService.setEm(em);

		CharacterSkill characterSkill = characterSkillService.findCharacterSkillByCharacterAndSkill(dbCharacter,
				dbSkill);

		if (characterSkill == null) {
			return 0;
		} else {
			return characterSkill.getFullBonus();
		}
	}
}
