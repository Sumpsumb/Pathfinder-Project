package services;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import entities.CharacterItem;
import entities.Item;

public class CharacterItemService extends GenericService<CharacterItem> {

	public CharacterItemService() {
		super(CharacterItem.class);
	}

	public CharacterItem findCharacterItemByItem(entities.Character character, Item item) {

		TypedQuery<CharacterItem> query = em.createQuery(
				"SELECT ci FROM CharacterItem ci WHERE ci.character = :character AND ci.item = :item ",
				CharacterItem.class);
		query.setParameter("character", character);
		query.setParameter("item", item);

		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
