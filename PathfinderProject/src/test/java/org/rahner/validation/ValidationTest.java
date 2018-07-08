package org.rahner.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidationTest {

	@Test
	public void testVerifyPassword() {
		String password = "testPassword";
		String passwordVerify = "testPassword";
		assertTrue(Validation.verifyPassword(password, passwordVerify));
	}

	@Test
	public void testVerifyWrongPassword() {
		String password = "testPassword";
		String passwordVerify = "otherPassword";
		assertFalse(Validation.verifyPassword(password, passwordVerify));
	}

	@Test
	public void testVerifyWrongPasswordCaseSensitiv() {
		String password = "testPassword";
		String passwordVerify = "TestPassword";
		assertFalse(Validation.verifyPassword(password, passwordVerify));
	}

	@Test
	public void testIfUsernameIsAlreadyInDb() {

		assertTrue(Validation.usernameInDatabase("Sump"));
	}

	@Test
	public void testIfUnlikeUsernameIsAlreadyInDb() {

		assertFalse(Validation.usernameInDatabase("££££$$$$$%%%%^^^^&&&&&&*****((((*&^%$%^&^%$£$%^&UYGE$%^"));
	}

	@Test
	public void testPasswordMatchingUsername() {

		assertTrue(Validation.passwordMatchingUsernamme("Sump", "blut"));
	}

	@Test
	public void testPasswordMatchingWithUnlikeCouple() {

		assertFalse(Validation.passwordMatchingUsernamme("Sump", "fasdfh87^*£^%$9ufs"));
	}
}
