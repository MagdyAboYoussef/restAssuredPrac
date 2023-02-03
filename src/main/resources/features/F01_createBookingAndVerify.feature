@api
Feature: Booking API

  Scenario Outline: F01 | Create and retrieve a booking
    Given I create a booking with first name "<firstName>", last name "<LastName>", total price "<price>", deposit paid "<deposit>", check-in "<check-in>", check-out "<checkout>", "<additionalneeds>" successfully
    And I should be able to retrieve the booking by ID
    Then the retrieved booking should have first name "<firstName>", last name "<LastName>", total price "<price>", deposit paid "<deposit>", check-in "<check-in>", check-out "<checkout>","<additionalneeds>"
    Examples:
      | firstName | LastName | price | deposit | check-in   | checkout   | additionalneeds |
      | John      | Doe      | 100   | true    | 2020-01-01 | 2020-01-02 | Breakfast       |
      | Jane      | Smith    | 200   | true    | 2020-02-01 | 2020-02-02 | Burger          |