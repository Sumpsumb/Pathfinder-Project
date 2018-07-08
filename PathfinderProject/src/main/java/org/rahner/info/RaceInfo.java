package org.rahner.info;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.rahner.exceptions.CharacterInfoException;
import org.rahner.random.DiceAndRollFactory;

import entities.Language;
import entities.RaceLanguage;
import entities.SpecialAbility;
import services.RaceLanguageService;
import services.SpecialAbilityService;

public class RaceInfo {

	private String race;

	public RaceInfo(String race) throws CharacterInfoException {

		if (!race.equals("Elf") && !race.equals("Half Elf") && !race.equals("Half Orc") && !race.equals("Gnome")
				&& !race.equals("Halfling") && !race.equals("Dwarf") && !race.equals("Human")) {
			throw new CharacterInfoException("Invalid race");
		} else {
			this.race = race;
		}
	}

	public int getStrBonus() {

		if (race.equals("Halfling") || race.equals("Gnome")) {
			return -2;
		} else {
			return 0;
		}
	}

	public int getDexBonus() {

		if (race.equals("Halfling") || race.equals("Elf")) {
			return 2;
		} else {
			return 0;
		}
	}

	public int getConBonus() {

		if (race.equals("Dwarf") || race.equals("Gnome")) {
			return 2;
		} else if (race.equals("Elf")) {
			return -2;
		} else {
			return 0;
		}
	}

	public int getIntBonus() {

		if (race.equals("Elf")) {
			return 2;
		} else {
			return 0;
		}
	}

	public int getWisBonus() {

		if (race.equals("Dwarf")) {
			return 2;
		} else {
			return 0;
		}
	}

	public int getChaBonus() {

		if (race.equals("Halfling") || race.equals("Gnome")) {
			return 2;
		} else if (race.equals("Dwarf")) {
			return -2;
		} else {
			return 0;
		}
	}

	public String getSize() {

		if (race.equals("Gnome") || race.equals("Halfling")) {
			return "Small";
		} else {
			return "Medium";
		}
	}

	public boolean hasRandomAttribute() {

		if (race.equals("Human") || race.equals("Half Orc") || race.equals("Half Elf")) {
			return true;
		} else {
			return false;
		}
	}

	public int getSpeedGroundInMeters() {

		if (race.equals("Halfling") || race.equals("Gnome")) {
			return 6;
		} else {
			return 9;
		}
	}

	public ArrayList<Language> getNativeLanguages() {

		ArrayList<Language> resultList = new ArrayList<Language>();

		EntityManagerFactory emFactory = javax.persistence.Persistence.createEntityManagerFactory("PathfinderProject");
		EntityManager emEntityManager = emFactory.createEntityManager();

		RaceLanguageService raceLanguageService = new RaceLanguageService();
		raceLanguageService.setEm(emEntityManager);

		for (RaceLanguage raceLanguage : raceLanguageService.findNativeLanguages(race)) {
			resultList.add(raceLanguage.getLanguage());
		}

		return resultList;
	}

	public ArrayList<Language> getIntLanguages() {

		ArrayList<Language> resultList = new ArrayList<Language>();

		EntityManagerFactory emFactory = javax.persistence.Persistence.createEntityManagerFactory("PathfinderProject");
		EntityManager emEntityManager = emFactory.createEntityManager();

		RaceLanguageService raceLanguageService = new RaceLanguageService();
		raceLanguageService.setEm(emEntityManager);

		for (RaceLanguage raceLanguage : raceLanguageService.findIntLanguages(race)) {
			resultList.add(raceLanguage.getLanguage());
		}

		return resultList;
	}

	public List<SpecialAbility> getRaceSkills() {

		EntityManagerFactory emFactory = javax.persistence.Persistence.createEntityManagerFactory("PathfinderProject");
		EntityManager emEntityManager = emFactory.createEntityManager();

		SpecialAbilityService specialAbilityService = new SpecialAbilityService();
		specialAbilityService.setEm(emEntityManager);

		return specialAbilityService.findAllRaceSkills(race);

	}

	public int getAge(String className) throws CharacterInfoException {

		if (race.equals("Human") || race.equals("Half Orc")
				&& (className.equals("Sorcerer") || className.equals("Barbarian") || className.equals("Rogue"))) {
			DiceAndRollFactory diceAndRollFactory = new DiceAndRollFactory("1D4");
			return 15 + diceAndRollFactory.rollAndSum();
		} else if (race.equals("Human") || race.equals("Half Orc") && (className.equals("Bard")
				|| className.equals("Fighter") || className.equals("Paladin") || className.equals("Ranger"))) {
			DiceAndRollFactory diceAndRollFactory = new DiceAndRollFactory("1D6");
			return 15 + diceAndRollFactory.rollAndSum();
		} else if (race.equals("Human") || race.equals("Half Orc") && (className.equals("Druid")
				|| className.equals("Cleric") || className.equals("Wizard") || className.equals("Monk"))) {
			DiceAndRollFactory diceAndRollFactory = new DiceAndRollFactory("2D6");
			return 15 + diceAndRollFactory.rollAndSum();
		} else if (race.equals("Elf")
				&& (className.equals("Sorcerer") || className.equals("Barbarian") || className.equals("Rogue"))) {
			DiceAndRollFactory diceAndRollFactory = new DiceAndRollFactory("4D6");
			return 110 + diceAndRollFactory.rollAndSum();
		} else if (race.equals("Elf") && (className.equals("Bard") || className.equals("Fighter")
				|| className.equals("Paladin") || className.equals("Ranger"))) {
			DiceAndRollFactory diceAndRollFactory = new DiceAndRollFactory("6D6");
			return 110 + diceAndRollFactory.rollAndSum();
		} else if (race.equals("Elf") && (className.equals("Druid") || className.equals("Cleric")
				|| className.equals("Wizard") || className.equals("Monk"))) {
			DiceAndRollFactory diceAndRollFactory = new DiceAndRollFactory("10D6");
			return 110 + diceAndRollFactory.rollAndSum();
		} else if (race.equals("Gnome")
				&& (className.equals("Sorcerer") || className.equals("Barbarian") || className.equals("Rogue"))) {
			DiceAndRollFactory diceAndRollFactory = new DiceAndRollFactory("4D6");
			return 40 + diceAndRollFactory.rollAndSum();
		} else if (race.equals("Gnome") && (className.equals("Bard") || className.equals("Fighter")
				|| className.equals("Paladin") || className.equals("Ranger"))) {
			DiceAndRollFactory diceAndRollFactory = new DiceAndRollFactory("6D6");
			return 40 + diceAndRollFactory.rollAndSum();
		} else if (race.equals("Gnome") && (className.equals("Druid") || className.equals("Cleric")
				|| className.equals("Wizard") || className.equals("Monk"))) {
			DiceAndRollFactory diceAndRollFactory = new DiceAndRollFactory("9D6");
			return 40 + diceAndRollFactory.rollAndSum();
		} else if (race.equals("Half Elf")
				&& (className.equals("Sorcerer") || className.equals("Barbarian") || className.equals("Rogue"))) {
			DiceAndRollFactory diceAndRollFactory = new DiceAndRollFactory("1D6");
			return 20 + diceAndRollFactory.rollAndSum();
		} else if (race.equals("Half Elf") && (className.equals("Bard") || className.equals("Fighter")
				|| className.equals("Paladin") || className.equals("Ranger"))) {
			DiceAndRollFactory diceAndRollFactory = new DiceAndRollFactory("2D6");
			return 20 + diceAndRollFactory.rollAndSum();
		} else if (race.equals("Half Elf") && (className.equals("Druid") || className.equals("Cleric")
				|| className.equals("Wizard") || className.equals("Monk"))) {
			DiceAndRollFactory diceAndRollFactory = new DiceAndRollFactory("3D6");
			return 20 + diceAndRollFactory.rollAndSum();
		} else if (race.equals("Halfling")
				&& (className.equals("Sorcerer") || className.equals("Barbarian") || className.equals("Rogue"))) {
			DiceAndRollFactory diceAndRollFactory = new DiceAndRollFactory("2D4");
			return 20 + diceAndRollFactory.rollAndSum();
		} else if (race.equals("Halfling") && (className.equals("Bard") || className.equals("Fighter")
				|| className.equals("Paladin") || className.equals("Ranger"))) {
			DiceAndRollFactory diceAndRollFactory = new DiceAndRollFactory("3D6");
			return 20 + diceAndRollFactory.rollAndSum();
		} else if (race.equals("Halfling") && (className.equals("Druid") || className.equals("Cleric")
				|| className.equals("Wizard") || className.equals("Monk"))) {
			DiceAndRollFactory diceAndRollFactory = new DiceAndRollFactory("4D6");
			return 20 + diceAndRollFactory.rollAndSum();
		} else if (race.equals("Dwarf")
				&& (className.equals("Sorcerer") || className.equals("Barbarian") || className.equals("Rogue"))) {
			DiceAndRollFactory diceAndRollFactory = new DiceAndRollFactory("3D6");
			return 40 + diceAndRollFactory.rollAndSum();
		} else if (race.equals("Dwarf") && (className.equals("Bard") || className.equals("Fighter")
				|| className.equals("Paladin") || className.equals("Ranger"))) {
			DiceAndRollFactory diceAndRollFactory = new DiceAndRollFactory("5D6");
			return 40 + diceAndRollFactory.rollAndSum();
		} else if (race.equals("Dwarf") && (className.equals("Druid") || className.equals("Cleric")
				|| className.equals("Wizard") || className.equals("Monk"))) {
			DiceAndRollFactory diceAndRollFactory = new DiceAndRollFactory("7D6");
			return 40 + diceAndRollFactory.rollAndSum();
		} else {
			throw new CharacterInfoException("Invalid class or race");
		}

	}

	public double[] getHeightAndWeight(String gender) throws CharacterInfoException {
		if (!gender.equals("M") && !gender.equals("F")) {
			throw new CharacterInfoException("Invalid gender");
		}

		double[] heightAndWeight = new double[2];
		int rollResult;

		if (race.equals("Human")) {
			DiceAndRollFactory diceAndRollFactory = new DiceAndRollFactory("2D10");
			rollResult = diceAndRollFactory.rollAndSum();
			if (gender.equals("M")) {
				heightAndWeight[0] = 147 + rollResult * 2.5;
				heightAndWeight[1] = 120 + rollResult * 5;
				return heightAndWeight;
			} else if (gender.equals("F")) {
				heightAndWeight[0] = 135 + rollResult * 2.5;
				heightAndWeight[1] = 85 + rollResult * 5;
				return heightAndWeight;
			} else {
				return heightAndWeight;
			}
		} else if (race.equals("Elf")) {
			if (gender.equals("M")) {
				DiceAndRollFactory diceAndRollFactory = new DiceAndRollFactory("2D8");
				rollResult = diceAndRollFactory.rollAndSum();
				heightAndWeight[0] = 158 + rollResult * 2.5;
				heightAndWeight[1] = 100 + rollResult * 3;
				return heightAndWeight;
			} else if (gender.equals("F")) {
				DiceAndRollFactory diceAndRollFactory = new DiceAndRollFactory("2D6");
				rollResult = diceAndRollFactory.rollAndSum();
				heightAndWeight[0] = 158 + rollResult * 2.5;
				heightAndWeight[1] = 90 + rollResult * 3;
				return heightAndWeight;
			} else {
				return heightAndWeight;
			}
		} else if (race.equals("Gnome")) {
			DiceAndRollFactory diceAndRollFactory = new DiceAndRollFactory("2D4");
			rollResult = diceAndRollFactory.rollAndSum();
			if (gender.equals("M")) {
				heightAndWeight[0] = 91 + rollResult * 2.5;
				heightAndWeight[1] = 35 + rollResult;
				return heightAndWeight;
			} else if (gender.equals("F")) {
				heightAndWeight[0] = 86 + rollResult * 2.5;
				heightAndWeight[1] = 30 + rollResult;
				return heightAndWeight;
			} else {
				return heightAndWeight;
			}
		} else if (race.equals("Half Elf")) {
			DiceAndRollFactory diceAndRollFactory = new DiceAndRollFactory("2D8");
			rollResult = diceAndRollFactory.rollAndSum();
			if (gender.equals("M")) {
				heightAndWeight[0] = 152 + rollResult * 2.5;
				heightAndWeight[1] = 110 + rollResult * 5;
				return heightAndWeight;
			} else if (gender.equals("F")) {
				heightAndWeight[0] = 147 + rollResult * 2.5;
				heightAndWeight[1] = 90 + rollResult * 5;
				return heightAndWeight;
			} else {
				return heightAndWeight;
			}
		} else if (race.equals("Halfling")) {
			DiceAndRollFactory diceAndRollFactory = new DiceAndRollFactory("2D4");
			rollResult = diceAndRollFactory.rollAndSum();
			if (gender.equals("M")) {
				heightAndWeight[0] = 81 + rollResult * 2.5;
				heightAndWeight[1] = 30 + rollResult;
				return heightAndWeight;
			} else if (gender.equals("F")) {
				heightAndWeight[0] = 76 + rollResult * 2.5;
				heightAndWeight[1] = 25 + rollResult;
				return heightAndWeight;
			} else {
				return heightAndWeight;
			}
		} else if (race.equals("Half Orc")) {
			DiceAndRollFactory diceAndRollFactory = new DiceAndRollFactory("2D12");
			rollResult = diceAndRollFactory.rollAndSum();
			if (gender.equals("M")) {
				heightAndWeight[0] = 147 + rollResult * 2.5;
				heightAndWeight[1] = 150 + rollResult * 7;
				return heightAndWeight;
			} else if (gender.equals("F")) {
				heightAndWeight[0] = 135 + rollResult * 2.5;
				heightAndWeight[1] = 110 + rollResult * 7;
				return heightAndWeight;
			} else {
				return heightAndWeight;
			}
		} else if (race.equals("Dwarf")) {
			DiceAndRollFactory diceAndRollFactory = new DiceAndRollFactory("2D4");
			rollResult = diceAndRollFactory.rollAndSum();
			if (gender.equals("M")) {
				heightAndWeight[0] = 114 + rollResult * 2.5;
				heightAndWeight[1] = 150 + rollResult * 7;
				return heightAndWeight;
			} else if (gender.equals("F")) {
				heightAndWeight[0] = 109 + rollResult * 2.5;
				heightAndWeight[1] = 120 + rollResult * 7;
				return heightAndWeight;
			} else {
				return heightAndWeight;
			}
		} else {
			return heightAndWeight;
		}
	}
}
