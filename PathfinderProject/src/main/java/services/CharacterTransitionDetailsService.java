package services;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import entities.Character;
import entities.CharacterTransitionDetail;
import entities.User;

public class CharacterTransitionDetailsService extends GenericService<CharacterTransitionDetail> {

	public CharacterTransitionDetailsService() {

		super(CharacterTransitionDetail.class);
	}

	public void setAttributes(CharacterTransitionDetail characterTransitionDetail, String STR, String DEX, String CON,
			String INT, String WIS, String CHA) {

		characterTransitionDetail.setStr(Integer.parseInt(STR));
		characterTransitionDetail.setDex(Integer.parseInt(DEX));
		characterTransitionDetail.setCon(Integer.parseInt(CON));
		characterTransitionDetail.setInte(Integer.parseInt(INT));
		characterTransitionDetail.setWis(Integer.parseInt(WIS));
		characterTransitionDetail.setCha(Integer.parseInt(CHA));
	}

	public CharacterTransitionDetail findForUserAndCharacter(User user, Character character) {

		TypedQuery<CharacterTransitionDetail> query = em.createQuery(
				"SELECT ctd FROM CharacterTransitionDetail ctd WHERE ctd.user = :user AND ctd.character = :character",
				CharacterTransitionDetail.class);
		query.setParameter("user", user);
		query.setParameter("character", character);

		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
