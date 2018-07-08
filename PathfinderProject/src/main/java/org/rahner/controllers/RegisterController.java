package org.rahner.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.rahner.distribution.UserMail;
import org.rahner.validation.Validation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entities.User;

@Controller
public class RegisterController extends MainController {

	@RequestMapping(value = "/register/verifyEmail", method = RequestMethod.GET)
	public String verifyEmail(HttpServletRequest request, Model model) {

		User user = userService.findOne(Integer.parseInt(request.getParameter("userId")));

		if (user.getPermission() != "U" && request.getParameter("sessionId").equals(request.getSession().getId())) {

			user.setPermission("U");
			userService.update(user);
			em.refresh(user);
			request.getSession().setAttribute("permission", user.getPermission());

		} else {

			return "register";
		}

		return "redirect:/";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegister(org.springframework.ui.Model model, HttpSession session) {

		model.addAttribute("user", new User());
		sessionIsValid(session, model);
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegistration(Model model, User user, HttpServletRequest request) {

		model.addAttribute("user", user);

		if (Validation.verifyPassword(user.getPassword(), user.getPasswordVerification())) {

			if (Validation.usernameInDatabase(user.getName())) {

				boolean usernameInDb = true;
				model.addAttribute("usernameInDb", usernameInDb);
				model.addAttribute("user", new User());
				return "register";

			} else {

				userService.create(user);
				boolean registrationSuccessful = true;
				model.addAttribute("registrationSuccessful", registrationSuccessful);

				try {
					UserMail.sendRegistrationVerificationLink(request.getSession().getId(), user.getId(),
							user.getEmail());
				} catch (EmailException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// model.addAttribute("sessionStarted", true);
				return "register";
			}

		} else {

			boolean passwordIdentically = false;
			model.addAttribute("passwordIdentically", passwordIdentically);
			model.addAttribute("user", new User());
			return "register";
		}
	}
}
