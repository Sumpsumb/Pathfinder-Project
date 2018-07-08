package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SKILLS database table.
 * 
 */
@Entity
@Table(name="SKILLS")
@NamedQuery(name="Skill.findAll", query="SELECT s FROM Skill s")
public class Skill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	private String name;

	@Column(name="primary_attribute")
	private String primaryAttribute;

	@Column(name="trained_only")
	private String trainedOnly;

	//bi-directional many-to-one association to CharacterSkill
	@OneToMany(mappedBy="skill")
	private List<CharacterSkill> characterSkills;

	public Skill() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrimaryAttribute() {
		return this.primaryAttribute;
	}

	public void setPrimaryAttribute(String primaryAttribute) {
		this.primaryAttribute = primaryAttribute;
	}

	public String getTrainedOnly() {
		return this.trainedOnly;
	}

	public void setTrainedOnly(String trainedOnly) {
		this.trainedOnly = trainedOnly;
	}

	public List<CharacterSkill> getCharacterSkills() {
		return this.characterSkills;
	}

	public void setCharacterSkills(List<CharacterSkill> characterSkills) {
		this.characterSkills = characterSkills;
	}

	public CharacterSkill addCharacterSkill(CharacterSkill characterSkill) {
		getCharacterSkills().add(characterSkill);
		characterSkill.setSkill(this);

		return characterSkill;
	}

	public CharacterSkill removeCharacterSkill(CharacterSkill characterSkill) {
		getCharacterSkills().remove(characterSkill);
		characterSkill.setSkill(null);

		return characterSkill;
	}

}