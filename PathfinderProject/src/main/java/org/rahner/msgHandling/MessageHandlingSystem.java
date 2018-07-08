package org.rahner.msgHandling;

import org.springframework.ui.Model;

public interface MessageHandlingSystem {

	public void createMsg(String msg, Model model, boolean isActive);
}
