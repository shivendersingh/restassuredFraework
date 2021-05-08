package com.scrolltest.api.tests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.scrolltest.api.helpers.Personservicehelpers;
import com.scrolltest.api.rEPORT.ExtentReport;

public class TestDELETPerson extends ExtentReport {
	private Personservicehelpers personservicehelpers;

	@BeforeClass
	public void init() {
		personservicehelpers = new Personservicehelpers();
	
	}

	@Test
	public void testpostcreateperson() {
		test = extent.createTest("Delete Testcase");
		personservicehelpers.DeleteUser(6);
	}
}
