@FunctionalTest
Feature: Dynamic Controls

  Scenario: Dynamic controls btns and field check
    Given page with dynamic Controls
    When we select checkbox
    And click Remove btn
    Then checkbox is removed and btn Add is visible
    When we click Add btn again
    Then checkbox should be visible again along with btn Remove
