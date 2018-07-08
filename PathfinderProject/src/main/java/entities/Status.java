package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the STATUS database table.
 * 
 */
@Entity
@Table(name="STATUS")
@NamedQuery(name="Status.findAll", query="SELECT s FROM Status s")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to CharacterStatus
	@OneToMany(mappedBy="status")
	private List<CharacterStatus> characterStatuses;

	public Status() {
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

	public List<CharacterStatus> getCharacterStatuses() {
		return this.characterStatuses;
	}

	public void setCharacterStatuses(List<CharacterStatus> characterStatuses) {
		this.characterStatuses = characterStatuses;
	}

	public CharacterStatus addCharacterStatus(CharacterStatus characterStatus) {
		getCharacterStatuses().add(characterStatus);
		characterStatus.setStatus(this);

		return characterStatus;
	}

	public CharacterStatus removeCharacterStatus(CharacterStatus characterStatus) {
		getCharacterStatuses().remove(characterStatus);
		characterStatus.setStatus(null);

		return characterStatus;
	}

}