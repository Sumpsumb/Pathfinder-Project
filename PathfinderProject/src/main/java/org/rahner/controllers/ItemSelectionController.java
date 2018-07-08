package org.rahner.controllers;

import javax.servlet.http.HttpServletRequest;

import org.rahner.exceptions.CharacterMaintainanceException;
import org.rahner.exceptions.CharacterNotInDbException;
import org.rahner.exceptions.ItemNotInDatabaseException;
import org.rahner.maintain.CharacterMaintanance;
import org.rahner.msgHandling.MsgType;
import org.rahner.validation.Validation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entities.Character;
import services.ItemService;

@Controller
public class ItemSelectionController extends MainController {

	@RequestMapping(value = "/creation/itemSelection", method = RequestMethod.GET)
	public String showItemSelection(HttpServletRequest request, Model model) {

		Character character = getCharacterFromSession(request);

		ItemService itemService = new ItemService();
		itemService.setEm(em);

		model.addAttribute("categories", itemService.findAllCategories());

		addMoneyToModel(model, character.getMoney());

		return "itemSelection";
	}

	@RequestMapping(value = "/creation/showItemsForCategory", method = RequestMethod.POST)
	public String showItems(HttpServletRequest request, Model model, @RequestParam("category") String category) {

		Character character = getCharacterFromSession(request);

		ItemService itemService = new ItemService();
		itemService.setEm(em);

		model.addAttribute("categories", itemService.findAllCategories());

		addMoneyToModel(model, character.getMoney());

		model.addAttribute("items", itemService.findItemsForCategory(category));
		model.addAttribute("selectedCategory", category);
		request.getSession().setAttribute("category", category);

		return "itemSelection";
	}

	@RequestMapping(value = "/creation/buyItems", method = RequestMethod.POST)
	public String buyItems(HttpServletRequest request, Model model, @RequestParam("itemId") int itemId,
			@RequestParam("amountToBuy") int amount) {

		Character character = getCharacterFromSession(request);

		ItemService itemService = new ItemService();
		itemService.setEm(em);

		try {
			CharacterMaintanance characterMaintanance = new CharacterMaintanance(character);

			if (Validation.characterHasEnoughMoneyToBuy(itemId, character, amount)) {

				characterMaintanance.buyItem(itemId, amount);
				em.refresh(character);

			} else {
				addMsgToModel("Not enough money!", MsgType.warning.toString(), model, true);
			}

		} catch (CharacterNotInDbException e) {
			addMsgToModel(e.getMessage(), MsgType.error.toString(), model, true);
		} catch (ItemNotInDatabaseException e) {
			addMsgToModel(e.getMessage(), MsgType.error.toString(), model, true);
		} catch (CharacterMaintainanceException e) {
			addMsgToModel(e.getMessage(), MsgType.error.toString(), model, true);
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		String category = request.getSession().getAttribute("category").toString();

		model.addAttribute("categories", itemService.findAllCategories());

		model.addAttribute("items",
				itemService.findItemsForCategory(request.getSession().getAttribute("category").toString()));

		model.addAttribute("selectedCategory", category);
		addMoneyToModel(model, character.getMoney());

		return "itemSelection";
	}
}
