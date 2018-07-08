package org.rahner.model;

public class UnitConverter {

	public static int[] convertMoneyFromCopper(int copperMoney) {

		int[] money = new int[4];

		if (copperMoney / 1000 >= 1) {
			money[0] = copperMoney / 1000;
		} else {
			money[0] = 0;
		}

		if ((copperMoney - (money[0] * 1000)) / 100 >= 1) {
			money[1] = (copperMoney - (money[0] * 1000)) / 100;
		} else {
			money[1] = 0;
		}

		if (copperMoney - (money[0] * 1000 + money[1] * 100) / 10 >= 1) {
			money[2] = (copperMoney - (money[0] * 1000 + money[1] * 100)) / 10;
		} else {
			money[2] = 0;
		}

		money[3] = copperMoney - (money[0] * 1000 + money[1] * 100 + money[2] * 10);
		return money;
	}

	public static int convertMoneyToCopper(int[] money) {

		int copperMoney;

		copperMoney = money[0] * 1000 + money[1] * 100 + money[2] * 10 + money[3];
		return copperMoney;
	}
}
