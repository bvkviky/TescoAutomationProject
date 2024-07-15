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

    Scenario Outline: User already exists
      Given I click on Registration Button
      When I fill out the Registration Page with user Information <email> and <password> and <passwordConfirm>
      And click on next
      Then Error Page opens with User exists Message

      Examples:
        | email              | password    | passwordConfirm |
        | bvk.viky@gmail.com | Azthiszem88 | Azthiszem88     |

    Scenario Outline: User already exists
      Given I click on Registration Button
      When I fill out the Registration Page with user Information <email> and <password> and <passwordConfirm>
      And cklick on next
      Then Error Page opens with User exists Message

      Examples:
        | email              | password    | passwordConfirm |
        | bvk.viky@gmail.com | Azthiszem88 | Azthiszem88     |

    Scenario Outline: Wrong Password credentials
      Given I click on Registration Button
      When I fill out the Registration Page with user Information <email> and <password>
      Then <ErrorMessage> appear

      Examples:
        | email        | password | ErrorMessage
        | test@test.de | asdfgh   | Password must be at least 8 letters and must include both numbers and letters. Password must contain at least one number. |
        | test@test.de | asdfgh1  | Password must be at least 8 letters and must include both numbers and letters.                                            |
        | test@test.de | asdfghjk | Password must contain at least one number.                                                                                |

    Scenario Outline: Password doesn't match
      Given I click on Registration Button
      When I fill out the Registration Page with user Information <email> and <password>, <passwordConfirm>
      Then <ErrorMessage> appears

      Examples:
        | email        | password    | passwordConfirm | ErrorMessage         |
        | test@test.de | Azthiszem88 | azthiszem88     | Passwords must match |