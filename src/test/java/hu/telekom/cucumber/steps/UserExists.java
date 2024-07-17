package hu.telekom.cucumber.steps;


import hu.telekom.pageobjects.RegistrationFirstPageObject;
import hu.telekom.pageobjects.UserExistsPageObject;
import hu.telekom.tests.BaseTest;

import io.cucumber.java.en.Then;

public class UserExists extends BaseTest {


    private UserExistsPageObject userExistsPageObject;
    private RegistrationFirstPageObject registrationFirstPageObject;


    @Then("New Page opens with User exists Message {string}")
    public void navigateUserExistPage (String message) {
        UserExistsPageObject userExistsPage = registrationFirstPageObject.navigateUserExistPage();
        userExistsPage.verifyUserExistPage();
    }
}