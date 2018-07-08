package services;

import javax.persistence.EntityManager;

import entities.User;

public class UserService extends GenericService<User> {

	public UserService() {
		super(User.class);
	}

	public UserService(EntityManager entityManager) {
		super(User.class, entityManager);
	}
}
