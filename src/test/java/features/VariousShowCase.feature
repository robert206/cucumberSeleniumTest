@FunctionalTest
Feature: Various elements Features I

  Scenario:Check for broken images
    Given subpage for broken images and list of all images on page
    Then we check all images for Http response code

  Scenario: Right click inside context Box
    Given the subpage for context click
    When clicking inside context box
    Then alert window is displayed

