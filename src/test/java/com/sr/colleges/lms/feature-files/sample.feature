Feature: Login
  Scenario: Verification of Login Function
    Given a policy number 12345
    When the consumer requests policy preferences with policy number 12345
    Then the response contains the delivery preference
    And list of packetIds is returned:
      |12345|
      |45678|