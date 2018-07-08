package org.rahner.info;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CharacterClassInfoTest {

	// Known spells tests

	@Test
	public void test_getKnownSpellsForSorcererClass_1_1() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 1);
		assertEquals(4, characterClassInfo.getAmountOfKnownSpells(1, 0));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_1_2() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 2);
		assertEquals(5, characterClassInfo.getAmountOfKnownSpells(2, 0));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_1_3() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 3);
		assertEquals(5, characterClassInfo.getAmountOfKnownSpells(3, 0));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_1_4() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 4);
		assertEquals(6, characterClassInfo.getAmountOfKnownSpells(4, 0));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_1_5() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 5);
		assertEquals(6, characterClassInfo.getAmountOfKnownSpells(5, 0));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_1_6() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 6);
		assertEquals(7, characterClassInfo.getAmountOfKnownSpells(6, 0));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_1_7() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 7);
		assertEquals(7, characterClassInfo.getAmountOfKnownSpells(7, 0));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_1_8() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 8);
		assertEquals(8, characterClassInfo.getAmountOfKnownSpells(8, 0));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_1_9() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 9);
		assertEquals(8, characterClassInfo.getAmountOfKnownSpells(9, 0));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_1_10() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 10);
		assertEquals(9, characterClassInfo.getAmountOfKnownSpells(10, 0));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_1_11() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 11);
		assertEquals(9, characterClassInfo.getAmountOfKnownSpells(11, 0));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_1_12() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 12);
		assertEquals(9, characterClassInfo.getAmountOfKnownSpells(12, 0));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_1_13() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 13);
		assertEquals(9, characterClassInfo.getAmountOfKnownSpells(13, 0));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_1_14() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 14);
		assertEquals(9, characterClassInfo.getAmountOfKnownSpells(14, 0));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_1_15() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 15);
		assertEquals(9, characterClassInfo.getAmountOfKnownSpells(15, 0));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_1_16() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 16);
		assertEquals(9, characterClassInfo.getAmountOfKnownSpells(16, 0));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_1_17() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 17);
		assertEquals(9, characterClassInfo.getAmountOfKnownSpells(17, 0));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_1_18() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 18);
		assertEquals(9, characterClassInfo.getAmountOfKnownSpells(18, 0));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_1_19() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 19);
		assertEquals(9, characterClassInfo.getAmountOfKnownSpells(19, 0));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_1_20() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 20);
		assertEquals(9, characterClassInfo.getAmountOfKnownSpells(20, 0));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_2_1() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 1);
		assertEquals(2, characterClassInfo.getAmountOfKnownSpells(1, 1));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_2_2() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 2);
		assertEquals(2, characterClassInfo.getAmountOfKnownSpells(2, 1));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_2_3() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 3);
		assertEquals(3, characterClassInfo.getAmountOfKnownSpells(3, 1));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_2_4() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 4);
		assertEquals(3, characterClassInfo.getAmountOfKnownSpells(4, 1));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_2_5() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 5);
		assertEquals(4, characterClassInfo.getAmountOfKnownSpells(5, 1));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_2_6() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 6);
		assertEquals(4, characterClassInfo.getAmountOfKnownSpells(6, 1));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_2_7() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 7);
		assertEquals(5, characterClassInfo.getAmountOfKnownSpells(7, 1));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_2_8() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 8);
		assertEquals(5, characterClassInfo.getAmountOfKnownSpells(8, 1));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_2_9() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 9);
		assertEquals(5, characterClassInfo.getAmountOfKnownSpells(9, 1));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_2_10() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 10);
		assertEquals(5, characterClassInfo.getAmountOfKnownSpells(10, 1));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_2_11() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 11);
		assertEquals(5, characterClassInfo.getAmountOfKnownSpells(11, 1));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_2_12() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 12);
		assertEquals(5, characterClassInfo.getAmountOfKnownSpells(12, 1));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_2_13() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 13);
		assertEquals(5, characterClassInfo.getAmountOfKnownSpells(13, 1));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_2_14() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 14);
		assertEquals(5, characterClassInfo.getAmountOfKnownSpells(14, 1));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_2_15() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 15);
		assertEquals(5, characterClassInfo.getAmountOfKnownSpells(15, 1));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_2_16() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 16);
		assertEquals(5, characterClassInfo.getAmountOfKnownSpells(16, 1));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_2_17() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 17);
		assertEquals(5, characterClassInfo.getAmountOfKnownSpells(17, 1));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_2_18() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 18);
		assertEquals(5, characterClassInfo.getAmountOfKnownSpells(18, 1));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_2_19() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 19);
		assertEquals(5, characterClassInfo.getAmountOfKnownSpells(19, 1));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_2_20() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 20);
		assertEquals(5, characterClassInfo.getAmountOfKnownSpells(20, 1));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_3_1() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 1);
		assertEquals(0, characterClassInfo.getAmountOfKnownSpells(1, 2));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_3_2() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 2);
		assertEquals(0, characterClassInfo.getAmountOfKnownSpells(2, 2));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_3_3() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 3);
		assertEquals(0, characterClassInfo.getAmountOfKnownSpells(3, 2));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_3_4() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 4);
		assertEquals(1, characterClassInfo.getAmountOfKnownSpells(4, 2));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_3_5() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 5);
		assertEquals(2, characterClassInfo.getAmountOfKnownSpells(5, 2));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_3_6() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 6);
		assertEquals(2, characterClassInfo.getAmountOfKnownSpells(6, 2));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_3_7() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 7);
		assertEquals(3, characterClassInfo.getAmountOfKnownSpells(7, 2));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_3_8() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 8);
		assertEquals(3, characterClassInfo.getAmountOfKnownSpells(8, 2));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_3_9() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 9);
		assertEquals(4, characterClassInfo.getAmountOfKnownSpells(9, 2));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_3_10() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 10);
		assertEquals(4, characterClassInfo.getAmountOfKnownSpells(10, 2));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_3_11() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 11);
		assertEquals(5, characterClassInfo.getAmountOfKnownSpells(11, 2));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_3_12() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 12);
		assertEquals(5, characterClassInfo.getAmountOfKnownSpells(12, 2));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_3_13() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 13);
		assertEquals(5, characterClassInfo.getAmountOfKnownSpells(13, 2));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_3_14() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 14);
		assertEquals(5, characterClassInfo.getAmountOfKnownSpells(14, 2));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_3_15() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 15);
		assertEquals(5, characterClassInfo.getAmountOfKnownSpells(15, 2));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_3_16() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 16);
		assertEquals(5, characterClassInfo.getAmountOfKnownSpells(16, 2));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_3_17() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 17);
		assertEquals(5, characterClassInfo.getAmountOfKnownSpells(17, 2));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_3_18() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 18);
		assertEquals(5, characterClassInfo.getAmountOfKnownSpells(18, 2));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_3_19() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 19);
		assertEquals(5, characterClassInfo.getAmountOfKnownSpells(19, 2));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_3_20() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 20);
		assertEquals(5, characterClassInfo.getAmountOfKnownSpells(20, 2));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_4_1() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 1);
		assertEquals(0, characterClassInfo.getAmountOfKnownSpells(1, 3));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_4_2() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 2);
		assertEquals(0, characterClassInfo.getAmountOfKnownSpells(2, 3));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_4_3() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 3);
		assertEquals(0, characterClassInfo.getAmountOfKnownSpells(3, 3));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_4_4() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 4);
		assertEquals(0, characterClassInfo.getAmountOfKnownSpells(4, 3));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_4_5() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 5);
		assertEquals(0, characterClassInfo.getAmountOfKnownSpells(5, 3));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_4_6() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 6);
		assertEquals(1, characterClassInfo.getAmountOfKnownSpells(6, 3));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_4_7() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 7);
		assertEquals(2, characterClassInfo.getAmountOfKnownSpells(7, 3));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_4_8() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 8);
		assertEquals(2, characterClassInfo.getAmountOfKnownSpells(8, 3));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_4_9() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 9);
		assertEquals(3, characterClassInfo.getAmountOfKnownSpells(9, 3));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_4_10() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 10);
		assertEquals(3, characterClassInfo.getAmountOfKnownSpells(10, 3));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_4_11() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 11);
		assertEquals(4, characterClassInfo.getAmountOfKnownSpells(11, 3));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_4_12() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 12);
		assertEquals(4, characterClassInfo.getAmountOfKnownSpells(12, 3));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_4_13() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 13);
		assertEquals(4, characterClassInfo.getAmountOfKnownSpells(13, 3));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_4_14() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 14);
		assertEquals(4, characterClassInfo.getAmountOfKnownSpells(14, 3));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_4_15() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 15);
		assertEquals(4, characterClassInfo.getAmountOfKnownSpells(15, 3));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_4_16() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 16);
		assertEquals(4, characterClassInfo.getAmountOfKnownSpells(16, 3));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_4_17() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 17);
		assertEquals(4, characterClassInfo.getAmountOfKnownSpells(17, 3));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_4_18() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 18);
		assertEquals(4, characterClassInfo.getAmountOfKnownSpells(18, 3));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_4_19() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 19);
		assertEquals(4, characterClassInfo.getAmountOfKnownSpells(19, 3));
	}

	@Test
	public void test_getKnownSpellsForSorcererClass_4_20() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 20);
		assertEquals(4, characterClassInfo.getAmountOfKnownSpells(20, 3));
	}

	// BAB tests

	@Test
	public void test_getBAB_1() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 1);
		assertEquals(0, characterClassInfo.getBAB(0));
		assertEquals(0, characterClassInfo.getBAB(1));
		assertEquals(0, characterClassInfo.getBAB(2));
		assertEquals(0, characterClassInfo.getBAB(3));
	}

	@Test
	public void test_getBAB_2() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 2);
		assertEquals(1, characterClassInfo.getBAB(0));
		assertEquals(0, characterClassInfo.getBAB(1));
		assertEquals(0, characterClassInfo.getBAB(2));
		assertEquals(0, characterClassInfo.getBAB(3));
	}

	@Test
	public void test_getBAB_3() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 3);
		assertEquals(1, characterClassInfo.getBAB(0));
		assertEquals(0, characterClassInfo.getBAB(1));
		assertEquals(0, characterClassInfo.getBAB(2));
		assertEquals(0, characterClassInfo.getBAB(3));
	}

	@Test
	public void test_getBAB_4() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 4);
		assertEquals(2, characterClassInfo.getBAB(0));
		assertEquals(0, characterClassInfo.getBAB(1));
		assertEquals(0, characterClassInfo.getBAB(2));
		assertEquals(0, characterClassInfo.getBAB(3));
	}

	@Test
	public void test_getBAB_5() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 5);
		assertEquals(2, characterClassInfo.getBAB(0));
		assertEquals(0, characterClassInfo.getBAB(1));
		assertEquals(0, characterClassInfo.getBAB(2));
		assertEquals(0, characterClassInfo.getBAB(3));
	}

	@Test
	public void test_getBAB_6() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 6);
		assertEquals(3, characterClassInfo.getBAB(0));
		assertEquals(0, characterClassInfo.getBAB(1));
		assertEquals(0, characterClassInfo.getBAB(2));
		assertEquals(0, characterClassInfo.getBAB(3));
	}

	@Test
	public void test_getBAB_7() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 7);
		assertEquals(3, characterClassInfo.getBAB(0));
		assertEquals(0, characterClassInfo.getBAB(1));
		assertEquals(0, characterClassInfo.getBAB(2));
		assertEquals(0, characterClassInfo.getBAB(3));
	}

	@Test
	public void test_getBAB_8() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 8);
		assertEquals(4, characterClassInfo.getBAB(0));
		assertEquals(0, characterClassInfo.getBAB(1));
		assertEquals(0, characterClassInfo.getBAB(2));
		assertEquals(0, characterClassInfo.getBAB(3));
	}

	@Test
	public void test_getBAB_9() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 9);
		assertEquals(4, characterClassInfo.getBAB(0));
		assertEquals(0, characterClassInfo.getBAB(1));
		assertEquals(0, characterClassInfo.getBAB(2));
		assertEquals(0, characterClassInfo.getBAB(3));
	}

	@Test
	public void test_getBAB_10() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 10);
		assertEquals(5, characterClassInfo.getBAB(0));
		assertEquals(0, characterClassInfo.getBAB(1));
		assertEquals(0, characterClassInfo.getBAB(2));
		assertEquals(0, characterClassInfo.getBAB(3));
	}

	@Test
	public void test_getBAB_11() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 11);
		assertEquals(5, characterClassInfo.getBAB(0));
		assertEquals(0, characterClassInfo.getBAB(1));
		assertEquals(0, characterClassInfo.getBAB(2));
		assertEquals(0, characterClassInfo.getBAB(3));
	}

	@Test
	public void test_getBAB_122() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 12);
		assertEquals(6, characterClassInfo.getBAB(0));
		assertEquals(1, characterClassInfo.getBAB(1));
		assertEquals(0, characterClassInfo.getBAB(2));
		assertEquals(0, characterClassInfo.getBAB(3));
	}

	@Test
	public void test_getBAB_13() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 13);
		assertEquals(6, characterClassInfo.getBAB(0));
		assertEquals(1, characterClassInfo.getBAB(1));
		assertEquals(0, characterClassInfo.getBAB(2));
		assertEquals(0, characterClassInfo.getBAB(3));
	}

	@Test
	public void test_getBAB_14() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 14);
		assertEquals(7, characterClassInfo.getBAB(0));
		assertEquals(2, characterClassInfo.getBAB(1));
		assertEquals(0, characterClassInfo.getBAB(2));
		assertEquals(0, characterClassInfo.getBAB(3));
	}

	@Test
	public void test_getBAB_15() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 15);
		assertEquals(7, characterClassInfo.getBAB(0));
		assertEquals(2, characterClassInfo.getBAB(1));
		assertEquals(0, characterClassInfo.getBAB(2));
		assertEquals(0, characterClassInfo.getBAB(3));
	}

	@Test
	public void test_getBAB_16() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 16);
		assertEquals(8, characterClassInfo.getBAB(0));
		assertEquals(3, characterClassInfo.getBAB(1));
		assertEquals(0, characterClassInfo.getBAB(2));
		assertEquals(0, characterClassInfo.getBAB(3));
	}

	@Test
	public void test_getBAB_17() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 17);
		assertEquals(8, characterClassInfo.getBAB(0));
		assertEquals(3, characterClassInfo.getBAB(1));
		assertEquals(0, characterClassInfo.getBAB(2));
		assertEquals(0, characterClassInfo.getBAB(3));
	}

	@Test
	public void test_getBAB_18() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 18);
		assertEquals(9, characterClassInfo.getBAB(0));
		assertEquals(4, characterClassInfo.getBAB(1));
		assertEquals(0, characterClassInfo.getBAB(2));
		assertEquals(0, characterClassInfo.getBAB(3));
	}

	@Test
	public void test_getBAB_19() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 19);
		assertEquals(9, characterClassInfo.getBAB(0));
		assertEquals(4, characterClassInfo.getBAB(1));
		assertEquals(0, characterClassInfo.getBAB(2));
		assertEquals(0, characterClassInfo.getBAB(3));
	}

	@Test
	public void test_getBAB_20() {
		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 20);
		assertEquals(10, characterClassInfo.getBAB(0));
		assertEquals(5, characterClassInfo.getBAB(1));
		assertEquals(0, characterClassInfo.getBAB(2));
		assertEquals(0, characterClassInfo.getBAB(3));
	}

	@Test
	public void test_getReflex_1() {

		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 1);
		assertEquals(0, characterClassInfo.getReflex());
	}

	@Test
	public void test_getWill_1() {

		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 1);
		assertEquals(2, characterClassInfo.getWill());
	}

	@Test
	public void test_getFortitude_1() {

		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 1);
		assertEquals(0, characterClassInfo.getFortitude());
	}

	@Test
	public void test_getReflex_10() {

		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 10);
		assertEquals(3, characterClassInfo.getReflex());
	}

	@Test
	public void test_getWill_10() {

		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 10);
		assertEquals(7, characterClassInfo.getWill());
	}

	@Test
	public void test_getFortitude_10() {

		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 10);
		assertEquals(3, characterClassInfo.getFortitude());
	}

	@Test
	public void test_getReflex_20() {

		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 20);
		assertEquals(6, characterClassInfo.getReflex());
	}

	@Test
	public void test_getWill_20() {

		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 20);
		assertEquals(12, characterClassInfo.getWill());
	}

	@Test
	public void test_getFortitude_20() {

		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 20);
		assertEquals(6, characterClassInfo.getFortitude());
	}

	// Test Spells per Day

	@Test
	public void test_getSpellsPerDay1_1() {

		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 1);
		assertEquals(3, characterClassInfo.getSpellsPerDay(1));
	}

	@Test
	public void test_getSpellsPerDay1_2() {

		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 2);
		assertEquals(4, characterClassInfo.getSpellsPerDay(1));
	}

	@Test
	public void test_getSpellsPerDay1_3() {

		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 3);
		assertEquals(5, characterClassInfo.getSpellsPerDay(1));
	}

	@Test
	public void test_getSpellsPerDay1_4() {

		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 4);
		assertEquals(6, characterClassInfo.getSpellsPerDay(1));
	}

	@Test
	public void test_getSpellsPerDay1_5() {

		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 5);
		assertEquals(6, characterClassInfo.getSpellsPerDay(1));
	}

	@Test
	public void test_getSpellsPerDay2_1() {

		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 3);
		assertEquals(0, characterClassInfo.getSpellsPerDay(2));
	}

	@Test
	public void test_getSpellsPerDay2_2() {

		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 4);
		assertEquals(3, characterClassInfo.getSpellsPerDay(2));
	}

	@Test
	public void test_getSpellsPerDay2_3() {

		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 5);
		assertEquals(4, characterClassInfo.getSpellsPerDay(2));
	}

	@Test
	public void test_getSpellsPerDay2_4() {

		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 6);
		assertEquals(5, characterClassInfo.getSpellsPerDay(2));
	}

	@Test
	public void test_getSpellsPerDay2_5() {

		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 7);
		assertEquals(6, characterClassInfo.getSpellsPerDay(2));
	}

	@Test
	public void test_getSpellsPerDay2_6() {

		CharacterClassInfo characterClassInfo = new CharacterClassInfo("Sorcerer", 20);
		assertEquals(6, characterClassInfo.getSpellsPerDay(2));
	}
}
