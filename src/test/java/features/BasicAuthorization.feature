@avoid
@BasicAuthorization
Feature: BasicAuthorization

  Scenario:  Basic auth in auth windows http://the-internet.herokuapp.com/basic_auth
    Given authorization page /dialog
    When I enter Username and Password and click Sign in
    Then I should be logged in
    And greeted with Congratulations message