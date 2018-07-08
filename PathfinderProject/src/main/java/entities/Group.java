package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the GROUPS database table.
 * 
 */
@Entity
@Table(name="GROUPS")
@NamedQuery(name="Group.findAll", query="SELECT g FROM Group g")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="AGL")
	private int agl;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String name;

	@Column(name="number_of_members")
	private int numberOfMembers;

	private Time time;

	//bi-directional many-to-one association to Character
	@OneToMany(mappedBy="group")
	private List<Character> characters;

	//bi-directional many-to-one association to Campaign
	@ManyToOne
	private Campaign campaign;

	//bi-directional many-to-one association to Quest
	@OneToMany(mappedBy="group")
	private List<Quest> quests;

	public Group() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAgl() {
		return this.agl;
	}

	public void setAgl(int agl) {
		this.agl = agl;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfMembers() {
		return this.numberOfMembers;
	}

	public void setNumberOfMembers(int numberOfMembers) {
		this.numberOfMembers = numberOfMembers;
	}

	public Time getTime() {
		return this.time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public List<Character> getCharacters() {
		return this.characters;
	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}

	public Character addCharacter(Character character) {
		getCharacters().add(character);
		character.setGroup(this);

		return character;
	}

	public Character removeCharacter(Character character) {
		getCharacters().remove(character);
		character.setGroup(null);

		return character;
	}

	public Campaign getCampaign() {
		return this.campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public List<Quest> getQuests() {
		return this.quests;
	}

	public void setQuests(List<Quest> quests) {
		this.quests = quests;
	}

	public Quest addQuest(Quest quest) {
		getQuests().add(quest);
		quest.setGroup(this);

		return quest;
	}

	public Quest removeQuest(Quest quest) {
		getQuests().remove(quest);
		quest.setGroup(null);

		return quest;
	}

}