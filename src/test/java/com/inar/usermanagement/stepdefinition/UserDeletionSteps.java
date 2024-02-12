package com.inar.usermanagement.stepdefinition;

import com.inar.usermanagement.context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.delete;

public class UserDeletionSteps extends BaseSteps {

	private static final Logger logger = LogManager.getLogger(UserLoginSteps.class);

	private Response response;

	private final TestContext testContext;

	public UserDeletionSteps(TestContext context) {
		this.testContext = context;

	}

	@Given("A user with ID {string} exists")
	public void aUserWithIDExists(String userId) {
		deleteUserEndpoint = deleteUserEndpoint + "/" + userId;

	}

	@When("I send a DELETE request to the delete endpoint")
	public void iSendADELETERequestToTheDeleteEndpoint() {
		response = RestAssured.delete(deleteUserEndpoint);
		testContext.setResponse(response);
	}

}
