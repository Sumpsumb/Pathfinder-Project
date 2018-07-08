package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the USER_CAMPAIGNS database table.
 * 
 */
@Entity
@Table(name="USER_CAMPAIGNS")
@NamedQuery(name="UserCampaign.findAll", query="SELECT u FROM UserCampaign u")
public class UserCampaign implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String role;

	//bi-directional many-to-one association to Campaign
	@ManyToOne
	private Campaign campaign;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-one association to UserCampaignRequest
	@OneToMany(mappedBy="userCampaign")
	private List<UserCampaignRequest> userCampaignRequests;

	public UserCampaign() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Campaign getCampaign() {
		return this.campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<UserCampaignRequest> getUserCampaignRequests() {
		return this.userCampaignRequests;
	}

	public void setUserCampaignRequests(List<UserCampaignRequest> userCampaignRequests) {
		this.userCampaignRequests = userCampaignRequests;
	}

	public UserCampaignRequest addUserCampaignRequest(UserCampaignRequest userCampaignRequest) {
		getUserCampaignRequests().add(userCampaignRequest);
		userCampaignRequest.setUserCampaign(this);

		return userCampaignRequest;
	}

	public UserCampaignRequest removeUserCampaignRequest(UserCampaignRequest userCampaignRequest) {
		getUserCampaignRequests().remove(userCampaignRequest);
		userCampaignRequest.setUserCampaign(null);

		return userCampaignRequest;
	}

}