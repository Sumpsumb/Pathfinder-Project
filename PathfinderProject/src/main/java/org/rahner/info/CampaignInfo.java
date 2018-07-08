package org.rahner.info;

public class CampaignInfo {

	public int getEnhancementPoints(String fantasyLevel) {

		if (fantasyLevel.equals("Low-Fantasy")) {
			return 10;
		} else if (fantasyLevel.equals("Standart-Fantasy")) {
			return 15;
		} else if (fantasyLevel.equals("High-Fantasy")) {
			return 20;
		} else if (fantasyLevel.equals("Epic-Fantasy")) {
			return 25;
		} else {
			return 0;
		}
	}
}
