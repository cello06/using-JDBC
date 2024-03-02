package com.inar.usermanagement.stepdefinition;

import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;

public class CommonSteps extends BaseSteps {

	@Then("the response status code should be {int}")
	public void theResponseStatusCodeShouldBe(int httpStatusCode) {
		Assertions.assertThat(response.getStatusCode()).isEqualTo(httpStatusCode);
	}

}
