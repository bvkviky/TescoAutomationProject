
Feature: Registration

  Rule: Registration Page is available

  Background:
    Given I open Tesco website
    And I accept privacy policy

    Scenario Outline: Create new User FirstStep
      Given I click on Registration Button
      When I fill out the Registration Page with user Information <email> and <password> and <passwordConfirm>
      And cklick on next
      Then Registration SecondPage will open

      Examples:
        | email        | password    | passwordConfirm |
        | test@test.de | Azthiszem88 | Azthiszem88     |
