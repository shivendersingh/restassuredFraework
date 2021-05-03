package com.scrolltest.api.tests;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.scrolltest.api.helpers.Personservicehelpers;

public class TestPATCHPerson {
	private Personservicehelpers personservicehelpers;

	@BeforeClass
	public void init() {
		personservicehelpers = new Personservicehelpers();
	}

	@Test
	public void testpostcreateperson() {
		String id = personservicehelpers.updateUser(3).jsonPath().getString("id");
		System.err.println(id);
		assertNotNull(id, "updated");
	}
}
