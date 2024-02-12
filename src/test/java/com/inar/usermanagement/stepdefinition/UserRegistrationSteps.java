package com.inar.usermanagement.stepdefinition;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inar.reqres.user.management.pojo.RegistrationCredentials;
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

public class UserRegistrationSteps extends BaseSteps {

	private static final Logger logger = LogManager.getLogger(UserLoginSteps.class);

	private ObjectMapper objectMapper = new ObjectMapper();

	private Response response;

	private RequestSpecification request;

	private final TestContext testContext;

	public UserRegistrationSteps(TestContext context) {
		this.testContext = context;
	}

	@Given("I have registration credentials {string} and {string}")
	public void iHaveRegistrationCredentialsAnd(String email, String password) {
		try {
			RegistrationCredentials credentials = new RegistrationCredentials(email, password);
			String jsonCredentials = objectMapper.writeValueAsString(credentials);
			request = given().contentType("application/json").body(jsonCredentials);
			logger.info("Registration credentials set for user: {}", email);
		}
		catch (JsonProcessingException e) {
			logger.error("Error serializing registration credentials", e);
			throw new RuntimeException(e);
		}
	}

	@When("I send a POST request to the registration endpoint")
	public void iSendAPOSTRequestToTheRegistrationEndpoint() {
		response = request.when().post(registerUserEndpoint);
		testContext.setResponse(response);
	}

	@Then("I receive a user id and a token in the response")
	public void iReceiveAUserIdAndATokenInTheResponse() {
		Response response = testContext.getResponse();
		Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
		int id = response.jsonPath().getInt("id");
		String token = response.jsonPath().getString("token");
		Assertions.assertThat(id).isNotZero();
		Assertions.assertThat(token).isNotEmpty();
	}

	@Then("the response should contain an error message {string}")
	public void theResponseShouldContainAnErrorMessage(String errorMessage) {
		Response response = testContext.getResponse();
		String responseError = response.jsonPath().getString("error");
		Assertions.assertThat(responseError).isEqualTo(errorMessage);
	}

}
