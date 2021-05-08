package com.scrolltest.api.tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.scrolltest.api.helpers.Personservicehelpers;
import com.scrolltest.api.rEPORT.ExtentReport;

public class TestPOSTPerson  extends ExtentReport{

	//init -Personservicehelpers
	
	private Personservicehelpers personservicehelpers;

	@BeforeClass
	public void init() {
		personservicehelpers = new Personservicehelpers();
	}
	@Test
	public void testpostcreateperson() {
		test = extent.createTest("Post Testcase");
		String id = personservicehelpers.createPerson().jsonPath().getString("id");
	System.err.println(id);
	assertNotNull(id, "id is not null");

	}
}
