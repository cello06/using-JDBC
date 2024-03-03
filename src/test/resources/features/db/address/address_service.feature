@regression  @db @addressService
Feature: Address Management Service
  @smoke
  Scenario: Get a list of all addresses
    Given the address service is up and running
    When I request a list of all addresses
    Then I should receive a list containing all addresses in the database

  Scenario: Get an address by its ID
    Given the address service is up and running
    When I request the address with ID 1
    Then I should receive the details of the address with ID 1

  Scenario: Get addresses by district
    Given the address service is up and running
    When I request addresses in the "Nagasaki" district
    Then I should receive a list of addresses located in the "Nagasaki" district

  Scenario Outline: Validate address record by ID
    Given the address service is up and running
    When I request the address with ID <address_id>
    Then I should receive the address with street "<street>", district "<district>", city ID <city_id>, postal code "<postal_code>", and phone "<phone>"

    Examples:
      | address_id | street                               | district         | city_id | postal_code | phone         |
      | 1          | 47 MySakila Drive                    | Alberta          | 300     |             |               |
      | 2          | 28 MySQL Boulevard                   | QLD              | 576     |             |               |
      | 3          | 23 Workhaven Lane                    | Alberta          | 300     |             | 14033335568   |
      | 4          | 1411 Lillydale Drive                 | QLD              | 576     |             | 6172235589    |
      | 5          | 1913 Hanoi Way                       | Nagasaki         | 463     | 35200       | 28303384290   |
      | 6          | 1121 Loja Avenue                     | California       | 449     | 17886       | 838635286649  |
      | 7          | 692 Joliet Street                    | Attika           | 38      | 83579       | 448477190408  |
      | 8          | 1566 Inegl Manor                     | Mandalay         | 349     | 53561       | 705814003527  |
      | 9          | 53 Idfu Parkway                      | Nantou           | 361     | 42399       | 10655648674   |
      | 10         | 1795 Santiago de Compostela Way      | Texas            | 295     | 18743       | 860452626434  |
      | 11         | 900 Santiago de Compostela Parkway   | Central Serbia   | 280     | 93896       | 716571220373  |