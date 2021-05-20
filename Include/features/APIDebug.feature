@API @Regression
Feature: Check

  Background: User uses default header to access application
    Given We initialize webservice

  @ID-Debug
  Scenario: Test user api
    When We send a GET request to '/user' endpoint
    Then We got the Response with status code '200'
    And We got the Response with body:
    """
    {
      "name": "Dryan Lam",
      "BU": "Turing"
    }
    """
