@FunctionalTest
Feature: Dynamic Controls

  Scenario: Dynamic controls btns and field check
    Given page with dynamic Controls
    When we select checkbox
    And click Remove btn
    Then checkbox is removed and btn Add is visible
    When we click Add btn again
    Then checkbox should be visible again along with btn Remove

  Scenario: Enable/disable input field test
    Given page with dynamic controls again
    When we click Enable btn
    Then text field should be enabled
    When we send some text to field and press Disable btn
    Then text field should be disabled again and btn disabled

