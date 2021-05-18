@API @Agent
Feature: Demo automated test for KataConnect

  Background: User uses default header to access application
    Given We initialize webservice

  @ID-1001
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

  @ID-1002
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

  @ID-1003
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
