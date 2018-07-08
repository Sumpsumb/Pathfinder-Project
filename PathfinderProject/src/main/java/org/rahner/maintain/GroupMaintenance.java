package org.rahner.maintain;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entities.Character;
import entities.Group;
import services.CharacterService;
import services.GroupService;

public class GroupMaintenance {

	private EntityManagerFactory entityManagerFactory = javax.persistence.Persistence
			.createEntityManagerFactory("PathfinderProject");

	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	private GroupService groupService = new GroupService(entityManager);

	private CharacterService characterService = new CharacterService(entityManager);

	private Group group;

	public GroupMaintenance() {

	}

	public GroupMaintenance(Group group) {

		this.group = groupService.findOne(group.getId());
	}

	public GroupMaintenance(int groupId) {

		this.group = groupService.findOne(groupId);
	}

	public void setGroup(Group group) {
		this.group = groupService.findOne(group.getId());
	}

	public void addCharacterToGroup(Character character) {

		group.addCharacter(character);
		determineAndSetAGL(group);
	}

	/**
	 * Removes this character from Group.
	 * <p>
	 * There is no validation, that the Character is in group before.
	 * 
	 * @param character
	 */

	public void removeCharacterFromGroup(Character character) {

		group.removeCharacter(character);
		determineAndSetAGL(group);
	}

	public void addCharactersToGroup(ArrayList<Character> characters) {

		for (Character character : characters) {

			group.addCharacter(character);
		}
		determineAndSetAGL(group);
	}

	public Group addCharactersToGroup(ArrayList<Character> characters, Group group) {

		Group dbGroup = groupService.findOne(group.getId());

		for (Character character : characters) {

			dbGroup.addCharacter(character);
		}
		determineAndSetAGL(dbGroup);
		return dbGroup;
	}

	/**
	 * Removes this character from Group.
	 * <p>
	 * There is no validation, that these Characters are in group before.
	 * 
	 * @param character
	 */

	public void removeCharactersFromGroup(ArrayList<Character> characters) {

		for (Character character : characters) {

			group.removeCharacter(character);
		}
		determineAndSetAGL(group);
	}

	public Group removeCharactersFromGroup(ArrayList<Character> characters, Group group) {

		Group dbGroup = groupService.findOne(group.getId());

		for (Character character : characters) {

			dbGroup.removeCharacter(character);
		}
		determineAndSetAGL(dbGroup);
		return dbGroup;
	}

	/**
	 * This method will assign this Character to another group. There is no
	 * validation that this Character is member of formerGroup.
	 * 
	 * @param character
	 * @param formerGroup
	 * @param newGroup
	 */

	public void changeGroup(Character character, Group formerGroup, Group newGroup) {

		formerGroup.removeCharacter(character);
		newGroup.addCharacter(character);
		determineAndSetAGL(formerGroup);
		determineAndSetAGL(newGroup);
	}

	/**
	 * This method splits a Group in two new Groups. The Characters are distributed
	 * accordingly
	 * 
	 * @param charactersToRemove
	 *            <Strong>Characters which will left the Group</Strong>
	 */

	public Group[] splitGroup(int groupIdForSplit, String newGroupName, ArrayList<Character> charactersToRemove) {

		Group groupForSplit = groupService.findOne(groupIdForSplit);

		Group newGroup = new Group();

		newGroup.setCampaign(groupForSplit.getCampaign());
		newGroup.setDate(groupForSplit.getDate());
		newGroup.setTime(groupForSplit.getTime());
		newGroup.setName(newGroupName);

		if (groupForSplit.getQuests().size() != 0) {
			newGroup.setQuests(groupForSplit.getQuests());
		}

		groupService.create(newGroup);

		ArrayList<Integer> characterIdList = new ArrayList<Integer>();

		for (Character character : charactersToRemove) {

			characterIdList.add(character.getId());
		}

		int groupSize = characterIdList.size();
		CharacterService characterService = new CharacterService(entityManager);

		for (int i = 0; i < groupSize; i++) {

			changeGroup(characterService.findOne(characterIdList.get(i)), groupForSplit, newGroup);
		}

		groupService.update(groupForSplit);

		Group[] resultingGroups = new Group[2];
		resultingGroups[0] = groupForSplit;
		resultingGroups[1] = newGroup;

		System.out.println("Old Group: " + resultingGroups[0].getCharacters().size());
		System.out.println("New Group: " + resultingGroups[1].getCharacters().size());

		return resultingGroups;
	}

	/**
	 * Merges two Groups together. If groupToDelete is empty null will be returned.
	 * 
	 * @param takeTimeFrom
	 *            has to permitted values 'A' and 'B' refers to Group A and B.
	 *            Default is A.
	 * @return
	 */

	public Group mergeGroups(Group groupToExtend, Group groupToDelete, String takeTimeFrom) {

		Group groupA = groupService.findOne(groupToExtend.getId());
		Group groupB = groupService.findOne(groupToDelete.getId());

		System.out.println("AGL of GROUP A" + groupA.getAgl());
		System.out.println("AGL of GROUP B" + groupB.getAgl());

		if (takeTimeFrom.equals("B")) {

			groupA.setDate(groupB.getDate());
		}

		ArrayList<Integer> characterIds = new ArrayList<Integer>();

		for (Character character : groupB.getCharacters()) {

			characterIds.add(character.getId());
		}

		if (characterIds.size() != 0) {

			for (Integer integer : characterIds) {

				changeGroup(characterService.findOne(integer), groupB, groupA);
			}

			groupService.deleteById(groupB.getId());
			return groupA;

		} else {
			return null;
		}
	}

	public int determineAndSetAGL(Group group) {

		int lvlSum = 0;

		for (Character groupCharacter : group.getCharacters()) {

			lvlSum = groupCharacter.getTotLevel() + lvlSum;
		}
		if (group.getCharacters().size() != 0) {
			group.setAgl(lvlSum / group.getCharacters().size());
			return lvlSum / group.getCharacters().size();
		} else {
			return 0;
		}
	}
}
