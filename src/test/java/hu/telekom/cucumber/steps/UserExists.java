package hu.telekom.cucumber.steps;


import hu.telekom.pageobjects.HomePageObject;
import hu.telekom.pageobjects.RegistrationFirstPageObject;
import hu.telekom.pageobjects.UserExistsPageObject;
import hu.telekom.tests.BaseTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class UserExists extends BaseTest {


    private RegistrationFirstPageObject registrationFirstPageObject;





    @Then("New Page opens with User exists Message {string}")
    public void navigateUserExistPage (String message) {
        registrationFirstPageObject.navigateUserExistPage();
    }


}
