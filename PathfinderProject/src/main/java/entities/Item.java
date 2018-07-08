package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.rahner.model.UnitConverter;

/**
 * The persistent class for the ITEMS database table.
 * 
 */
@Entity
@Table(name = "ITEMS")
@NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "belongs_to_quest")
	private String belongsToQuest;

	private String category;

	private String description;

	@Column(name = "is_armor")
	private String isArmor;

	@Column(name = "is_common")
	private String isCommon;

	@Column(name = "is_new")
	private String isNew;

	@Column(name = "is_trade_good")
	private String isTradeGood;

	@Column(name = "is_weapon")
	private String isWeapon;

	private String name;

	private int prize;

	private double weight;

	// bi-directional many-to-one association to ArmorDetail
	@OneToMany(mappedBy = "item")
	private List<ArmorDetail> armorDetails;

	// bi-directional many-to-one association to CharacterItem
	@OneToMany(mappedBy = "item")
	private List<CharacterItem> characterItems;

	// bi-directional many-to-one association to ItemReward
	@OneToMany(mappedBy = "item")
	private List<ItemReward> itemRewards;

	// bi-directional many-to-one association to WeaponDetail
	@OneToMany(mappedBy = "item")
	private List<WeaponDetail> weaponDetails;

	public Item() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBelongsToQuest() {
		return this.belongsToQuest;
	}

	public void setBelongsToQuest(String belongsToQuest) {
		this.belongsToQuest = belongsToQuest;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsArmor() {
		return this.isArmor;
	}

	public void setIsArmor(String isArmor) {
		this.isArmor = isArmor;
	}

	public String getIsCommon() {
		return this.isCommon;
	}

	public void setIsCommon(String isCommon) {
		this.isCommon = isCommon;
	}

	public String getIsNew() {
		return this.isNew;
	}

	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}

	public String getIsTradeGood() {
		return this.isTradeGood;
	}

	public void setIsTradeGood(String isTradeGood) {
		this.isTradeGood = isTradeGood;
	}

	public String getIsWeapon() {
		return this.isWeapon;
	}

	public void setIsWeapon(String isWeapon) {
		this.isWeapon = isWeapon;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrize() {
		return this.prize;
	}

	public void setPrize(int prize) {
		this.prize = prize;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public List<ArmorDetail> getArmorDetails() {
		return this.armorDetails;
	}

	public void setArmorDetails(List<ArmorDetail> armorDetails) {
		this.armorDetails = armorDetails;
	}

	public ArmorDetail addArmorDetail(ArmorDetail armorDetail) {
		getArmorDetails().add(armorDetail);
		armorDetail.setItem(this);

		return armorDetail;
	}

	public ArmorDetail removeArmorDetail(ArmorDetail armorDetail) {
		getArmorDetails().remove(armorDetail);
		armorDetail.setItem(null);

		return armorDetail;
	}

	public List<CharacterItem> getCharacterItems() {
		return this.characterItems;
	}

	public void setCharacterItems(List<CharacterItem> characterItems) {
		this.characterItems = characterItems;
	}

	public CharacterItem addCharacterItem(CharacterItem characterItem) {
		getCharacterItems().add(characterItem);
		characterItem.setItem(this);

		return characterItem;
	}

	public CharacterItem removeCharacterItem(CharacterItem characterItem) {
		getCharacterItems().remove(characterItem);
		characterItem.setItem(null);

		return characterItem;
	}

	public List<ItemReward> getItemRewards() {
		return this.itemRewards;
	}

	public void setItemRewards(List<ItemReward> itemRewards) {
		this.itemRewards = itemRewards;
	}

	public ItemReward addItemReward(ItemReward itemReward) {
		getItemRewards().add(itemReward);
		itemReward.setItem(this);

		return itemReward;
	}

	public ItemReward removeItemReward(ItemReward itemReward) {
		getItemRewards().remove(itemReward);
		itemReward.setItem(null);

		return itemReward;
	}

	public List<WeaponDetail> getWeaponDetails() {
		return this.weaponDetails;
	}

	public void setWeaponDetails(List<WeaponDetail> weaponDetails) {
		this.weaponDetails = weaponDetails;
	}

	public WeaponDetail addWeaponDetail(WeaponDetail weaponDetail) {
		getWeaponDetails().add(weaponDetail);
		weaponDetail.setItem(this);

		return weaponDetail;
	}

	public WeaponDetail removeWeaponDetail(WeaponDetail weaponDetail) {
		getWeaponDetails().remove(weaponDetail);
		weaponDetail.setItem(null);

		return weaponDetail;
	}

	public String showPrizeInAppropriateCurrency() {

		StringBuilder sb = new StringBuilder(20);
		int[] money = UnitConverter.convertMoneyFromCopper(getPrize());

		if (getPrize() >= 1000000) {
			sb.append(money[0] + " Platin");
			if (money[1] != 0) {
				sb.append(" " + money[1] + " Gold");
				if (money[2] != 0) {
					sb.append(" " + money[2] + " Silver");
					if (money[3] != 0) {
						sb.append(" " + money[3] + " Copper");
					}
				}
			}
		} else if (money[0] != 0) {

			int goldTotal = (money[0] * 10) + money[1];
			sb.append(goldTotal + " Gold");
			if (money[2] != 0) {
				sb.append(" " + money[2] + " Silver");
				if (money[3] != 0) {
					sb.append(" " + money[3] + " Copper");
				}
			}
		} else if (money[1] != 0) {

			sb.append(money[1] + " Gold");
			if (money[2] != 0) {
				sb.append(" " + money[2] + " Silver");
				if (money[3] != 0) {
					sb.append(" " + money[3] + " Copper");
				}
			}
		} else if (money[2] != 0) {

			sb.append(money[2] + " Silver");
			if (money[3] != 0) {
				sb.append(" " + money[3] + " Copper");
			}
		} else {

			sb.append(money[3] + " Copper");
		}

		return sb.toString();
	}

}