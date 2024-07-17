Feature: Registration

  Rule: Registration Page is available

    Background:
      Given Open Tesco website
      And Accept privacy policy

    Scenario : Create new User FirstStep
      And navigate to Registration Page
      When Register with User Information <email> and <password> and <passwordConfirm>
      And click on next
      Then Registration SecondPage will open



    Scenario: User already exists
      Given navigate to Registration Page
      When register with "test@test.com" and "Password123"
      Then New Page opens with User exists Message "Ezt az email címet már regisztráltuk"


# _____________________________________________________________________________________________________________

    Scenario Outline: Wrong Password credentials
      Given I click on Registration Button
      When I fill out the Registration Page with user Information <email> and <password>
      Then <ErrorMessage> appears

      Examples:
        | email        | password | ErrorMessage                                                                                                              |
        | test@test.de | asdfgh   | Password must be at least 8 letters and must include both numbers and letters. Password must contain at least one number. |
        | test@test.de | asdfgh1  | Password must be at least 8 letters and must include both numbers and letters.                                            |
        | test@test.de | asdfghjk | Password must contain at least one number.                                                                                |

    Scenario Outline: Password doesn't match
      Given I click on Registration Button
      When I fill out the Registration Page with user Information <email> and <password> and <passwordConfirm>
      Then <ErrorMessage> appears

      Examples:
        | email        | password   | passwordConfirm | ErrorMessage         |
        | test@test.de | Asdfghjk88 | Asdfghjk88      | Passwords must match |

    Scenario Outline: Invalid email address
      Given I click on Registration Button
      When I fill out the Registration Page with user Information <email>
      Then <ErrorMessage> appears

      Examples:
        | email        | ErrorMessage                                        |
        | invalidemail | Invalid email address Don't forget to include the @ |