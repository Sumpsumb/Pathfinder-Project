package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CHARACTER_CLASSES database table.
 * 
 */
@Entity
@Table(name="CHARACTER_CLASSES")
@NamedQuery(name="CharacterClass.findAll", query="SELECT c FROM CharacterClass c")
public class CharacterClass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to CharacterCharacterClass
	@OneToMany(mappedBy="characterClass")
	private List<CharacterCharacterClass> characterCharacterClasses;

	public CharacterClass() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CharacterCharacterClass> getCharacterCharacterClasses() {
		return this.characterCharacterClasses;
	}

	public void setCharacterCharacterClasses(List<CharacterCharacterClass> characterCharacterClasses) {
		this.characterCharacterClasses = characterCharacterClasses;
	}

	public CharacterCharacterClass addCharacterCharacterClass(CharacterCharacterClass characterCharacterClass) {
		getCharacterCharacterClasses().add(characterCharacterClass);
		characterCharacterClass.setCharacterClass(this);

		return characterCharacterClass;
	}

	public CharacterCharacterClass removeCharacterCharacterClass(CharacterCharacterClass characterCharacterClass) {
		getCharacterCharacterClasses().remove(characterCharacterClass);
		characterCharacterClass.setCharacterClass(null);

		return characterCharacterClass;
	}

}