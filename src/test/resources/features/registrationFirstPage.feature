Feature: Registration

  Rule: Registration Page is available

    Background:
      Given Open TESCO website
      And Accept privacy policy

    Scenario: Create new User FirstStep
      Given navigate to Registration Page
      When Register with User Information <email> and <password> and <passwordConfirm>
      And click on next
      Then Registration SecondPage will open

    Scenario: User already exists
      Given  navigate to Registration Page
      When register with "test@test.com" and "Password123"
      Then New Page opens with User exists Message "Ezt az email címet már regisztráltuk"

    Scenario Outline: Wrong Password credentials
      Given navigate to Registration Page
      When register with user Information "<email>" and "<password>"
      Then "<ErrorMessage>" appears

      Examples:
        | email        | password  | ErrorMessage                                                                                                 |
        | test@test.de | asdfgha   | A jelszónak legalább 8 karakter hosszúnak kell lennie és tartalmaznia kell legalább egy betűt és egy számot. |
        | test@test.de | asdfghjk  | A jelszónak tartalmaznia kell legalább egy számot.                                                           |
        | test@test.de | 012345678 | A jelszónak legalább 1 betűt tartalmaznia kell!                                                              |
