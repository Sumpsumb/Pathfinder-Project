package org.rahner.random;

import java.util.Random;

public class Dice {

	private int amountOfSurfaces;

	private Random random;

	public Dice(int amountOfSurfaces) {
		this.random = new Random();
		this.amountOfSurfaces = amountOfSurfaces;
	}

	public int roll() {

		return (int) showRandomInteger(1, amountOfSurfaces, random);
	}

	private static long showRandomInteger(int aStart, int aEnd, Random aRandom) {
		if (aStart > aEnd) {
			throw new IllegalArgumentException("Start cannot exceed End.");
		}
		// get the range, casting to long to avoid overflow problems
		long range = (long) aEnd - (long) aStart + 1L;
		// compute a fraction of the range, 0 <= frac < range
		long fraction = (long) (range * aRandom.nextDouble());
		long randomNumber = fraction + aStart;
		// log("Generated : " + randomNumber);
		return randomNumber;

	}
}
