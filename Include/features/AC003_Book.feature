@Book @Regression
Feature: Demo automated test for KataConnect

  Background: User uses default header to access application
    Given We initialize webservice

  @ID-1003
  Scenario: Test book api
    When We send a GET request to '/book' endpoint
    Then We got the Response with status code '200'
    And We got the Response with body:
    """
    {
      "total": "3",
      "cost": "2000"
    }
    """
