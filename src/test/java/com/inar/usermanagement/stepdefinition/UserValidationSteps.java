package com.inar.usermanagement.stepdefinition;

import com.inar.reqres.user.management.pojo.User;
import com.inar.usermanagement.context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.assertj.core.api.SoftAssertions;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserValidationSteps extends BaseSteps {

	private final TestContext testContext;

	Response response;

	public UserValidationSteps(TestContext context) {
		this.testContext = context;
	}

	@When("I make a request to list users with page number {int}")
	public void iMakeARequestToWithPageNumber(int pageNumber) {
		response = given().queryParam("page", pageNumber).when().get(listUsersEndpoint);
		testContext.setResponse(response);
	}

	@And("the response should include the following user details:")
	public void theResponseShouldIncludeTheFollowingUserDetails(DataTable dataTable) {
		SoftAssertions softAssertions = new SoftAssertions();

		List<Map<String, String>> expectedUsers = dataTable.asMaps(String.class, String.class);

		for (Map<String, String> expectedUser : expectedUsers) {
			int id = Integer.parseInt(expectedUser.get("id"));

			String expectedEmail = expectedUser.get("email");
			String actualEmail = response.jsonPath().getString("data.find { user -> user.id == " + id + "}.email");
			String expectedFirstName = expectedUser.get("first_name");
			String actualFirstName = response.jsonPath()
				.getString("data.find { user -> user.id == " + id + "}.first_name");
			String expectedLastName = expectedUser.get("last_name");
			String actualLastName = response.jsonPath()
				.getString("data.find { user -> user.id == " + id + "}.last_name");

			softAssertions.assertThat(actualEmail)
				.as("Verify that user api returns correct user email for id : " + id)
				.isEqualTo(expectedEmail);
			softAssertions.assertThat(actualFirstName)
				.as("Verify that user api returns correct user FirstName for id : " + id)
				.isEqualTo(expectedFirstName);
			softAssertions.assertThat(actualLastName)
				.as("Verify that user api returns correct user LastName for id : " + id)
				.isEqualTo(expectedLastName);

		}

		softAssertions.assertAll();
	}

	@And("the response should include the following user details as list:")
	public void theResponseShouldIncludeTheFollowingUserDetailsLsit(List<String> dataTableAsList) {
		SoftAssertions softAssertions = new SoftAssertions();

		for (String testData : dataTableAsList) {
			String[] expectedData = testData.split(",");
			int id = Integer.parseInt(expectedData[0]);
			String expectedEmail = expectedData[1];
			String expectedFirstName = expectedData[2];
			String actualFirstName = response.jsonPath()
				.getString("data.find { user -> user.id == " + id + "}.first_name");
			String expectedLastName = expectedData[3];
			String actualLastName = response.jsonPath()
				.getString("data.find { user -> user.id == " + id + "}.last_name");
			String actualEmail = response.jsonPath().getString("data.find { user -> user.id == " + id + "}.email");

			softAssertions.assertThat(actualEmail)
				.as("Verify that user api returns correct user email for id : " + id)
				.isEqualTo(expectedEmail);
			softAssertions.assertThat(actualFirstName)
				.as("Verify that user api returns correct user FirstName for id : " + id)
				.isEqualTo(expectedFirstName);
			softAssertions.assertThat(actualLastName)
				.as("Verify that user api returns correct user LastName for id : " + id)
				.isEqualTo(expectedLastName);
		}

		softAssertions.assertAll();
	}

	@And("the response should include the following user details as User:")
	public void theResponseShouldIncludeTheFollowingUserDetailsasUser(List<User> expectedUsers) {

		SoftAssertions softAssertions = new SoftAssertions();

		for (User expectedUser : expectedUsers) {
			int id = expectedUser.getId();

			String expectedEmail = expectedUser.getEmail();
			String actualEmail = response.jsonPath().getString("data.find { user -> user.id == " + id + "}.email");
			String expectedFirstName = expectedUser.getFirstName();
			String actualFirstName = response.jsonPath()
				.getString("data.find { user -> user.id == " + id + "}.first_name");
			String expectedLastName = expectedUser.getLastName();
			String actualLastName = response.jsonPath()
				.getString("data.find { user -> user.id == " + id + "}.last_name");

			softAssertions.assertThat(actualEmail)
				.as("Verify that user api returns correct user email for id : " + id)
				.isEqualTo(expectedEmail);
			softAssertions.assertThat(actualFirstName)
				.as("Verify that user api returns correct user FirstName for id : " + id)
				.isEqualTo(expectedFirstName);
			softAssertions.assertThat(actualLastName)
				.as("Verify that user api returns correct user LastName for id : " + id)
				.isEqualTo(expectedLastName);
		}
		softAssertions.assertAll();
	}

	@DataTableType
	public User userEntry(Map<String, String> entry) {
		return new User(Integer.parseInt(entry.get("id")), entry.get("email"), entry.get("firstName"),
				entry.get("lastName"));
	}

}
