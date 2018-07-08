package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SHOPS database table.
 * 
 */
@Entity
@Table(name="SHOPS")
@NamedQuery(name="Shop.findAll", query="SELECT s FROM Shop s")
public class Shop implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String owner;

	//bi-directional many-to-one association to Location
	@ManyToOne
	private Location location;

	public Shop() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}