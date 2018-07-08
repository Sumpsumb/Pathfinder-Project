package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the QUESTS database table.
 * 
 */
@Entity
@Table(name="QUESTS")
@NamedQuery(name="Quest.findAll", query="SELECT q FROM Quest q")
public class Quest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="CL")
	private int cl;

	private int experience;

	private int money;

	private String name;

	//bi-directional many-to-one association to ItemReward
	@OneToMany(mappedBy="quest")
	private List<ItemReward> itemRewards;

	//bi-directional many-to-one association to Character
	@ManyToOne
	private Character character;

	//bi-directional many-to-one association to Group
	@ManyToOne
	private Group group;

	public Quest() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCl() {
		return this.cl;
	}

	public void setCl(int cl) {
		this.cl = cl;
	}

	public int getExperience() {
		return this.experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getMoney() {
		return this.money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ItemReward> getItemRewards() {
		return this.itemRewards;
	}

	public void setItemRewards(List<ItemReward> itemRewards) {
		this.itemRewards = itemRewards;
	}

	public ItemReward addItemReward(ItemReward itemReward) {
		getItemRewards().add(itemReward);
		itemReward.setQuest(this);

		return itemReward;
	}

	public ItemReward removeItemReward(ItemReward itemReward) {
		getItemRewards().remove(itemReward);
		itemReward.setQuest(null);

		return itemReward;
	}

	public Character getCharacter() {
		return this.character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

}