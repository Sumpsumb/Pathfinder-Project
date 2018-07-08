package services;

import java.util.List;

import javax.persistence.TypedQuery;

import entities.Campaign;

public class CampaignService extends GenericService<Campaign> {

	public CampaignService() {
		super(Campaign.class);
	}

	// TODO:Update method
	public void createNewCampaign(String campaignName, String fantasyLevel) {

		Campaign campaign = new Campaign();
		campaign.setName(campaignName);
		campaign.setFantasyLevel(fantasyLevel);

		// String dateString = "01/01/1000";
		// SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		// java.util.Date date = new java.util.Date();
		// try {
		// date = simpleDateFormat.parse(dateString);
		// } catch (ParseException e) {
		// e.printStackTrace();
		// }
		//
		// Time time = new Time(0);
		//
		// campaign.setDate(date);
		// campaign.setTime(time);

		create(campaign);
	}

	public List<Campaign> findAllPublishedCampaigns() {

		TypedQuery<Campaign> query = em.createQuery("SELECT c FROM Campaign c WHERE c.isPublished = 'Y'",
				Campaign.class);

		return query.getResultList();
	}
}
