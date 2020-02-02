@FunctionalTest
Feature: Various ShowCase II

  Scenario: Disappearing elements
    Given opening elements page
    When we click Home btn
    Then we should land on Home page
    When we click About btn
    Then we should land on about page

    Scenario: Drop-down menu usage
      Given dropdown page
      When we select Option1
      Then Option1 should be selected
      When we select Option2
      Then Option2 should be selected
