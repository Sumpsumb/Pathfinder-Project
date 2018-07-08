package services;

import javax.persistence.EntityManager;

import entities.Group;

public class GroupService extends GenericService<Group> {
	public GroupService() {
		super(Group.class);
	}

	public GroupService(EntityManager entityManager) {
		super(Group.class, entityManager);
	}
}
