package services;

import java.util.List;

import javax.persistence.TypedQuery;

import entities.RaceLanguage;

public class RaceLanguageService extends GenericService<RaceLanguage> {

	public RaceLanguageService() {
		super(RaceLanguage.class);
	}

	public List<RaceLanguage> findNativeLanguages(String race) {

		TypedQuery<RaceLanguage> query = em.createQuery(
				"SELECT rl FROM RaceLanguage rl WHERE rl.isNative = 'Y' AND rl.race.name = :race", RaceLanguage.class);
		query.setParameter("race", race);
		return query.getResultList();
	}

	public List<RaceLanguage> findIntLanguages(String race) {

		TypedQuery<RaceLanguage> query = em.createQuery(
				"SELECT rl FROM RaceLanguage rl WHERE rl.isNative = 'N' AND rl.race.name = :race", RaceLanguage.class);
		query.setParameter("race", race);
		return query.getResultList();
	}
}
