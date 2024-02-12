package com.inar.usermanagement.stepdefinition;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inar.reqres.user.management.pojo.LoginCredentials;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inar.usermanagement.context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;

import static io.restassured.RestAssured.given;

public class UserLoginSteps extends BaseSteps {

	private static final Logger logger = LogManager.getLogger(UserLoginSteps.class);

	private ObjectMapper objectMapper = new ObjectMapper();

	private Response response;

	private RequestSpecification request;

	private final TestContext testContext;

	public UserLoginSteps(TestContext context) {
		this.testContext = context;
	}

	@Given("I have login credentials {string} and {string}")
	public void iHaveLoginCredentialsAnd(String email, String password) {
		try {
			LoginCredentials credentials = new LoginCredentials(email, password);
			String jsonCredentials = objectMapper.writeValueAsString(credentials);
			request = given().contentType("application/json").body(jsonCredentials);
			logger.info("Login credentials set for user: {}", email);
		}
		catch (JsonProcessingException e) {
			logger.error("Error serializing login credentials", e);
			throw new RuntimeException(e);
		}
	}

	@When("I send a POST request to the login endpoint")
	public void iSendAPOSTRequestToTheLoginEndpoint() {
		response = request.when().post(loginEndpoint);
		testContext.setResponse(response);
	}

	@Then("I receive a token in the response")
	public void iReceiveATokenInTheResponse() {
		Response response = testContext.getResponse();
		String token = response.jsonPath().getString("token");
		Assertions.assertThat(token).isNotNull();
		Assertions.assertThat(token).isNotEmpty();
	}

}
