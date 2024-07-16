Feature: The user shall be able to do change the language in BudapestGO

  Background:
    Given I open the main page
    And I accept cookies

  Rule: Allow to change the language

    Scenario Outline: Change language
      Given language is set to "<language>"
      When I change the language to "<newLanguage>"
      Then it shows elements in "<newLanguage>"

      Examples:
        | language  | newLanguage |
        | hungarian | english     |
        | english   | hungarian   |

    Scenario: Change language with data table
      Given language is set to "english"
      When I change the language to

        | nyelv     | kod |
        | hungarian | HUN |
        | english   | ENG |
      Then it shows elements in "english"