@smoke @regression @user_update
Feature: User update

  Scenario: Successful update of user details
    Given I have the user update details for user with id "2"
    When I update user with id 2 with name "Hamza" and job "Product Owner"
    Then the response status code should be 200
    And the response should contain the user details: name "Hamza" and job "Product Owner"

  Scenario Outline: Successful update of user details
    Given I have the user update details for user with id "<id>"
    When I update user with id <id> with name "<name>" and job "<job>"
    Then the response status code should be 200
    And the response should contain the user details: name "<name>" and job "<job>"

    Examples:
      | id   | name             | job                        |
      | 1023 | Emma Johnson     | Software Developer         |
      | 1024 | Michael Brown    | Graphic Designer           |
      | 1025 | Sarah Martinez   | Project Manager            |
      | 1026 | David Smith      | Marketing Coordinator      |
      | 1027 | Linda Garcia     | Human Resources Specialist |
      | 1028 | Robert Hernandez | Data Analyst               |
      | 1029 | Maria Rodriguez  | Sales Executive            |
      | 1030 | James Lee        | Customer Service Rep       |
      | 1031 | Patricia Wilson  | Accountant                 |
      | 1032 | John Miller      | IT Support Technician      |
      | 1033 | Barbara Davis    | Product Manager            |
      | 1034 | William Anderson | Network Engineer           |
      | 1035 | Elizabeth Taylor | Content Writer             |
      | 1036 | Joseph Martinez  | Operations Manager         |
      | 1037 | Jennifer Thomas  | UX/UI Designer             |
      | 1038 | Charles Gonzalez | Research Scientist         |
      | 1039 | Angela Moore     | Business Analyst           |