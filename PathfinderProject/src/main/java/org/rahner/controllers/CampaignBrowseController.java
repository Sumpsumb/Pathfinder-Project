package org.rahner.controllers;

import javax.servlet.http.HttpServletRequest;

import org.rahner.validation.Validation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entities.User;
import entities.UserCampaign;
import services.CampaignService;
import services.UserCampaignService;

@Controller
public class CampaignBrowseController extends MainController {

	@RequestMapping(value = "/browseCampaigns", method = RequestMethod.GET)
	public String showCampaigns(HttpServletRequest request, Model model) {

		CampaignService campaignService = new CampaignService();
		campaignService.setEm(em);

		model.addAttribute("campaigns", campaignService.findAllPublishedCampaigns());

		return "campaignBrowser";
	}

	@RequestMapping(value = "/createUserCampaign", method = RequestMethod.POST)
	public String sendCampaignRequest(HttpServletRequest request, Model model,
			@RequestParam("campaignId") String campaignId) {

		User user = getUserFromSession(request);

		CampaignService campaignService = new CampaignService();
		campaignService.setEm(em);

		UserCampaignService userCampaignService = new UserCampaignService();
		userCampaignService.setEm(em);

		if (Validation.userHasAlreadyThatUserCampaign(user, campaignService.findOne(Integer.parseInt(campaignId)))) {

			// TODO:Msg Handling
		} else {

			UserCampaign userCampaign = new UserCampaign();
			userCampaign.setCampaign(campaignService.findOne(Integer.parseInt(campaignId)));
			userCampaign.setRole("G");
			userCampaign.setUser(user);
			userCampaignService.create(userCampaign);
		}

		model.addAttribute("campaigns", campaignService.findAllPublishedCampaigns());

		return "campaignBrowser";
	}
}
