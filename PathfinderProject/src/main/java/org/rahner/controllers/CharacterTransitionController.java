package org.rahner.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.rahner.exceptions.CharacterInfoException;
import org.rahner.exceptions.CharacterNotInDbException;
import org.rahner.info.CampaignInfo;
import org.rahner.maintain.CharacterMaintanance;
import org.rahner.msgHandling.MsgType;
import org.rahner.validation.Validation;
import org.rahner.view.Attributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entities.Character;
import entities.CharacterTransitionDetail;
import entities.User;
import entities.UserCampaign;
import services.CharacterTransitionDetailsService;

@Controller
public class CharacterTransitionController extends MainController {

	@RequestMapping(value = "/creation/attributes", method = RequestMethod.GET)
	public String showCharacterTransitionScreen(Model model, HttpServletRequest request) {

		// TODO:Interceptor bauen
		Character character = getCharacterFromSession(request);
		User user = getUserFromSession(request);
		UserCampaign userCampaign = getUserCampaignFromSession(request);

		if (character.getLevelUpPhase() != 1) {

			addMsgToModel("Character is in wrong phase", MsgType.error.toString(), model, true);
			return "CharacterCreationAttributes";

		} else if (character.getInLevelUp().equals("Y")) {

			// TODO:Implement

		} else {

			if (userCampaign.getCampaign().getAttributeRule() == 1) {

				model.addAttribute("attributes", Attributes.getNames());

				HttpSession session = request.getSession();

				addEnhancementPointsToModel(session, model, user, character, userCampaign);

				return "CharacterCreationAttributes";
			}

			// TODO: Weitere Attribute methoden implementieren
		}

		return "CharacterCreationAttributes";

	}

	@RequestMapping(value = "/creation/attributes/validateAttributes", method = RequestMethod.POST)
	public String validateAttributes(Model model, @RequestParam("STR") String STRvalue,
			@RequestParam("DEX") String DEXvalue, @RequestParam("CON") String CONvalue,
			@RequestParam("WIS") String WISvalue, @RequestParam("CHA") String CHAvalue,
			@RequestParam("INT") String INTvalue, HttpServletRequest request) {

		Character character = getCharacterFromSession(request);
		User user = getUserFromSession(request);

		HttpSession session = request.getSession();

		if (Validation.allEnhancementPointsConsumed(Integer.parseInt(STRvalue), Integer.parseInt(DEXvalue),
				Integer.parseInt(CONvalue), Integer.parseInt(INTvalue), Integer.parseInt(WISvalue),
				Integer.parseInt(CHAvalue), (Integer) session.getAttribute("enhancementPoints"))) {

			CharacterTransitionDetailsService characterTransitionDetailsService = new CharacterTransitionDetailsService();
			characterTransitionDetailsService.setEm(em);

			CharacterTransitionDetail characterTransitionDetail = characterTransitionDetailsService
					.findForUserAndCharacter(user, character);

			characterTransitionDetailsService.setAttributes(characterTransitionDetail, STRvalue, DEXvalue, CONvalue,
					INTvalue, WISvalue, CHAvalue);

			characterTransitionDetailsService.update(characterTransitionDetail);

			try {
				CharacterMaintanance characterMaintanance = new CharacterMaintanance(character);
				try {
					characterMaintanance.gainAttributes(Integer.parseInt(STRvalue), Integer.parseInt(DEXvalue),
							Integer.parseInt(CONvalue), Integer.parseInt(INTvalue), Integer.parseInt(WISvalue),
							Integer.parseInt(CHAvalue));

				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (CharacterInfoException e) {
					e.printStackTrace();
				}

				characterMaintanance.goToNextPhase();

			} catch (CharacterNotInDbException e) {

				addMsgToModel(e.getMessage(), MsgType.error.toString(), model, true);
				return "CharacterCreationAttributes";
			} catch (Exception e) {

				e.printStackTrace();

			}
			return "redirect:/creation/class";

		} else {
			model.addAttribute("attributes", Attributes.getNames());
			addMsgToModel("Not all or too much enhancement points were used!", MsgType.warning.toString(), model, true);
		}
		return "CharacterCreationAttributes";
	}

	private void addEnhancementPointsToModel(HttpSession session, Model model, User user, Character character,
			UserCampaign userCampaign) {

		CampaignInfo campaignInfo = new CampaignInfo();
		CharacterTransitionDetailsService characterTransitionDetailsService = new CharacterTransitionDetailsService();
		characterTransitionDetailsService.setEm(em);

		CharacterTransitionDetail characterTransitionDetail = characterTransitionDetailsService
				.findForUserAndCharacter(user, character);
		int additionalPoints = characterTransitionDetail.getRandomAttributes();

		model.addAttribute("enhancementPoints",
				campaignInfo.getEnhancementPoints(userCampaign.getCampaign().getFantasyLevel()) + additionalPoints);
		session.setAttribute("enhancementPoints",
				campaignInfo.getEnhancementPoints(userCampaign.getCampaign().getFantasyLevel()) + additionalPoints);
	}
}
