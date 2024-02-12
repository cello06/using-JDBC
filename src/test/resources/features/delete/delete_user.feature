@smoke @regression @user_deletion
Feature: User deletion

  Scenario: Deleting a user should return the correct response code
    Given A user with ID "2" exists
    When I send a DELETE request to the delete endpoint
    Then the response status code should be 204

  Scenario: Deleting a user should return the correct response code
    Given A user with ID "4" exists
    When I send a DELETE request to the delete endpoint
    Then the response status code should be 204

  Scenario: Deleting a user should return the correct response code
    Given A user with ID "6" exists
    When I send a DELETE request to the delete endpoint
    Then the response status code should be 204