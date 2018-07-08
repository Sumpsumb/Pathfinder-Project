package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the WEAPON_DETAILS database table.
 * 
 */
@Entity
@Table(name="WEAPON_DETAILS")
@NamedQuery(name="WeaponDetail.findAll", query="SELECT w FROM WeaponDetail w")
public class WeaponDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="base_range")
	private int baseRange;

	private String category;

	private String crit;

	@Column(name="dmg_medium")
	private String dmgMedium;

	@Column(name="dmg_small")
	private String dmgSmall;

	@Column(name="is_melee")
	private String isMelee;

	private String kind;

	private String special;

	//bi-directional many-to-one association to Item
	@ManyToOne
	private Item item;

	public WeaponDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBaseRange() {
		return this.baseRange;
	}

	public void setBaseRange(int baseRange) {
		this.baseRange = baseRange;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCrit() {
		return this.crit;
	}

	public void setCrit(String crit) {
		this.crit = crit;
	}

	public String getDmgMedium() {
		return this.dmgMedium;
	}

	public void setDmgMedium(String dmgMedium) {
		this.dmgMedium = dmgMedium;
	}

	public String getDmgSmall() {
		return this.dmgSmall;
	}

	public void setDmgSmall(String dmgSmall) {
		this.dmgSmall = dmgSmall;
	}

	public String getIsMelee() {
		return this.isMelee;
	}

	public void setIsMelee(String isMelee) {
		this.isMelee = isMelee;
	}

	public String getKind() {
		return this.kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSpecial() {
		return this.special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}