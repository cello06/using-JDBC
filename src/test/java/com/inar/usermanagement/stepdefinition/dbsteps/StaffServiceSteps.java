package com.inar.usermanagement.stepdefinition.dbsteps;

import com.inar.reqres.user.management.model.Staff;
import com.inar.reqres.user.management.service.StaffService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

public class StaffServiceSteps {
    private static final Logger LOGGER = LogManager.getLogger(StaffServiceSteps.class);
    private List<Staff> staffList;

    private StaffService staffService;

    private Staff staff;

    @Given("the staff service is up and running")
    public void theStaffServiceIsUpAndRunning() {
        staffService = new StaffService();
        LOGGER.info("the staff service is up and running");
    }

    @When("the user request a list of all staffs")
    public void theUserRequestAListOfAllStaffs() {
        staffList = staffService.getListOfAllStaffs();
        LOGGER.info("the user request a list of all staffs");
    }

    @Then("the user should get the list of all staffs")
    public void theUserShouldGetTheListOfAllStaffs() {
        Assertions.assertThat(staffList).as("Staff list could not be received from database!").isNotNull().isNotEmpty();
        LOGGER.debug("the user get the list of all staffs");
    }

    @When("the user request a staff by using {string}")
    public void theUserRequestAStaffByUsing(String staffId) {
        staff = staffService.getAStaffByStaffId(Integer.parseInt(staffId));
        LOGGER.info("the user request a staff by using staff_id --> " + staffId);
    }

    @Then("the user should receive staff with {string}")
    public void theUserShouldReceiveStaffWith(String staffId) {
        Assertions.assertThat(staff).as("Staff can not be received from database!").isNotNull();
        Assertions.assertThat(staff.getStaffId())
                .as("Staff id is not matching with the information in database!")
                .isEqualTo(Integer.parseInt(staffId));
        LOGGER.debug("the user received staff with staff_id --> " + staffId);
    }

    @Then("the user receive a staff with following details {string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void theUserReceiveAStaffWithFollowingDetails
            (String firstName,
             String lastName,
             String addressId,
             String email,
             String storeId,
             String active,
             String username,
             String password,
             String lastUpdate) {

        Assertions.assertThat(staff).as("Staff can not be received from database!").isNotNull();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(staff.getFirstName()).as("Firstname is not matching").isEqualTo(firstName);
        softAssertions.assertThat(staff.getLastName()).as("Lastname is not matching").isEqualTo(lastName);
        softAssertions.assertThat(staff.getAddressId()).as("Address id is not matching").isEqualTo(Integer.parseInt(addressId));
        softAssertions.assertThat(staff.getEmail()).as("Email is not matching").isEqualTo(email);
        softAssertions.assertThat(staff.getStoreId()).as("Store id is not matching").isEqualTo(Integer.parseInt(storeId));
        softAssertions.assertThat(staff.isActive()).as("Activation is not matching").isEqualTo(Boolean.parseBoolean(active));
        softAssertions.assertThat(staff.getUsername()).as("Username is not matching").isEqualTo(username);
        softAssertions.assertThat(staff.getPassword()).as("Password is not matching").isEqualTo(password);
        softAssertions.assertThat(staff.getLastUpdate().toString()).as("Last update is not matching").isEqualTo(lastUpdate);

        softAssertions.assertAll();

        LOGGER.debug("the user receive a staff with correct details");
    }
}
