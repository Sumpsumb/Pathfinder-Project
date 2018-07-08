package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CHARACTER_SPECIAL_ABILITIES database table.
 * 
 */
@Entity
@Table(name="CHARACTER_SPECIAL_ABILITIES")
@NamedQuery(name="CharacterSpecialAbility.findAll", query="SELECT c FROM CharacterSpecialAbility c")
public class CharacterSpecialAbility implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Character
	@ManyToOne
	private Character character;

	//bi-directional many-to-one association to SpecialAbility
	@ManyToOne
	@JoinColumn(name="special_ability_id")
	private SpecialAbility specialAbility;

	public CharacterSpecialAbility() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Character getCharacter() {
		return this.character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public SpecialAbility getSpecialAbility() {
		return this.specialAbility;
	}

	public void setSpecialAbility(SpecialAbility specialAbility) {
		this.specialAbility = specialAbility;
	}

}