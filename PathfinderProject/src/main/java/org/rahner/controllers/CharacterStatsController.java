package org.rahner.controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpSession;

import org.rahner.info.AttributeInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entities.Character;
import entities.User;
import services.CharacterService;
import services.UserService;

@Controller
public class CharacterStatsController extends MainController {

	@RequestMapping(value = "/charStats", method = RequestMethod.GET)
	public String showCharacterStats(HttpSession session, Model model) {

		if (sessionIsValid(session, model)) {

			EntityManagerFactory entityManagerFactory = javax.persistence.Persistence
					.createEntityManagerFactory("PathfinderProject");
			EntityManager em = entityManagerFactory.createEntityManager();

			UserService us = new UserService();
			us.setEm(em);
			User currentUser = us.findOne(Integer.parseInt(session.getAttribute("userId").toString()));

			model.addAttribute("characters", currentUser.getCharacters());
			model.addAttribute("statsCharacter", new entities.Character());
		}

		return "charStats";
	}

	@RequestMapping(value = "/charStats", method = RequestMethod.POST)
	public String showStatsForSpecificCharacter(HttpSession session, Model model, Character statsCharacter) {

		if (sessionIsValid(session, model)) {

			EntityManagerFactory entityManagerFactory = javax.persistence.Persistence
					.createEntityManagerFactory("PathfinderProject");
			EntityManager em = entityManagerFactory.createEntityManager();

			UserService us = new UserService();
			CharacterService cs = new CharacterService();
			us.setEm(em);
			cs.setEm(em);

			AttributeInfo attributeInfo = new AttributeInfo();
			User currentUser = us.findOne(Integer.parseInt(session.getAttribute("userId").toString()));

			model.addAttribute("characters", currentUser.getCharacters());
			model.addAttribute("dbCharacter", cs.findCharacterByName(statsCharacter.getName()));
			model.addAttribute("statsCharacter", cs.findCharacterByName(statsCharacter.getName()));
		}

		return "charStats";
	}
}
