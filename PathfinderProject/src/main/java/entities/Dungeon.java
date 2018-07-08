package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DUNGEONS database table.
 * 
 */
@Entity
@Table(name="DUNGEONS")
@NamedQuery(name="Dungeon.findAll", query="SELECT d FROM Dungeon d")
public class Dungeon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to Location
	@OneToMany(mappedBy="dungeon")
	private List<Location> locations;

	public Dungeon() {
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

	public List<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public Location addLocation(Location location) {
		getLocations().add(location);
		location.setDungeon(this);

		return location;
	}

	public Location removeLocation(Location location) {
		getLocations().remove(location);
		location.setDungeon(null);

		return location;
	}

}