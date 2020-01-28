Feature: Form Authentication

  Scenario Outline: : Login form using valid and invalid credentials
    Given That I go to form authentication
    When I enter username "<username>" and "<password>" and press Submit
    Then I should get correct "<status>"
    Examples:
    |username|password|status|
    |wrongUsername|wrongPassword|false|
    |tomsmith     |SuperSecretPassword!|true|



