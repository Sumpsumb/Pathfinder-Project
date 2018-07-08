package org.rahner.msgHandling;

import org.springframework.ui.Model;

public class WarningMsg implements MessageHandlingSystem {

	public void createMsg(String msg, Model model, boolean isActive) {

		model.addAttribute("warningActive", isActive);
		model.addAttribute("warningStyle", "msg-box warning");
		model.addAttribute("warningMsg", msg);
	}
}
