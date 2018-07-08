package services;

import java.util.List;

import javax.persistence.TypedQuery;

import entities.SpecialAbility;

public class SpecialAbilityService extends GenericService<SpecialAbility> {

	public SpecialAbilityService() {

		super(SpecialAbility.class);
	}

	/**
	 * This method finds all SpecialAbilites belonging to the race String. There is
	 * no validation of race String.
	 * 
	 * @param race
	 * @return
	 */
	public List<SpecialAbility> findAllRaceSkills(String race) {

		if (race.equals("Half Elf")) {
			race = "Half-Elf";
		} else if (race.equals("Half Orc")) {
			race = "Half-Orc";
		}

		TypedQuery<SpecialAbility> query = em.createQuery(
				"SELECT sa FROM SpecialAbility sa WHERE sa.kind = 'race' AND sa.value LIKE :race",
				SpecialAbility.class);
		query.setParameter("race", "%!" + race + "%");

		return query.getResultList();
	}
}
