package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CHARACTER_SKILLS database table.
 * 
 */
@Entity
@Table(name="CHARACTER_SKILLS")
@NamedQuery(name="CharacterSkill.findAll", query="SELECT c FROM CharacterSkill c")
public class CharacterSkill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="attribute_mod")
	private int attributeMod;

	@Column(name="full_bonus")
	private int fullBonus;

	@Column(name="is_class_skill")
	private String isClassSkill;

	@Column(name="other_mod")
	private int otherMod;

	private int rang;

	//bi-directional many-to-one association to Character
	@ManyToOne
	private Character character;

	//bi-directional many-to-one association to Skill
	@ManyToOne
	private Skill skill;

	public CharacterSkill() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAttributeMod() {
		return this.attributeMod;
	}

	public void setAttributeMod(int attributeMod) {
		this.attributeMod = attributeMod;
	}

	public int getFullBonus() {
		return this.fullBonus;
	}

	public void setFullBonus(int fullBonus) {
		this.fullBonus = fullBonus;
	}

	public String getIsClassSkill() {
		return this.isClassSkill;
	}

	public void setIsClassSkill(String isClassSkill) {
		this.isClassSkill = isClassSkill;
	}

	public int getOtherMod() {
		return this.otherMod;
	}

	public void setOtherMod(int otherMod) {
		this.otherMod = otherMod;
	}

	public int getRang() {
		return this.rang;
	}

	public void setRang(int rang) {
		this.rang = rang;
	}

	public Character getCharacter() {
		return this.character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public Skill getSkill() {
		return this.skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

}