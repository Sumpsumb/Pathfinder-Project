package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ARMOR_DETAILS database table.
 * 
 */
@Entity
@Table(name="ARMOR_DETAILS")
@NamedQuery(name="ArmorDetail.findAll", query="SELECT a FROM ArmorDetail a")
public class ArmorDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="armor_bonus")
	private int armorBonus;

	@Column(name="armor_malus")
	private int armorMalus;

	@Column(name="chance_for_blooper")
	private int chanceForBlooper;

	@Column(name="is_shield")
	private String isShield;

	@Column(name="is_weapon")
	private String isWeapon;

	@Column(name="max_dex")
	private int maxDex;

	@Column(name="speed_6")
	private double speed6;

	@Column(name="speed_9")
	private double speed9;

	//bi-directional many-to-one association to Item
	@ManyToOne
	private Item item;

	public ArmorDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArmorBonus() {
		return this.armorBonus;
	}

	public void setArmorBonus(int armorBonus) {
		this.armorBonus = armorBonus;
	}

	public int getArmorMalus() {
		return this.armorMalus;
	}

	public void setArmorMalus(int armorMalus) {
		this.armorMalus = armorMalus;
	}

	public int getChanceForBlooper() {
		return this.chanceForBlooper;
	}

	public void setChanceForBlooper(int chanceForBlooper) {
		this.chanceForBlooper = chanceForBlooper;
	}

	public String getIsShield() {
		return this.isShield;
	}

	public void setIsShield(String isShield) {
		this.isShield = isShield;
	}

	public String getIsWeapon() {
		return this.isWeapon;
	}

	public void setIsWeapon(String isWeapon) {
		this.isWeapon = isWeapon;
	}

	public int getMaxDex() {
		return this.maxDex;
	}

	public void setMaxDex(int maxDex) {
		this.maxDex = maxDex;
	}

	public double getSpeed6() {
		return this.speed6;
	}

	public void setSpeed6(double speed6) {
		this.speed6 = speed6;
	}

	public double getSpeed9() {
		return this.speed9;
	}

	public void setSpeed9(double speed9) {
		this.speed9 = speed9;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}