package hu.telekom.cucumber.steps;

import hu.telekom.pageobjects.HomePageObject;
import hu.telekom.pageobjects.RegistrationFirstPageObject;
import hu.telekom.tests.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Random;

public class RegistrationFirst extends BaseTest {

    private HomePageObject homePage;
    private RegistrationFirstPageObject registrationFirstPageObject;

    @Before
    public void setUp() {
        super.setup(); // Call the setup method from BaseTest
        homePage = new HomePageObject(driver);
        registrationFirstPageObject = new RegistrationFirstPageObject(driver);
        homePage.clickOnPrivacyPolicy();
    }


    @Given("I click on Registration Button")
    public void iClickOnRegistrationButton () {
        homePage.clickOnRegistrationButton();
    }

    @And("click on next")
    public void clickOnNext () {
        registrationFirstPageObject.clickOnNext();
    }

    @When("I fill out the Registration Page with user Information <email> and <password> and <passwordConfirm>")
    public void fillAllUserInformationWhitNoParams() throws Exception{
        String randomEmail= registrationFirstPageObject.generateRandomEmail();
        String password = registrationFirstPageObject.generatePassword();
        String passwordConfirm = password;

        if (registrationFirstPageObject.isEmailValid(randomEmail)) {
            try {
                registrationFirstPageObject.fillOutRegistrationForm(randomEmail, password, passwordConfirm);
            } catch (Exception e) {
                throw new Exception(e);
            }
        } else {
            throw new IllegalArgumentException("Invalid email format: " + randomEmail);
        }


    }

  /*  @When("I fill out the Registration Page with user Information <email> and <password> and <passwordConfirm>")
    public void fillAllUserInformation (String email, String password, String passwordConfirm) throws Exception {
        if (email.equals("test@test.de")) {
            email = registrationFirstPageObject.generateRandomEmail();

            registrationFirstPageObject.fillOutRegistrationForm(email, password, passwordConfirm);
        }
        throw new Exception("Some Error");
    }*/


    @When("I fill out the Registration Page with user Information <email> and <password>")
    public void fillOutEmailPW () {


    }

    @Then("<ErrorMessage> appears")
    public void errorMessageAppears () {
    }

    @When("I fill out the Registration Page with user Information <email>")
    public void fillOutEmailOnly () {
    }



}
