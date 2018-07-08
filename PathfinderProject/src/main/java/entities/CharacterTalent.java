package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CHARACTER_TALENTS database table.
 * 
 */
@Entity
@Table(name="CHARACTER_TALENTS")
@NamedQuery(name="CharacterTalent.findAll", query="SELECT c FROM CharacterTalent c")
public class CharacterTalent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Character
	@ManyToOne
	private Character character;

	//bi-directional many-to-one association to Talent
	@ManyToOne
	private Talent talent;

	public CharacterTalent() {
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

	public Talent getTalent() {
		return this.talent;
	}

	public void setTalent(Talent talent) {
		this.talent = talent;
	}

}