package org.rahner.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainCockpitController extends MainController {

	@RequestMapping(value = "/mainCockpit", method = RequestMethod.GET)
	public String showMainCockpit(HttpServletRequest request, Model model) {

		return "mainCockpit";
	}
}
