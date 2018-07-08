package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SPECIAL_ABILITIES database table.
 * 
 */
@Entity
@Table(name="SPECIAL_ABILITIES")
@NamedQuery(name="SpecialAbility.findAll", query="SELECT s FROM SpecialAbility s")
public class SpecialAbility implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	private String kind;

	private String name;

	private String trig;

	private String value;

	//bi-directional many-to-one association to CharacterSpecialAbility
	@OneToMany(mappedBy="specialAbility")
	private List<CharacterSpecialAbility> characterSpecialAbilities;

	public SpecialAbility() {
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

	public String getKind() {
		return this.kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTrig() {
		return this.trig;
	}

	public void setTrig(String trig) {
		this.trig = trig;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<CharacterSpecialAbility> getCharacterSpecialAbilities() {
		return this.characterSpecialAbilities;
	}

	public void setCharacterSpecialAbilities(List<CharacterSpecialAbility> characterSpecialAbilities) {
		this.characterSpecialAbilities = characterSpecialAbilities;
	}

	public CharacterSpecialAbility addCharacterSpecialAbility(CharacterSpecialAbility characterSpecialAbility) {
		getCharacterSpecialAbilities().add(characterSpecialAbility);
		characterSpecialAbility.setSpecialAbility(this);

		return characterSpecialAbility;
	}

	public CharacterSpecialAbility removeCharacterSpecialAbility(CharacterSpecialAbility characterSpecialAbility) {
		getCharacterSpecialAbilities().remove(characterSpecialAbility);
		characterSpecialAbility.setSpecialAbility(null);

		return characterSpecialAbility;
	}

}