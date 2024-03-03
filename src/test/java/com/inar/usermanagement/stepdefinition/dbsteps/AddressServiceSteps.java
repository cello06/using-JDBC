package com.inar.usermanagement.stepdefinition.dbsteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.*;

import com.inar.reqres.user.management.service.AddressService;
import com.inar.reqres.user.management.model.Address;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class AddressServiceSteps {

    private AddressService addressService;
    private List<Address> addresses;
    private Address address;

    @Given("the address service is up and running")
    public void the_address_service_is_up_and_running() {
        addressService = new AddressService();
    }

    @When("I request a list of all addresses")
    public void i_request_a_list_of_all_addresses() {
        addresses = addressService.getAllAddresses();
    }

    @Then("I should receive a list containing all addresses in the database")
    public void i_should_receive_a_list_containing_all_addresses() {
        assertThat(addresses).isNotNull();
        assertThat(addresses).isNotEmpty();
    }

    @When("I request the address with ID {int}")
    public void i_request_the_address_with_id(Integer id) {
        address = addressService.getAddressById(id);
    }

    @Then("I should receive the details of the address with ID {int}")
    public void i_should_receive_the_details_of_the_address_with_id(Integer id) {
        assertNotNull(address);
        assertThat(address.getAddressId()).isEqualTo(id);
    }

    @When("I request addresses in the {string} district")
    public void i_request_addresses_in_the_district(String district) {
        addresses = addressService.getAddressByDistrict(district);
    }

    @Then("I should receive a list of addresses located in the {string} district")
    public void i_should_receive_a_list_of_addresses_in_the_district(String district) {
        assertThat(addresses)
                .as("Check if the address list is not null and not empty")
                .isNotNull()
                .isNotEmpty();
        assertThat(addresses)
                .as("Check if every address in the list has the district: %s", district)
                .extracting(Address::getDistrict)
                .containsOnly(district);
    }

    @Then("I should receive the address with street {string}, district {string}, city ID {int}, postal code {string}, and phone {string}")
    public void i_should_receive_the_address_with_details(String street, String district, Integer cityId, String postalCode, String phone) {
        assertThat(address).as("Check if the address details are correct")
                .isNotNull();

        assertThat(address.getAddress()).as("Validate street").isEqualTo(street);
        assertThat(address.getDistrict()).as("Validate district").isEqualTo(district);
        assertThat(address.getCityId()).as("Validate city ID").isEqualTo(cityId);
        // Postal code and phone might be empty, so we handle these cases
        if (postalCode != null && !postalCode.isEmpty()) {
            assertThat(address.getPostalCode()).as("Validate postal code").isEqualTo(postalCode);
        }
        if (phone != null && !phone.isEmpty()) {
            assertThat(address.getPhone()).as("Validate phone").isEqualTo(phone);
        }
    }
}
