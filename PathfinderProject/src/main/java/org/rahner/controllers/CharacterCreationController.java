package org.rahner.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.rahner.exceptions.CharacterInfoException;
import org.rahner.maintain.CharacterMaintanance;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entities.Character;
import entities.CharacterTransitionDetail;
import entities.UserCampaign;
import services.CharacterTransitionDetailsService;
import services.UserCampaignService;

@Controller
public class CharacterCreationController extends MainController {

	@RequestMapping(value = "/setUserCampaign", method = RequestMethod.GET)
	public String setUserCampaign(HttpServletRequest request, Model model) {

		if (userCampaignDoesExist(request)) {

			boolean errorOccured = true;
			String errorMsg = "The choosen campaign does not exist!";
			model.addAttribute("errorOccured", errorOccured);
			model.addAttribute("errorMsg", errorMsg);
			addUserCampaignsToModel(model, request);

			return "CharacterCreationBase";
		}

		if (!userCampaignBelongsToUser(request)) {

			boolean errorOccured = true;
			String errorMsg = "The choosen campaign does not belong to the user!";
			model.addAttribute("errorOccured", errorOccured);
			model.addAttribute("errorMsg", errorMsg);
			addUserCampaignsToModel(model, request);
			return "CharacterCreationBase";
		}

		setUserCampaignIdtoModelAndSession(model, request);
		List<UserCampaign> userCampaigns = getUserFromSession(request).getUserCampaigns();
		model.addAttribute("userCampaigns", userCampaigns);

		return "CharacterCreationBase";
	}

	@RequestMapping(value = "/baseCreation", method = RequestMethod.GET)
	public String showBasePage(HttpServletRequest request, Model model) {

		addUserCampaignsToModel(model, request);

		return "CharacterCreationBase";
	}

	@RequestMapping(value = "/handleBaseInput", method = RequestMethod.POST)
	public String handleBaseInput(HttpServletRequest request, Model model,
			@RequestParam("characterName") String characterName, @RequestParam("deity") String deity,
			@RequestParam("homeland") String homeland, @RequestParam("gender") String gender,
			@RequestParam("alignment") String alignment, @RequestParam("hair") String hair,
			@RequestParam("eye") String eye, @RequestParam("race") String race, @RequestParam("age") String age,
			@RequestParam("weight") String weight, @RequestParam("height") String height) {

		UserCampaignService userCampaignService = new UserCampaignService();
		userCampaignService.setEm(em);

		String campaignName = userCampaignService
				.findOne(Integer.parseInt(request.getSession().getAttribute("userCampaignId").toString())).getCampaign()
				.getName();

		if (deity.equals(null)) {
			deity = "None";
		}

		if (homeland.equals(null)) {
			homeland = "Unknown";
		}

		String genderAbbr = (gender.equals("male")) ? "M" : "F";
		int intAge = (!age.equals("12")) ? Integer.parseInt(age) : 0;
		double dWeight = (!weight.equals("25")) ? Double.parseDouble(weight) : 0d;
		double dHeight = (!height.equals("80")) ? Double.parseDouble(height) : 0d;

		userService.setEm(em);

		CharacterMaintanance characterMaintanance = new CharacterMaintanance();

		try {

			Character newCharacter;
			newCharacter = characterMaintanance.createNewCharacter(characterName, race, homeland, alignment, hair, eye,
					genderAbbr, deity, intAge, getUserFromSession(request).getName(), campaignName, "N", dWeight,
					dHeight);

			CharacterTransitionDetailsService characterTransitionDetailsService = new CharacterTransitionDetailsService();
			characterTransitionDetailsService.setEm(em);

			CharacterTransitionDetail characterTransitionDetail = new CharacterTransitionDetail();
			characterTransitionDetail.setCharacter(newCharacter);
			characterTransitionDetail.setUser(
					userService.findOne(Integer.parseInt(request.getSession().getAttribute("userId").toString())));
			characterTransitionDetailsService.create(characterTransitionDetail);

			// Apply Race to Character
			characterMaintanance.applyRace(characterTransitionDetail);

			request.getSession().setAttribute("characterId", newCharacter.getId());

		} catch (CharacterInfoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		addUserCampaignsToModel(model, request);
		return "redirect:/creation/attributes";
	}

	private void addUserCampaignsToModel(Model model, HttpServletRequest request) {

		List<UserCampaign> userCampaigns = getUserFromSession(request).getUserCampaigns();

		boolean noUserCampaign;

		if (userCampaigns.size() == 0) {
			noUserCampaign = true;
		} else {
			noUserCampaign = false;
			model.addAttribute("userCampaigns", userCampaigns);
		}

		model.addAttribute("noUserCampaign", noUserCampaign);
	}

	private boolean userCampaignDoesExist(HttpServletRequest request) {

		UserCampaignService userCampaignService = new UserCampaignService();
		userCampaignService.setEm(em);

		if (userCampaignService.findOne(Integer.parseInt(request.getParameter("userCampaignId").toString())) == null) {
			return true;
		} else {
			return false;
		}
	}

	private boolean userCampaignBelongsToUser(HttpServletRequest request) {

		UserCampaignService userCampaignService = new UserCampaignService();
		userCampaignService.setEm(em);

		if (userCampaignService.findOne(Integer.parseInt(request.getParameter("userCampaignId").toString())).getUser()
				.getId() != Integer.parseInt(request.getSession().getAttribute("userId").toString())) {
			return false;
		} else {
			return true;
		}
	}
}
