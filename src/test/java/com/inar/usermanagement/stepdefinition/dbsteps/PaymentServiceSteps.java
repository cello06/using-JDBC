package com.inar.usermanagement.stepdefinition.dbsteps;

import com.inar.reqres.user.management.model.Payment;
import com.inar.reqres.user.management.service.PaymentService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

public class PaymentServiceSteps {

    private static final Logger LOGGER = LogManager.getLogger(PaymentServiceSteps.class);
    private List<Payment> paymentList;

    private Payment payment;

    private PaymentService paymentService;

    @Given("the payment service is up and running")
    public void thePaymentServiceIsUpAndRunning() {
        paymentService = new PaymentService();
        LOGGER.info("the film service is up and running");
    }

    @When("the user request a list of all payments")
    public void theUserRequestAListOfAllPayments() {
        paymentList = paymentService.getListOfAllPayments();
        LOGGER.info("the user request a list of all payments");
    }

    @Then("the user should receive a list containing all payments in the database")
    public void theUserShouldReceiveAListContainingAllPaymentsInTheDatabase() {
        Assertions.assertThat(paymentList).as("Payment list could not be received from database!").isNotNull().isNotEmpty();
        LOGGER.debug("the user received a list containing all payments in the database");
    }

    @When("the user request a payment by using {string}")
    public void theUserRequestAPaymentByUsing(String paymentId) {
        payment = paymentService.getAPaymentByPaymentId(Integer.parseInt(paymentId));
        LOGGER.info("the user request a payment by using payment_id --> " + paymentId);
    }

    @Then("the user should receive payment with {string}")
    public void theUserShouldReceivePaymentWith(String paymentId) {
        Assertions.assertThat(payment).as("Payment object is null!").isNotNull();
        Assertions.assertThat(payment.getPaymentId()).as("Payment id is not matching with the database information!").isEqualTo(Integer.parseInt(paymentId));
        LOGGER.debug("the user received payment with payment_id --> " + paymentId);
    }

    @Then("the user should receive the payment with following details {string},{string},{string},{string},{string}")
    public void theUserShouldReceiveThePaymentWithFollowingDetails
            (String customerId, String staffId, String rentalId, String amount, String paymentDate) {
        Assertions.assertThat(payment).as("Payment object is null!").isNotNull();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(payment.getCustomerId()).as("Customer_id is not matching!").isEqualTo(Integer.parseInt(customerId));
        softAssertions.assertThat(payment.getStaffId()).as("Staff_id is not matching!").isEqualTo(Integer.parseInt(staffId));
        softAssertions.assertThat(payment.getRentalId()).as("Rental_id is not matching!").isEqualTo(Integer.parseInt(rentalId));
        softAssertions.assertThat(payment.getAmount()).as("Amount is not matching!").isEqualTo(Double.parseDouble(amount));
        softAssertions.assertThat(payment.getPaymentDate().toString()).as("Payment_date is not matching!").isEqualTo(paymentDate);

        softAssertions.assertAll();

        LOGGER.debug("the user received the payment with correct details");

    }
}
