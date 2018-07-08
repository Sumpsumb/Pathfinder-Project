package main;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.rahner.exceptions.CharacterNotInDbException;
import org.rahner.maintain.GroupMaintenance;

import services.CampaignService;
import services.CharacterService;
import services.ItemService;
import services.UserService;

public class Main {

	public static void main(String[] args) throws CharacterNotInDbException {

		EntityManagerFactory entityManagerFactory = javax.persistence.Persistence
				.createEntityManagerFactory("PathfinderProject");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		CharacterService characterService = new CharacterService();
		characterService.setEm(entityManager);

		ItemService itemService = new ItemService();
		itemService.setEm(entityManager);

		UserService userService = new UserService();
		userService.setEm(entityManager);

		CampaignService campaignService = new CampaignService();
		campaignService.setEm(entityManager);

		GroupMaintenance groupMaintenance = new GroupMaintenance();
		ArrayList<entities.Character> charactersToRemove = new ArrayList<entities.Character>();
		charactersToRemove.add(characterService.findOne(1));
		groupMaintenance.splitGroup(characterService.findOne(1).getGroup().getId(), "Die Fanzy Gruppe",
				charactersToRemove);
	}
}
