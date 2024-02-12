package com.inar.usermanagement.stepdefinition;

import com.inar.reqres.user.management.pojo.UserUpdate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inar.usermanagement.context.TestContext;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserUpdateSteps extends BaseSteps {

	private static final Logger logger = LogManager.getLogger(UserUpdateSteps.class);

	private final TestContext testContext;

	private RequestSpecification request;

	private Response response;

	private ObjectMapper objectMapper = new ObjectMapper();

	public UserUpdateSteps(TestContext context) {
		this.testContext = context;
	}

	@Given("I have the user update details for user with id {string}")
	public void iHaveTheUserUpdateDetailsForUserWithId(String userId) {
		logger.info("Setting up update details for user with ID: {}", userId);
	}

	@When("I update user with id {int} with name {string} and job {string}")
	public void iUpdateUserWithIdWithNameAndJob(int userId, String name, String job) {
		request = given().contentType("application/json");
		UserUpdate userUpdate = new UserUpdate(name, job);
		response = request.body(userUpdate).patch(updateUsersEndpoint + "/" + userId);
		testContext.setResponse(response);
	}

	@And("the response should contain the user details: name {string} and job {string}")
	public void theResponseShouldContainTheUserDetailsNameAndJob(String expectedName, String expectedJob) {

		UserUpdate actualDetails = response.jsonPath().getObject("", UserUpdate.class);

		SoftAssertions softAssertions = new SoftAssertions();

		softAssertions.assertThat(actualDetails.getName()).as("Check name").isEqualTo(expectedName);

		softAssertions.assertThat(actualDetails.getJob()).as("Check job").isEqualTo(expectedJob);

		ZonedDateTime expectedUpdatedAt = ZonedDateTime.now(ZoneOffset.UTC);

		long minutesDifference = ChronoUnit.MINUTES.between(actualDetails.getUpdatedAt(), expectedUpdatedAt);

		softAssertions.assertThat(minutesDifference)
			.as("Check updatedAt is within acceptable range of current UTC time")
			.isBetween(-5L, 5L);

		softAssertions.assertAll();
	}

}
