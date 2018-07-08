package org.rahner.info;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AttributeInfoTest {

	private AttributeInfo attributeInfo;

	@Before
	public void init() {
		attributeInfo = new AttributeInfo();
	}

	@Test
	public void testQuick() {

		assertEquals(6, attributeInfo.getModi(23));
	}

	@Test
	public void testGetModiWithOddValue() {

		assertEquals(2, attributeInfo.getModi(15));
	}

	@Test
	public void testGetModiWithEvenValue() {

		assertEquals(2, attributeInfo.getModi(15));
	}

	@Test
	public void testGetModiWithNegativeResult() {

		assertEquals(-5, attributeInfo.getModi(1));
	}

	@Test
	public void testGetSpellsPerDayForLvl0_1() {

		assertEquals(0, attributeInfo.getAdditionalSpellsPerDay(4, 0));
	}

	@Test
	public void testGetSpellsPerDayForLvl0_2() {

		assertEquals(0, attributeInfo.getAdditionalSpellsPerDay(10, 0));
	}

	@Test
	public void testGetSpellsPerDayForLvl0_3() {

		assertEquals(0, attributeInfo.getAdditionalSpellsPerDay(11, 0));
	}

	@Test
	public void testGetSpellsPerDayForLvl0_4() {

		assertEquals(0, attributeInfo.getAdditionalSpellsPerDay(16, 0));
	}

	@Test
	public void testGetSpellsPerDayForLvl0_5() {

		assertEquals(0, attributeInfo.getAdditionalSpellsPerDay(18, 0));
	}

	@Test
	public void testGetSpellsPerDayForLvl0_6() {

		assertEquals(0, attributeInfo.getAdditionalSpellsPerDay(19, 0));
	}

	@Test
	public void testGetSpellsPerDayForLvl0_7() {

		assertEquals(0, attributeInfo.getAdditionalSpellsPerDay(345, 0));
	}

	@Test
	public void testGetSpellsPerDayForLvl1_1() {

		assertEquals(0, attributeInfo.getAdditionalSpellsPerDay(1, 1));
	}

	@Test
	public void testGetSpellsPerDayForLvl1_2() {

		assertEquals(0, attributeInfo.getAdditionalSpellsPerDay(9, 1));
	}

	@Test
	public void testGetSpellsPerDayForLvl1_3() {

		assertEquals(0, attributeInfo.getAdditionalSpellsPerDay(11, 1));
	}

	@Test
	public void testGetSpellsPerDayForLvl1_4() {

		assertEquals(1, attributeInfo.getAdditionalSpellsPerDay(12, 1));
	}

	@Test
	public void testGetSpellsPerDayForLvl1_5() {

		assertEquals(1, attributeInfo.getAdditionalSpellsPerDay(13, 1));
	}

	@Test
	public void testGetSpellsPerDayForLvl1_6() {

		assertEquals(1, attributeInfo.getAdditionalSpellsPerDay(18, 1));
	}

	@Test
	public void testGetSpellsPerDayForLvl1_7() {

		assertEquals(1, attributeInfo.getAdditionalSpellsPerDay(19, 1));
	}

	@Test
	public void testGetSpellsPerDayForLvl1_8() {

		assertEquals(2, attributeInfo.getAdditionalSpellsPerDay(20, 1));
	}

	@Test
	public void testGetSpellsPerDayForLvl1_9() {

		assertEquals(2, attributeInfo.getAdditionalSpellsPerDay(21, 1));
	}

	@Test
	public void testGetSpellsPerDayForLvl1_10() {

		assertEquals(2, attributeInfo.getAdditionalSpellsPerDay(26, 1));
	}

	@Test
	public void testGetSpellsPerDayForLvl1_11() {

		assertEquals(2, attributeInfo.getAdditionalSpellsPerDay(27, 1));
	}

	@Test
	public void testGetSpellsPerDayForLvl1_12() {

		assertEquals(5, attributeInfo.getAdditionalSpellsPerDay(45, 1));
	}

	@Test
	public void testGetSpellsPerDayForLvl7_1() {

		assertEquals(0, attributeInfo.getAdditionalSpellsPerDay(1, 7));
	}

	@Test
	public void testGetSpellsPerDayForLvl7_2() {

		assertEquals(0, attributeInfo.getAdditionalSpellsPerDay(11, 7));
	}

	@Test
	public void testGetSpellsPerDayForLvl7_3() {

		assertEquals(0, attributeInfo.getAdditionalSpellsPerDay(23, 7));
	}

	@Test
	public void testGetSpellsPerDayForLvl7_4() {

		assertEquals(1, attributeInfo.getAdditionalSpellsPerDay(24, 7));
	}

	@Test
	public void testGetSpellsPerDayForLvl7_5() {

		assertEquals(1, attributeInfo.getAdditionalSpellsPerDay(25, 7));
	}

	@Test
	public void testGetSpellsPerDayForLvl7_6() {

		assertEquals(1, attributeInfo.getAdditionalSpellsPerDay(31, 7));
	}

	@Test
	public void testGetSpellsPerDayForLvl7_8() {

		assertEquals(2, attributeInfo.getAdditionalSpellsPerDay(32, 7));
	}

	@Test
	public void testGetSpellsPerDayForLvl7_9() {

		assertEquals(2, attributeInfo.getAdditionalSpellsPerDay(39, 7));
	}

	@Test
	public void testGetSpellsPerDayForLvl7_10() {

		assertEquals(3, attributeInfo.getAdditionalSpellsPerDay(40, 7));
	}

	@Test
	public void testGetSpellsPerDayForLvl7_11() {

		assertEquals(3, attributeInfo.getAdditionalSpellsPerDay(41, 7));
	}

	@Test
	public void testGetSpellsPerDayForLvl9_1() {

		assertEquals(3, attributeInfo.getAdditionalSpellsPerDay(45, 9));
	}

	@Test
	public void testRandomMatrixValue_1() {

		assertEquals(3, attributeInfo.getAdditionalSpellsPerDay(41, 5));
	}

	@Test
	public void testOverloadOfSpellsPerDay() {

		attributeInfo.setModificator(attributeInfo.getModi(41));
		assertEquals(3, attributeInfo.getAdditionalSpellsPerDay(5));
	}
}
