#language: en
Feature: Kafka event received
  Event has to be received properly

  Scenario: proposal event is received
    Given a list of proposals:
    | name | vote | proposal | comment |
    | "Alvaro" | "like" | "cucumber" | "jirafa" | 
    Then the webpage contains that proposal