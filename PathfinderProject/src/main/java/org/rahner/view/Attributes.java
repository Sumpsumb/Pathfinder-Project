package org.rahner.view;

public enum Attributes {

	STR, DEX, CON, INT, WIS, CHA;

	public static String[] getNames() {

		String[] result = new String[6];
		int i = 0;

		for (Attributes attributes : Attributes.values()) {

			result[i] = attributes.toString();
			i++;
		}
		return result;
	}
}
