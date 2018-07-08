package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CHARACTER_ITEMS database table.
 * 
 */
@Entity
@Table(name="CHARACTER_ITEMS")
@NamedQuery(name="CharacterItem.findAll", query="SELECT c FROM CharacterItem c")
public class CharacterItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int amount;

	@Column(name="estimated_prize")
	private int estimatedPrize;

	//bi-directional many-to-one association to Character
	@ManyToOne
	private Character character;

	//bi-directional many-to-one association to Item
	@ManyToOne
	private Item item;

	public CharacterItem() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getEstimatedPrize() {
		return this.estimatedPrize;
	}

	public void setEstimatedPrize(int estimatedPrize) {
		this.estimatedPrize = estimatedPrize;
	}

	public Character getCharacter() {
		return this.character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}