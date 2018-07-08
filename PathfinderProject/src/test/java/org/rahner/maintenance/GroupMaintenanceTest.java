package org.rahner.maintenance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.rahner.maintain.GroupMaintenance;

import entities.Character;
import entities.Group;
import services.CharacterService;
import services.GroupService;

public class GroupMaintenanceTest {

	private EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("PathfinderProject");

	private EntityManager em = emf.createEntityManager();

	private GroupService groupService = new GroupService(em);

	private GroupMaintenance groupMaintenance = new GroupMaintenance();

	private CharacterService characterService = new CharacterService(em);

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Group testGroup1;
	private Group testGroup2;

	private Character character1;
	private Character character2;
	private Character character3;

	@Before
	public void init() throws ParseException {

		String s = "05:30:00";
		SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");
		long ms = sdf2.parse(s).getTime();
		Time time = new Time(ms);

		this.testGroup1 = new Group();
		testGroup1.setDate(sdf.parse("01/01/1000"));
		testGroup1.setTime(time);
		groupService.create(testGroup1);

		character1 = new Character();
		character2 = new Character();
		character3 = new Character();
		character1.setName("testName1");
		character2.setName("testName2");
		character3.setName("testName3");
		characterService.create(character1);
		characterService.create(character2);
		characterService.create(character3);

		testGroup1.addCharacter(character1);
		testGroup1.addCharacter(character2);
		testGroup1.addCharacter(character3);
		groupService.update(testGroup1);
	}

	@Test
	public void test_getAGLforSimpleGroup1() {

		character1.setTotLevel(1);
		character2.setTotLevel(1);
		character3.setTotLevel(1);

		assertEquals(1, groupMaintenance.determineAndSetAGL(testGroup1));
	}

	@Test
	public void test_getAGLforSimpleGroup2() {

		character1.setTotLevel(1);
		character2.setTotLevel(2);
		character3.setTotLevel(3);

		assertEquals(2, groupMaintenance.determineAndSetAGL(testGroup1));
	}

	@Test
	public void test_getAGLforSimpleGroup3() {

		character1.setTotLevel(2);
		character2.setTotLevel(2);
		character3.setTotLevel(3);

		assertEquals(2, groupMaintenance.determineAndSetAGL(testGroup1));
	}

	@Test
	public void test_getAGLforSimpleGroup4() {

		character1.setTotLevel(5);
		character2.setTotLevel(7);
		character3.setTotLevel(8);

		assertEquals(6, groupMaintenance.determineAndSetAGL(testGroup1));
	}

	@Test
	public void test_getAGLforSimpleGroup5() {

		character1.setTotLevel(5);
		character2.setTotLevel(7);
		character3.setTotLevel(8);

		groupMaintenance.determineAndSetAGL(testGroup1);

		assertEquals(6, testGroup1.getAgl());
	}

	@Test
	public void test_newAGLCausedByGroupChange1() {

		this.testGroup2 = new Group();
		groupService.create(testGroup2);
		groupMaintenance.changeGroup(character1, testGroup1, testGroup2);

		assertTrue(testGroup2.getCharacters().contains(character1));
	}

	@Test
	public void test_newAGLCausedByGroupChange2() {

		this.testGroup2 = new Group();
		groupService.create(testGroup2);
		groupMaintenance.changeGroup(character1, testGroup1, testGroup2);

		assertFalse(testGroup1.getCharacters().contains(character1));
	}

	@Test
	public void test_newAGLCausedByGroupChange3() {

		this.testGroup2 = new Group();
		groupService.create(testGroup2);

		character1.setTotLevel(4);
		character2.setTotLevel(1);
		character3.setTotLevel(1);

		groupMaintenance.changeGroup(character1, testGroup1, testGroup2);

		assertEquals(4, testGroup2.getAgl());
	}

	@Test
	public void test_newAGLCausedByGroupChange4() {

		this.testGroup2 = new Group();
		groupService.create(testGroup2);

		character1.setTotLevel(4);
		character2.setTotLevel(1);
		character3.setTotLevel(1);

		groupMaintenance.changeGroup(character1, testGroup1, testGroup2);

		assertEquals(1, testGroup1.getAgl());
	}

	@Test
	public void test_splitGroup1() {

		character1.setTotLevel(4);
		character2.setTotLevel(1);
		character3.setTotLevel(1);

		ArrayList<Character> charactersToRemove = new ArrayList<Character>();
		charactersToRemove.add(character1);
		charactersToRemove.add(character2);

		Group[] splitGroups = groupMaintenance.splitGroup(testGroup1.getId(), "Die Test Gruppe££££££££££££",
				charactersToRemove);
		assertEquals(1, splitGroups[0].getCharacters().size());
	}

	@Test
	public void test_mergeGroup1() {

		character1.setTotLevel(4);
		character2.setTotLevel(1);
		character3.setTotLevel(1);

		ArrayList<Character> charactersToRemove = new ArrayList<Character>();
		charactersToRemove.add(character1);
		charactersToRemove.add(character2);

		Group[] splitGroups = groupMaintenance.splitGroup(testGroup1.getId(), "Die Test Gruppe££££££££££££",
				charactersToRemove);

		System.out.println("Size of splitGroup0 = " + splitGroups[0].getCharacters().size());
		Group mergedGroup = groupMaintenance.mergeGroups(splitGroups[0], splitGroups[1], "A");
		assertEquals(3, mergedGroup.getCharacters().size());
	}

	@Test
	public void test_mergeGroup2() {

		character1.setTotLevel(4);
		character2.setTotLevel(1);
		character3.setTotLevel(1);

		ArrayList<Character> charactersToRemove = new ArrayList<Character>();
		charactersToRemove.add(character1);
		charactersToRemove.add(character2);

		Group[] splitGroups = groupMaintenance.splitGroup(testGroup1.getId(), "Die Test Gruppe£", charactersToRemove);

		Group mergedGroup = groupMaintenance.mergeGroups(splitGroups[0], splitGroups[1], "A");
		assertEquals(testGroup1.getId(), mergedGroup.getId());
	}

	@Test
	public void test_mergeGroup3() {

		character1.setTotLevel(4);
		character2.setTotLevel(1);
		character3.setTotLevel(1);

		ArrayList<Character> charactersToRemove = new ArrayList<Character>();
		charactersToRemove.add(character1);
		charactersToRemove.add(character2);

		Group[] splitGroups = groupMaintenance.splitGroup(testGroup1.getId(), "Die Test Gruppe£", charactersToRemove);

		Group mergedGroup = groupMaintenance.mergeGroups(splitGroups[0], splitGroups[1], "A");
		assertEquals(2, mergedGroup.getAgl());
	}

	@Test
	public void test_splitGroup2() {

		character1.setTotLevel(4);
		character2.setTotLevel(1);
		character3.setTotLevel(1);

		ArrayList<Character> charactersToRemove = new ArrayList<Character>();
		charactersToRemove.add(character1);
		charactersToRemove.add(character2);
		Group[] splitGroups = groupMaintenance.splitGroup(testGroup1.getId(), "Die Test Gruppe££££££££££££",
				charactersToRemove);
		System.out.println(splitGroups[0].getCharacters().size());
		System.out.println(splitGroups[1].getCharacters().size());
		assertEquals(2, splitGroups[1].getCharacters().size());
	}

	@After
	public void cleanUp() {

		Group splitGroup = groupService.findOneByName("Die Test Gruppe££££££££££££");

		if (splitGroup != null) {
			groupService.deleteById(splitGroup.getId());
		}

		if (testGroup1 != null) {
			groupService.deleteById(testGroup1.getId());
		}

		if (testGroup2 != null) {
			groupService.deleteById(testGroup2.getId());
		}

		if (character1 != null) {
			characterService.deleteById(character1.getId());
		}

		if (character2 != null) {
			characterService.deleteById(character2.getId());
		}

		if (character3 != null) {
			characterService.deleteById(character3.getId());
		}
	}
}
