package org.rahner.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController extends MainController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showIndex(HttpSession session) {

		return "index";
	}
}
