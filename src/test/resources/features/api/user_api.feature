Feature: User API validation

  @api
  Scenario: Get user details
    Given I initialize API
    When I send GET request for user id 1
    Then I should receive status code 200