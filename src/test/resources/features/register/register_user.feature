@smoke @regression @user_registration
Feature: User registration
@test
  Scenario Outline: Successful registration with valid credentials
    Given I have registration credentials "<email>" and "<password>"
    When I send a POST request to the registration endpoint
    Then the response status code should be <status_code>
    And I receive a user id and a token in the response

    Examples:
      | email              | password | status_code |
      | eve.holt@reqres.in | pistol   | 200         |


  Scenario Outline: Unsuccessful registration with invalid credentials
    Given I have registration credentials "<email>" and "<password>"
    When I send a POST request to the registration endpoint
    Then the response status code should be <status_code>
    And the response should contain an error message "<error_message>"

    Examples:
      | email          | password | status_code | error_message                                 |
      | sydney@fife    |          | 400         | Missing password                              |
      | John@gmail.com | john     | 400         | Note: Only defined users succeed registration |
