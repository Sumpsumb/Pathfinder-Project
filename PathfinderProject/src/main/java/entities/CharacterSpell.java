package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CHARACTER_SPELLS database table.
 * 
 */
@Entity
@Table(name="CHARACTER_SPELLS")
@NamedQuery(name="CharacterSpell.findAll", query="SELECT c FROM CharacterSpell c")
public class CharacterSpell implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Character
	@ManyToOne
	private Character character;

	//bi-directional many-to-one association to Spell
	@ManyToOne
	private Spell spell;

	public CharacterSpell() {
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

	public Spell getSpell() {
		return this.spell;
	}

	public void setSpell(Spell spell) {
		this.spell = spell;
	}

}