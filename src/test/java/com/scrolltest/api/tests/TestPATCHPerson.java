package com.scrolltest.api.tests;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.scrolltest.api.helpers.Personservicehelpers;
import com.scrolltest.api.rEPORT.ExtentReport;

public class TestPATCHPerson extends ExtentReport {
	private Personservicehelpers personservicehelpers;
	@BeforeClass
	public void init() {
		personservicehelpers = new Personservicehelpers();
	}

	@Test
	public void testpostcreateperson() {
		test = extent.createTest("PATCH Testcase");
		String id = personservicehelpers.updateUser(3).jsonPath().getString("id");
		System.err.println(id);
		assertNotNull(id, "updated");
	}
}
