@api
Feature: Booking API with invalid info

  Scenario Outline: F02| Try to create a booking with invalid info and retrieve a booking
    Given I create a booking with invalid info of "<firstName>", last name "<LastName>", total price "<price>", deposit paid "<deposit>", check-in "<check-in>", check-out "<checkout>", "<additionalneeds>" successfully
    Then status code should be 404 for all invalid entries
    Examples:
      | firstName | LastName | price | deposit | check-in   | checkout   | additionalneeds |
      | John      | Doe      | -100  | true    | 2020-01-01 | 2020-01-02 | Breakfast       |
      | Jane      | Smith    | 200   | false   | 2020-02-01 | 2020-02-02 | Burger          |
      | Peter     | Mal      | test  | true    | 2020-02-01 | 2020-02-02 | Burger          |
      | Ahmed     | Tarik    | 200   |         | 2020-02-02 | 2020-01-02 | Burger          |
      | Hisham    | Tarik    | 200-4 | true    | 2020-02-02 | 2020-01-02 | Burger          |
      | Mohammed  | Tarik    | 200   | true    | string     | 2020-01-02 | Burger          |
      | Samer     | Tarik    | 200   | true    | 2020-02-02 | string     | Burger          |
      | 15        | Tarik    | 200   | true    | 2020-02-01 | 2020-02-02 | Burger          |
      | Samer     | 15       | 200   | true    | 2020-02-01 | 2020-02-02 | Burger          |