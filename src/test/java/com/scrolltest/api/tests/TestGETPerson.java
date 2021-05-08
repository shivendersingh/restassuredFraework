package com.scrolltest.api.tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.scrolltest.api.helpers.Personservicehelpers;
import com.scrolltest.api.models.User;
import com.scrolltest.api.rEPORT.ExtentReport;

public class TestGETPerson extends ExtentReport {

	private Personservicehelpers personservicehelpers;
	ExtentReports report;
	@BeforeClass
	public void init() {
		personservicehelpers = new Personservicehelpers();
	}

	@Test
	public void testgetAllperson() {
		test = extent.createTest("GET Testcase");
		List<User> userlist = personservicehelpers.getalluser();
		assertNotNull(userlist, "user list is not empty");
		assertFalse(userlist.isEmpty(), "user list is not true");
	}
}
