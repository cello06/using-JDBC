@smoke @regression @user_validation
Feature: Validation user management api

  Scenario: User details should match the expected response from the API
    When I make a request to list users with page number 1
    Then the response status code should be 200
    And the response should include the following user details:
      | id | email                    | first_name | last_name |
      | 1  | george.bluth@reqres.in   | George     | Bluth     |
      | 2  | janet.weaver@reqres.in   | Janet      | Weaver    |
      | 3  | emma.wong@reqres.in      | Emma       | Wong      |
      | 4  | eve.holt@reqres.in       | Eve        | Holt      |
      | 5  | charles.morris@reqres.in | Charles    | Morris    |
      | 6  | tracey.ramos@reqres.in   | Tracey     | Ramos     |


  Scenario: User details should match the expected response from the API as List
    When I make a request to list users with page number 1
    Then the response status code should be 200
    And the response should include the following user details as list:
      | 1,george.bluth@reqres.in,George,Bluth |
      | 2,janet.weaver@reqres.in,Janet,Weaver |
      | 3,emma.wong@reqres.in,Emma,Wong       |


  Scenario: User details should match the expected response from the API with user objects
    When I make a request to list users with page number 1
    Then the response status code should be 200
    And the response should include the following user details as User:
      | id | email                    | firstName | lastName |
      | 1  | george.bluth@reqres.in   | George    | Bluth    |
      | 2  | janet.weaver@reqres.in   | Janet     | Weaver   |
      | 3  | emma.wong@reqres.in      | Emma      | Wong     |
      | 4  | eve.holt@reqres.in       | Eve       | Holt     |
      | 5  | charles.morris@reqres.in | Charles   | Morris   |
      | 6  | tracey.ramos@reqres.in   | Tracey    | Ramos    |


  Scenario: User details should match the expected response from the API
    When I make a request to list users with page number 2
    Then the response status code should be 200
    And the response should include the following user details as User:
      | id | email                      | firstName | lastName |
      | 7  | michael.lawson@reqres.in   | Michael   | Lawson   |
      | 8  | lindsay.ferguson@reqres.in | Lindsay   | Ferguson |
      | 9  | tobias.funke@reqres.in     | Tobias    | Funke    |
      | 10 | byron.fields@reqres.in     | Byron     | Fields   |
      | 11 | george.edwards@reqres.in   | George    | Edwards  |
      | 12 | rachel.howell@reqres.in    | Rachel    | Howell   |




