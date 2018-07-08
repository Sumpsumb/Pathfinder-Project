package services;

import java.util.List;

import javax.persistence.TypedQuery;

import entities.Skill;

public class SkillService extends GenericService<Skill> {

	public SkillService() {
		super(Skill.class);
	}

	public Skill findSkillByName(String name) {

		TypedQuery<Skill> query = em.createQuery("SELECT s FROM Skill s WHERE s.name LIKE :name", Skill.class);
		query.setParameter("name", name);
		List<Skill> list = query.getResultList();
		return list.get(0);
	}
}
