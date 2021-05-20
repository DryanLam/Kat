@Bike @Regression
Feature: Demo automated test for KataConnect

  Background: User uses default header to access application
    Given We initialize webservice

  @ID-1002
  Scenario: Test bike api
    When We send a GET request to '/bike' endpoint
    Then We got the Response with status code '200'
    And We got the Response with body:
    """
    {
      "name": "Future",
      "type": "Road"
    }
    """
