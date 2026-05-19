Feature: OAuth2 Authentication

  @auth2
  Scenario: Generate OAuth2 token successfully
    Given I generate OAuth2 token
    Then I should have a valid access token

  @oauth2
  Scenario: Call API using OAuth2 token
#    Given I generate OAuth2 token
    When I get user with id 1
    Then OAuth should receive status code 200