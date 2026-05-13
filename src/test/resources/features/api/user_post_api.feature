Feature: User creation API

  @apipost
  Scenario: Create new user

    Given I initialize API
    When I create user with name "Dheeraj" and job "QA"
    Then I should receive status code 201
    Then I validate response contains name "Dheeraj"