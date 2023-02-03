@api
Feature: generating auth token

  Scenario: F04 |  User sends a post request to /auth
    Given user sends a post request to get auth with username : "admin" and password: "password123" token
    Then auth token should be returned

