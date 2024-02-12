@smoke @regression @user_login
Feature: User login

  Scenario Outline: Successful login with valid credentials
    Given I have login credentials "<email>" and "<password>"
    When I send a POST request to the login endpoint
    Then the response status code should be <status_code>
    And I receive a token in the response
    Examples:
      | email              | password   | status_code |
      | eve.holt@reqres.in | cityslicka | 200         |


  Scenario Outline: Successful login with invalid credentials
    Given I have login credentials "<email>" and "<password>"
    When I send a POST request to the login endpoint
    Then the response status code should be <status_code>
    Examples:
      | email                  | password   | status_code |
      | sydney@fife            |            | 400         |
      | invalid.user@reqres.in | wrongpass  | 400         |