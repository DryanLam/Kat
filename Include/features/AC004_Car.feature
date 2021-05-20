@Car @Regression
Feature: Demo automated test for KataConnect

  Background: User uses default header to access application
    Given We initialize webservice

  @ID-1004
  Scenario: Test car api
    When We send a GET request to '/car' endpoint
    Then We got the Response with status code '200'
    And We got the Response with body:
    """
    {
      "name": "Jeep",
      "type": "Off Road"
    }
    """
