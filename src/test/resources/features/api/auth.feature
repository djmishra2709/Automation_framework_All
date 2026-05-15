Feature: Authentication API

  @BasicAuthapi
  Scenario: Generate bearer token

    Given I initialize Auth API
    When I generate Basic auth token
    Then token should be generated successfully