package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RACE_LANGUAGES database table.
 * 
 */
@Entity
@Table(name="RACE_LANGUAGES")
@NamedQuery(name="RaceLanguage.findAll", query="SELECT r FROM RaceLanguage r")
public class RaceLanguage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="is_native")
	private String isNative;

	//bi-directional many-to-one association to Language
	@ManyToOne
	private Language language;

	//bi-directional many-to-one association to Race
	@ManyToOne
	private Race race;

	public RaceLanguage() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsNative() {
		return this.isNative;
	}

	public void setIsNative(String isNative) {
		this.isNative = isNative;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Race getRace() {
		return this.race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

}