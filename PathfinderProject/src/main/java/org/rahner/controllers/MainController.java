package org.rahner.controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.rahner.model.UnitConverter;
import org.rahner.msgHandling.ErrorMsg;
import org.rahner.msgHandling.InfoMsg;
import org.rahner.msgHandling.MessageHandlingSystem;
import org.rahner.msgHandling.WarningMsg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import entities.Character;
import entities.User;
import entities.UserCampaign;
import services.CharacterService;
import services.UserCampaignService;
import services.UserService;

@Controller
public class MainController {

	private MessageHandlingSystem mhs;

	protected EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("PathfinderProject");

	protected EntityManager em = emf.createEntityManager();

	protected UserService userService = new UserService(em);

	protected CharacterService characterService = new CharacterService(em);

	protected UserCampaignService userCampaignService = new UserCampaignService(em);

	protected boolean sessionIsValid(HttpSession session, Model model) {

		if (session.getAttribute("userId") == null) {
			model.addAttribute("sessionStarted", false);
			return false;
		} else {
			model.addAttribute("sessionStarted", true);
			model.addAttribute("userId", (session.getAttribute("userId")));
			return true;
		}

	}

	protected void setUserCampaignIdtoModelAndSession(Model model, HttpServletRequest request) {

		request.getSession().setAttribute("userCampaignId", request.getParameter("userCampaignId"));
		model.addAttribute("userCampaignId", request.getParameter("userCampaignId"));
	}

	protected User getUserFromSession(HttpServletRequest request) {

		return userService.findOne(Integer.parseInt(request.getSession().getAttribute("userId").toString()));
	}

	protected Character getCharacterFromSession(HttpServletRequest request) {

		CharacterService characterService = new CharacterService(em);

		return characterService.findOne(Integer.parseInt(request.getSession().getAttribute("characterId").toString()));
	}

	protected UserCampaign getUserCampaignFromSession(HttpServletRequest request) {

		UserCampaignService userCampaignService = new UserCampaignService(em);

		return userCampaignService
				.findOne(Integer.parseInt(request.getSession().getAttribute("userCampaignId").toString()));
	}

	protected void addMsgToModel(String msg, String severity, Model model, boolean isActive) {

		if (severity.equals("info")) {
			mhs = new InfoMsg();
			mhs.createMsg(msg, model, isActive);
		} else if (severity.equals("warning")) {
			mhs = new WarningMsg();
			mhs.createMsg(msg, model, isActive);
		} else if (severity.equals("error")) {
			mhs = new ErrorMsg();
			mhs.createMsg(msg, model, isActive);
		} else {
			try {
				// Will never happen :)
				throw new Exception("Severe programming error");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected void addMoneyToModel(Model model, int copperMoney) {

		int[] money = UnitConverter.convertMoneyFromCopper(copperMoney);
		model.addAttribute("copper", money[3]);
		model.addAttribute("silver", money[2]);
		model.addAttribute("gold", money[1]);
		model.addAttribute("platin", money[0]);
	}
}
