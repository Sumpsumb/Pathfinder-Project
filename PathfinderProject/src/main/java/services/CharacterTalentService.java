package services;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import entities.Character;
import entities.CharacterTalent;
import entities.Talent;

public class CharacterTalentService extends GenericService<CharacterTalent> {

	public CharacterTalentService() {
		super(CharacterTalent.class);
	}

	public boolean knowsTalent(Character character, Talent talent) {

		CharacterTalent characterTalent;

		TypedQuery<CharacterTalent> query = em.createQuery(
				"SELECT ct FROM CharacterTalent ct WHERE ct.character = :character AND ct.talent = :talent",
				CharacterTalent.class);
		query.setParameter("character", character);
		query.setParameter("talent", talent);
		try {
			characterTalent = query.getSingleResult();
		} catch (NoResultException e) {
			characterTalent = null;
		}

		if (characterTalent != null) {
			return true;
		} else {
			return false;
		}
	}
}
