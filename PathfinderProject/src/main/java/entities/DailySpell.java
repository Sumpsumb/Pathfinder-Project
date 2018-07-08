package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DAILY_SPELLS database table.
 * 
 */
@Entity
@Table(name="DAILY_SPELLS")
@NamedQuery(name="DailySpell.findAll", query="SELECT d FROM DailySpell d")
public class DailySpell implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;

	@Column(name="level_0_spells_left")
	private int level0SpellsLeft;

	@Column(name="level_1_spells_left")
	private int level1SpellsLeft;

	@Column(name="level_2_spells_left")
	private int level2SpellsLeft;

	@Column(name="level_3_spells_left")
	private int level3SpellsLeft;

	@Column(name="level_4_spells_left")
	private int level4SpellsLeft;

	@Column(name="level_5_spells_left")
	private int level5SpellsLeft;

	@Column(name="level_6_spells_left")
	private int level6SpellsLeft;

	@Column(name="level_7_spells_left")
	private int level7SpellsLeft;

	@Column(name="level_8_spells_left")
	private int level8SpellsLeft;

	@Column(name="level_9_spells_left")
	private int level9SpellsLeft;

	//bi-directional many-to-one association to Character
	@OneToMany(mappedBy="dailySpell")
	private List<Character> characters;

	public DailySpell() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLevel0SpellsLeft() {
		return this.level0SpellsLeft;
	}

	public void setLevel0SpellsLeft(int level0SpellsLeft) {
		this.level0SpellsLeft = level0SpellsLeft;
	}

	public int getLevel1SpellsLeft() {
		return this.level1SpellsLeft;
	}

	public void setLevel1SpellsLeft(int level1SpellsLeft) {
		this.level1SpellsLeft = level1SpellsLeft;
	}

	public int getLevel2SpellsLeft() {
		return this.level2SpellsLeft;
	}

	public void setLevel2SpellsLeft(int level2SpellsLeft) {
		this.level2SpellsLeft = level2SpellsLeft;
	}

	public int getLevel3SpellsLeft() {
		return this.level3SpellsLeft;
	}

	public void setLevel3SpellsLeft(int level3SpellsLeft) {
		this.level3SpellsLeft = level3SpellsLeft;
	}

	public int getLevel4SpellsLeft() {
		return this.level4SpellsLeft;
	}

	public void setLevel4SpellsLeft(int level4SpellsLeft) {
		this.level4SpellsLeft = level4SpellsLeft;
	}

	public int getLevel5SpellsLeft() {
		return this.level5SpellsLeft;
	}

	public void setLevel5SpellsLeft(int level5SpellsLeft) {
		this.level5SpellsLeft = level5SpellsLeft;
	}

	public int getLevel6SpellsLeft() {
		return this.level6SpellsLeft;
	}

	public void setLevel6SpellsLeft(int level6SpellsLeft) {
		this.level6SpellsLeft = level6SpellsLeft;
	}

	public int getLevel7SpellsLeft() {
		return this.level7SpellsLeft;
	}

	public void setLevel7SpellsLeft(int level7SpellsLeft) {
		this.level7SpellsLeft = level7SpellsLeft;
	}

	public int getLevel8SpellsLeft() {
		return this.level8SpellsLeft;
	}

	public void setLevel8SpellsLeft(int level8SpellsLeft) {
		this.level8SpellsLeft = level8SpellsLeft;
	}

	public int getLevel9SpellsLeft() {
		return this.level9SpellsLeft;
	}

	public void setLevel9SpellsLeft(int level9SpellsLeft) {
		this.level9SpellsLeft = level9SpellsLeft;
	}

	public List<Character> getCharacters() {
		return this.characters;
	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}

	public Character addCharacter(Character character) {
		getCharacters().add(character);
		character.setDailySpell(this);

		return character;
	}

	public Character removeCharacter(Character character) {
		getCharacters().remove(character);
		character.setDailySpell(null);

		return character;
	}

}