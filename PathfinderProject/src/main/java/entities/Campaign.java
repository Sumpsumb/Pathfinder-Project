package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the CAMPAIGNS database table.
 * 
 */
@Entity
@Table(name = "CAMPAIGNS")
@NamedQuery(name = "Campaign.findAll", query = "SELECT c FROM Campaign c")
public class Campaign implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "attribute_rule")
	private int attributeRule;

	@Column(name = "fantasy_level")
	private String fantasyLevel;

	@Column(name = "level_up_speed")
	private String levelUpSpeed;

	@Column(name = "is_published")
	private String isPublished;

	private String name;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private User user;

	// bi-directional many-to-one association to Character
	@OneToMany(mappedBy = "campaign")
	private List<Character> characters;

	// bi-directional many-to-one association to Group
	@OneToMany(mappedBy = "campaign")
	private List<Group> groups;

	// bi-directional many-to-one association to Location
	@OneToMany(mappedBy = "campaign")
	private List<Location> locations;

	// bi-directional many-to-one association to UserCampaign
	@OneToMany(mappedBy = "campaign")
	private List<UserCampaign> userCampaigns;

	public Campaign() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAttributeRule() {
		return this.attributeRule;
	}

	public void setAttributeRule(int attributeRule) {
		this.attributeRule = attributeRule;
	}

	public String getFantasyLevel() {
		return this.fantasyLevel;
	}

	public void setFantasyLevel(String fantasyLevel) {
		this.fantasyLevel = fantasyLevel;
	}

	public String getLevelUpSpeed() {
		return this.levelUpSpeed;
	}

	public void setLevelUpSpeed(String levelUpSpeed) {
		this.levelUpSpeed = levelUpSpeed;
	}

	public String getIsPublished() {
		return this.isPublished;
	}

	public void setIsPublished(String isPublished) {
		this.isPublished = isPublished;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Character> getCharacters() {
		return this.characters;
	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}

	public Character addCharacter(Character character) {
		getCharacters().add(character);
		character.setCampaign(this);

		return character;
	}

	public Character removeCharacter(Character character) {
		getCharacters().remove(character);
		character.setCampaign(null);

		return character;
	}

	public List<Group> getGroups() {
		return this.groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public Group addGroup(Group group) {
		getGroups().add(group);
		group.setCampaign(this);

		return group;
	}

	public Group removeGroup(Group group) {
		getGroups().remove(group);
		group.setCampaign(null);

		return group;
	}

	public List<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public Location addLocation(Location location) {
		getLocations().add(location);
		location.setCampaign(this);

		return location;
	}

	public Location removeLocation(Location location) {
		getLocations().remove(location);
		location.setCampaign(null);

		return location;
	}

	public List<UserCampaign> getUserCampaigns() {
		return this.userCampaigns;
	}

	public void setUserCampaigns(List<UserCampaign> userCampaigns) {
		this.userCampaigns = userCampaigns;
	}

	public UserCampaign addUserCampaign(UserCampaign userCampaign) {
		getUserCampaigns().add(userCampaign);
		userCampaign.setCampaign(this);

		return userCampaign;
	}

	public UserCampaign removeUserCampaign(UserCampaign userCampaign) {
		getUserCampaigns().remove(userCampaign);
		userCampaign.setCampaign(null);

		return userCampaign;
	}

}