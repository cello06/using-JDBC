@regression @db @staffService
Feature: Staff Management Service

  Scenario: Get list of all staffs
    Given the staff service is up and running
    When the user request a list of all staffs
    Then the user should get the list of all staffs

  Scenario Outline: Get a staff by using staff id
    Given the staff service is up and running
    When the user request a staff by using "<staff_id>"
    Then the user should receive staff with "<staff_id>"
    Examples:
      | staff_id |
      | 1        |
      | 2        |


  Scenario Outline: Get a staff with correct details from database by using staff id
    Given the staff service is up and running
    When the user request a staff by using "<staff_id>"
    Then the user receive a staff with following details "<first_name>","<last_name>","<address_id>","<email>","<store_id>","<active>","<username>","<password>","<last_update>"
    Examples:
      | staff_id | first_name | last_name | address_id | email                        | store_id | active | username | password                                 | last_update               |
      | 1        | Mike       | Hillyer   | 3          | Mike.Hillyer@sakilastaff.com | 1        | true   | Mike     | 8cb2237d0679ca88db6464eac60da96345513964 | 2006-05-16 16:13:11.79328 |
      | 2        | Jon        | Stephens  | 4          | Jon.Stephens@sakilastaff.com | 2        | true   | Jon      | 8cb2237d0679ca88db6464eac60da96345513964 | 2006-05-16 16:13:11.79328 |