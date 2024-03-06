@regression @db @filmService
Feature: Payment Management Service

  @smoke
  Scenario: Get list of all payments
    Given the payment service is up and running
    When the user request a list of all payments
    Then the user should receive a list containing all payments in the database

  Scenario Outline: Get a payment by using payment id
    Given the payment service is up and running
    When the user request a payment by using "<payment_id>"
    Then the user should receive payment with "<payment_id>"
    Examples:
      | payment_id |
      | 17503      |
      | 17511      |

  Scenario Outline: Validate a payment information by using payment_id
    Given the payment service is up and running
    When the user request a payment by using "<payment_id>"
    Then the user should receive the payment with following details "<customer_id>","<staff_id>","<rental_id>","<amount>","<payment_date>"
    Examples:
      | payment_id | customer_id | staff_id | rental_id | amount | payment_date               |
      | 17503      | 341         | 2        | 1520      | 7.99   | 2007-02-15 22:25:46.996577 |
      | 17509      | 342         | 2        | 2190      | 5.99   | 2007-02-17 23:58:17.996577 |
      | 17512      | 343         | 2        | 1547      | 4.99   | 2007-02-16 00:10:50.996577 |
      | 17542      | 350         | 1        | 2619      | 0.99   | 2007-02-19 06:31:38.996577 |
