package com.inar.usermanagement.stepdefinition;

import com.inar.reqres.user.management.utils.ConfigManager;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.baseURI;

public abstract class BaseSteps {

	static protected Response response;
	static protected RequestSpecification request;

	protected String registerUserEndpoint;

	protected String loginEndpoint;

	protected String deleteUserEndpoint;

	protected String listUsersEndpoint;

	protected String updateUsersEndpoint;

	public BaseSteps() {
		baseURI = ConfigManager.getProperty("base.uri");
		loginEndpoint = ConfigManager.getProperty("api.login.endpoint");
		registerUserEndpoint = ConfigManager.getProperty("api.register.endpoint");
		deleteUserEndpoint = ConfigManager.getProperty("api.delete.endpoint");
		updateUsersEndpoint = ConfigManager.getProperty("api.update.endpoint");
		listUsersEndpoint = ConfigManager.getProperty("api.users.endpoint");

	}

}
