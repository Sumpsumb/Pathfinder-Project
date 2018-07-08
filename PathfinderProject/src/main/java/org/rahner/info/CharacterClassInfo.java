package org.rahner.info;

import java.util.ArrayList;

import org.rahner.random.DiceAndRollFactory;
import org.rahner.view.Attributes;

public class CharacterClassInfo {

	private String characterClass;

	private int classLevel;

	private int[] BAB = new int[4];

	private int[] knownSpells = new int[10];

	private int[] spellsPerDay = new int[10];

	private ArrayList<String> classSkills = new ArrayList<String>();

	// Constructor

	public CharacterClassInfo(String characterClassString, int classLevel) {

		// TODO:Add other classes

		if (characterClassString.equals("Sorcerer")) {
			this.characterClass = characterClassString;
			this.classLevel = classLevel;
			this.knownSpells[0] = getAmountOfKnownSpells(0);
			this.knownSpells[1] = getAmountOfKnownSpells(1);
			this.knownSpells[2] = getAmountOfKnownSpells(2);
			this.knownSpells[3] = getAmountOfKnownSpells(3);
			this.knownSpells[4] = getAmountOfKnownSpells(4);
			this.knownSpells[5] = getAmountOfKnownSpells(5);
			this.knownSpells[6] = getAmountOfKnownSpells(6);
			this.knownSpells[7] = getAmountOfKnownSpells(7);
			this.knownSpells[8] = getAmountOfKnownSpells(8);
			this.knownSpells[9] = getAmountOfKnownSpells(9);
			this.BAB[0] = getBAB(0);
			this.BAB[1] = getBAB(1);
			this.BAB[2] = getBAB(2);
			this.BAB[3] = getBAB(3);
			this.spellsPerDay[0] = getSpellsPerDay(0);
			this.spellsPerDay[1] = getSpellsPerDay(1);
			this.spellsPerDay[2] = getSpellsPerDay(2);
			this.spellsPerDay[3] = getSpellsPerDay(3);
			this.spellsPerDay[4] = getSpellsPerDay(4);
			this.spellsPerDay[5] = getSpellsPerDay(5);
			this.spellsPerDay[6] = getSpellsPerDay(6);
			this.spellsPerDay[7] = getSpellsPerDay(7);
			this.spellsPerDay[8] = getSpellsPerDay(8);
			this.spellsPerDay[9] = getSpellsPerDay(9);
			this.classSkills.add("Profession");
			this.classSkills.add("Bluff");
			this.classSkills.add("Intimidate");
			this.classSkills.add("Fly");
			this.classSkills.add("Craft");
			this.classSkills.add("Use magic device");
			this.classSkills.add("Appraise");
			this.classSkills.add("Knowledge(Arcana)");
			this.classSkills.add("Spellcraft");

		} else if (characterClassString.equals("Fighter")) {

			this.characterClass = characterClassString;
			this.classLevel = classLevel;
			this.BAB[0] = getBAB(0);
			this.BAB[1] = getBAB(1);
			this.BAB[2] = getBAB(2);
			this.BAB[3] = getBAB(3);
			this.classSkills.add("Profession(Smith)");
			this.classSkills.add("Climb");
			this.classSkills.add("Intimidate");
			this.classSkills.add("Handle Animal");
			this.classSkills.add("Craft");
			this.classSkills.add("Ride");
			this.classSkills.add("Swim");
			this.classSkills.add("Survival");
			this.classSkills.add("Knowledge(Dungoneering)");
			this.classSkills.add("Knowledge(Engeneering)");

		} else if (characterClassString.equals("Barbarian")) {

			this.characterClass = characterClassString;
			this.classLevel = classLevel;
			this.BAB[0] = getBAB(0);
			this.BAB[1] = getBAB(1);
			this.BAB[2] = getBAB(2);
			this.BAB[3] = getBAB(3);
			this.classSkills.add("Acrobatics");
			this.classSkills.add("Intimidate");
			this.classSkills.add("Craft(Alchemy)");
			this.classSkills.add("Climb");
			this.classSkills.add("Handle Animal");
			this.classSkills.add("Ride");
			this.classSkills.add("Swim");
			this.classSkills.add("Survival");
			this.classSkills.add("Perception");
			this.classSkills.add("Knowledge(Nature)");

		} else if (characterClassString.equals("Bard")) {

			this.characterClass = characterClassString;
			this.classLevel = classLevel;
			this.knownSpells[0] = getAmountOfKnownSpells(0);
			this.knownSpells[1] = getAmountOfKnownSpells(1);
			this.knownSpells[2] = getAmountOfKnownSpells(2);
			this.knownSpells[3] = getAmountOfKnownSpells(3);
			this.knownSpells[4] = getAmountOfKnownSpells(4);
			this.knownSpells[5] = getAmountOfKnownSpells(5);
			this.knownSpells[6] = getAmountOfKnownSpells(6);
			this.BAB[0] = getBAB(0);
			this.BAB[1] = getBAB(1);
			this.BAB[2] = getBAB(2);
			this.BAB[3] = getBAB(3);
			this.spellsPerDay[0] = getSpellsPerDay(0);
			this.spellsPerDay[1] = getSpellsPerDay(1);
			this.spellsPerDay[2] = getSpellsPerDay(2);
			this.spellsPerDay[3] = getSpellsPerDay(3);
			this.spellsPerDay[4] = getSpellsPerDay(4);
			this.spellsPerDay[5] = getSpellsPerDay(5);
			this.spellsPerDay[6] = getSpellsPerDay(6);
			// TODO:Add specific Professions
			this.classSkills.add("Acrobatics");
			this.classSkills.add("Perform(Dance)");
			// TODO:Add all perfomance
			this.classSkills.add("Profession");
			this.classSkills.add("Bluff");
			this.classSkills.add("Diplomacy");
			this.classSkills.add("Intimidate");
			this.classSkills.add("Sleight of Hand");
			// TODO:Add all crafts
			this.classSkills.add("Craft(Alchemy)");
			this.classSkills.add("Stealth");
			this.classSkills.add("Climb");
			this.classSkills.add("Use magic Device");
			this.classSkills.add("Sense Motiv");
			this.classSkills.add("Appraise");
			this.classSkills.add("Linguistics");
			this.classSkills.add("Disguise");
			this.classSkills.add("Perception");
			this.classSkills.add("Knowledge(Arcana)");
			this.classSkills.add("Knowledge(Dungoneering)");
			this.classSkills.add("Knowledge(Engeneering)");
			this.classSkills.add("Knowledge(Geography)");
			this.classSkills.add("Knowledge(History)");
			this.classSkills.add("Knowledge(Local)");
			this.classSkills.add("Knowledge(Nature)");
			this.classSkills.add("Knowledge(Nobility)");
			this.classSkills.add("Knowledge(Planes)");
			this.classSkills.add("Knowledge(Religion)");
			this.classSkills.add("Spellcraft");
		}
	}

	// Setter

	public void setcharacterClass(String characterClass) {

		this.characterClass = characterClass;
	}

	public void setCharacterLevel(int classLevel) {

		this.classLevel = classLevel;
	}

	// Getter

	public int getKnownSpells(int spellLevel) {

		return this.knownSpells[spellLevel];
	}

	public int[] getBAB() {

		return this.BAB;
	}

	public int getBaseHP() {

		if (characterClass.equals("Sorcerer")) {
			return 6;
		} else if (characterClass.equals("Fighter")) {
			return 10;
		} else if (characterClass.equals("Barbarian")) {
			return 12;
		} else if (characterClass.equals("Bard")) {
			return 8;
		} else {
			return 0;
		}
	}

	public int[] getSpellsPerDay() {

		return this.spellsPerDay;
	}

	// Methods

	public int getAmountOfKnownSpells(int spellLevel) {

		if (characterClass.equals("Sorcerer")) {

			if (classLevel == 1 && spellLevel == 0) {
				return 4;
			} else if ((classLevel == 2 || classLevel == 3) && spellLevel == 0) {
				return 5;
			} else if ((classLevel == 4 || classLevel == 5) && spellLevel == 0) {
				return 6;
			} else if ((classLevel == 6 || classLevel == 7) && spellLevel == 0) {
				return 7;
			} else if ((classLevel == 8 || classLevel == 9) && spellLevel == 0) {
				return 8;
			} else if (classLevel >= 10 && spellLevel == 0) {
				return 9;
			} else if ((classLevel == 1 || classLevel == 2) && spellLevel == 1) {
				return 2;
			} else if ((classLevel == 3 || classLevel == 4) && spellLevel == 1) {
				return 3;
			} else if ((classLevel == 5 || classLevel == 6) && spellLevel == 1) {
				return 4;
			} else if (classLevel >= 7 && spellLevel == 1) {
				return 5;
			} else if (classLevel == 4 && spellLevel == 2) {
				return 1;
			} else if ((classLevel == 5 || classLevel == 6) && spellLevel == 2) {
				return 2;
			} else if ((classLevel == 7 || classLevel == 8) && spellLevel == 2) {
				return 3;
			} else if ((classLevel == 9 || classLevel == 10) && spellLevel == 2) {
				return 4;
			} else if (classLevel >= 11 && spellLevel == 2) {
				return 5;
			} else if (classLevel == 6 && spellLevel == 3) {
				return 1;
			} else if ((classLevel == 7 || classLevel == 8) && spellLevel == 3) {
				return 2;
			} else if ((classLevel == 9 || classLevel == 10) && spellLevel == 3) {
				return 3;
			} else if (classLevel >= 11 && spellLevel == 3) {
				return 4;
			} else if (classLevel == 8 && spellLevel == 4) {
				return 1;
			} else if ((classLevel == 9 || classLevel == 10) && spellLevel == 4) {
				return 2;
			} else if ((classLevel == 11 || classLevel == 12) && spellLevel == 4) {
				return 3;
			} else if (classLevel >= 13 && spellLevel == 4) {
				return 4;
			} else if (classLevel == 10 && spellLevel == 5) {
				return 1;
			} else if ((classLevel == 11 || classLevel == 12) && spellLevel == 5) {
				return 2;
			} else if ((classLevel == 13 || classLevel == 14) && spellLevel == 5) {
				return 3;
			} else if (classLevel >= 15 && spellLevel == 5) {
				return 4;
			} else if (classLevel == 12 && spellLevel == 6) {
				return 1;
			} else if ((classLevel == 13 || classLevel == 14) && spellLevel == 6) {
				return 2;
			} else if (classLevel >= 15 && spellLevel == 6) {
				return 3;
			} else if (classLevel == 14 && spellLevel == 7) {
				return 1;
			} else if ((classLevel == 15 || classLevel == 16) && spellLevel == 7) {
				return 2;
			} else if (classLevel >= 17 && spellLevel == 7) {
				return 3;
			} else if (classLevel == 16 && spellLevel == 8) {
				return 1;
			} else if ((classLevel == 17 || classLevel == 18) && spellLevel == 8) {
				return 2;
			} else if (classLevel >= 19 && spellLevel == 8) {
				return 3;
			} else if (classLevel == 18 && spellLevel == 9) {
				return 1;
			} else if (classLevel == 19 && spellLevel == 9) {
				return 2;
			} else if (classLevel == 20 && spellLevel == 9) {
				return 3;
			} else {
				return 0;
			}
		} else if (characterClass.equals("Bard")) {

			if (classLevel == 1 && spellLevel == 0) {
				return 4;
			} else if (classLevel == 2 && spellLevel == 0) {
				return 5;
			} else if (classLevel >= 3 && spellLevel == 0) {
				return 6;
			} else if (classLevel == 1 && spellLevel == 1) {
				return 2;
			} else if (classLevel == 2 && spellLevel == 1) {
				return 3;
			} else if ((classLevel >= 3 && classLevel <= 6) && spellLevel == 1) {
				return 4;
			} else if ((classLevel >= 7 && classLevel <= 10) && spellLevel == 1) {
				return 5;
			} else if (classLevel >= 11 && spellLevel == 1) {
				return 6;
			} else if ((classLevel >= 1 && classLevel <= 3) && spellLevel == 2) {
				return 0;
			} else if (classLevel == 4 && spellLevel == 2) {
				return 2;
			} else if (classLevel == 5 && spellLevel == 2) {
				return 3;
			} else if ((classLevel >= 6 && classLevel <= 9) && spellLevel == 2) {
				return 4;
			} else if ((classLevel >= 10 && classLevel <= 13) && spellLevel == 2) {
				return 5;
			} else if (classLevel >= 14 && spellLevel == 2) {
				return 6;
			} else if ((classLevel >= 1 && classLevel <= 6) && spellLevel == 3) {
				return 0;
			} else if (classLevel == 7 && spellLevel == 3) {
				return 2;
			} else if (classLevel == 8 && spellLevel == 3) {
				return 3;
			} else if ((classLevel >= 9 && classLevel <= 12) && spellLevel == 3) {
				return 4;
			} else if ((classLevel >= 13 && classLevel <= 16) && spellLevel == 3) {
				return 5;
			} else if (classLevel >= 17 && spellLevel == 3) {
				return 6;
			} else if ((classLevel >= 1 && classLevel <= 9) && spellLevel == 4) {
				return 0;
			} else if (classLevel == 10 && spellLevel == 4) {
				return 2;
			} else if (classLevel == 11 && spellLevel == 4) {
				return 3;
			} else if ((classLevel >= 12 && classLevel <= 15) && spellLevel == 4) {
				return 4;
			} else if ((classLevel >= 16 && classLevel <= 19) && spellLevel == 4) {
				return 5;
			} else if (classLevel == 20 && spellLevel == 4) {
				return 6;
			} else if ((classLevel >= 1 && classLevel <= 12) && spellLevel == 5) {
				return 0;
			} else if (classLevel == 13 && spellLevel == 5) {
				return 2;
			} else if (classLevel == 14 && spellLevel == 5) {
				return 3;
			} else if ((classLevel >= 15 && classLevel <= 18) && spellLevel == 5) {
				return 4;
			} else if ((classLevel >= 19 && classLevel <= 20) && spellLevel == 5) {
				return 5;
			} else if ((classLevel >= 1 && classLevel <= 15) && spellLevel == 6) {
				return 0;
			} else if (classLevel == 16 && spellLevel == 5) {
				return 2;
			} else if (classLevel == 17 && spellLevel == 5) {
				return 3;
			} else if ((classLevel >= 18 && classLevel <= 19) && spellLevel == 5) {
				return 4;
			} else if (classLevel == 20 && spellLevel == 5) {
				return 5;
			} else {
				return 0;
			}

		} else {
			return 0;
		}
	}

	public int getAmountOfKnownSpells(int classLevel, int spellLevel) {

		if (characterClass.equals("Sorcerer")) {

			if (classLevel == 1 && spellLevel == 0) {
				return 4;
			} else if ((classLevel == 2 || classLevel == 3) && spellLevel == 0) {
				return 5;
			} else if ((classLevel == 4 || classLevel == 5) && spellLevel == 0) {
				return 6;
			} else if ((classLevel == 6 || classLevel == 7) && spellLevel == 0) {
				return 7;
			} else if ((classLevel == 8 || classLevel == 9) && spellLevel == 0) {
				return 8;
			} else if (classLevel >= 10 && spellLevel == 0) {
				return 9;
			} else if ((classLevel == 1 || classLevel == 2) && spellLevel == 1) {
				return 2;
			} else if ((classLevel == 3 || classLevel == 4) && spellLevel == 1) {
				return 3;
			} else if ((classLevel == 5 || classLevel == 6) && spellLevel == 1) {
				return 4;
			} else if (classLevel >= 7 && spellLevel == 1) {
				return 5;
			} else if (classLevel == 4 && spellLevel == 2) {
				return 1;
			} else if ((classLevel == 5 || classLevel == 6) && spellLevel == 2) {
				return 2;
			} else if ((classLevel == 7 || classLevel == 8) && spellLevel == 2) {
				return 3;
			} else if ((classLevel == 9 || classLevel == 10) && spellLevel == 2) {
				return 4;
			} else if (classLevel >= 11 && spellLevel == 2) {
				return 5;
			} else if (classLevel == 6 && spellLevel == 3) {
				return 1;
			} else if ((classLevel == 7 || classLevel == 8) && spellLevel == 3) {
				return 2;
			} else if ((classLevel == 9 || classLevel == 10) && spellLevel == 3) {
				return 3;
			} else if (classLevel >= 11 && spellLevel == 3) {
				return 4;
			} else if (classLevel == 8 && spellLevel == 4) {
				return 1;
			} else if ((classLevel == 9 || classLevel == 10) && spellLevel == 4) {
				return 2;
			} else if ((classLevel == 11 || classLevel == 12) && spellLevel == 4) {
				return 3;
			} else if (classLevel >= 13 && spellLevel == 4) {
				return 4;
			} else if (classLevel == 10 && spellLevel == 5) {
				return 1;
			} else if ((classLevel == 11 || classLevel == 12) && spellLevel == 5) {
				return 2;
			} else if ((classLevel == 13 || classLevel == 14) && spellLevel == 5) {
				return 3;
			} else if (classLevel >= 15 && spellLevel == 5) {
				return 4;
			} else if (classLevel == 12 && spellLevel == 6) {
				return 1;
			} else if ((classLevel == 13 || classLevel == 14) && spellLevel == 6) {
				return 2;
			} else if (classLevel >= 15 && spellLevel == 6) {
				return 3;
			} else if (classLevel == 14 && spellLevel == 7) {
				return 1;
			} else if ((classLevel == 15 || classLevel == 16) && spellLevel == 7) {
				return 2;
			} else if (classLevel >= 17 && spellLevel == 7) {
				return 3;
			} else if (classLevel == 16 && spellLevel == 8) {
				return 1;
			} else if ((classLevel == 17 || classLevel == 18) && spellLevel == 8) {
				return 2;
			} else if (classLevel >= 19 && spellLevel == 8) {
				return 3;
			} else if (classLevel == 18 && spellLevel == 9) {
				return 1;
			} else if (classLevel == 19 && spellLevel == 9) {
				return 2;
			} else if (classLevel == 20 && spellLevel == 9) {
				return 3;
			} else {
				return 0;
			}
		} else if (characterClass.equals("Bard")) {

			if (classLevel == 1 && spellLevel == 0) {
				return 4;
			} else if (classLevel == 2 && spellLevel == 0) {
				return 5;
			} else if (classLevel >= 3 && spellLevel == 0) {
				return 6;
			} else if (classLevel == 1 && spellLevel == 1) {
				return 2;
			} else if (classLevel == 2 && spellLevel == 1) {
				return 3;
			} else if ((classLevel >= 3 && classLevel <= 6) && spellLevel == 1) {
				return 4;
			} else if ((classLevel >= 7 && classLevel <= 10) && spellLevel == 1) {
				return 5;
			} else if (classLevel >= 11 && spellLevel == 1) {
				return 6;
			} else if ((classLevel >= 1 && classLevel <= 3) && spellLevel == 2) {
				return 0;
			} else if (classLevel == 4 && spellLevel == 2) {
				return 2;
			} else if (classLevel == 5 && spellLevel == 2) {
				return 3;
			} else if ((classLevel >= 6 && classLevel <= 9) && spellLevel == 2) {
				return 4;
			} else if ((classLevel >= 10 && classLevel <= 13) && spellLevel == 2) {
				return 5;
			} else if (classLevel >= 14 && spellLevel == 2) {
				return 6;
			} else if ((classLevel >= 1 && classLevel <= 6) && spellLevel == 3) {
				return 0;
			} else if (classLevel == 7 && spellLevel == 3) {
				return 2;
			} else if (classLevel == 8 && spellLevel == 3) {
				return 3;
			} else if ((classLevel >= 9 && classLevel <= 12) && spellLevel == 3) {
				return 4;
			} else if ((classLevel >= 13 && classLevel <= 16) && spellLevel == 3) {
				return 5;
			} else if (classLevel >= 17 && spellLevel == 3) {
				return 6;
			} else if ((classLevel >= 1 && classLevel <= 9) && spellLevel == 4) {
				return 0;
			} else if (classLevel == 10 && spellLevel == 4) {
				return 2;
			} else if (classLevel == 11 && spellLevel == 4) {
				return 3;
			} else if ((classLevel >= 12 && classLevel <= 15) && spellLevel == 4) {
				return 4;
			} else if ((classLevel >= 16 && classLevel <= 19) && spellLevel == 4) {
				return 5;
			} else if (classLevel == 20 && spellLevel == 4) {
				return 6;
			} else if ((classLevel >= 1 && classLevel <= 12) && spellLevel == 5) {
				return 0;
			} else if (classLevel == 13 && spellLevel == 5) {
				return 2;
			} else if (classLevel == 14 && spellLevel == 5) {
				return 3;
			} else if ((classLevel >= 15 && classLevel <= 18) && spellLevel == 5) {
				return 4;
			} else if ((classLevel >= 19 && classLevel <= 20) && spellLevel == 5) {
				return 5;
			} else if ((classLevel >= 1 && classLevel <= 15) && spellLevel == 6) {
				return 0;
			} else if (classLevel == 16 && spellLevel == 5) {
				return 2;
			} else if (classLevel == 17 && spellLevel == 5) {
				return 3;
			} else if ((classLevel >= 18 && classLevel <= 19) && spellLevel == 5) {
				return 4;
			} else if (classLevel == 20 && spellLevel == 5) {
				return 5;
			} else {
				return 0;
			}

		} else {
			return 0;
		}
	}

	public int getBAB(int i) {

		if (characterClass.equals("Sorcerer")) {

			int[] BAB = { classLevel / 2, (classLevel / 12) * ((classLevel / 2) - 5), 0, 0 };
			return BAB[i];

		} else if (characterClass.equals("Fighter") || characterClass.equals("Barbarian")) {

			int[] BAB = { classLevel, ((classLevel / 6) - (classLevel / 12) - (classLevel / 18)) * (classLevel - 5),
					(classLevel / 11) * (classLevel - 10), (classLevel / 16) * (classLevel - 15) };
			return BAB[i];
		} else if (characterClass.equals("Bard")) {

			int[] BAB = { (classLevel - 1) - ((classLevel - 1) / 4), 0,
					(classLevel - 14 - (classLevel / 17)) * (classLevel / 15), 0 };

			if (classLevel >= 1 && classLevel <= 7) {
				BAB[1] = 0;
			} else if (classLevel >= 8 && classLevel <= 9) {
				BAB[1] = 1;
			} else if (classLevel == 10) {
				BAB[1] = 2;
			} else if (classLevel == 11) {
				BAB[1] = 3;
			} else if (classLevel >= 12 && classLevel <= 13) {
				BAB[1] = 4;
			} else if (classLevel == 14) {
				BAB[1] = 5;
			} else if (classLevel == 15) {
				BAB[1] = 6;
			} else if (classLevel >= 16 && classLevel <= 17) {
				BAB[1] = 7;
			} else if (classLevel == 18) {
				BAB[1] = 8;
			} else if (classLevel == 19) {
				BAB[1] = 9;
			} else if (classLevel == 20) {
				BAB[1] = 10;
			}

			return BAB[i];
		} else {

			int[] BAB = { 0, 0, 0, 0 };
			return BAB[i];
		}
	}

	public int getReflex() {

		if (characterClass.equals("Sorcerer") || characterClass.equals("Fighter")
				|| characterClass.equals("Barbarian")) {
			return classLevel / 3;
		} else if (characterClass.equals("Bard")) {
			return (classLevel) - (classLevel - 3) / 2;
			// TODO:Fix that
		} else {

			return 0;
		}

	}

	public int getWill() {

		if (characterClass.equals("Sorcerer")) {
			return (classLevel + 4) / 2;
		} else if (characterClass.equals("Fighter") || characterClass.equals("Barbarian")) {
			return classLevel / 3;
		} else {

			return 0;
		}
	}

	public int getFortitude() {

		if (characterClass.equals("Sorcerer")) {
			return getReflex();
		} else if (characterClass.equals("Fighter") || characterClass.equals("Barbarian")) {
			return (classLevel / 2) + 2;
		} else {

			return 0;
		}
	}

	public int getSpellsPerDay(int spellLevel) {

		if (characterClass.equals("Sorcerer")) {

			if (spellLevel == 0) {
				return 0;
			}

			if (classLevel == 1 && spellLevel == 1) {
				return 3;
			} else if (classLevel == 2 && spellLevel == 1) {
				return 4;
			} else if (classLevel == 3 && spellLevel == 1) {
				return 5;
			} else if (classLevel >= 4 && spellLevel == 1) {
				return 6;
			} else if (classLevel < 2 * spellLevel) {
				return 0;
			} else if (classLevel == 2 * spellLevel && classLevel % spellLevel == 0) {
				return 3;
			} else if (classLevel == (2 * spellLevel) + 1) {
				return 4;
			} else if (classLevel == (2 * spellLevel) + 2) {
				return 5;
			} else if (classLevel >= (2 * spellLevel) + 3) {
				return 6;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}

	public int getBaseAmountOfSkillPointsPerLevel() {

		if (characterClass.equals("Sorcerer") || characterClass.equals("Fighter")) {

			return 2;
		} else if (characterClass.equals("Barbarian")) {
			return 4;
		} else {
			return 0;
		}
	}

	public boolean isAbleToUseSimpleWeapons() {

		if (characterClass.equals("Sorcerer") || characterClass.equals("Fighter")
				|| characterClass.equals("Barbarian")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isAbleToUseShields() {
		if (characterClass.equals("Sorcerer")) {
			return false;
		} else if (characterClass.equals("Fighter") || characterClass.equals("Barbarian")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isAbleToUseArmors() {
		if (characterClass.equals("Sorcerer")) {
			return false;
		} else if (characterClass.equals("Fighter") || characterClass.equals("Barbarian")) {
			return true;
		} else {
			return false;
		}
	}

	public String getPrimaryAttribute() {
		if (characterClass.equals("Sorcerer")) {
			return Attributes.CHA.toString();
		} else {
			return null;
		}
	}

	public int getStartMoneyInGold() {
		if (characterClass.equals("Sorcerer")) {

			DiceAndRollFactory diceAndRollFactory = new DiceAndRollFactory("2D6");
			return diceAndRollFactory.rollAndSum() * 10;

		} else if (characterClass.equals("Fighter")) {

			DiceAndRollFactory diceAndRollFactory = new DiceAndRollFactory("5D6");
			return diceAndRollFactory.rollAndSum() * 10;

		} else if (characterClass.equals("Barbarian")) {

			DiceAndRollFactory diceAndRollFactory = new DiceAndRollFactory("3D6");
			return diceAndRollFactory.rollAndSum() * 10;
		} else {
			return 0;
		}
	}

	public int getAverageStartMoneyinGold() {
		if (characterClass.equals("Sorcerer")) {
			return 70;
		} else if (characterClass.equals("Fighter")) {
			return 175;
		} else if (characterClass.equals("Barbarian")) {
			return 105;
		} else {
			return 0;
		}
	}

	public ArrayList<String> getClassSkills() {
		return this.classSkills;
	}
}
