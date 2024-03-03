package com.inar.usermanagement.stepdefinition.dbsteps;

import com.inar.reqres.user.management.mappers.ActorMapper;
import com.inar.reqres.user.management.mappers.AddressMapper;
import com.inar.reqres.user.management.model.Actor;
import com.inar.reqres.user.management.model.Address;
import com.inar.reqres.user.management.service.ActorService;
import com.inar.reqres.user.management.service.AddressService;
import com.inar.reqres.user.management.utils.DBUtils;
import com.inar.reqres.user.management.utils.RowMapper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActorSteps {

    private List<Actor> actorList;

    private List<Address> addressList;

    private Actor actor;

    private final ActorService actorService = new ActorService(); // Instantiate
    // ActorService

    private final AddressService addressService = new AddressService(); // Instantiate
    // ActorService

    private Timestamp lastUpdateTimestamp;

    List<Map<String, Object>> resultList;

    @Given("the database is accessible")
    public void the_database_is_accessible() {
        try {
            Assertions.assertThat(DBUtils.getConnection()).isNotNull();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @When("I request all actor records")
    public void i_request_all_actor_records() {
        resultList = DBUtils.executeQueryForMapList("SELECT * FROM actor"); // Use ActorService to get all actors
    }


    @Then("I should receive a list of all actors")
    public void i_should_receive_a_list_of_all_actors() {
        Assertions.assertThat(resultList).isNotEmpty();
        Assertions.assertThat(resultList.size()).isEqualTo(200);
    }

    @When("I request the actor record with ID {int}")
    public void i_request_the_actor_record_with_id(Integer actorId) {
        String query = "SELECT * FROM actor WHERE actor_id=" + actorId;
        resultList = DBUtils.executeQueryForMapList(query);
        actor = new Actor(
                (Integer) resultList.get(0).get("actor_id"),
                (String) resultList.get(0).get("first_name"),
                (String) resultList.get(0).get("last_name"),
                (Timestamp) resultList.get(0).get("last_update"));
    }

    @Then("I should receive the actor record with first name {string} and last name {string}")
    public void i_should_receive_the_actor_record_with_first_name_and_last_name(String firstName, String lastName) {
        Assertions.assertThat(actor).isNotNull();
        Assertions.assertThat(actor.getFirstName()).isEqualTo(firstName);
        Assertions.assertThat(actor.getLastName()).isEqualTo(lastName);
    }

    @When("I check the last update timestamp for any actor record")
    public void i_check_the_last_update_timestamp_for_any_actor_record() {
        String query = "SELECT MAX(last_update) as last_update FROM actor";
         List<Timestamp> timestamps = DBUtils.executeQuery(query, rs ->
         rs.getTimestamp("last_update"));

         //      Assuming that the query will return at least one result
         Assertions.assertThat(timestamps).isNotEmpty();
         lastUpdateTimestamp = timestamps.get(0); // Get the first and only timestamp
    }

    @Then("the last update timestamp should be more recent than {string}")
    public void the_last_update_timestamp_should_be_more_recent_than(String dateStr) {
        Timestamp expectedTimestamp = Timestamp.valueOf(dateStr);
        Assertions.assertThat(lastUpdateTimestamp).isAfter(expectedTimestamp);
    }

    @Then("the timestamp should be later than {string}")
    public void the_timestamp_should_be_later_than(String date) {
        Timestamp timestampLimit = Timestamp.valueOf(date);
        Assertions.assertThat(actor.getLastUpdate()).isAfter(timestampLimit);
    }

}
