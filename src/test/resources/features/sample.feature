@sample
Feature: Sample file


  Scenario Outline: Eat cucumbers
    Given there are <start> cucumbers
    When I eat <eat> cucumber
    Then I should have left <left> cucumbers

    Examples:
      | start | eat | left |
      | 15    | 5   | 8    |
      | 20    | 20  | 0    |
      | 3     | 2   | 1    |