package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the RACES database table.
 * 
 */
@Entity
@Table(name="RACES")
@NamedQuery(name="Race.findAll", query="SELECT r FROM Race r")
public class Race implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to RaceLanguage
	@OneToMany(mappedBy="race")
	private List<RaceLanguage> raceLanguages;

	public Race() {
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

	public List<RaceLanguage> getRaceLanguages() {
		return this.raceLanguages;
	}

	public void setRaceLanguages(List<RaceLanguage> raceLanguages) {
		this.raceLanguages = raceLanguages;
	}

	public RaceLanguage addRaceLanguage(RaceLanguage raceLanguage) {
		getRaceLanguages().add(raceLanguage);
		raceLanguage.setRace(this);

		return raceLanguage;
	}

	public RaceLanguage removeRaceLanguage(RaceLanguage raceLanguage) {
		getRaceLanguages().remove(raceLanguage);
		raceLanguage.setRace(null);

		return raceLanguage;
	}

}