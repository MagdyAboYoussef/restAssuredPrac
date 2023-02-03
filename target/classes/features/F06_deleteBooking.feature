@api
Feature: user can delete booking with auth token

  Scenario: F06 |  User sends a delete request to booking/id
    Given I create  booking with first name "John", last name "Does", total price "200", deposit paid "true", check-in "2020-01-01", check-out "<2020-02-02>", "Breakfast" successfully
    And user enters auth token and sends a delete request to created id
    Then response to id inquiry should show not found


