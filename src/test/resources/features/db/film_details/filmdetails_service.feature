@regression @db @filmDetailsService
Feature: Film Details Management Service

  @smoke
  Scenario: Get list of all film details
    Given film details service is running
    When the user sends request to database to get list of all film details
    Then the user should receive a list containing all film details in the database

  Scenario: Get details of a film by film id
    Given film details service is running
    When the user sends request to database to get details of a film by 970
    Then the user should receive details of the film


  Scenario Outline: Get information of film details from database by using film id
    Given film details service is running
    When the user sends request to database to get details of a film by "<film_id>"
    Then the user should receive information of film details as "<filmTitle>","<description>","<releaseYear>","<categoryName>","<actorFirstName>","<actorLastName>","<actorId>"
    Examples:
      | film_id | filmTitle        | description                                                                                                         | releaseYear | categoryName | actorFirstName | actorLastName | actorId |
      | 1       | Academy Dinosaur | A Epic Drama of a Feminist And a Mad Scientist who must Battle a Teacher in The Canadian Rockies                    | 2006        | Documentary  | Penelope       | Guiness       | 1       |
      | 9       | Alabama Devil    | A Thoughtful Panorama of a Database Administrator And a Mad Scientist who must Outgun a Mad Scientist in A Jet Boat | 2006        | Horror       | Christian      | Gable         | 10      |
      | 15      | Alien Center     | A Brilliant Drama of a Cat And a Mad Scientist who must Battle a Feminist in A MySQL Convention                     | 2006        | Foreign      | Burt           | Dukakis       | 36      |
