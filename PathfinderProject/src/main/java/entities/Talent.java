package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the TALENTS database table.
 * 
 */
@Entity
@Table(name = "TALENTS")
@NamedQuery(name = "Talent.findAll", query = "SELECT t FROM Talent t")
public class Talent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "appears_at")
	private String appearsAt;

	private String description;

	@Column(name = "is_combat_talent")
	private String isCombatTalent;

	private String name;

	// bi-directional many-to-one association to CharacterTalent
	@OneToMany(mappedBy = "talent")
	private List<CharacterTalent> characterTalents;

	// bi-directional many-to-one association to TalentCondition
	@OneToMany(mappedBy = "talent")
	private List<TalentCondition> talentConditions;

	public Talent() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAppearsAt() {
		return this.appearsAt;
	}

	public void setAppearsAt(String appearsAt) {
		this.appearsAt = appearsAt;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsCombatTalent() {
		return this.isCombatTalent;
	}

	public void setIsCombatTalent(String isCombatTalent) {
		this.isCombatTalent = isCombatTalent;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CharacterTalent> getCharacterTalents() {
		return this.characterTalents;
	}

	public void setCharacterTalents(List<CharacterTalent> characterTalents) {
		this.characterTalents = characterTalents;
	}

	public CharacterTalent addCharacterTalent(CharacterTalent characterTalent) {
		getCharacterTalents().add(characterTalent);
		characterTalent.setTalent(this);

		return characterTalent;
	}

	public CharacterTalent removeCharacterTalent(CharacterTalent characterTalent) {
		getCharacterTalents().remove(characterTalent);
		characterTalent.setTalent(null);

		return characterTalent;
	}

	public List<TalentCondition> getTalentConditions() {
		return this.talentConditions;
	}

	public void setTalentConditions(List<TalentCondition> talentConditions) {
		this.talentConditions = talentConditions;
	}

	public TalentCondition addTalentCondition(TalentCondition talentCondition) {
		getTalentConditions().add(talentCondition);
		talentCondition.setTalent(this);

		return talentCondition;
	}

	public TalentCondition removeTalentCondition(TalentCondition talentCondition) {
		getTalentConditions().remove(talentCondition);
		talentCondition.setTalent(null);

		return talentCondition;
	}

	public int getSizeOfTalentConditions() {

		return getTalentConditions().size();
	}

}