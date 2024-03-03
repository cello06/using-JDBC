@regression  @db @cityService
Feature: City Management Service

  @smoke
  Scenario: Get a list of all cities
    Given the city service is up and running
    When I request a list of all cities
    Then I should receive a list containing all cities in the database

  Scenario: Get a city by its ID
    Given the city service is up and running
    When I request the city with ID 1
    Then I should receive the details of the city with ID 1

  Scenario Outline: Validate city record by ID
    Given the city service is up and running
    When I request the city with ID <city_id>
    Then I should receive the city with name "<city_name>" and country ID <country_id>

    Examples:
      | city_id | city_name          | country_id |
      | 1       | A Corua (La Corua) | 87         |
      | 2       | Abha               | 82         |
      | 3       | Abu Dhabi          | 101        |
      | 4       | Acua               | 60         |
      | 5       | Adana              | 97         |
      | 6       | Addis Abeba        | 31         |
      | 7       | Aden               | 107        |
      | 8       | Adoni              | 44         |
      | 9       | Ahmadnagar         | 44         |
      | 10      | Akishima           | 50         |
