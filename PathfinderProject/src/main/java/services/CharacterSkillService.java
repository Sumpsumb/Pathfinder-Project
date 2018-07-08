package services;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import entities.Character;
import entities.CharacterSkill;
import entities.Skill;

public class CharacterSkillService extends GenericService<CharacterSkill> {

	public CharacterSkillService() {
		super(CharacterSkill.class);
	}

	public CharacterSkill findCharacterSkillByCharacterAndSkill(Character character, Skill skill) {

		TypedQuery<CharacterSkill> query = em.createQuery(
				"SELECT cs FROM CharacterSkill cs WHERE cs.character = :character AND cs.skill = :skill",
				CharacterSkill.class);
		query.setParameter("character", character);
		query.setParameter("skill", skill);
		return query.getSingleResult();
	}

	public List<CharacterSkill> findAllCharacterSkillsForCharacter(Character character) {

		TypedQuery<CharacterSkill> query = em
				.createQuery("SELECT cs FROM CharacterSkill cs WHERE cs.character = :character", CharacterSkill.class);
		query.setParameter("character", character);
		return query.getResultList();
	}

	public CharacterSkill findCharacterSkillForCharacterAndName(Character character, String skillName) {

		TypedQuery<CharacterSkill> query = em.createQuery(
				"SELECT cs FROM CharacterSkill cs WHERE cs.character = :character AND cs.skill.name = :skillName",
				CharacterSkill.class);
		query.setParameter("skillName", skillName);
		query.setParameter("character", character);

		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
