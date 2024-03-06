package com.inar.usermanagement.stepdefinition.dbsteps;

import com.inar.reqres.user.management.model.Film;
import com.inar.reqres.user.management.service.FilmService;
import com.inar.reqres.user.management.utils.DBUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.internal.common.assertion.Assertion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

public class FilmServiceSteps {
    private static final Logger LOGGER = LogManager.getLogger(FilmServiceSteps.class);
    private FilmService filmService;
    private List<Film> filmList;
    private Film film;


    @Given("the film service is up and running")
    public void theFilmServiceIsUpAndRunning() {
        filmService = new FilmService();
    }

    @When("the user request a list of all films")
    public void theUserRequestAListOfAllFilms() {
        filmList = filmService.getAllFilms();
        LOGGER.info("the user request a list of all films");
    }

    @Then("the user should receive a list containing all films in the database")
    public void theUserShouldReceiveAListContainingAllFilmsInTheDatabase() {
        Assertions.assertThat(filmList).as("Film List could not received from database!").isNotNull().isNotEmpty();
        LOGGER.debug("the user received a list containing all films in the database");
    }

    @When("the user request a film by using {string}")
    public void theUserRequestAFilmByUsing(String filmId) {
        film = filmService.getFilmById(Integer.parseInt(filmId));
        LOGGER.info("the user request a film by using filmId --> " + filmId);
    }

    @Then("the user should receive film with {string}")
    public void theUserShouldReceiveFilmWith(String filmId) {
        Assertions.assertThat(film).isNotNull();
        Assertions.assertThat(film.getFilmId()).isEqualTo(Integer.parseInt(filmId));
        LOGGER.debug("the user should receive film with filmId --> " + filmId);
    }

    @Then("the user should receive the film with following details {string},{string},{string},{string},{string},{string}")
    public void theUserShouldReceiveTheFilmWithFollowingDetails
            (String filmTitle,
             String rentalDuration,
             String rentalRate,
             String length,
             String replacementCost,
             String lastUpdate) {
        Assertions.assertThat(film).isNotNull();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(film.getTitle()).isEqualTo(filmTitle);
        softAssertions.assertThat(film.getRentalDuration()).isEqualTo(Integer.parseInt(rentalDuration));
        softAssertions.assertThat(film.getRentalRate()).isEqualTo(Double.parseDouble(rentalRate));
        softAssertions.assertThat(film.getLength()).isEqualTo(Integer.parseInt(length));
        softAssertions.assertThat(film.getReplacementCost()).isEqualTo(Double.parseDouble(replacementCost));
        softAssertions.assertThat(film.getLastUpdate().toString()).isEqualTo(lastUpdate);

        softAssertions.assertAll();
    }
}
