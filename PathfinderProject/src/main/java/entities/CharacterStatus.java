package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CHARACTER_STATUS database table.
 * 
 */
@Entity
@Table(name="CHARACTER_STATUS")
@NamedQuery(name="CharacterStatus.findAll", query="SELECT c FROM CharacterStatus c")
public class CharacterStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Character
	@ManyToOne
	private Character character;

	//bi-directional many-to-one association to Status
	@ManyToOne
	private Status status;

	public CharacterStatus() {
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

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}