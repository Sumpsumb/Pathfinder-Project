package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CHARACTER_CHARACTER_CLASSES database table.
 * 
 */
@Entity
@Table(name="CHARACTER_CHARACTER_CLASSES")
@NamedQuery(name="CharacterCharacterClass.findAll", query="SELECT c FROM CharacterCharacterClass c")
public class CharacterCharacterClass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="is_main")
	private String isMain;

	private int level;

	//bi-directional many-to-one association to Character
	@ManyToOne
	private Character character;

	//bi-directional many-to-one association to CharacterClass
	@ManyToOne
	@JoinColumn(name="character_class_id")
	private CharacterClass characterClass;

	public CharacterCharacterClass() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsMain() {
		return this.isMain;
	}

	public void setIsMain(String isMain) {
		this.isMain = isMain;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Character getCharacter() {
		return this.character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public CharacterClass getCharacterClass() {
		return this.characterClass;
	}

	public void setCharacterClass(CharacterClass characterClass) {
		this.characterClass = characterClass;
	}

}