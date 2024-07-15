package hu.telekom.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationFirstSteps {
    @Given("I open Tesco website")
    public void iOpenTescoWebsite () {
    }

    @And("I accept privacy policy")
    public void iAcceptPrivacyPolicy () {
    }

    @Given("I click on Registration Button")
    public void iClickOnRegistrationButton () {
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
