package org.rahner.controllers;

import javax.servlet.http.HttpServletRequest;

import org.rahner.exceptions.CharacterInfoException;
import org.rahner.exceptions.CharacterNotInDbException;
import org.rahner.maintain.CharacterMaintanance;
import org.rahner.msgHandling.MsgType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entities.Character;
import services.CharacterClassService;

@Controller
public class CharacterCreationClassController extends MainController {

	@RequestMapping(value = "/creation/class", method = RequestMethod.GET)
	public String showAvaiableClasses(HttpServletRequest request, Model model) {

		Character character = getCharacterFromSession(request);

		if (character.getLevelUpPhase() != 2) {

			addMsgToModel("Character is in wrong phase", MsgType.error.toString(), model, true);
			return "CharacterCreatingClass";

		} else {

			CharacterClassService characterClassService = new CharacterClassService();
			characterClassService.setEm(em);
			model.addAttribute("characterClasses", characterClassService.findAll());
		}

		return "CharacterCreatingClass";
	}

	@RequestMapping(value = "/creation/processClass", method = RequestMethod.POST)
	public String processClass(Model model, HttpServletRequest request, @RequestParam("className") String className) {

		Character dbCharacter = getCharacterFromSession(request);

		try {
			CharacterMaintanance characterMaintanance = new CharacterMaintanance(dbCharacter);
			characterMaintanance.linkMainCharacterClassToCharacter(className);
			try {
				characterMaintanance.initiateMoney();
				characterMaintanance.updateBABWilRefFor(className);
				characterMaintanance.initateHp();
				characterMaintanance.goToNextPhase();

			} catch (CharacterInfoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (CharacterNotInDbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/creation/skills";
	}
}
