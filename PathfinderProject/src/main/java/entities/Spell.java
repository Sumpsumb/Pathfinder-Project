package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SPELLS database table.
 * 
 */
@Entity
@Table(name="SPELLS")
@NamedQuery(name="Spell.findAll", query="SELECT s FROM Spell s")
public class Spell implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to CharacterSpell
	@OneToMany(mappedBy="spell")
	private List<CharacterSpell> characterSpells;

	public Spell() {
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

	public List<CharacterSpell> getCharacterSpells() {
		return this.characterSpells;
	}

	public void setCharacterSpells(List<CharacterSpell> characterSpells) {
		this.characterSpells = characterSpells;
	}

	public CharacterSpell addCharacterSpell(CharacterSpell characterSpell) {
		getCharacterSpells().add(characterSpell);
		characterSpell.setSpell(this);

		return characterSpell;
	}

	public CharacterSpell removeCharacterSpell(CharacterSpell characterSpell) {
		getCharacterSpells().remove(characterSpell);
		characterSpell.setSpell(null);

		return characterSpell;
	}

}