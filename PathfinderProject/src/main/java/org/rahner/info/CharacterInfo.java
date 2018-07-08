package org.rahner.info;

public class CharacterInfo {

	public static int[] getPayload(int str) {

		int[] result = new int[6];

		if (str == 1) {
			result[0] = 3;
			result[1] = 6;
			result[2] = 10;
		} else if (str == 2) {
			result[0] = 6;
			result[1] = 13;
			result[2] = 20;
		} else if (str == 3) {
			result[0] = 10;
			result[1] = 20;
			result[2] = 30;
		} else if (str == 4) {
			result[0] = 13;
			result[1] = 26;
			result[2] = 40;
		} else if (str == 5) {
			result[0] = 16;
			result[1] = 33;
			result[2] = 50;
		} else if (str == 6) {
			result[0] = 20;
			result[1] = 40;
			result[2] = 60;
		} else if (str == 7) {
			result[0] = 23;
			result[1] = 46;
			result[2] = 70;
		} else if (str == 8) {
			result[0] = 26;
			result[1] = 53;
			result[2] = 80;
		} else if (str == 9) {
			result[0] = 30;
			result[1] = 60;
			result[2] = 90;
		} else if (str == 10) {
			result[0] = 33;
			result[1] = 66;
			result[2] = 100;
		} else if (str == 11) {
			result[0] = 38;
			result[1] = 76;
			result[2] = 115;
		} else if (str == 12) {
			result[0] = 43;
			result[1] = 86;
			result[2] = 130;
		} else if (str == 13) {
			result[0] = 50;
			result[1] = 100;
			result[2] = 150;
		} else if (str == 14) {
			result[0] = 58;
			result[1] = 116;
			result[2] = 175;
		} else if (str == 15) {
			result[0] = 66;
			result[1] = 133;
			result[2] = 200;
		} else if (str == 16) {
			result[0] = 76;
			result[1] = 153;
			result[2] = 230;
		} else if (str == 17) {
			result[0] = 86;
			result[1] = 173;
			result[2] = 260;
		} else if (str == 18) {
			result[0] = 100;
			result[1] = 200;
			result[2] = 300;
		} else if (str == 19) {
			result[0] = 116;
			result[1] = 233;
			result[2] = 350;
		} else if (str == 20) {
			result[0] = 133;
			result[1] = 266;
			result[2] = 400;
		} else if (str == 21) {
			result[0] = 153;
			result[1] = 306;
			result[2] = 460;
		} else if (str == 22) {
			result[0] = 173;
			result[1] = 346;
			result[2] = 520;
		} else if (str == 23) {
			result[0] = 200;
			result[1] = 400;
			result[2] = 600;
		} else if (str == 24) {
			result[0] = 233;
			result[1] = 466;
			result[2] = 700;
		} else if (str == 25) {
			result[0] = 266;
			result[1] = 533;
			result[2] = 800;
		} else if (str == 26) {
			result[0] = 306;
			result[1] = 613;
			result[2] = 920;
		} else if (str == 27) {
			result[0] = 346;
			result[1] = 693;
			result[2] = 1040;
		} else if (str == 28) {
			result[0] = 400;
			result[1] = 800;
			result[2] = 1200;
		} else if (str == 29) {
			result[0] = 466;
			result[1] = 933;
			result[2] = 1400;
		}

		result[3] = result[2];
		result[4] = 2 * result[2];
		result[5] = 5 * result[2];
		return result;
	}

	/**
	 * This method returns the required amount of experience to get that level.
	 * 
	 * 
	 * @param lvl
	 *            permitted values are <Strong> 2-20 </Strong>
	 * @param speed
	 *            permitted values are <Strong> slow, medium and fast </Strong>
	 * @return There is no check against input parameter, in case of wrong input
	 *         this method will return 0.
	 */

	public static int getRequiredExpForLevel(int lvl, String speed) {

		if (lvl == 2 && speed.equals("slow")) {
			return 3000;
		} else if (lvl == 2 && speed.equals("medium")) {
			return 2000;
		} else if (lvl == 2 && speed.equals("fast")) {
			return 1300;
		} else if (lvl == 3 && speed.equals("slow")) {
			return 7500;
		} else if (lvl == 3 && speed.equals("medium")) {
			return 5000;
		} else if (lvl == 3 && speed.equals("fast")) {
			return 3300;
		} else if (lvl == 4 && speed.equals("slow")) {
			return 14000;
		} else if (lvl == 4 && speed.equals("medium")) {
			return 9000;
		} else if (lvl == 4 && speed.equals("fast")) {
			return 6000;
		} else if (lvl == 5 && speed.equals("slow")) {
			return 23000;
		} else if (lvl == 5 && speed.equals("medium")) {
			return 15000;
		} else if (lvl == 5 && speed.equals("fast")) {
			return 10000;
		} else if (lvl == 6 && speed.equals("slow")) {
			return 35000;
		} else if (lvl == 6 && speed.equals("medium")) {
			return 23000;
		} else if (lvl == 6 && speed.equals("fast")) {
			return 15000;
		} else if (lvl == 7 && speed.equals("slow")) {
			return 53000;
		} else if (lvl == 7 && speed.equals("medium")) {
			return 35000;
		} else if (lvl == 7 && speed.equals("fast")) {
			return 23000;
		} else if (lvl == 8 && speed.equals("slow")) {
			return 77000;
		} else if (lvl == 8 && speed.equals("medium")) {
			return 51000;
		} else if (lvl == 8 && speed.equals("fast")) {
			return 34000;
		} else if (lvl == 9 && speed.equals("slow")) {
			return 115000;
		} else if (lvl == 9 && speed.equals("medium")) {
			return 75000;
		} else if (lvl == 9 && speed.equals("fast")) {
			return 50000;
		} else if (lvl == 10 && speed.equals("slow")) {
			return 160000;
		} else if (lvl == 10 && speed.equals("medium")) {
			return 105000;
		} else if (lvl == 10 && speed.equals("fast")) {
			return 71000;
		} else if (lvl == 11 && speed.equals("slow")) {
			return 235000;
		} else if (lvl == 11 && speed.equals("medium")) {
			return 155000;
		} else if (lvl == 11 && speed.equals("fast")) {
			return 105000;
		} else if (lvl == 12 && speed.equals("slow")) {
			return 330000;
		} else if (lvl == 12 && speed.equals("medium")) {
			return 220000;
		} else if (lvl == 12 && speed.equals("fast")) {
			return 145000;
		} else if (lvl == 13 && speed.equals("slow")) {
			return 475000;
		} else if (lvl == 13 && speed.equals("medium")) {
			return 315000;
		} else if (lvl == 13 && speed.equals("fast")) {
			return 210000;
		} else if (lvl == 14 && speed.equals("slow")) {
			return 665000;
		} else if (lvl == 14 && speed.equals("medium")) {
			return 445000;
		} else if (lvl == 14 && speed.equals("fast")) {
			return 295000;
		} else if (lvl == 15 && speed.equals("slow")) {
			return 955000;
		} else if (lvl == 15 && speed.equals("medium")) {
			return 635000;
		} else if (lvl == 15 && speed.equals("fast")) {
			return 425000;
		} else if (lvl == 16 && speed.equals("slow")) {
			return 1350000;
		} else if (lvl == 16 && speed.equals("medium")) {
			return 890000;
		} else if (lvl == 16 && speed.equals("fast")) {
			return 600000;
		} else if (lvl == 17 && speed.equals("slow")) {
			return 1900000;
		} else if (lvl == 17 && speed.equals("medium")) {
			return 1300000;
		} else if (lvl == 17 && speed.equals("fast")) {
			return 850000;
		} else if (lvl == 18 && speed.equals("slow")) {
			return 2700000;
		} else if (lvl == 18 && speed.equals("medium")) {
			return 1800000;
		} else if (lvl == 18 && speed.equals("fast")) {
			return 1200000;
		} else if (lvl == 19 && speed.equals("slow")) {
			return 3850000;
		} else if (lvl == 19 && speed.equals("medium")) {
			return 2550000;
		} else if (lvl == 19 && speed.equals("fast")) {
			return 1700000;
		} else if (lvl == 20 && speed.equals("slow")) {
			return 5350000;
		} else if (lvl == 20 && speed.equals("medium")) {
			return 3600000;
		} else if (lvl == 20 && speed.equals("fast")) {
			return 2400000;
		} else {
			return 0;
		}
	}

	public static boolean newTalentOnThatLevel(int lvl) {

		if (lvl % 2 == 0) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean newAttributeOnThatLevel(int lvl) {

		if (lvl % 4 == 0) {
			return true;
		} else {
			return false;
		}
	}
}
