package com.inar.usermanagement.stepdefinition.dbsteps;

import com.inar.reqres.user.management.model.Rental;
import com.inar.reqres.user.management.service.PaymentService;
import com.inar.reqres.user.management.service.RentalService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

public class RentalServiceSteps {

    private static final Logger LOGGER = LogManager.getLogger(RentalServiceSteps.class);
    private List<Rental> rentalList;

    private RentalService rentalService;

    private Rental rental;

    @Given("the rental service is up and running")
    public void theRentalServiceIsUpAndRunning() {
        rentalService = new RentalService();
        LOGGER.info("the payment service is up and running");
    }

    @When("the user request a list of all rentals")
    public void theUserRequestAListOfAllRentals() {
        rentalList = rentalService.getListOfAllRentals();
        LOGGER.info("the user request a list of all rentals");
    }

    @Then("the user should receive a list containing all rentals in the database")
    public void theUserShouldReceiveAListContainingAllRentalsInTheDatabase() {
        Assertions.assertThat(rentalList).as("Rental list could not be taken from database!").isNotEmpty().isNotNull();
        LOGGER.debug("the user received a list containing all rentals in the database");
    }

    @When("the user request a rental by using {string}")
    public void theUserRequestARentalByUsing(String rentalId) {
        rental = rentalService.getARentalByRentalId(Integer.parseInt(rentalId));
        LOGGER.info("the user request a rental by using rental_id --> " + rentalId);
    }

    @Then("the user should receive rental with {string}")
    public void theUserShouldReceiveRentalWith(String rentalId) {
        Assertions.assertThat(rental).as("Rental could not be taken from database!").isNotNull();
        Assertions.assertThat(rental.getRentalId())
                .as("Rental id is not matching with the information in database!")
                .isEqualTo(Integer.parseInt(rentalId));
        LOGGER.debug("the user received rental with rental_id --> " + rentalId);
    }

    @Then("the user receive a rental with following details {string},{string},{string},{string},{string},{string}")
    public void theUserReceiveARentalWithFollowingDetails
            (String rentalDate, String inventoryId, String customerId, String returnDate, String staffId, String lastUpdate) {
        Assertions.assertThat(rental).as("Rental could not be taken from database!").isNotNull();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(rental.getRentalDate().toString().substring(0, 19)).as("Rental date is not matching!").isEqualTo(rentalDate);
        softAssertions.assertThat(rental.getInventoryId()).as("Inventory id is not matching!").isEqualTo(Integer.parseInt(inventoryId));
        softAssertions.assertThat(rental.getCustomerId()).as("Customer id is not matching!").isEqualTo(Integer.parseInt(customerId));
        softAssertions.assertThat(rental.getReturnDate().toString().substring(0, 19)).as("Return date is not matching!").isEqualTo(returnDate);
        softAssertions.assertThat(rental.getStaffId()).as("Staff id is not matching!").isEqualTo(Integer.parseInt(staffId));
        softAssertions.assertThat(rental.getLastUpdate().toString().substring(0, 19)).as("Last update is not matching!").isEqualTo(lastUpdate);

        softAssertions.assertAll();

        LOGGER.debug("the user received a rental with correct details");
    }
}
