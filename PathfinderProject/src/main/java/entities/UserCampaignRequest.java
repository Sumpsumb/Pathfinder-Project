package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USER_CAMPAIGN_REQUESTS database table.
 * 
 */
@Entity
@Table(name="USER_CAMPAIGN_REQUESTS")
@NamedQuery(name="UserCampaignRequest.findAll", query="SELECT u FROM UserCampaignRequest u")
public class UserCampaignRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="requester_id")
	private User user;

	//bi-directional many-to-one association to UserCampaign
	@ManyToOne
	@JoinColumn(name="user_campaign_id")
	private UserCampaign userCampaign;

	public UserCampaignRequest() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserCampaign getUserCampaign() {
		return this.userCampaign;
	}

	public void setUserCampaign(UserCampaign userCampaign) {
		this.userCampaign = userCampaign;
	}

}