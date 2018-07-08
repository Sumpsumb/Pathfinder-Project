package services;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import entities.Item;

public class ItemService extends GenericService<entities.Item> {

	public ItemService() {

		super(entities.Item.class);
	}

	public Item findItemByName(String name) {

		TypedQuery<Item> query = em.createQuery("SELECT i FROM Item i WHERE i.name LIKE :name", Item.class);
		query.setParameter("name", name);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

	public List<String> findAllCategories() {

		TypedQuery<String> query = em.createQuery("SELECT DISTINCT i.category FROM Item i", String.class);
		return query.getResultList();
	}

	public List<Item> findItemsForCategory(String category) {

		TypedQuery<Item> query = em.createQuery("SELECT i FROM Item i WHERE i.category = :category", Item.class);
		query.setParameter("category", category);
		return query.getResultList();
	}
}
