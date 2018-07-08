package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ITEM_REWARDS database table.
 * 
 */
@Entity
@Table(name="ITEM_REWARDS")
@NamedQuery(name="ItemReward.findAll", query="SELECT i FROM ItemReward i")
public class ItemReward implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int amount;

	//bi-directional many-to-one association to Item
	@ManyToOne
	private Item item;

	//bi-directional many-to-one association to Quest
	@ManyToOne
	private Quest quest;

	public ItemReward() {
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

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Quest getQuest() {
		return this.quest;
	}

	public void setQuest(Quest quest) {
		this.quest = quest;
	}

}