@api
Feature: Retrieve All booking ids

  Scenario: F03|  User sends a get request to get all the booking ids
    Given user sends a get request to get all id of booking
    Then status code should be 200 success

