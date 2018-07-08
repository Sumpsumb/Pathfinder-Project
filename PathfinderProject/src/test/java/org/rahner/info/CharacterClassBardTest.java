package org.rahner.info;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CharacterClassBardTest {

	private CharacterClassInfo characterClassInfo;

	// BAB

	@Test
	public void test_BAB_1_1() {

		characterClassInfo = new CharacterClassInfo("Bard", 1);
		assertEquals(0, characterClassInfo.getBAB()[0]);
	}

	@Test
	public void test_BAB_1_2() {

		characterClassInfo = new CharacterClassInfo("Bard", 2);
		assertEquals(1, characterClassInfo.getBAB()[0]);
	}

	@Test
	public void test_BAB_1_3() {

		characterClassInfo = new CharacterClassInfo("Bard", 3);
		assertEquals(2, characterClassInfo.getBAB()[0]);
	}

	@Test
	public void test_BAB_1_4() {

		characterClassInfo = new CharacterClassInfo("Bard", 4);
		assertEquals(3, characterClassInfo.getBAB()[0]);
	}

	@Test
	public void test_BAB_1_5() {

		characterClassInfo = new CharacterClassInfo("Bard", 5);
		assertEquals(3, characterClassInfo.getBAB()[0]);
	}

	@Test
	public void test_BAB_1_6() {

		characterClassInfo = new CharacterClassInfo("Bard", 6);
		assertEquals(4, characterClassInfo.getBAB()[0]);
	}

	@Test
	public void test_BAB_1_7() {

		characterClassInfo = new CharacterClassInfo("Bard", 7);
		assertEquals(5, characterClassInfo.getBAB()[0]);
	}

	@Test
	public void test_BAB_1_8() {

		characterClassInfo = new CharacterClassInfo("Bard", 8);
		assertEquals(6, characterClassInfo.getBAB()[0]);
	}

	@Test
	public void test_BAB_1_9() {

		characterClassInfo = new CharacterClassInfo("Bard", 9);
		assertEquals(6, characterClassInfo.getBAB()[0]);
	}

	@Test
	public void test_BAB_1_10() {

		characterClassInfo = new CharacterClassInfo("Bard", 10);
		assertEquals(7, characterClassInfo.getBAB()[0]);
	}

	@Test
	public void test_BAB_1_11() {

		characterClassInfo = new CharacterClassInfo("Bard", 11);
		assertEquals(8, characterClassInfo.getBAB()[0]);
	}

	@Test
	public void test_BAB_1_12() {

		characterClassInfo = new CharacterClassInfo("Bard", 12);
		assertEquals(9, characterClassInfo.getBAB()[0]);
	}

	@Test
	public void test_BAB_1_13() {

		characterClassInfo = new CharacterClassInfo("Bard", 13);
		assertEquals(9, characterClassInfo.getBAB()[0]);
	}

	@Test
	public void test_BAB_1_14() {

		characterClassInfo = new CharacterClassInfo("Bard", 14);
		assertEquals(10, characterClassInfo.getBAB()[0]);
	}

	@Test
	public void test_BAB_1_15() {

		characterClassInfo = new CharacterClassInfo("Bard", 15);
		assertEquals(11, characterClassInfo.getBAB()[0]);
	}

	@Test
	public void test_BAB_1_16() {

		characterClassInfo = new CharacterClassInfo("Bard", 16);
		assertEquals(12, characterClassInfo.getBAB()[0]);
	}

	@Test
	public void test_BAB_1_17() {

		characterClassInfo = new CharacterClassInfo("Bard", 17);
		assertEquals(12, characterClassInfo.getBAB()[0]);
	}

	@Test
	public void test_BAB_1_18() {

		characterClassInfo = new CharacterClassInfo("Bard", 18);
		assertEquals(13, characterClassInfo.getBAB()[0]);
	}

	@Test
	public void test_BAB_1_19() {

		characterClassInfo = new CharacterClassInfo("Bard", 19);
		assertEquals(14, characterClassInfo.getBAB()[0]);
	}

	@Test
	public void test_BAB_1_20() {

		characterClassInfo = new CharacterClassInfo("Bard", 20);
		assertEquals(15, characterClassInfo.getBAB()[0]);
	}

	@Test
	public void test_BAB_2_1to7() {

		for (int i = 0; i < 7; i++) {

			characterClassInfo = new CharacterClassInfo("Bard", i + 1);
			assertEquals(0, characterClassInfo.getBAB()[1]);
		}
	}

	@Test
	public void test_BAB_2_8() {

		characterClassInfo = new CharacterClassInfo("Bard", 8);
		assertEquals(1, characterClassInfo.getBAB()[1]);
	}

	@Test
	public void test_BAB_2_9() {

		characterClassInfo = new CharacterClassInfo("Bard", 9);
		assertEquals(1, characterClassInfo.getBAB()[1]);
	}

	@Test
	public void test_BAB_2_10() {

		characterClassInfo = new CharacterClassInfo("Bard", 10);
		assertEquals(2, characterClassInfo.getBAB()[1]);
	}

	@Test
	public void test_BAB_2_11() {

		characterClassInfo = new CharacterClassInfo("Bard", 11);
		assertEquals(3, characterClassInfo.getBAB()[1]);
	}

	@Test
	public void test_BAB_2_12() {

		characterClassInfo = new CharacterClassInfo("Bard", 12);
		assertEquals(4, characterClassInfo.getBAB()[1]);
	}

	@Test
	public void test_BAB_2_13() {

		characterClassInfo = new CharacterClassInfo("Bard", 13);
		assertEquals(4, characterClassInfo.getBAB()[1]);
	}

	@Test
	public void test_BAB_2_14() {

		characterClassInfo = new CharacterClassInfo("Bard", 14);
		assertEquals(5, characterClassInfo.getBAB()[1]);
	}

	@Test
	public void test_BAB_2_15() {

		characterClassInfo = new CharacterClassInfo("Bard", 15);
		assertEquals(6, characterClassInfo.getBAB()[1]);
	}

	@Test
	public void test_BAB_2_16() {

		characterClassInfo = new CharacterClassInfo("Bard", 16);
		assertEquals(7, characterClassInfo.getBAB()[1]);
	}

	@Test
	public void test_BAB_2_17() {

		characterClassInfo = new CharacterClassInfo("Bard", 17);
		assertEquals(7, characterClassInfo.getBAB()[1]);
	}

	@Test
	public void test_BAB_2_18() {

		characterClassInfo = new CharacterClassInfo("Bard", 18);
		assertEquals(8, characterClassInfo.getBAB()[1]);
	}

	@Test
	public void test_BAB_2_19() {

		characterClassInfo = new CharacterClassInfo("Bard", 19);
		assertEquals(9, characterClassInfo.getBAB()[1]);
	}

	@Test
	public void test_BAB_2_20() {

		characterClassInfo = new CharacterClassInfo("Bard", 20);
		assertEquals(10, characterClassInfo.getBAB()[1]);
	}

	@Test
	public void test_BAB_3_1to14() {

		for (int i = 0; i < 14; i++) {

			characterClassInfo = new CharacterClassInfo("Bard", i + 1);
			assertEquals(0, characterClassInfo.getBAB()[2]);
		}

	}

	@Test
	public void test_BAB_3_15() {

		characterClassInfo = new CharacterClassInfo("Bard", 15);
		assertEquals(1, characterClassInfo.getBAB()[2]);
	}

	@Test
	public void test_BAB_3_16() {

		characterClassInfo = new CharacterClassInfo("Bard", 16);
		assertEquals(2, characterClassInfo.getBAB()[2]);
	}

	@Test
	public void test_BAB_3_17() {

		characterClassInfo = new CharacterClassInfo("Bard", 17);
		assertEquals(2, characterClassInfo.getBAB()[2]);
	}

	@Test
	public void test_BAB_3_18() {

		characterClassInfo = new CharacterClassInfo("Bard", 18);
		assertEquals(3, characterClassInfo.getBAB()[2]);
	}

	@Test
	public void test_BAB_3_19() {

		characterClassInfo = new CharacterClassInfo("Bard", 19);
		assertEquals(4, characterClassInfo.getBAB()[2]);
	}

	@Test
	public void test_BAB_3_20() {

		characterClassInfo = new CharacterClassInfo("Bard", 20);
		assertEquals(5, characterClassInfo.getBAB()[2]);
	}

	@Test
	public void test_BAB_4_1to20() {

		for (int i = 0; i < 20; i++) {

			characterClassInfo = new CharacterClassInfo("Bard", i + 1);
			assertEquals(0, characterClassInfo.getBAB()[3]);
		}

	}

	// Reflex

	@Test
	public void test_Reflex1() {

		characterClassInfo = new CharacterClassInfo("Bard", 1);
		assertEquals(2, characterClassInfo.getReflex());
	}

	@Test
	public void test_Reflex2() {

		characterClassInfo = new CharacterClassInfo("Bard", 2);
		assertEquals(3, characterClassInfo.getReflex());
	}

	@Test
	public void test_Reflex3() {

		characterClassInfo = new CharacterClassInfo("Bard", 3);
		assertEquals(3, characterClassInfo.getReflex());
	}

	@Test
	public void test_Reflex4() {

		characterClassInfo = new CharacterClassInfo("Bard", 4);
		assertEquals(4, characterClassInfo.getReflex());
	}

	@Test
	public void test_Reflex5() {

		characterClassInfo = new CharacterClassInfo("Bard", 5);
		assertEquals(4, characterClassInfo.getReflex());
	}

	@Test
	public void test_Reflex6() {

		characterClassInfo = new CharacterClassInfo("Bard", 6);
		assertEquals(5, characterClassInfo.getReflex());
	}

	@Test
	public void test_Reflex7() {

		characterClassInfo = new CharacterClassInfo("Bard", 7);
		assertEquals(5, characterClassInfo.getReflex());
	}

	@Test
	public void test_Reflex8() {

		characterClassInfo = new CharacterClassInfo("Bard", 8);
		assertEquals(6, characterClassInfo.getReflex());
	}

	@Test
	public void test_Reflex9() {

		characterClassInfo = new CharacterClassInfo("Bard", 9);
		assertEquals(6, characterClassInfo.getReflex());
	}

	@Test
	public void test_Reflex10() {

		characterClassInfo = new CharacterClassInfo("Bard", 10);
		assertEquals(7, characterClassInfo.getReflex());
	}

	@Test
	public void test_Reflex11() {

		characterClassInfo = new CharacterClassInfo("Bard", 11);
		assertEquals(7, characterClassInfo.getReflex());
	}

	@Test
	public void test_Reflex12() {

		characterClassInfo = new CharacterClassInfo("Bard", 12);
		assertEquals(8, characterClassInfo.getReflex());
	}

	@Test
	public void test_Reflex13() {

		characterClassInfo = new CharacterClassInfo("Bard", 13);
		assertEquals(8, characterClassInfo.getReflex());
	}

	@Test
	public void test_Reflex14() {

		characterClassInfo = new CharacterClassInfo("Bard", 14);
		assertEquals(9, characterClassInfo.getReflex());
	}

	@Test
	public void test_Reflex15() {

		characterClassInfo = new CharacterClassInfo("Bard", 15);
		assertEquals(9, characterClassInfo.getReflex());
	}

	@Test
	public void test_Reflex16() {

		characterClassInfo = new CharacterClassInfo("Bard", 16);
		assertEquals(10, characterClassInfo.getReflex());
	}

	@Test
	public void test_Reflex17() {

		characterClassInfo = new CharacterClassInfo("Bard", 17);
		assertEquals(10, characterClassInfo.getReflex());
	}

	@Test
	public void test_Reflex18() {

		characterClassInfo = new CharacterClassInfo("Bard", 18);
		assertEquals(11, characterClassInfo.getReflex());
	}

	@Test
	public void test_Reflex19() {

		characterClassInfo = new CharacterClassInfo("Bard", 19);
		assertEquals(11, characterClassInfo.getReflex());
	}

	@Test
	public void test_Reflex20() {

		characterClassInfo = new CharacterClassInfo("Bard", 20);
		assertEquals(12, characterClassInfo.getReflex());
	}

	// Will

	@Test
	public void test_Will1() {

		characterClassInfo = new CharacterClassInfo("Bard", 1);
		assertEquals(2, characterClassInfo.getWill());
	}

	@Test
	public void test_Will2() {

		characterClassInfo = new CharacterClassInfo("Bard", 2);
		assertEquals(3, characterClassInfo.getWill());
	}

	@Test
	public void test_Will3() {

		characterClassInfo = new CharacterClassInfo("Bard", 3);
		assertEquals(3, characterClassInfo.getWill());
	}

	@Test
	public void test_Will4() {

		characterClassInfo = new CharacterClassInfo("Bard", 4);
		assertEquals(4, characterClassInfo.getWill());
	}

	@Test
	public void test_Will5() {

		characterClassInfo = new CharacterClassInfo("Bard", 5);
		assertEquals(4, characterClassInfo.getWill());
	}

	@Test
	public void test_Will6() {

		characterClassInfo = new CharacterClassInfo("Bard", 6);
		assertEquals(5, characterClassInfo.getWill());
	}

	@Test
	public void test_Will7() {

		characterClassInfo = new CharacterClassInfo("Bard", 7);
		assertEquals(5, characterClassInfo.getWill());
	}

	@Test
	public void test_Will8() {

		characterClassInfo = new CharacterClassInfo("Bard", 8);
		assertEquals(6, characterClassInfo.getWill());
	}

	@Test
	public void test_Will9() {

		characterClassInfo = new CharacterClassInfo("Bard", 9);
		assertEquals(6, characterClassInfo.getWill());
	}

	@Test
	public void test_Will10() {

		characterClassInfo = new CharacterClassInfo("Bard", 10);
		assertEquals(7, characterClassInfo.getWill());
	}

	@Test
	public void test_Will11() {

		characterClassInfo = new CharacterClassInfo("Bard", 11);
		assertEquals(7, characterClassInfo.getWill());
	}

	@Test
	public void test_Will12() {

		characterClassInfo = new CharacterClassInfo("Bard", 12);
		assertEquals(8, characterClassInfo.getWill());
	}

	@Test
	public void test_Will13() {

		characterClassInfo = new CharacterClassInfo("Bard", 13);
		assertEquals(8, characterClassInfo.getWill());
	}

	@Test
	public void test_Will14() {

		characterClassInfo = new CharacterClassInfo("Bard", 14);
		assertEquals(9, characterClassInfo.getWill());
	}

	@Test
	public void test_Will15() {

		characterClassInfo = new CharacterClassInfo("Bard", 15);
		assertEquals(9, characterClassInfo.getWill());
	}

	@Test
	public void test_Will16() {

		characterClassInfo = new CharacterClassInfo("Bard", 16);
		assertEquals(10, characterClassInfo.getWill());
	}

	@Test
	public void test_Will17() {

		characterClassInfo = new CharacterClassInfo("Bard", 17);
		assertEquals(10, characterClassInfo.getWill());
	}

	@Test
	public void test_Will18() {

		characterClassInfo = new CharacterClassInfo("Bard", 18);
		assertEquals(11, characterClassInfo.getWill());
	}

	@Test
	public void test_Will19() {

		characterClassInfo = new CharacterClassInfo("Bard", 19);
		assertEquals(11, characterClassInfo.getWill());
	}

	@Test
	public void test_Will20() {

		characterClassInfo = new CharacterClassInfo("Bard", 20);
		assertEquals(12, characterClassInfo.getWill());
	}

	// Fortitude

	@Test
	public void test_Fortitude1() {

		characterClassInfo = new CharacterClassInfo("Bard", 1);
		assertEquals(0, characterClassInfo.getFortitude());
	}

	@Test
	public void test_Fortitude2() {

		characterClassInfo = new CharacterClassInfo("Bard", 2);
		assertEquals(0, characterClassInfo.getFortitude());
	}

	@Test
	public void test_Fortitude3() {

		characterClassInfo = new CharacterClassInfo("Bard", 3);
		assertEquals(1, characterClassInfo.getFortitude());
	}

	@Test
	public void test_Fortitude4() {

		characterClassInfo = new CharacterClassInfo("Bard", 4);
		assertEquals(1, characterClassInfo.getFortitude());
	}

	@Test
	public void test_Fortitude5() {

		characterClassInfo = new CharacterClassInfo("Bard", 5);
		assertEquals(1, characterClassInfo.getFortitude());
	}

	@Test
	public void test_Fortitude6() {

		characterClassInfo = new CharacterClassInfo("Bard", 6);
		assertEquals(2, characterClassInfo.getFortitude());
	}

	@Test
	public void test_Fortitude7() {

		characterClassInfo = new CharacterClassInfo("Bard", 7);
		assertEquals(2, characterClassInfo.getFortitude());
	}

	@Test
	public void test_Fortitude8() {

		characterClassInfo = new CharacterClassInfo("Bard", 8);
		assertEquals(2, characterClassInfo.getFortitude());
	}

	@Test
	public void test_Fortitude9() {

		characterClassInfo = new CharacterClassInfo("Bard", 9);
		assertEquals(3, characterClassInfo.getFortitude());
	}

	@Test
	public void test_Fortitude10() {

		characterClassInfo = new CharacterClassInfo("Bard", 10);
		assertEquals(3, characterClassInfo.getFortitude());
	}

	@Test
	public void test_Fortitude11() {

		characterClassInfo = new CharacterClassInfo("Bard", 11);
		assertEquals(3, characterClassInfo.getFortitude());
	}

	@Test
	public void test_Fortitude12() {

		characterClassInfo = new CharacterClassInfo("Bard", 12);
		assertEquals(4, characterClassInfo.getFortitude());
	}

	@Test
	public void test_Fortitude13() {

		characterClassInfo = new CharacterClassInfo("Bard", 13);
		assertEquals(4, characterClassInfo.getFortitude());
	}

	@Test
	public void test_Fortitude14() {

		characterClassInfo = new CharacterClassInfo("Bard", 14);
		assertEquals(4, characterClassInfo.getFortitude());
	}

	@Test
	public void test_Fortitude15() {

		characterClassInfo = new CharacterClassInfo("Bard", 15);
		assertEquals(5, characterClassInfo.getFortitude());
	}

	@Test
	public void test_Fortitude16() {

		characterClassInfo = new CharacterClassInfo("Bard", 16);
		assertEquals(5, characterClassInfo.getFortitude());
	}

	@Test
	public void test_Fortitude17() {

		characterClassInfo = new CharacterClassInfo("Bard", 17);
		assertEquals(5, characterClassInfo.getFortitude());
	}

	@Test
	public void test_Fortitude18() {

		characterClassInfo = new CharacterClassInfo("Bard", 18);
		assertEquals(6, characterClassInfo.getFortitude());
	}

	@Test
	public void test_Fortitude19() {

		characterClassInfo = new CharacterClassInfo("Bard", 19);
		assertEquals(6, characterClassInfo.getFortitude());
	}

	@Test
	public void test_Fortitude20() {

		characterClassInfo = new CharacterClassInfo("Bard", 20);
		assertEquals(6, characterClassInfo.getFortitude());
	}

	// Spells per Day

	@Test
	public void test_spellsPerDay1() {

		characterClassInfo = new CharacterClassInfo("Bard", 1);
		assertEquals(1, characterClassInfo.getSpellsPerDay(1));
		assertEquals(0, characterClassInfo.getSpellsPerDay(2));
		assertEquals(0, characterClassInfo.getSpellsPerDay(3));
		assertEquals(0, characterClassInfo.getSpellsPerDay(4));
		assertEquals(0, characterClassInfo.getSpellsPerDay(5));
		assertEquals(0, characterClassInfo.getSpellsPerDay(6));
	}

	@Test
	public void test_spellsPerDay2() {

		characterClassInfo = new CharacterClassInfo("Bard", 2);
		assertEquals(2, characterClassInfo.getSpellsPerDay(1));
		assertEquals(0, characterClassInfo.getSpellsPerDay(2));
		assertEquals(0, characterClassInfo.getSpellsPerDay(3));
		assertEquals(0, characterClassInfo.getSpellsPerDay(4));
		assertEquals(0, characterClassInfo.getSpellsPerDay(5));
		assertEquals(0, characterClassInfo.getSpellsPerDay(6));
	}

	@Test
	public void test_spellsPerDay3() {

		characterClassInfo = new CharacterClassInfo("Bard", 3);
		assertEquals(3, characterClassInfo.getSpellsPerDay(1));
		assertEquals(0, characterClassInfo.getSpellsPerDay(2));
		assertEquals(0, characterClassInfo.getSpellsPerDay(3));
		assertEquals(0, characterClassInfo.getSpellsPerDay(4));
		assertEquals(0, characterClassInfo.getSpellsPerDay(5));
		assertEquals(0, characterClassInfo.getSpellsPerDay(6));
	}

	@Test
	public void test_spellsPerDay4() {

		characterClassInfo = new CharacterClassInfo("Bard", 4);
		assertEquals(3, characterClassInfo.getSpellsPerDay(1));
		assertEquals(1, characterClassInfo.getSpellsPerDay(2));
		assertEquals(0, characterClassInfo.getSpellsPerDay(3));
		assertEquals(0, characterClassInfo.getSpellsPerDay(4));
		assertEquals(0, characterClassInfo.getSpellsPerDay(5));
		assertEquals(0, characterClassInfo.getSpellsPerDay(6));
	}

	@Test
	public void test_spellsPerDay5() {

		characterClassInfo = new CharacterClassInfo("Bard", 5);
		assertEquals(4, characterClassInfo.getSpellsPerDay(1));
		assertEquals(2, characterClassInfo.getSpellsPerDay(2));
		assertEquals(0, characterClassInfo.getSpellsPerDay(3));
		assertEquals(0, characterClassInfo.getSpellsPerDay(4));
		assertEquals(0, characterClassInfo.getSpellsPerDay(5));
		assertEquals(0, characterClassInfo.getSpellsPerDay(6));
	}

	@Test
	public void test_spellsPerDay6() {

		characterClassInfo = new CharacterClassInfo("Bard", 6);
		assertEquals(4, characterClassInfo.getSpellsPerDay(1));
		assertEquals(3, characterClassInfo.getSpellsPerDay(2));
		assertEquals(0, characterClassInfo.getSpellsPerDay(3));
		assertEquals(0, characterClassInfo.getSpellsPerDay(4));
		assertEquals(0, characterClassInfo.getSpellsPerDay(5));
		assertEquals(0, characterClassInfo.getSpellsPerDay(6));
	}

	@Test
	public void test_spellsPerDay7() {

		characterClassInfo = new CharacterClassInfo("Bard", 7);
		assertEquals(4, characterClassInfo.getSpellsPerDay(1));
		assertEquals(3, characterClassInfo.getSpellsPerDay(2));
		assertEquals(1, characterClassInfo.getSpellsPerDay(3));
		assertEquals(0, characterClassInfo.getSpellsPerDay(4));
		assertEquals(0, characterClassInfo.getSpellsPerDay(5));
		assertEquals(0, characterClassInfo.getSpellsPerDay(6));
	}

	@Test
	public void test_spellsPerDay8() {

		characterClassInfo = new CharacterClassInfo("Bard", 8);
		assertEquals(4, characterClassInfo.getSpellsPerDay(1));
		assertEquals(4, characterClassInfo.getSpellsPerDay(2));
		assertEquals(2, characterClassInfo.getSpellsPerDay(3));
		assertEquals(0, characterClassInfo.getSpellsPerDay(4));
		assertEquals(0, characterClassInfo.getSpellsPerDay(5));
		assertEquals(0, characterClassInfo.getSpellsPerDay(6));
	}

	@Test
	public void test_spellsPerDay9() {

		characterClassInfo = new CharacterClassInfo("Bard", 9);
		assertEquals(5, characterClassInfo.getSpellsPerDay(1));
		assertEquals(4, characterClassInfo.getSpellsPerDay(2));
		assertEquals(3, characterClassInfo.getSpellsPerDay(3));
		assertEquals(0, characterClassInfo.getSpellsPerDay(4));
		assertEquals(0, characterClassInfo.getSpellsPerDay(5));
		assertEquals(0, characterClassInfo.getSpellsPerDay(6));
	}

	@Test
	public void test_spellsPerDay10() {

		characterClassInfo = new CharacterClassInfo("Bard", 10);
		assertEquals(5, characterClassInfo.getSpellsPerDay(1));
		assertEquals(4, characterClassInfo.getSpellsPerDay(2));
		assertEquals(3, characterClassInfo.getSpellsPerDay(3));
		assertEquals(1, characterClassInfo.getSpellsPerDay(4));
		assertEquals(0, characterClassInfo.getSpellsPerDay(5));
		assertEquals(0, characterClassInfo.getSpellsPerDay(6));
	}

	@Test
	public void test_spellsPerDay11() {

		characterClassInfo = new CharacterClassInfo("Bard", 11);
		assertEquals(5, characterClassInfo.getSpellsPerDay(1));
		assertEquals(4, characterClassInfo.getSpellsPerDay(2));
		assertEquals(4, characterClassInfo.getSpellsPerDay(3));
		assertEquals(2, characterClassInfo.getSpellsPerDay(4));
		assertEquals(0, characterClassInfo.getSpellsPerDay(5));
		assertEquals(0, characterClassInfo.getSpellsPerDay(6));
	}

	@Test
	public void test_spellsPerDay12() {

		characterClassInfo = new CharacterClassInfo("Bard", 12);
		assertEquals(5, characterClassInfo.getSpellsPerDay(1));
		assertEquals(5, characterClassInfo.getSpellsPerDay(2));
		assertEquals(4, characterClassInfo.getSpellsPerDay(3));
		assertEquals(3, characterClassInfo.getSpellsPerDay(4));
		assertEquals(0, characterClassInfo.getSpellsPerDay(5));
		assertEquals(0, characterClassInfo.getSpellsPerDay(6));
	}

	@Test
	public void test_spellsPerDay13() {

		characterClassInfo = new CharacterClassInfo("Bard", 13);
		assertEquals(5, characterClassInfo.getSpellsPerDay(1));
		assertEquals(5, characterClassInfo.getSpellsPerDay(2));
		assertEquals(4, characterClassInfo.getSpellsPerDay(3));
		assertEquals(3, characterClassInfo.getSpellsPerDay(4));
		assertEquals(1, characterClassInfo.getSpellsPerDay(5));
		assertEquals(0, characterClassInfo.getSpellsPerDay(6));
	}

	@Test
	public void test_spellsPerDay14() {

		characterClassInfo = new CharacterClassInfo("Bard", 14);
		assertEquals(5, characterClassInfo.getSpellsPerDay(1));
		assertEquals(5, characterClassInfo.getSpellsPerDay(2));
		assertEquals(4, characterClassInfo.getSpellsPerDay(3));
		assertEquals(4, characterClassInfo.getSpellsPerDay(4));
		assertEquals(2, characterClassInfo.getSpellsPerDay(5));
		assertEquals(0, characterClassInfo.getSpellsPerDay(6));
	}

	@Test
	public void test_spellsPerDay15() {

		characterClassInfo = new CharacterClassInfo("Bard", 15);
		assertEquals(5, characterClassInfo.getSpellsPerDay(1));
		assertEquals(5, characterClassInfo.getSpellsPerDay(2));
		assertEquals(5, characterClassInfo.getSpellsPerDay(3));
		assertEquals(4, characterClassInfo.getSpellsPerDay(4));
		assertEquals(3, characterClassInfo.getSpellsPerDay(5));
		assertEquals(0, characterClassInfo.getSpellsPerDay(6));
	}

	@Test
	public void test_spellsPerDay16() {

		characterClassInfo = new CharacterClassInfo("Bard", 16);
		assertEquals(5, characterClassInfo.getSpellsPerDay(1));
		assertEquals(5, characterClassInfo.getSpellsPerDay(2));
		assertEquals(5, characterClassInfo.getSpellsPerDay(3));
		assertEquals(4, characterClassInfo.getSpellsPerDay(4));
		assertEquals(3, characterClassInfo.getSpellsPerDay(5));
		assertEquals(1, characterClassInfo.getSpellsPerDay(6));
	}

	@Test
	public void test_spellsPerDay17() {

		characterClassInfo = new CharacterClassInfo("Bard", 17);
		assertEquals(5, characterClassInfo.getSpellsPerDay(1));
		assertEquals(5, characterClassInfo.getSpellsPerDay(2));
		assertEquals(5, characterClassInfo.getSpellsPerDay(3));
		assertEquals(4, characterClassInfo.getSpellsPerDay(4));
		assertEquals(4, characterClassInfo.getSpellsPerDay(5));
		assertEquals(2, characterClassInfo.getSpellsPerDay(6));
	}

	@Test
	public void test_spellsPerDay18() {

		characterClassInfo = new CharacterClassInfo("Bard", 18);
		assertEquals(5, characterClassInfo.getSpellsPerDay(1));
		assertEquals(5, characterClassInfo.getSpellsPerDay(2));
		assertEquals(5, characterClassInfo.getSpellsPerDay(3));
		assertEquals(5, characterClassInfo.getSpellsPerDay(4));
		assertEquals(4, characterClassInfo.getSpellsPerDay(5));
		assertEquals(3, characterClassInfo.getSpellsPerDay(6));
	}

	@Test
	public void test_spellsPerDay19() {

		characterClassInfo = new CharacterClassInfo("Bard", 19);
		assertEquals(5, characterClassInfo.getSpellsPerDay(1));
		assertEquals(5, characterClassInfo.getSpellsPerDay(2));
		assertEquals(5, characterClassInfo.getSpellsPerDay(3));
		assertEquals(5, characterClassInfo.getSpellsPerDay(4));
		assertEquals(5, characterClassInfo.getSpellsPerDay(5));
		assertEquals(4, characterClassInfo.getSpellsPerDay(6));
	}

	@Test
	public void test_spellsPerDay20() {

		characterClassInfo = new CharacterClassInfo("Bard", 20);
		assertEquals(5, characterClassInfo.getSpellsPerDay(1));
		assertEquals(5, characterClassInfo.getSpellsPerDay(2));
		assertEquals(5, characterClassInfo.getSpellsPerDay(3));
		assertEquals(5, characterClassInfo.getSpellsPerDay(4));
		assertEquals(5, characterClassInfo.getSpellsPerDay(5));
		assertEquals(5, characterClassInfo.getSpellsPerDay(6));
	}

	@Test
	public void test_knownSpells1() {

		characterClassInfo = new CharacterClassInfo("Bard", 1);
		assertEquals(4, characterClassInfo.getKnownSpells(0));
		assertEquals(2, characterClassInfo.getKnownSpells(1));
		assertEquals(0, characterClassInfo.getKnownSpells(2));
		assertEquals(0, characterClassInfo.getKnownSpells(3));
		assertEquals(0, characterClassInfo.getKnownSpells(4));
		assertEquals(0, characterClassInfo.getKnownSpells(5));
		assertEquals(0, characterClassInfo.getKnownSpells(6));
	}

	@Test
	public void test_knownSpells2() {

		characterClassInfo = new CharacterClassInfo("Bard", 2);
		assertEquals(5, characterClassInfo.getKnownSpells(0));
		assertEquals(3, characterClassInfo.getKnownSpells(1));
		assertEquals(0, characterClassInfo.getKnownSpells(2));
		assertEquals(0, characterClassInfo.getKnownSpells(3));
		assertEquals(0, characterClassInfo.getKnownSpells(4));
		assertEquals(0, characterClassInfo.getKnownSpells(5));
		assertEquals(0, characterClassInfo.getKnownSpells(6));
	}

	@Test
	public void test_knownSpells3() {

		characterClassInfo = new CharacterClassInfo("Bard", 3);
		assertEquals(6, characterClassInfo.getKnownSpells(0));
		assertEquals(4, characterClassInfo.getKnownSpells(1));
		assertEquals(0, characterClassInfo.getKnownSpells(2));
		assertEquals(0, characterClassInfo.getKnownSpells(3));
		assertEquals(0, characterClassInfo.getKnownSpells(4));
		assertEquals(0, characterClassInfo.getKnownSpells(5));
		assertEquals(0, characterClassInfo.getKnownSpells(6));
	}

	@Test
	public void test_knownSpells4() {

		characterClassInfo = new CharacterClassInfo("Bard", 4);
		assertEquals(6, characterClassInfo.getKnownSpells(0));
		assertEquals(4, characterClassInfo.getKnownSpells(1));
		assertEquals(2, characterClassInfo.getKnownSpells(2));
		assertEquals(0, characterClassInfo.getKnownSpells(3));
		assertEquals(0, characterClassInfo.getKnownSpells(4));
		assertEquals(0, characterClassInfo.getKnownSpells(5));
		assertEquals(0, characterClassInfo.getKnownSpells(6));
	}

	@Test
	public void test_knownSpells5() {

		characterClassInfo = new CharacterClassInfo("Bard", 5);
		assertEquals(6, characterClassInfo.getKnownSpells(0));
		assertEquals(4, characterClassInfo.getKnownSpells(1));
		assertEquals(3, characterClassInfo.getKnownSpells(2));
		assertEquals(0, characterClassInfo.getKnownSpells(3));
		assertEquals(0, characterClassInfo.getKnownSpells(4));
		assertEquals(0, characterClassInfo.getKnownSpells(5));
		assertEquals(0, characterClassInfo.getKnownSpells(6));
	}

	@Test
	public void test_knownSpells6() {

		characterClassInfo = new CharacterClassInfo("Bard", 6);
		assertEquals(6, characterClassInfo.getKnownSpells(0));
		assertEquals(4, characterClassInfo.getKnownSpells(1));
		assertEquals(4, characterClassInfo.getKnownSpells(2));
		assertEquals(0, characterClassInfo.getKnownSpells(3));
		assertEquals(0, characterClassInfo.getKnownSpells(4));
		assertEquals(0, characterClassInfo.getKnownSpells(5));
		assertEquals(0, characterClassInfo.getKnownSpells(6));
	}

	@Test
	public void test_knownSpells7() {

		characterClassInfo = new CharacterClassInfo("Bard", 7);
		assertEquals(6, characterClassInfo.getKnownSpells(0));
		assertEquals(5, characterClassInfo.getKnownSpells(1));
		assertEquals(4, characterClassInfo.getKnownSpells(2));
		assertEquals(2, characterClassInfo.getKnownSpells(3));
		assertEquals(0, characterClassInfo.getKnownSpells(4));
		assertEquals(0, characterClassInfo.getKnownSpells(5));
		assertEquals(0, characterClassInfo.getKnownSpells(6));
	}

	@Test
	public void test_knownSpells8() {

		characterClassInfo = new CharacterClassInfo("Bard", 8);
		assertEquals(6, characterClassInfo.getKnownSpells(0));
		assertEquals(5, characterClassInfo.getKnownSpells(1));
		assertEquals(4, characterClassInfo.getKnownSpells(2));
		assertEquals(3, characterClassInfo.getKnownSpells(3));
		assertEquals(0, characterClassInfo.getKnownSpells(4));
		assertEquals(0, characterClassInfo.getKnownSpells(5));
		assertEquals(0, characterClassInfo.getKnownSpells(6));
	}

	@Test
	public void test_knownSpells9() {

		characterClassInfo = new CharacterClassInfo("Bard", 9);
		assertEquals(6, characterClassInfo.getKnownSpells(0));
		assertEquals(5, characterClassInfo.getKnownSpells(1));
		assertEquals(4, characterClassInfo.getKnownSpells(2));
		assertEquals(4, characterClassInfo.getKnownSpells(3));
		assertEquals(0, characterClassInfo.getKnownSpells(4));
		assertEquals(0, characterClassInfo.getKnownSpells(5));
		assertEquals(0, characterClassInfo.getKnownSpells(6));
	}

	@Test
	public void test_knownSpells10() {

		characterClassInfo = new CharacterClassInfo("Bard", 10);
		assertEquals(6, characterClassInfo.getKnownSpells(0));
		assertEquals(5, characterClassInfo.getKnownSpells(1));
		assertEquals(5, characterClassInfo.getKnownSpells(2));
		assertEquals(4, characterClassInfo.getKnownSpells(3));
		assertEquals(2, characterClassInfo.getKnownSpells(4));
		assertEquals(0, characterClassInfo.getKnownSpells(5));
		assertEquals(0, characterClassInfo.getKnownSpells(6));
	}

	@Test
	public void test_knownSpells11() {

		characterClassInfo = new CharacterClassInfo("Bard", 11);
		assertEquals(6, characterClassInfo.getKnownSpells(0));
		assertEquals(6, characterClassInfo.getKnownSpells(1));
		assertEquals(5, characterClassInfo.getKnownSpells(2));
		assertEquals(4, characterClassInfo.getKnownSpells(3));
		assertEquals(3, characterClassInfo.getKnownSpells(4));
		assertEquals(0, characterClassInfo.getKnownSpells(5));
		assertEquals(0, characterClassInfo.getKnownSpells(6));
	}

	@Test
	public void test_knownSpells12() {

		characterClassInfo = new CharacterClassInfo("Bard", 12);
		assertEquals(6, characterClassInfo.getKnownSpells(0));
		assertEquals(6, characterClassInfo.getKnownSpells(1));
		assertEquals(5, characterClassInfo.getKnownSpells(2));
		assertEquals(4, characterClassInfo.getKnownSpells(3));
		assertEquals(4, characterClassInfo.getKnownSpells(4));
		assertEquals(0, characterClassInfo.getKnownSpells(5));
		assertEquals(0, characterClassInfo.getKnownSpells(6));
	}

	@Test
	public void test_knownSpells13() {

		characterClassInfo = new CharacterClassInfo("Bard", 13);
		assertEquals(6, characterClassInfo.getKnownSpells(0));
		assertEquals(6, characterClassInfo.getKnownSpells(1));
		assertEquals(5, characterClassInfo.getKnownSpells(2));
		assertEquals(5, characterClassInfo.getKnownSpells(3));
		assertEquals(4, characterClassInfo.getKnownSpells(4));
		assertEquals(2, characterClassInfo.getKnownSpells(5));
		assertEquals(0, characterClassInfo.getKnownSpells(6));
	}

	@Test
	public void test_knownSpells14() {

		characterClassInfo = new CharacterClassInfo("Bard", 14);
		assertEquals(6, characterClassInfo.getKnownSpells(0));
		assertEquals(6, characterClassInfo.getKnownSpells(1));
		assertEquals(6, characterClassInfo.getKnownSpells(2));
		assertEquals(5, characterClassInfo.getKnownSpells(3));
		assertEquals(4, characterClassInfo.getKnownSpells(4));
		assertEquals(3, characterClassInfo.getKnownSpells(5));
		assertEquals(0, characterClassInfo.getKnownSpells(6));
	}

	@Test
	public void test_knownSpells15() {

		characterClassInfo = new CharacterClassInfo("Bard", 15);
		assertEquals(6, characterClassInfo.getKnownSpells(0));
		assertEquals(6, characterClassInfo.getKnownSpells(1));
		assertEquals(6, characterClassInfo.getKnownSpells(2));
		assertEquals(5, characterClassInfo.getKnownSpells(3));
		assertEquals(4, characterClassInfo.getKnownSpells(4));
		assertEquals(4, characterClassInfo.getKnownSpells(5));
		assertEquals(0, characterClassInfo.getKnownSpells(6));
	}

	@Test
	public void test_knownSpells16() {

		characterClassInfo = new CharacterClassInfo("Bard", 16);
		assertEquals(6, characterClassInfo.getKnownSpells(0));
		assertEquals(6, characterClassInfo.getKnownSpells(1));
		assertEquals(6, characterClassInfo.getKnownSpells(2));
		assertEquals(5, characterClassInfo.getKnownSpells(3));
		assertEquals(5, characterClassInfo.getKnownSpells(4));
		assertEquals(4, characterClassInfo.getKnownSpells(5));
		assertEquals(2, characterClassInfo.getKnownSpells(6));
	}

	@Test
	public void test_knownSpells17() {

		characterClassInfo = new CharacterClassInfo("Bard", 17);
		assertEquals(6, characterClassInfo.getKnownSpells(0));
		assertEquals(6, characterClassInfo.getKnownSpells(1));
		assertEquals(6, characterClassInfo.getKnownSpells(2));
		assertEquals(6, characterClassInfo.getKnownSpells(3));
		assertEquals(5, characterClassInfo.getKnownSpells(4));
		assertEquals(4, characterClassInfo.getKnownSpells(5));
		assertEquals(3, characterClassInfo.getKnownSpells(6));
	}

	@Test
	public void test_knownSpells18() {

		characterClassInfo = new CharacterClassInfo("Bard", 18);
		assertEquals(6, characterClassInfo.getKnownSpells(0));
		assertEquals(6, characterClassInfo.getKnownSpells(1));
		assertEquals(6, characterClassInfo.getKnownSpells(2));
		assertEquals(6, characterClassInfo.getKnownSpells(3));
		assertEquals(5, characterClassInfo.getKnownSpells(4));
		assertEquals(4, characterClassInfo.getKnownSpells(5));
		assertEquals(4, characterClassInfo.getKnownSpells(6));
	}

	@Test
	public void test_knownSpells19() {

		characterClassInfo = new CharacterClassInfo("Bard", 19);
		assertEquals(6, characterClassInfo.getKnownSpells(0));
		assertEquals(6, characterClassInfo.getKnownSpells(1));
		assertEquals(6, characterClassInfo.getKnownSpells(2));
		assertEquals(6, characterClassInfo.getKnownSpells(3));
		assertEquals(5, characterClassInfo.getKnownSpells(4));
		assertEquals(5, characterClassInfo.getKnownSpells(5));
		assertEquals(4, characterClassInfo.getKnownSpells(6));
	}

	@Test
	public void test_knownSpells20() {

		characterClassInfo = new CharacterClassInfo("Bard", 20);
		assertEquals(6, characterClassInfo.getKnownSpells(0));
		assertEquals(6, characterClassInfo.getKnownSpells(1));
		assertEquals(6, characterClassInfo.getKnownSpells(2));
		assertEquals(6, characterClassInfo.getKnownSpells(3));
		assertEquals(6, characterClassInfo.getKnownSpells(4));
		assertEquals(5, characterClassInfo.getKnownSpells(5));
		assertEquals(5, characterClassInfo.getKnownSpells(6));
	}

	// Base HP

	@Test
	public void test_baseHp() {

		characterClassInfo = new CharacterClassInfo("Bard", 1);
		assertEquals(8, characterClassInfo.getBaseHP());
	}

	@Test
	public void test_maxSpellLevel() {

		characterClassInfo = new CharacterClassInfo("Bard", 1);
		assertEquals(6, characterClassInfo.getMaxSpellLevel());
	}

	@Test
	public void test_startMoney1() {

		characterClassInfo = new CharacterClassInfo("Bard", 1);

		for (int i = 0; i < 1000; i++) {

			assertTrue(characterClassInfo.getStartMoneyInGold() >= 30);
			assertTrue(characterClassInfo.getStartMoneyInGold() <= 180);
			assertFalse(characterClassInfo.getStartMoneyInGold() < 30);
			assertFalse(characterClassInfo.getStartMoneyInGold() > 180);
		}
	}

	@Test
	public void test_avgMoney() {

		characterClassInfo = new CharacterClassInfo("Bard", 1);
		assertEquals(105, characterClassInfo.getAverageStartMoneyinGold());
	}

	@Test
	public void test_primaryAttribute() {

		characterClassInfo = new CharacterClassInfo("Bard", 1);
		assertEquals("CHA", characterClassInfo.getPrimaryAttribute());
	}

	@Test
	public void test_baseSkillPoints() {

		characterClassInfo = new CharacterClassInfo("Bard", 1);
		assertEquals(6, characterClassInfo.getBaseAmountOfSkillPointsPerLevel());
	}
}
