package com.scrolltest.api.tests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.scrolltest.api.helpers.Personservicehelpers;

public class TestDELETPerson {
	private Personservicehelpers personservicehelpers;

	@BeforeClass
	public void init() {
		personservicehelpers = new Personservicehelpers();
	}

	@Test
	public void testpostcreateperson() {
		personservicehelpers.DeleteUser(6);
	}
}
