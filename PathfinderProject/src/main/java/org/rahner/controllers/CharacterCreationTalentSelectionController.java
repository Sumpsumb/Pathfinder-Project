package org.rahner.controllers;

import javax.servlet.http.HttpServletRequest;

import org.rahner.exceptions.ProcessTalentException;
import org.rahner.exceptions.TalentAlreadyKnownException;
import org.rahner.exceptions.TalentConditionException;
import org.rahner.exceptions.TalentNotInDbException;
import org.rahner.maintain.CharacterMaintanance;
import org.rahner.msgHandling.MsgType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entities.Character;
import entities.CharacterTransitionDetail;
import entities.User;
import services.CharacterTransitionDetailsService;
import services.TalentService;

@Controller
public class CharacterCreationTalentSelectionController extends MainController {

	@RequestMapping(value = "/creation/talents", method = RequestMethod.GET)
	public String showTalentSelection(HttpServletRequest request, Model model) {

		Character character = getCharacterFromSession(request);

		if (character.getLevelUpPhase() != 4) {

			addMsgToModel("Character is in wrong creation phase", MsgType.error.toString(), model, true);
			return "characterTalentSelection";
		}

		TalentService talentService = new TalentService();
		talentService.setEm(em);

		model.addAttribute("talents", talentService.findAll());

		return "characterTalentSelection";
	}

	@RequestMapping(value = "/creation/processTalent", method = RequestMethod.POST)
	public String processTalent(HttpServletRequest request, Model model, @RequestParam("talentId") int talentId) {

		Character dbCharacter = getCharacterFromSession(request);
		User user = getUserFromSession(request);

		try {
			CharacterMaintanance characterMaintanance = new CharacterMaintanance(dbCharacter);
			characterMaintanance.learnTalent(talentId);

			CharacterTransitionDetailsService characterTransitionDetailsService = new CharacterTransitionDetailsService();
			characterTransitionDetailsService.setEm(em);
			CharacterTransitionDetail characterTransitionDetail = characterTransitionDetailsService
					.findForUserAndCharacter(user, dbCharacter);

			if (characterTransitionDetail.getTalentPoints() == 1 || characterTransitionDetail.getTalentPoints() == 0) {
				characterTransitionDetail.setTalentPoints(0);
				characterTransitionDetailsService.update(characterTransitionDetail);
				characterMaintanance.goToNextPhase();
				return "redirect:itemSelection";
			} else {
				characterTransitionDetail.setTalentPoints(characterTransitionDetail.getTalentPoints() - 1);
				characterTransitionDetailsService.update(characterTransitionDetail);
			}

			em.refresh(characterTransitionDetail);

		} catch (TalentNotInDbException talentNotInDbE) {

			addMsgToModel(talentNotInDbE.getMessage(), MsgType.error.toString(), model, true);

		} catch (TalentAlreadyKnownException e) {

			addMsgToModel(e.getMessage(), MsgType.warning.toString(), model, true);

		} catch (TalentConditionException e) {

			addMsgToModel(e.getMessage(), MsgType.warning.toString(), model, true);

		} catch (ProcessTalentException e) {

			addMsgToModel(e.getMessage(), MsgType.warning.toString(), model, true);

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			TalentService talentService = new TalentService();
			talentService.setEm(em);

			model.addAttribute("talents", talentService.findAll());
		}

		return "characterTalentSelection";
	}
}
