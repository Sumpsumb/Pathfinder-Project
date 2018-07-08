package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the LOCATIONS database table.
 * 
 */
@Entity
@Table(name="LOCATIONS")
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="climate_zone")
	private String climateZone;

	private String name;

	//bi-directional many-to-one association to Character
	@OneToMany(mappedBy="location")
	private List<Character> characters;

	//bi-directional many-to-one association to Campaign
	@ManyToOne
	private Campaign campaign;

	//bi-directional many-to-one association to Shop
	@OneToMany(mappedBy="location")
	private List<Shop> shops;

	//bi-directional many-to-one association to Dungeon
	@ManyToOne
	private Dungeon dungeon;

	public Location() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClimateZone() {
		return this.climateZone;
	}

	public void setClimateZone(String climateZone) {
		this.climateZone = climateZone;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Character> getCharacters() {
		return this.characters;
	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}

	public Character addCharacter(Character character) {
		getCharacters().add(character);
		character.setLocation(this);

		return character;
	}

	public Character removeCharacter(Character character) {
		getCharacters().remove(character);
		character.setLocation(null);

		return character;
	}

	public Campaign getCampaign() {
		return this.campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public List<Shop> getShops() {
		return this.shops;
	}

	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}

	public Shop addShop(Shop shop) {
		getShops().add(shop);
		shop.setLocation(this);

		return shop;
	}

	public Shop removeShop(Shop shop) {
		getShops().remove(shop);
		shop.setLocation(null);

		return shop;
	}

	public Dungeon getDungeon() {
		return this.dungeon;
	}

	public void setDungeon(Dungeon dungeon) {
		this.dungeon = dungeon;
	}

}