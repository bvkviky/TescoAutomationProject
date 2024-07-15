package hu.telekom.cucumber.steps;

import hu.telekom.pageobjects.HomePageObject;
import hu.telekom.tests.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationFirstSteps extends BaseTest {

    private HomePageObject homePage;

    @Given("I open Tesco website")
    public void iOpenTescoWebsite () {
        driver.get(baseURL);
        homePage = new HomePageObject(driver);
    }

    @And("I accept privacy policy")
    public void iAcceptPrivacyPolicy () {
        homePage.clicklOnPrivacyPolicy();
    }

    @Given("I click on Registration Button")
    public void iClickOnRegistrationButton () {
        homePage.clickOnRegistrationButton();
    }

    @When("I fill out the Registration Page with user Information <email> and <password> and <passwordConfirm>")
    public void iFillOutTheRegistrationPageWithUserInformationEmailAndPasswordAndPasswordConfirm () {
    }

    @And("click on next")
    public void clickOnNext () {
    }

    @Then("Registration SecondPage will open")
    public void registrationSecondPageWillOpen () {
    }

    @Then("Error Page opens with User exists Message")
    public void errorPageOpensWithUserExistsMessage () {
    }

    @When("I fill out the Registration Page with user Information <email> and <password>")
    public void iFillOutTheRegistrationPageWithUserInformationEmailAndPassword () {
    }

    @Then("<ErrorMessage> appears")
    public void errormessageAppear () {
    }

    @When("I fill out the Registration Page with user Information <email> and <password>, <passwordConfirm>")
    public void iFillOutTheRegistrationPageWithUserInformationEmailAndPasswordPasswordConfirm () {
    }
}
