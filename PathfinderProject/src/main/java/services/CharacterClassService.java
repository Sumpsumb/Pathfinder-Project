package services;

import javax.persistence.TypedQuery;

import entities.CharacterClass;

public class CharacterClassService extends GenericService<CharacterClass> {

	public CharacterClassService() {
		super(CharacterClass.class);
	}

	public CharacterClass findCharacterClassByName(String characterClassName) {

		TypedQuery<CharacterClass> query = em.createQuery("SELECT cc FROM CharacterClass cc WHERE cc.name LIKE :name",
				CharacterClass.class);
		query.setParameter("name", characterClassName);
		return query.getSingleResult();
	}
}
