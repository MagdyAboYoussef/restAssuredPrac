@api
Feature: user shouldnt be able to  update booking with invalid auth

  Scenario: F07 |  User sends a put request to booking/id with invalid auth token
    Given user sends a put request with invalid auth to id : "4211" with firstname: "Mohammed", last name "Tarik", total price "500", deposit paid "true", check-in "2020-01-01", check-out "2020-02-02", additional needs "Dinner"
    Then response should fail

Scenario: F07 |  User sends a delete request to booking/id with invalid auth token
  Given user sends a delete request to id 4211
  Then response should fail
