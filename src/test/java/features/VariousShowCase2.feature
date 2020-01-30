@FunctionalTest
Feature: Various ShowCase II

  Scenario: Disappearing elements
    Given opening elements page
    When we click Home btn
    Then we should land on Home page
    When we click About btn
    Then we should land on about page
