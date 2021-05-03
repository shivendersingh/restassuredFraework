package com.scrolltest.api.helpers;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.apache.http.HttpStatus;

import com.scrolltest.api.constaints.Endpoints;
import com.scrolltest.api.models.User;
import com.scrolltest.api.utils.ConfigManager;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Personservicehelpers {

	// we need to read the config variables
	// REst assured about the URL, Port
	// Make a GET request on the URL and Send the data to TestGETperson

	private static final String BASE_URL = ConfigManager.getinstance().getString("baseUrl");
	private static final String PORT = ConfigManager.getinstance().getString("port");

	public Personservicehelpers() {
		RestAssured.baseURI = BASE_URL;
		RestAssured.port = Integer.parseInt(PORT);
		RestAssured.useRelaxedHTTPSValidation();
	}

	public List<User> getalluser() {

		Response response = RestAssured.given().log().all().contentType(ContentType.JSON).get(Endpoints.GET_ALL_USER)
				.andReturn();

		java.lang.reflect.Type type = new com.fasterxml.jackson.core.type.TypeReference<List<User>>() {
		}.getType();

	//	assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "ok");
		List<User> userlist = response.as(type);
		return userlist;
	}

	public Response createPerson() {
		User user = new User();
		user.setId("6");
		user.setFirstname("Arpit");
		user.setLastName("chauhan");
		user.setAge(46);
		user.setEmail("asdasd@gmail.com");

		// Need to make a POST call
		Response response = RestAssured.given().contentType(ContentType.JSON).when().body(user)
				.post(Endpoints.Create_USER).andReturn();
	//	assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED, "created");

		return response;

	}
//For update the user with it's ID
	public Response updateUser(Integer id) {
		User user = new User();
		user.setFirstname("Rohan");
		user.setLastName("Patil");
		user.setAge(47);
		user.setEmail("rohan.patil@cybage.com");
		Response response = RestAssured.given().contentType(ContentType.JSON).pathParam("id", id).when().body(user)
				.patch(Endpoints.Update_USER).andReturn();
//		assertTrue(response.getStatusCode() == HttpStatus.SC_OK);
		return response;
	}
	
//delete a user with it's id	
	public void DeleteUser(Integer id) {
		User user = new User();
		Response response = RestAssured.given().contentType(ContentType.JSON).pathParam("id", id).when().body(user)
				.delete(Endpoints.GET_single_USER).andReturn();
	//	assertTrue(response.getStatusCode() == HttpStatus.SC_OK);
	}
}