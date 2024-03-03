@regression  @db @actorService
Feature: Actor Management Service
  @smoke
  Scenario: Get a list of all actors
    Given the actor service is up and running
    When I request a list of all actors
    Then I should receive a list containing all actors in the database

  Scenario: Get an actor by their ID
    Given the actor service is up and running
    When I request the actor with ID 1
    Then I should receive the details of the actor with ID 1

  Scenario: Get actor's name and last name by their ID
    Given the actor service is up and running
    When I request the name and last name of the actor with ID 1
    Then I should receive the first name and last name of the actor with ID 1

  Scenario Outline: Get actor's name and last name by their ID
    Given the actor service is up and running
    When I request the name and last name of the actor with ID <actor_id>
    Then I should receive the first name "<first_name>" and last name "<last_name>" of the actor with ID <actor_id>

    Examples:
      | actor_id | first_name | last_name  |
      | 1        | Penelope   | Guiness      |
      | 2        | Nick       | Wahlberg      |
      | 3        | Ed         | Chase         |
      | 4        | Jennifer   | Davis         |
      | 5        | Johnny     | Lollobrigida  |
      | 6        | Bette      | Nicholson     |
      | 7        | Grace      | Mostel        |
      | 8        | Matthew    | Johansson     |
      | 9        | Joe        | Swank         |
      | 10       | Christian  | Gable         |
      | 11       | Zero       | Cage          |
      | 12       | Karl       | Berry         |
      | 13       | Uma        | Wood          |
      | 14       | Vivien     | Bergen        |
      | 15       | Cuba       | Olivier       |
      | 16       | Fred       | Costner       |
      | 17       | Helen      | Voight        |
      | 18       | Dan        | Torn          |
      | 19       | Bob        | Fawcett       |
      | 20       | Lucille    | Tracy         |
      | 21       | Kirsten    | Paltrow       |
      | 22       | Elvis      | Marx          |
      | 23       | Sandra     | Kilmer        |
      | 24       | Cameron    | Streep        |
      | 25       | Kevin      | Bloom         |
      | 26       | Rip        | Crawford      |
      | 27       | Julia      | Mcqueen       |
      | 28       | Woody      | Hoffman       |
      | 29       | Alec       | Wayne         |
      | 30       | Sandra     | Peck          |