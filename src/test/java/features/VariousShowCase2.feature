@FunctionalTest
Feature: Various ShowCase II

  Scenario: Disappearing elements
    Given opening elements page
    When we click Home btn
    Then we should land on Home page
    When we click About btn
    Then we should land on about page

  Scenario: Drag and Drop elements
    Given drag and drop page
    When we drag element A into element B
    Then elements A and B should swap places