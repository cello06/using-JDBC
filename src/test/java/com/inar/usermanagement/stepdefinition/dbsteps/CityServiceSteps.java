package com.inar.usermanagement.stepdefinition.dbsteps;

import com.inar.reqres.user.management.model.City;
import com.inar.reqres.user.management.service.CityService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CityServiceSteps {

    private CityService cityService;
    private List<City> cities;
    private City city;

    @Given("the city service is up and running")
    public void the_city_service_is_up_and_running() {
        cityService = new CityService();
    }

    @When("I request a list of all cities")
    public void i_request_a_list_of_all_cities() {
        cities = cityService.getAllCities();
    }

    @Then("I should receive a list containing all cities in the database")
    public void i_should_receive_a_list_containing_all_cities() {
        assertThat(cities).isNotNull().isNotEmpty();
    }

    @When("I request the city with ID {int}")
    public void i_request_the_city_with_id(int id) {
        city = cityService.getCityById(id);
    }

    @Then("I should receive the details of the city with ID {int}")
    public void i_should_receive_the_details_of_the_city_with_id(int id) {
        assertThat(city).isNotNull();
        assertThat(city.cityId()).isEqualTo(id);  // NOTE, in records we don't have getters, so intead of getCityId I use cityId
    }

    @Then("I should receive the city with name {string} and country ID {int}")
    public void i_should_receive_the_city_with_name_and_country_id(String cityName, Integer countryId) {
        assertThat(city).as("Check if the city details are correct")
                .isNotNull();

        assertThat(city.city()).as("Validate city name").isEqualTo(cityName);
        assertThat(city.countryId()).as("Validate country ID").isEqualTo(countryId);
    }
}
