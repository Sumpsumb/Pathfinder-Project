package org.rahner.msgHandling;

import org.springframework.ui.Model;

public class InfoMsg implements MessageHandlingSystem {

	/**
	 * This method creates a msg of severity: Info
	 */
	public void createMsg(String msg, Model model, boolean isActive) {

		model.addAttribute("infoActive", isActive);
		model.addAttribute("infoStyle", "msg-box info");
		model.addAttribute("infoMsg", msg);
	}

}
