package services;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import entities.Campaign;
import entities.User;
import entities.UserCampaign;

public class UserCampaignService extends GenericService<UserCampaign> {

	public UserCampaignService() {

		super(UserCampaign.class);
	}

	public UserCampaignService(EntityManager entityManager) {

		super(UserCampaign.class, entityManager);
	}

	public UserCampaign findUserCampaignForUser(entities.User user, String campaignName) {

		TypedQuery<UserCampaign> query = em.createQuery(
				"SELECT uc FROM UserCampaign uc WHERE uc.user = :user AND uc.campaign.name = :name",
				UserCampaign.class);
		query.setParameter("user", user);
		query.setParameter("name", campaignName);

		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public boolean campaignBelongsToUser(User user, Campaign campaign) {

		TypedQuery<UserCampaign> query = em.createQuery(
				"SELECT uc FROM UserCampaign uc WHERE uc.campaign = :campaign AND uc.user = :user", UserCampaign.class);
		query.setParameter("user", user);
		query.setParameter("campaign", campaign);

		try {
			query.getSingleResult();
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}
}
