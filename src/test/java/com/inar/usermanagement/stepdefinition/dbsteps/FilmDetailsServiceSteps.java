package com.inar.usermanagement.stepdefinition.dbsteps;

import com.inar.reqres.user.management.model.FilmDetails;
import com.inar.reqres.user.management.service.FilmDetailsService;
import com.inar.reqres.user.management.service.FilmService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;

import java.util.Arrays;
import java.util.List;

public class FilmDetailsServiceSteps {
    private static final Logger LOGGER = LogManager.getLogger(FilmDetailsServiceSteps.class);

    private FilmDetailsService filmDetailsService;

    private List<FilmDetails> filmDetailsList;

    private FilmDetails filmDetails;

    @Given("film details service is running")
    public void filmDetailsServiceIsRunning() {
        filmDetailsService = new FilmDetailsService();
        LOGGER.info("film details service is running");
    }


    @When("the user sends request to database to get list of all film details")
    public void theUserSendsRequestToDatabaseToGetListOfAllFilmDetails() {
        filmDetailsList = filmDetailsService.getListOfAllFilmDetails();
        System.out.println("FILM LIST SIZE  " + filmDetailsList.size());
        LOGGER.info("the user sends request to database to get list of all film details");
    }

    @Then("the user should receive a list containing all film details in the database")
    public void theUserShouldReceiveAListContainingAllFilmDetailsInTheDatabase() {
        Assertions.assertThat(filmDetailsList).as("Film details list could not be received from database!").isNotNull().isNotEmpty();
        LOGGER.debug("the user received a list containing all film details in the database");
    }


    @When("the user sends request to database to get details of a film by {string}")
    public void theUserSendsRequestToDatabaseToGetDetailsOfAFilmBy(String filmId) {
        filmDetails = filmDetailsService.getAFilmDetailByFilmId(Integer.parseInt(filmId));
        LOGGER.info("the user sends request to database to get details of a film by film_id --> " + filmId);
    }

    @Then("the user should receive details of the film")
    public void theUserShouldReceiveDetailsOfTheFilmWith() {
        Assertions.assertThat(filmDetails).as("Film details could not be received from database!").isNotNull();
        LOGGER.debug("Film details received from database!");
    }


    @Then("the user should receive information of film details as,{string},{string},{string},{string},{string}")
    public void theUserShouldReceiveInformationOfFilmDetailsAs
            (String filmTitle, String description, String releaseYear, String category, String actorList) {
        Assertions.assertThat(filmDetails).as("Film details could not be received from database!").isNotNull();
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(filmDetails.getFilmTitle()).isEqualTo(filmTitle);
        softAssertions.assertThat(filmDetails.getDescription()).isEqualTo(description);
        softAssertions.assertThat(filmDetails.getReleaseYear()).isEqualTo(Integer.parseInt(releaseYear));
        softAssertions.assertThat(filmDetails.getCategory()).isEqualTo(category);
        List<String> actors = Arrays.stream(filmDetails.getActorList().split(",")).toList();
        for(String actor : actors){
            softAssertions.assertThat(actorList.contains(actor)).isTrue();
        }
        softAssertions.assertAll();

        LOGGER.debug("the user received correct information of film details");
    }
}
