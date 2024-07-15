package hu.telekom.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LanguageSetSteps {
    @Given("I open BKK website")
    public void iOpenBKKWebsite () {
    }

    @Given("language is set to {string}")
    public void languageIsSetToEnglish () {
    }

    @When("I click on the {string} flag")
    public void iClickOnTheHungarianFlag () {
    }

    @Then("language is changed to {string}")
    public void languageIsChangedToHungarian () {
    }
}
