@regression @db @filmService
Feature: Film Management Service

  @smoke
  Scenario: Get list of all films
    Given the film service is up and running
    When the user request a list of all films
    Then the user should receive a list containing all films in the database


  Scenario Outline: Get a film by using film id
    Given the film service is up and running
    When the user request a film by using "<film_id>"
    Then the user should receive film with "<film_id>"
    Examples:
      | film_id |
      | 11      |
      | 1       |

  Scenario Outline: Validate film record by ID
    Given the film service is up and running
    When the user request a film by using "<film_id>"
    Then the user should receive the film with following details "<film_title>","<rental_duration>","<rental_rate>","<length>","<replacement_cost>","<last_update>"
    Examples:
      | film_id | film_title       | rental_duration | rental_rate | length | replacement_cost | last_update             |
      | 1       | Academy Dinosaur | 6               | 0.99        | 86     | 20.99            | 2013-05-26 14:50:58.951 |
      | 2       | Ace Goldfinger   | 3               | 4.99        | 48     | 12.99            | 2013-05-26 14:50:58.951 |
      | 3       | Adaptation Holes | 7               | 2.99        | 50     | 18.99            | 2013-05-26 14:50:58.951 |
      | 4       | Affair Prejudice | 5               | 2.99        | 117    | 26.99            | 2013-05-26 14:50:58.951 |
      | 5       | African Egg      | 6               | 2.99        | 130    | 22.99            | 2013-05-26 14:50:58.951 |
      | 6       | Agent Truman     | 3               | 2.99        | 169    | 17.99            | 2013-05-26 14:50:58.951 |
      | 7       | Airplane Sierra  | 6               | 4.99        | 62     | 28.99            | 2013-05-26 14:50:58.951 |
      | 8       | Airport Pollock  | 6               | 4.99        | 54     | 15.99            | 2013-05-26 14:50:58.951 |