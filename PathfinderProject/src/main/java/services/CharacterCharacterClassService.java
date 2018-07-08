package services;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import entities.Character;
import entities.CharacterCharacterClass;

public class CharacterCharacterClassService extends GenericService<CharacterCharacterClass> {

	public CharacterCharacterClassService() {
		super(CharacterCharacterClass.class);
	}

	public CharacterCharacterClass findMainCharacterCharacterClass(Character character) {

		TypedQuery<CharacterCharacterClass> query = em.createQuery(
				"SELECT ccc FROM CharacterCharacterClass ccc WHERE ccc.character = :character AND ccc.isMain LIKE 'Y'",
				CharacterCharacterClass.class);
		query.setParameter("character", character);

		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public CharacterCharacterClass findCharacterCharacterClassByName(Character character, String className) {

		TypedQuery<CharacterCharacterClass> query = em.createQuery(
				"SELECT ccc FROM CharacterCharacterClass ccc WHERE ccc.character = :character AND ccc.characterClass.name = :name",
				CharacterCharacterClass.class);
		query.setParameter("character", character);
		query.setParameter("name", className);

		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
