package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CHARACTERS database table.
 * 
 */
@Entity
@Table(name="CHARACTERS")
@NamedQuery(name="Character.findAll", query="SELECT c FROM Character c")
public class Character implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int age;

	private String alignment;

	@Column(name="CHA")
	private int cha;

	private int CHA_mod;

	private int CHA_temp;

	private int CHA_temp_mod;

	@Column(name="character_size")
	private String characterSize;

	@Column(name="CON")
	private int con;

	private int CON_mod;

	private int CON_temp;

	private int CON_temp_mod;

	private String deity;

	@Column(name="DEX")
	private int dex;

	private int DEX_mod;

	private int DEX_temp;

	private int DEX_temp_mod;

	@Column(name="DOP")
	private int dop;

	private int experience;

	private String eye;

	private String gender;

	private String hair;

	private double height;

	@Column(name="HL")
	private int hl;

	private String homeland;

	@Column(name="in_combat")
	private String inCombat;

	@Column(name="in_level_up")
	private String inLevelUp;

	private int INT_mod;

	private int INT_temp;

	private int INT_temp_mod;

	@Column(name="INTE")
	private int inte;

	@Column(name="is_npc")
	private String isNpc;

	@Column(name="level_up_phase")
	private int levelUpPhase;

	@Column(name="LL")
	private int ll;

	@Column(name="LOG")
	private int log;

	@Column(name="LOH")
	private int loh;

	@Column(name="ML")
	private int ml;

	private int money;

	private String name;

	private String race;

	@Column(name="STR")
	private int str;

	private int STR_mod;

	private int STR_temp;

	private int STR_temp_mod;

	@Column(name="tot_level")
	private int totLevel;

	@Column(name="tot_weight")
	private double totWeight;

	private double weight;

	@Column(name="WIS")
	private int wis;

	private int WIS_mod;

	private int WIS_temp;

	private int WIS_temp_mod;

	//bi-directional many-to-one association to Campaign
	@ManyToOne
	private Campaign campaign;

	//bi-directional many-to-one association to CombatStat
	@ManyToOne
	@JoinColumn(name="combat_stat_id")
	private CombatStat combatStat;

	//bi-directional many-to-one association to DailySpell
	@ManyToOne
	@JoinColumn(name="daily_spells_id")
	private DailySpell dailySpell;

	//bi-directional many-to-one association to Group
	@ManyToOne
	private Group group;

	//bi-directional many-to-one association to Location
	@ManyToOne
	private Location location;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-one association to CharacterCharacterClass
	@OneToMany(mappedBy="character")
	private List<CharacterCharacterClass> characterCharacterClasses;

	//bi-directional many-to-one association to CharacterItem
	@OneToMany(mappedBy="character")
	private List<CharacterItem> characterItems;

	//bi-directional many-to-one association to CharacterLanguage
	@OneToMany(mappedBy="character")
	private List<CharacterLanguage> characterLanguages;

	//bi-directional many-to-one association to CharacterSkill
	@OneToMany(mappedBy="character")
	private List<CharacterSkill> characterSkills;

	//bi-directional many-to-one association to CharacterSpecialAbility
	@OneToMany(mappedBy="character")
	private List<CharacterSpecialAbility> characterSpecialAbilities;

	//bi-directional many-to-one association to CharacterSpell
	@OneToMany(mappedBy="character")
	private List<CharacterSpell> characterSpells;

	//bi-directional many-to-one association to CharacterStatus
	@OneToMany(mappedBy="character")
	private List<CharacterStatus> characterStatuses;

	//bi-directional many-to-one association to CharacterTalent
	@OneToMany(mappedBy="character")
	private List<CharacterTalent> characterTalents;

	//bi-directional many-to-one association to CharacterTransitionDetail
	@OneToMany(mappedBy="character")
	private List<CharacterTransitionDetail> characterTransitionDetails;

	//bi-directional many-to-one association to Quest
	@OneToMany(mappedBy="character")
	private List<Quest> quests;

	public Character() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAlignment() {
		return this.alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	public int getCha() {
		return this.cha;
	}

	public void setCha(int cha) {
		this.cha = cha;
	}

	public int getCHA_mod() {
		return this.CHA_mod;
	}

	public void setCHA_mod(int CHA_mod) {
		this.CHA_mod = CHA_mod;
	}

	public int getCHA_temp() {
		return this.CHA_temp;
	}

	public void setCHA_temp(int CHA_temp) {
		this.CHA_temp = CHA_temp;
	}

	public int getCHA_temp_mod() {
		return this.CHA_temp_mod;
	}

	public void setCHA_temp_mod(int CHA_temp_mod) {
		this.CHA_temp_mod = CHA_temp_mod;
	}

	public String getCharacterSize() {
		return this.characterSize;
	}

	public void setCharacterSize(String characterSize) {
		this.characterSize = characterSize;
	}

	public int getCon() {
		return this.con;
	}

	public void setCon(int con) {
		this.con = con;
	}

	public int getCON_mod() {
		return this.CON_mod;
	}

	public void setCON_mod(int CON_mod) {
		this.CON_mod = CON_mod;
	}

	public int getCON_temp() {
		return this.CON_temp;
	}

	public void setCON_temp(int CON_temp) {
		this.CON_temp = CON_temp;
	}

	public int getCON_temp_mod() {
		return this.CON_temp_mod;
	}

	public void setCON_temp_mod(int CON_temp_mod) {
		this.CON_temp_mod = CON_temp_mod;
	}

	public String getDeity() {
		return this.deity;
	}

	public void setDeity(String deity) {
		this.deity = deity;
	}

	public int getDex() {
		return this.dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	public int getDEX_mod() {
		return this.DEX_mod;
	}

	public void setDEX_mod(int DEX_mod) {
		this.DEX_mod = DEX_mod;
	}

	public int getDEX_temp() {
		return this.DEX_temp;
	}

	public void setDEX_temp(int DEX_temp) {
		this.DEX_temp = DEX_temp;
	}

	public int getDEX_temp_mod() {
		return this.DEX_temp_mod;
	}

	public void setDEX_temp_mod(int DEX_temp_mod) {
		this.DEX_temp_mod = DEX_temp_mod;
	}

	public int getDop() {
		return this.dop;
	}

	public void setDop(int dop) {
		this.dop = dop;
	}

	public int getExperience() {
		return this.experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getEye() {
		return this.eye;
	}

	public void setEye(String eye) {
		this.eye = eye;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHair() {
		return this.hair;
	}

	public void setHair(String hair) {
		this.hair = hair;
	}

	public double getHeight() {
		return this.height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getHl() {
		return this.hl;
	}

	public void setHl(int hl) {
		this.hl = hl;
	}

	public String getHomeland() {
		return this.homeland;
	}

	public void setHomeland(String homeland) {
		this.homeland = homeland;
	}

	public String getInCombat() {
		return this.inCombat;
	}

	public void setInCombat(String inCombat) {
		this.inCombat = inCombat;
	}

	public String getInLevelUp() {
		return this.inLevelUp;
	}

	public void setInLevelUp(String inLevelUp) {
		this.inLevelUp = inLevelUp;
	}

	public int getINT_mod() {
		return this.INT_mod;
	}

	public void setINT_mod(int INT_mod) {
		this.INT_mod = INT_mod;
	}

	public int getINT_temp() {
		return this.INT_temp;
	}

	public void setINT_temp(int INT_temp) {
		this.INT_temp = INT_temp;
	}

	public int getINT_temp_mod() {
		return this.INT_temp_mod;
	}

	public void setINT_temp_mod(int INT_temp_mod) {
		this.INT_temp_mod = INT_temp_mod;
	}

	public int getInte() {
		return this.inte;
	}

	public void setInte(int inte) {
		this.inte = inte;
	}

	public String getIsNpc() {
		return this.isNpc;
	}

	public void setIsNpc(String isNpc) {
		this.isNpc = isNpc;
	}

	public int getLevelUpPhase() {
		return this.levelUpPhase;
	}

	public void setLevelUpPhase(int levelUpPhase) {
		this.levelUpPhase = levelUpPhase;
	}

	public int getLl() {
		return this.ll;
	}

	public void setLl(int ll) {
		this.ll = ll;
	}

	public int getLog() {
		return this.log;
	}

	public void setLog(int log) {
		this.log = log;
	}

	public int getLoh() {
		return this.loh;
	}

	public void setLoh(int loh) {
		this.loh = loh;
	}

	public int getMl() {
		return this.ml;
	}

	public void setMl(int ml) {
		this.ml = ml;
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

	public String getRace() {
		return this.race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public int getStr() {
		return this.str;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public int getSTR_mod() {
		return this.STR_mod;
	}

	public void setSTR_mod(int STR_mod) {
		this.STR_mod = STR_mod;
	}

	public int getSTR_temp() {
		return this.STR_temp;
	}

	public void setSTR_temp(int STR_temp) {
		this.STR_temp = STR_temp;
	}

	public int getSTR_temp_mod() {
		return this.STR_temp_mod;
	}

	public void setSTR_temp_mod(int STR_temp_mod) {
		this.STR_temp_mod = STR_temp_mod;
	}

	public int getTotLevel() {
		return this.totLevel;
	}

	public void setTotLevel(int totLevel) {
		this.totLevel = totLevel;
	}

	public double getTotWeight() {
		return this.totWeight;
	}

	public void setTotWeight(double totWeight) {
		this.totWeight = totWeight;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getWis() {
		return this.wis;
	}

	public void setWis(int wis) {
		this.wis = wis;
	}

	public int getWIS_mod() {
		return this.WIS_mod;
	}

	public void setWIS_mod(int WIS_mod) {
		this.WIS_mod = WIS_mod;
	}

	public int getWIS_temp() {
		return this.WIS_temp;
	}

	public void setWIS_temp(int WIS_temp) {
		this.WIS_temp = WIS_temp;
	}

	public int getWIS_temp_mod() {
		return this.WIS_temp_mod;
	}

	public void setWIS_temp_mod(int WIS_temp_mod) {
		this.WIS_temp_mod = WIS_temp_mod;
	}

	public Campaign getCampaign() {
		return this.campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public CombatStat getCombatStat() {
		return this.combatStat;
	}

	public void setCombatStat(CombatStat combatStat) {
		this.combatStat = combatStat;
	}

	public DailySpell getDailySpell() {
		return this.dailySpell;
	}

	public void setDailySpell(DailySpell dailySpell) {
		this.dailySpell = dailySpell;
	}

	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<CharacterCharacterClass> getCharacterCharacterClasses() {
		return this.characterCharacterClasses;
	}

	public void setCharacterCharacterClasses(List<CharacterCharacterClass> characterCharacterClasses) {
		this.characterCharacterClasses = characterCharacterClasses;
	}

	public CharacterCharacterClass addCharacterCharacterClass(CharacterCharacterClass characterCharacterClass) {
		getCharacterCharacterClasses().add(characterCharacterClass);
		characterCharacterClass.setCharacter(this);

		return characterCharacterClass;
	}

	public CharacterCharacterClass removeCharacterCharacterClass(CharacterCharacterClass characterCharacterClass) {
		getCharacterCharacterClasses().remove(characterCharacterClass);
		characterCharacterClass.setCharacter(null);

		return characterCharacterClass;
	}

	public List<CharacterItem> getCharacterItems() {
		return this.characterItems;
	}

	public void setCharacterItems(List<CharacterItem> characterItems) {
		this.characterItems = characterItems;
	}

	public CharacterItem addCharacterItem(CharacterItem characterItem) {
		getCharacterItems().add(characterItem);
		characterItem.setCharacter(this);

		return characterItem;
	}

	public CharacterItem removeCharacterItem(CharacterItem characterItem) {
		getCharacterItems().remove(characterItem);
		characterItem.setCharacter(null);

		return characterItem;
	}

	public List<CharacterLanguage> getCharacterLanguages() {
		return this.characterLanguages;
	}

	public void setCharacterLanguages(List<CharacterLanguage> characterLanguages) {
		this.characterLanguages = characterLanguages;
	}

	public CharacterLanguage addCharacterLanguage(CharacterLanguage characterLanguage) {
		getCharacterLanguages().add(characterLanguage);
		characterLanguage.setCharacter(this);

		return characterLanguage;
	}

	public CharacterLanguage removeCharacterLanguage(CharacterLanguage characterLanguage) {
		getCharacterLanguages().remove(characterLanguage);
		characterLanguage.setCharacter(null);

		return characterLanguage;
	}

	public List<CharacterSkill> getCharacterSkills() {
		return this.characterSkills;
	}

	public void setCharacterSkills(List<CharacterSkill> characterSkills) {
		this.characterSkills = characterSkills;
	}

	public CharacterSkill addCharacterSkill(CharacterSkill characterSkill) {
		getCharacterSkills().add(characterSkill);
		characterSkill.setCharacter(this);

		return characterSkill;
	}

	public CharacterSkill removeCharacterSkill(CharacterSkill characterSkill) {
		getCharacterSkills().remove(characterSkill);
		characterSkill.setCharacter(null);

		return characterSkill;
	}

	public List<CharacterSpecialAbility> getCharacterSpecialAbilities() {
		return this.characterSpecialAbilities;
	}

	public void setCharacterSpecialAbilities(List<CharacterSpecialAbility> characterSpecialAbilities) {
		this.characterSpecialAbilities = characterSpecialAbilities;
	}

	public CharacterSpecialAbility addCharacterSpecialAbility(CharacterSpecialAbility characterSpecialAbility) {
		getCharacterSpecialAbilities().add(characterSpecialAbility);
		characterSpecialAbility.setCharacter(this);

		return characterSpecialAbility;
	}

	public CharacterSpecialAbility removeCharacterSpecialAbility(CharacterSpecialAbility characterSpecialAbility) {
		getCharacterSpecialAbilities().remove(characterSpecialAbility);
		characterSpecialAbility.setCharacter(null);

		return characterSpecialAbility;
	}

	public List<CharacterSpell> getCharacterSpells() {
		return this.characterSpells;
	}

	public void setCharacterSpells(List<CharacterSpell> characterSpells) {
		this.characterSpells = characterSpells;
	}

	public CharacterSpell addCharacterSpell(CharacterSpell characterSpell) {
		getCharacterSpells().add(characterSpell);
		characterSpell.setCharacter(this);

		return characterSpell;
	}

	public CharacterSpell removeCharacterSpell(CharacterSpell characterSpell) {
		getCharacterSpells().remove(characterSpell);
		characterSpell.setCharacter(null);

		return characterSpell;
	}

	public List<CharacterStatus> getCharacterStatuses() {
		return this.characterStatuses;
	}

	public void setCharacterStatuses(List<CharacterStatus> characterStatuses) {
		this.characterStatuses = characterStatuses;
	}

	public CharacterStatus addCharacterStatus(CharacterStatus characterStatus) {
		getCharacterStatuses().add(characterStatus);
		characterStatus.setCharacter(this);

		return characterStatus;
	}

	public CharacterStatus removeCharacterStatus(CharacterStatus characterStatus) {
		getCharacterStatuses().remove(characterStatus);
		characterStatus.setCharacter(null);

		return characterStatus;
	}

	public List<CharacterTalent> getCharacterTalents() {
		return this.characterTalents;
	}

	public void setCharacterTalents(List<CharacterTalent> characterTalents) {
		this.characterTalents = characterTalents;
	}

	public CharacterTalent addCharacterTalent(CharacterTalent characterTalent) {
		getCharacterTalents().add(characterTalent);
		characterTalent.setCharacter(this);

		return characterTalent;
	}

	public CharacterTalent removeCharacterTalent(CharacterTalent characterTalent) {
		getCharacterTalents().remove(characterTalent);
		characterTalent.setCharacter(null);

		return characterTalent;
	}

	public List<CharacterTransitionDetail> getCharacterTransitionDetails() {
		return this.characterTransitionDetails;
	}

	public void setCharacterTransitionDetails(List<CharacterTransitionDetail> characterTransitionDetails) {
		this.characterTransitionDetails = characterTransitionDetails;
	}

	public CharacterTransitionDetail addCharacterTransitionDetail(CharacterTransitionDetail characterTransitionDetail) {
		getCharacterTransitionDetails().add(characterTransitionDetail);
		characterTransitionDetail.setCharacter(this);

		return characterTransitionDetail;
	}

	public CharacterTransitionDetail removeCharacterTransitionDetail(CharacterTransitionDetail characterTransitionDetail) {
		getCharacterTransitionDetails().remove(characterTransitionDetail);
		characterTransitionDetail.setCharacter(null);

		return characterTransitionDetail;
	}

	public List<Quest> getQuests() {
		return this.quests;
	}

	public void setQuests(List<Quest> quests) {
		this.quests = quests;
	}

	public Quest addQuest(Quest quest) {
		getQuests().add(quest);
		quest.setCharacter(this);

		return quest;
	}

	public Quest removeQuest(Quest quest) {
		getQuests().remove(quest);
		quest.setCharacter(null);

		return quest;
	}

}