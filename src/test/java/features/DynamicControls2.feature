Feature:Dynamically loaded elements
  Scenario: Dynamic hidden or rendered elements
    Given the page with link element that is hidden
    When we click on Start btn on example 1
    Then Start btn should disappear and hidden element appears
    When We navigate back and this time select Example 2
    Then We should be on Example2 page
    When We click Start btn on example2
    Then Start btn is gone again and element is rendered after the fact






