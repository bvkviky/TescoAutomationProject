# User Stories for Registration Feature

## Feature: Registration

### Rule: Registration Page is available

- Website: https://bevasarlas.tesco.hu/groceries/hu-HU


---

### User Story 1: Create New User (First Step)
As a new user, I want to register on the website so that I can create an account.

- **Given** I click on the Registration Button
- **When** I fill out the Registration Page with user information `<email>` and `<password>` and `<passwordConfirm>`
- **And** click on next
- **Then** the Registration Second Page will open


---

### User Story 2: User Already Exists
As a returning user, I want to know if my email is already registered so that I can take appropriate action.

- **Given** I click on the Registration Button
- **When** I fill out the Registration Page with user information `<email>` and `<password>` and `<passwordConfirm>`
- **And** click on next
- **Then** an error page opens with a "User exists" message


---

### User Story 3: Wrong Password Credentials
As a user, I want to receive feedback if my password does not meet the criteria so that I can enter a valid password.

- **Given** I click on the Registration Button
- **When** I fill out the Registration Page with user information `<email>` and `<password>`
- **Then** `<ErrorMessage>` appears

---

### User Story 4: Password Doesn't Match
As a user, I want to be informed if my passwords do not match so that I can correct them.

- **Given** I click on the Registration Button
- **When** I fill out the Registration Page with user information `<email>` and `<password>` and `<passwordConfirm>`
- **Then** `<ErrorMessage>` appears

---

### User Story 5: Invalid Email Address
As a user, I want to be notified if I enter an invalid email so that I can correct it.

- **Given** I click on the Registration Button
- **When** I fill out the Registration Page with user information `<email>`
- **Then** `<ErrorMessage>` appears


