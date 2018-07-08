package org.rahner.random;

public class DiceAndRollFactory {

	private static int amountDice;

	private static Dice dice;

	public DiceAndRollFactory(String dice) {

		String[] amountArray = dice.split("D");
		this.amountDice = Integer.parseInt(amountArray[0]);
		this.dice = new Dice(Integer.parseInt(amountArray[1]));
	}

	public int rollAndSum() {

		if (amountDice == 1) {
			return dice.roll();
		} else {
			int sum = 0;
			for (int i = 0; i < amountDice; i++) {
				sum = sum + dice.roll();
			}
			return sum;
		}
	}
}
