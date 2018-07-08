package org.rahner.msgHandling;

import org.springframework.ui.Model;

public class ErrorMsg implements MessageHandlingSystem {

	public void createMsg(String msg, Model model, boolean isActive) {

		model.addAttribute("errorActive", isActive);
		model.addAttribute("errorStyle", "msg-box error");
		model.addAttribute("errorMsg", msg);
	}
}
