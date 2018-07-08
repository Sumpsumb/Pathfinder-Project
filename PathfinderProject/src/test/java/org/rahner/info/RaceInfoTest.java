package org.rahner.info;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.rahner.exceptions.CharacterInfoException;

public class RaceInfoTest {

	@Test(expected = CharacterInfoException.class)
	public void exception_basic_race_String_test() throws CharacterInfoException {

		RaceInfo raceInfo = new RaceInfo("Test");
	}

	@Test
	public void heightAndWeight_baisc_human_male_test() {
		try {
			RaceInfo raceInfo = new RaceInfo("Human");
			assertTrue(raceInfo.getHeightAndWeight("M")[0] >= 147);
		} catch (CharacterInfoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void heightAndWeight_baisc_human_female_test() {
		try {
			RaceInfo raceInfo = new RaceInfo("Human");
			assertTrue(raceInfo.getHeightAndWeight("M")[0] >= 135);
		} catch (CharacterInfoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void heightAndWeight_baisc_elf_male_test() {
		try {
			RaceInfo raceInfo = new RaceInfo("Human");
			assertTrue(raceInfo.getHeightAndWeight("M")[0] >= 158);
		} catch (CharacterInfoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void heightAndWeight_baisc_elf_female_test() {
		try {
			RaceInfo raceInfo = new RaceInfo("Human");
			assertTrue(raceInfo.getHeightAndWeight("M")[0] >= 158);
		} catch (CharacterInfoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void heightAndWeight_baisc_gnome_male_test() {
		try {
			RaceInfo raceInfo = new RaceInfo("Human");
			assertTrue(raceInfo.getHeightAndWeight("M")[0] >= 91);
		} catch (CharacterInfoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void heightAndWeight_baisc_gnome_female_test() {
		try {
			RaceInfo raceInfo = new RaceInfo("Human");
			assertTrue(raceInfo.getHeightAndWeight("M")[0] >= 86);
		} catch (CharacterInfoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void heightAndWeight_baisc_HalfElf_male_test() {
		try {
			RaceInfo raceInfo = new RaceInfo("Human");
			assertTrue(raceInfo.getHeightAndWeight("M")[0] >= 152);
		} catch (CharacterInfoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void heightAndWeight_baisc_HalfElf_female_test() {
		try {
			RaceInfo raceInfo = new RaceInfo("Human");
			assertTrue(raceInfo.getHeightAndWeight("M")[0] >= 147);
		} catch (CharacterInfoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void heightAndWeight_baisc_halfling_male_test() {
		try {
			RaceInfo raceInfo = new RaceInfo("Human");
			assertTrue(raceInfo.getHeightAndWeight("M")[0] >= 81);
		} catch (CharacterInfoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void heightAndWeight_baisc_halfling_female_test() {
		try {
			RaceInfo raceInfo = new RaceInfo("Human");
			assertTrue(raceInfo.getHeightAndWeight("M")[0] >= 76);
		} catch (CharacterInfoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void heightAndWeight_baisc_halfOrc_male_test() {
		try {
			RaceInfo raceInfo = new RaceInfo("Human");
			assertTrue(raceInfo.getHeightAndWeight("M")[0] >= 147);
		} catch (CharacterInfoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void heightAndWeight_baisc_halfOrc_female_test() {
		try {
			RaceInfo raceInfo = new RaceInfo("Human");
			assertTrue(raceInfo.getHeightAndWeight("M")[0] >= 135);
		} catch (CharacterInfoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void heightAndWeight_baisc_dwarf_male_test() {
		try {
			RaceInfo raceInfo = new RaceInfo("Human");
			assertTrue(raceInfo.getHeightAndWeight("M")[0] >= 114);
		} catch (CharacterInfoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void heightAndWeight_baisc_dwarf_female_test() {
		try {
			RaceInfo raceInfo = new RaceInfo("Human");
			assertTrue(raceInfo.getHeightAndWeight("M")[0] >= 109);
		} catch (CharacterInfoException e) {
			e.printStackTrace();
		}
	}
}
