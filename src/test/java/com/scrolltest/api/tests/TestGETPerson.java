package com.scrolltest.api.tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.scrolltest.api.helpers.Personservicehelpers;
import com.scrolltest.api.models.User;

public class TestGETPerson {

	private Personservicehelpers personservicehelpers;

	@BeforeClass
	public void init() {
		personservicehelpers = new Personservicehelpers();
	}

	@Test
	public void testgetAllperson() {
		List<User> userlist = personservicehelpers.getalluser();
		assertNotNull(userlist, "user list is not empty");
		assertFalse(userlist.isEmpty(), "user list is not true");
	}
}
