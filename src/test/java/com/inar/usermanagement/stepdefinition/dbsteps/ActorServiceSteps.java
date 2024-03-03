package com.inar.usermanagement.stepdefinition.dbsteps;

import com.inar.reqres.user.management.service.ActorService;
import com.inar.reqres.user.management.model.Actor;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;

public class ActorServiceSteps {

    private ActorService actorService;
    private List<Actor> actors;
    private Actor actor;
    private Map<String, Object> actorDetails;

    @Given("the actor service is up and running")
    public void the_actor_service_is_up_and_running() {
        actorService = new ActorService();
    }

    @When("I request a list of all actors")
    public void i_request_a_list_of_all_actors() {
        actors = actorService.getAllActors();
    }

    @Then("I should receive a list containing all actors in the database")
    public void i_should_receive_a_list_containing_all_actors() {
        assertThat(actors)
                .as("Check if the actor list is not null and not empty")
                .isNotNull()
                .isNotEmpty();
    }

    @When("I request the actor with ID {int}")
    public void i_request_the_actor_with_id(Integer actorId) {
        actor = actorService.getActorById(actorId);
    }
    @Then("I should receive the details of the actor with ID {int}")
    public void i_should_receive_the_details_of_the_actor_with_id(Integer actorId) {
        assertThat(actor)
                .as("Check if the actor is not null and has the correct ID")
                .isNotNull()
                .matches(a -> a.getActorId() == (actorId), "Actor ID should be " + actorId);
    }

    @When("I request the name and last name of the actor with ID {int}")
    public void i_request_the_name_and_last_name_of_the_actor_with_id(Integer actorId) {
        actorDetails = actorService.getActorNameAndLastNameById(actorId);
        assertThat(actorDetails)
                .as("Check if the actor details are not null for actor ID %s", actorId)
                .isNotNull();
    }
    @Then("I should receive the first name and last name of the actor with ID {int}")
    public void i_should_receive_the_first_name_and_last_name_of_the_actor_with_id(Integer actorId) {
        assertThat(actorDetails)
                .as("Check if the actor details map is not null and contains the expected name and last name")
                .isNotNull()
                .containsKeys("first_name", "last_name");

        String firstName = (String) actorDetails.get("first_name");
        String lastName = (String) actorDetails.get("last_name");

        assertThat(firstName)
                .as("Check if the first name is not null")
                .isNotNull();

        assertThat(lastName)
                .as("Check if the last name is not null")
                .isNotNull();
    }
    @Then("I should receive the first name {string} and last name {string} of the actor with ID {int}")
    public void i_should_receive_the_first_name_and_last_name_of_the_actor_with_id(String firstName, String lastName, Integer actorId) {
        assertThat(actorDetails)
                .as("Check if the actor details map contains keys 'first_name' and 'last_name'")
                .containsEntry("first_name", firstName)
                .containsEntry("last_name", lastName);
    }
}
