package org.rahner.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.rahner.exceptions.CharacterNotInDbException;
import org.rahner.maintain.CharacterMaintanance;
import org.rahner.msgHandling.MsgType;
import org.rahner.validation.Validation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entities.Character;
import entities.CharacterSkill;
import entities.CharacterTransitionDetail;
import entities.User;
import services.CharacterSkillService;
import services.CharacterTransitionDetailsService;

@Controller
public class CharacterCreationSkillSelectionController extends MainController {

	@RequestMapping(value = "/creation/skills", method = RequestMethod.GET)
	public String showSkills(HttpServletRequest request, Model model) {

		Character character = getCharacterFromSession(request);
		User user = getUserFromSession(request);

		if (character.getLevelUpPhase() != 3) {

			addMsgToModel("Character is in wrong creation phase", MsgType.error.toString(), model, true);
			return "characterSkillSelection";

		} else {

			model.addAttribute("characterSkills", character.getCharacterSkills());
			CharacterTransitionDetailsService characterTransitionDetailsService = new CharacterTransitionDetailsService();
			characterTransitionDetailsService.setEm(em);
			model.addAttribute("skillpoints",
					characterTransitionDetailsService.findForUserAndCharacter(user, character).getSkillPoints());
		}

		return "characterSkillSelection";
	}

	@RequestMapping(value = "/creation/processSkill", method = RequestMethod.POST)
	public String processSkill(HttpServletRequest request, Model model,
			@RequestParam("characterSkillName") String characterSkillName) {

		Character character = getCharacterFromSession(request);
		User user = getUserFromSession(request);

		if (Validation.rankEqualsTotLvl(character, characterSkillName)) {

			addMsgToModel("Skill rank exceeds you total Character level! Choose another skill",
					MsgType.warning.toString(), model, true);

			model.addAttribute("characterSkills", character.getCharacterSkills());
			CharacterTransitionDetailsService characterTransitionDetailsService = new CharacterTransitionDetailsService();
			characterTransitionDetailsService.setEm(em);

			model.addAttribute("skillpoints",
					characterTransitionDetailsService.findForUserAndCharacter(user, character).getSkillPoints());
			return "characterSkillSelection";

			// TODO:finish error handling
		}

		CharacterTransitionDetailsService characterTransitionDetailsService = new CharacterTransitionDetailsService();
		characterTransitionDetailsService.setEm(em);

		CharacterTransitionDetail characterTransitionDetail = characterTransitionDetailsService
				.findForUserAndCharacter(user, character);

		characterTransitionDetail.setSkillPoints(characterTransitionDetail.getSkillPoints() - 1);
		characterTransitionDetailsService.update(characterTransitionDetail);
		em.refresh(characterTransitionDetail);

		try {
			CharacterMaintanance characterMaintanance = new CharacterMaintanance(character);
			characterMaintanance.learnSkill(characterSkillName);

			if (characterTransitionDetail.getSkillPoints() == 0) {
				characterMaintanance.goToNextPhase();
				return "redirect:/creation/talents";
			} else {
				model.addAttribute("skillpoints", characterTransitionDetail.getSkillPoints());
			}

		} catch (CharacterNotInDbException e) {

			addMsgToModel(e.getMessage(), MsgType.error.toString(), model, true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		CharacterSkillService characterSkillService = new CharacterSkillService();
		characterSkillService.setEm(em);

		List<CharacterSkill> characterSkills = characterSkillService.findAllCharacterSkillsForCharacter(character);
		for (CharacterSkill characterSkill : characterSkills) {
			em.refresh(characterSkill);
		}

		model.addAttribute("characterSkills", characterSkills);

		return "characterSkillSelection";
	}
}
