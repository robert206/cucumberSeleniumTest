Feature: CheckBoxes

  Scenario:  CheckBoxes
    Given The checkboxes page
    When I click checkbox1
    Then it should be selected
    When I click checkbox2
    Then It should be deselected