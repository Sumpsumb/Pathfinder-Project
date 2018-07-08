package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CHARACTER_TRANSITION_DETAILS database table.
 * 
 */
@Entity
@Table(name="CHARACTER_TRANSITION_DETAILS")
@NamedQuery(name="CharacterTransitionDetail.findAll", query="SELECT c FROM CharacterTransitionDetail c")
public class CharacterTransitionDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="CHA")
	private int cha;

	@Column(name="CON")
	private int con;

	@Column(name="DEX")
	private int dex;

	@Column(name="HP")
	private int hp;

	@Column(name="INTE")
	private int inte;

	@Column(name="random_0_spells")
	private int random0Spells;

	@Column(name="random_1_spells")
	private int random1Spells;

	@Column(name="random_2_spells")
	private int random2Spells;

	@Column(name="random_3_spells")
	private int random3Spells;

	@Column(name="random_4_spells")
	private int random4Spells;

	@Column(name="random_5_spells")
	private int random5Spells;

	@Column(name="random_6_spells")
	private int random6Spells;

	@Column(name="random_7_spells")
	private int random7Spells;

	@Column(name="random_8_spells")
	private int random8Spells;

	@Column(name="random_9_spells")
	private int random9Spells;

	@Column(name="random_attributes")
	private int randomAttributes;

	@Column(name="skill_points")
	private int skillPoints;

	@Column(name="STR")
	private int str;

	@Column(name="talent_points")
	private int talentPoints;

	@Column(name="WIS")
	private int wis;

	//bi-directional many-to-one association to Character
	@ManyToOne
	private Character character;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public CharacterTransitionDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCha() {
		return this.cha;
	}

	public void setCha(int cha) {
		this.cha = cha;
	}

	public int getCon() {
		return this.con;
	}

	public void setCon(int con) {
		this.con = con;
	}

	public int getDex() {
		return this.dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getInte() {
		return this.inte;
	}

	public void setInte(int inte) {
		this.inte = inte;
	}

	public int getRandom0Spells() {
		return this.random0Spells;
	}

	public void setRandom0Spells(int random0Spells) {
		this.random0Spells = random0Spells;
	}

	public int getRandom1Spells() {
		return this.random1Spells;
	}

	public void setRandom1Spells(int random1Spells) {
		this.random1Spells = random1Spells;
	}

	public int getRandom2Spells() {
		return this.random2Spells;
	}

	public void setRandom2Spells(int random2Spells) {
		this.random2Spells = random2Spells;
	}

	public int getRandom3Spells() {
		return this.random3Spells;
	}

	public void setRandom3Spells(int random3Spells) {
		this.random3Spells = random3Spells;
	}

	public int getRandom4Spells() {
		return this.random4Spells;
	}

	public void setRandom4Spells(int random4Spells) {
		this.random4Spells = random4Spells;
	}

	public int getRandom5Spells() {
		return this.random5Spells;
	}

	public void setRandom5Spells(int random5Spells) {
		this.random5Spells = random5Spells;
	}

	public int getRandom6Spells() {
		return this.random6Spells;
	}

	public void setRandom6Spells(int random6Spells) {
		this.random6Spells = random6Spells;
	}

	public int getRandom7Spells() {
		return this.random7Spells;
	}

	public void setRandom7Spells(int random7Spells) {
		this.random7Spells = random7Spells;
	}

	public int getRandom8Spells() {
		return this.random8Spells;
	}

	public void setRandom8Spells(int random8Spells) {
		this.random8Spells = random8Spells;
	}

	public int getRandom9Spells() {
		return this.random9Spells;
	}

	public void setRandom9Spells(int random9Spells) {
		this.random9Spells = random9Spells;
	}

	public int getRandomAttributes() {
		return this.randomAttributes;
	}

	public void setRandomAttributes(int randomAttributes) {
		this.randomAttributes = randomAttributes;
	}

	public int getSkillPoints() {
		return this.skillPoints;
	}

	public void setSkillPoints(int skillPoints) {
		this.skillPoints = skillPoints;
	}

	public int getStr() {
		return this.str;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public int getTalentPoints() {
		return this.talentPoints;
	}

	public void setTalentPoints(int talentPoints) {
		this.talentPoints = talentPoints;
	}

	public int getWis() {
		return this.wis;
	}

	public void setWis(int wis) {
		this.wis = wis;
	}

	public Character getCharacter() {
		return this.character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}