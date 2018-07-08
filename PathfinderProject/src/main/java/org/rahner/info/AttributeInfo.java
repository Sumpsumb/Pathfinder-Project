package org.rahner.info;

public class AttributeInfo {

	private int modificator;

	public void setModificator(int modificator) {

		this.modificator = modificator;
	}

	public int getModi(int attributeValue) {

		if (attributeValue % 2 == 0) {

			return (attributeValue / 2) - 5;
		} else {

			return ((attributeValue - 1) / 2) - 5;
		}
	}

	public int getAdditionalSpellsPerDay(int spellLvl) {

		if (spellLvl == 0) {

			return 0;
		}

		if (modificator - spellLvl < 0) {

			return 0;
		} else if (modificator - spellLvl == 0) {

			return 1;
		} else {

			return ((modificator - spellLvl) / 4) + 1;
		}
	}

	public int getAdditionalSpellsPerDay(int attributeValue, int spellLvl) {

		if (spellLvl == 0) {

			return 0;
		}

		if (getModi(attributeValue) - spellLvl < 0) {

			return 0;
		} else if (getModi(attributeValue) - spellLvl == 0) {

			return 1;
		} else {

			return ((getModi(attributeValue) - spellLvl) / 4) + 1;
		}
	}
}
