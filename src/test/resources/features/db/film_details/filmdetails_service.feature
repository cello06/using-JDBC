@regression @db @filmDetailsService
Feature: Film Details Management Service

  @smoke
  Scenario: Get list of all film details
    Given film details service is running
    When the user sends request to database to get list of all film details
    Then the user should receive a list containing all film details in the database

  Scenario: Get details of a film by film id
    Given film details service is running
    When the user sends request to database to get details of a film by "970"
    Then the user should receive details of the film


  Scenario Outline: Get information of film details from database by using film id
    Given film details service is running
    When the user sends request to database to get details of a film by "<film_id>"
    Then the user should receive information of film details as,"<film_title>","<description>","<release_year>","<category>","<actor_list>"
    Examples:
      | film_id | film_title           | description                                                                                          | release_year | category | actor_list                                                  |
      | 2       | Ace Goldfinger       | A Astounding Epistle of a Database Administrator And a Explorer who must Find a Car in Ancient China | 2006         | Horror   | Minnie Zellweger,Chris Depp,Bob Fawcett,Sean Guiness        |
      | 22      | Amistad Midsummer    | A Emotional Character Study of a Dentist And a Crocodile who must Meet a Sumo Wrestler in California | 2006         | New      | Cary Mcconaughey,Daryl Wahlberg,Scarlett Bening,Salma Nolte |
      | 41      | Arsenic Independence | A Fanciful Documentary of a Mad Cow And a Womanizer who must Find a Dentist in Berlin                | 2006         | Travel   | Rita Reynolds,Cuba Allen,Oprah Kilmer                       |
