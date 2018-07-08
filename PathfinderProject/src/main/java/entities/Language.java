package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the LANGUAGES database table.
 * 
 */
@Entity
@Table(name="LANGUAGES")
@NamedQuery(name="Language.findAll", query="SELECT l FROM Language l")
public class Language implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to CharacterLanguage
	@OneToMany(mappedBy="language")
	private List<CharacterLanguage> characterLanguages;

	//bi-directional many-to-one association to RaceLanguage
	@OneToMany(mappedBy="language")
	private List<RaceLanguage> raceLanguages;

	public Language() {
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

	public List<CharacterLanguage> getCharacterLanguages() {
		return this.characterLanguages;
	}

	public void setCharacterLanguages(List<CharacterLanguage> characterLanguages) {
		this.characterLanguages = characterLanguages;
	}

	public CharacterLanguage addCharacterLanguage(CharacterLanguage characterLanguage) {
		getCharacterLanguages().add(characterLanguage);
		characterLanguage.setLanguage(this);

		return characterLanguage;
	}

	public CharacterLanguage removeCharacterLanguage(CharacterLanguage characterLanguage) {
		getCharacterLanguages().remove(characterLanguage);
		characterLanguage.setLanguage(null);

		return characterLanguage;
	}

	public List<RaceLanguage> getRaceLanguages() {
		return this.raceLanguages;
	}

	public void setRaceLanguages(List<RaceLanguage> raceLanguages) {
		this.raceLanguages = raceLanguages;
	}

	public RaceLanguage addRaceLanguage(RaceLanguage raceLanguage) {
		getRaceLanguages().add(raceLanguage);
		raceLanguage.setLanguage(this);

		return raceLanguage;
	}

	public RaceLanguage removeRaceLanguage(RaceLanguage raceLanguage) {
		getRaceLanguages().remove(raceLanguage);
		raceLanguage.setLanguage(null);

		return raceLanguage;
	}

}