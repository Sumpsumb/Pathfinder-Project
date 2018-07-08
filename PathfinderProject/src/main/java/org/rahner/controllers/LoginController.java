package org.rahner.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.rahner.msgHandling.MsgType;
import org.rahner.validation.Validation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entities.User;

@Controller
public class LoginController extends MainController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginScreen(Model model, HttpSession session) {

		model.addAttribute("user", new User());
		sessionIsValid(session, model);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processLogin(Model model, User user, HttpServletRequest request) {

		model.addAttribute("user", user);

		if (Validation.usernameInDatabase(user.getName())) {
			if (Validation.passwordMatchingUsernamme(user.getName(), user.getPassword())) {

				User dbUser = userService.findOneByName(user.getName());

				if (Validation.emailIsVerified(dbUser)) {

					addMsgToModel("Login successful", MsgType.info.toString(), model, true);
					HttpSession session = request.getSession();
					session.setAttribute("userId", dbUser.getId());
					model.addAttribute("sessionStarted", true);
					request.getSession().setAttribute("permission", dbUser.getPermission());
					return "login";

				} else {

					// TODO: Msg handling
					model.addAttribute("user", new User());
					return "login";
				}

			} else {

				addMsgToModel("Password incorrect", MsgType.warning.toString(), model, true);
				model.addAttribute("user", new User());
				return "login";
			}

		} else {

			addMsgToModel("Unknown Username", MsgType.warning.toString(), model, true);
			model.addAttribute("user", new User());
			return "login";
		}
	}
}
