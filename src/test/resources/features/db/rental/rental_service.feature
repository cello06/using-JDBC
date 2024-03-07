@regression @db @rentalService
Feature: Rental Management Service

  @smoke
  Scenario: Get list of all rentals
    Given the rental service is up and running
    When the user request a list of all rentals
    Then the user should receive a list containing all rentals in the database

  Scenario Outline: Get a rental by using rental id
    Given the rental service is up and running
    When the user request a rental by using "<rental_id>"
    Then the user should receive rental with "<rental_id>"
    Examples:
      | rental_id |
      | 16        |
      | 41        |

  Scenario Outline: Get a rental with correct details from database by using rental id
    Given the rental service is up and running
    When the user request a rental by using "<rental_id>"
    Then the user receive a rental with following details "<rental_date>","<inventory_id>","<customer_id>","<return_date>","<staff_id>","<last_update>"
    Examples:
      | rental_id | rental_date         | inventory_id | customer_id | return_date         | staff_id | last_update         |
      | 1         | 2005-05-24 22:53:30 | 367          | 130         | 2005-05-26 22:04:30 | 1        | 2006-02-15 21:30:53 |
      | 30        | 2005-05-25 04:01:32 | 3744         | 430         | 2005-05-30 03:12:32 | 1        | 2006-02-16 02:30:53 |
      | 60        | 2005-05-25 08:58:25 | 330          | 470         | 2005-05-30 14:14:25 | 1        | 2006-02-16 02:30:53 |
      | 90        | 2005-05-25 14:31:25 | 2984         | 25          | 2005-06-01 10:07:25 | 1        | 2006-02-16 02:30:53 |
      | 120       | 2005-05-25 19:37:47 | 37           | 365         | 2005-06-01 23:29:47 | 2        | 2006-02-16 02:30:53 |
      | 150       | 2005-05-26 00:28:39 | 909          | 429         | 2005-06-01 02:10:39 | 2        | 2006-02-16 02:30:53 |
