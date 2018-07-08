package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the COMBAT_STATS database table.
 * 
 */
@Entity
@Table(name="COMBAT_STATS")
@NamedQuery(name="CombatStat.findAll", query="SELECT c FROM CombatStat c")
public class CombatStat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="BAB1")
	private int bab1;

	@Column(name="BAB2")
	private int bab2;

	@Column(name="BAB3")
	private int bab3;

	@Column(name="BAB4")
	private int bab4;

	@Column(name="CMB")
	private int cmb;

	@Column(name="CMD")
	private int cmd;

	@Column(name="FFAC")
	private int ffac;

	private int fortitude;

	@Column(name="INI")
	private int ini;

	@Column(name="MAX_HP")
	private int maxHp;

	private int reflex;

	@Column(name="speed_borrow")
	private int speedBorrow;

	@Column(name="speed_climb")
	private int speedClimb;

	@Column(name="speed_fly")
	private int speedFly;

	@Column(name="speed_ground")
	private int speedGround;

	@Column(name="speed_ground_wa")
	private int speedGroundWa;

	@Column(name="speed_swim")
	private int speedSwim;

	@Column(name="SR")
	private int sr;

	@Column(name="TAC")
	private int tac;

	@Column(name="taken_dmg")
	private int takenDmg;

	@Column(name="taken_nl_dmg")
	private int takenNlDmg;

	private int will;

	//bi-directional many-to-one association to Character
	@OneToMany(mappedBy="combatStat")
	private List<Character> characters;

	public CombatStat() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBab1() {
		return this.bab1;
	}

	public void setBab1(int bab1) {
		this.bab1 = bab1;
	}

	public int getBab2() {
		return this.bab2;
	}

	public void setBab2(int bab2) {
		this.bab2 = bab2;
	}

	public int getBab3() {
		return this.bab3;
	}

	public void setBab3(int bab3) {
		this.bab3 = bab3;
	}

	public int getBab4() {
		return this.bab4;
	}

	public void setBab4(int bab4) {
		this.bab4 = bab4;
	}

	public int getCmb() {
		return this.cmb;
	}

	public void setCmb(int cmb) {
		this.cmb = cmb;
	}

	public int getCmd() {
		return this.cmd;
	}

	public void setCmd(int cmd) {
		this.cmd = cmd;
	}

	public int getFfac() {
		return this.ffac;
	}

	public void setFfac(int ffac) {
		this.ffac = ffac;
	}

	public int getFortitude() {
		return this.fortitude;
	}

	public void setFortitude(int fortitude) {
		this.fortitude = fortitude;
	}

	public int getIni() {
		return this.ini;
	}

	public void setIni(int ini) {
		this.ini = ini;
	}

	public int getMaxHp() {
		return this.maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getReflex() {
		return this.reflex;
	}

	public void setReflex(int reflex) {
		this.reflex = reflex;
	}

	public int getSpeedBorrow() {
		return this.speedBorrow;
	}

	public void setSpeedBorrow(int speedBorrow) {
		this.speedBorrow = speedBorrow;
	}

	public int getSpeedClimb() {
		return this.speedClimb;
	}

	public void setSpeedClimb(int speedClimb) {
		this.speedClimb = speedClimb;
	}

	public int getSpeedFly() {
		return this.speedFly;
	}

	public void setSpeedFly(int speedFly) {
		this.speedFly = speedFly;
	}

	public int getSpeedGround() {
		return this.speedGround;
	}

	public void setSpeedGround(int speedGround) {
		this.speedGround = speedGround;
	}

	public int getSpeedGroundWa() {
		return this.speedGroundWa;
	}

	public void setSpeedGroundWa(int speedGroundWa) {
		this.speedGroundWa = speedGroundWa;
	}

	public int getSpeedSwim() {
		return this.speedSwim;
	}

	public void setSpeedSwim(int speedSwim) {
		this.speedSwim = speedSwim;
	}

	public int getSr() {
		return this.sr;
	}

	public void setSr(int sr) {
		this.sr = sr;
	}

	public int getTac() {
		return this.tac;
	}

	public void setTac(int tac) {
		this.tac = tac;
	}

	public int getTakenDmg() {
		return this.takenDmg;
	}

	public void setTakenDmg(int takenDmg) {
		this.takenDmg = takenDmg;
	}

	public int getTakenNlDmg() {
		return this.takenNlDmg;
	}

	public void setTakenNlDmg(int takenNlDmg) {
		this.takenNlDmg = takenNlDmg;
	}

	public int getWill() {
		return this.will;
	}

	public void setWill(int will) {
		this.will = will;
	}

	public List<Character> getCharacters() {
		return this.characters;
	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}

	public Character addCharacter(Character character) {
		getCharacters().add(character);
		character.setCombatStat(this);

		return character;
	}

	public Character removeCharacter(Character character) {
		getCharacters().remove(character);
		character.setCombatStat(null);

		return character;
	}

}