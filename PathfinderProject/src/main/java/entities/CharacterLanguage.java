package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CHARACTER_LANGUAGES database table.
 * 
 */
@Entity
@Table(name="CHARACTER_LANGUAGES")
@NamedQuery(name="CharacterLanguage.findAll", query="SELECT c FROM CharacterLanguage c")
public class CharacterLanguage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Character
	@ManyToOne
	private Character character;

	//bi-directional many-to-one association to Language
	@ManyToOne
	private Language language;

	public CharacterLanguage() {
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

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}