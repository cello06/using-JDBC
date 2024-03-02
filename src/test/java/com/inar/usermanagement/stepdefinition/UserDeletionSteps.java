package com.inar.usermanagement.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDeletionSteps extends BaseSteps {

	private static final Logger logger = LogManager.getLogger(UserLoginSteps.class);

	@Given("A user with ID {string} exists")
	public void aUserWithIDExists(String userId) {
		deleteUserEndpoint = deleteUserEndpoint + "/" + userId;
	}

	@When("I send a DELETE request to the delete endpoint")
	public void iSendADELETERequestToTheDeleteEndpoint() {
		response = RestAssured.delete(deleteUserEndpoint);
	}

}
