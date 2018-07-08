package services;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import entities.Talent;

public class TalentService extends GenericService<Talent> {

	public TalentService() {
		super(Talent.class);
	}

	public Talent findTalentByName(String talentName) {

		TypedQuery<Talent> query = em.createQuery("SELECT t FROM Talent t WHERE t.name LIKE :name", Talent.class);
		query.setParameter("name", talentName);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
