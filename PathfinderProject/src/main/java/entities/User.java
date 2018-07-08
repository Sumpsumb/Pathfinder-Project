package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name = "USERS")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String email;

	private String name;

	private String password;

	@Transient
	private String passwordVerification;

	private String permission;

	// bi-directional many-to-one association to Campaign
	@OneToMany(mappedBy = "user")
	private List<Campaign> campaigns;

	// bi-directional many-to-one association to Character
	@OneToMany(mappedBy = "user")
	private List<Character> characters;

	// bi-directional many-to-one association to CharacterTransitionDetail
	@OneToMany(mappedBy = "user")
	private List<CharacterTransitionDetail> characterTransitionDetails;

	// bi-directional many-to-one association to UserCampaign
	@OneToMany(mappedBy = "user")
	private List<UserCampaign> userCampaigns;

	// bi-directional many-to-one association to UserCampaignRequest
	@OneToMany(mappedBy = "user")
	private List<UserCampaignRequest> userCampaignRequests;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordVerification() {
		return this.passwordVerification;
	}

	public void setPasswordVerification(String passwordVerification) {
		this.passwordVerification = passwordVerification;
	}

	public String getPermission() {
		return this.permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public List<Campaign> getCampaigns() {
		return this.campaigns;
	}

	public void setCampaigns(List<Campaign> campaigns) {
		this.campaigns = campaigns;
	}

	public Campaign addCampaign(Campaign campaign) {
		getCampaigns().add(campaign);
		campaign.setUser(this);

		return campaign;
	}

	public Campaign removeCampaign(Campaign campaign) {
		getCampaigns().remove(campaign);
		campaign.setUser(null);

		return campaign;
	}

	public List<Character> getCharacters() {
		return this.characters;
	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}

	public Character addCharacter(Character character) {
		getCharacters().add(character);
		character.setUser(this);

		return character;
	}

	public Character removeCharacter(Character character) {
		getCharacters().remove(character);
		character.setUser(null);

		return character;
	}

	public List<CharacterTransitionDetail> getCharacterTransitionDetails() {
		return this.characterTransitionDetails;
	}

	public void setCharacterTransitionDetails(List<CharacterTransitionDetail> characterTransitionDetails) {
		this.characterTransitionDetails = characterTransitionDetails;
	}

	public CharacterTransitionDetail addCharacterTransitionDetail(CharacterTransitionDetail characterTransitionDetail) {
		getCharacterTransitionDetails().add(characterTransitionDetail);
		characterTransitionDetail.setUser(this);

		return characterTransitionDetail;
	}

	public CharacterTransitionDetail removeCharacterTransitionDetail(
			CharacterTransitionDetail characterTransitionDetail) {
		getCharacterTransitionDetails().remove(characterTransitionDetail);
		characterTransitionDetail.setUser(null);

		return characterTransitionDetail;
	}

	public List<UserCampaign> getUserCampaigns() {
		return this.userCampaigns;
	}

	public void setUserCampaigns(List<UserCampaign> userCampaigns) {
		this.userCampaigns = userCampaigns;
	}

	public UserCampaign addUserCampaign(UserCampaign userCampaign) {
		getUserCampaigns().add(userCampaign);
		userCampaign.setUser(this);

		return userCampaign;
	}

	public UserCampaign removeUserCampaign(UserCampaign userCampaign) {
		getUserCampaigns().remove(userCampaign);
		userCampaign.setUser(null);

		return userCampaign;
	}

	public List<UserCampaignRequest> getUserCampaignRequests() {
		return this.userCampaignRequests;
	}

	public void setUserCampaignRequests(List<UserCampaignRequest> userCampaignRequests) {
		this.userCampaignRequests = userCampaignRequests;
	}

	public UserCampaignRequest addUserCampaignRequest(UserCampaignRequest userCampaignRequest) {
		getUserCampaignRequests().add(userCampaignRequest);
		userCampaignRequest.setUser(this);

		return userCampaignRequest;
	}

	public UserCampaignRequest removeUserCampaignRequest(UserCampaignRequest userCampaignRequest) {
		getUserCampaignRequests().remove(userCampaignRequest);
		userCampaignRequest.setUser(null);

		return userCampaignRequest;
	}

}