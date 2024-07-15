package hu.telekom.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SampleSteps {
    public int numberOfCucumbers = 0;

    //@Given("^there are (.*) cucumbers$") //regular expression
    @Given("there are {int} cucumbers") //cucumber expression
    public void thereAreCucumbers(int input) {
        numberOfCucumbers = input;
    }

    @When("I eat {int} cucumber(s)")
    public void iEatCucumbers(int cucumbersEaten) {
        numberOfCucumbers -= cucumbersEaten;
    }

    @Then("I should have left {int} cucumbers")
    public void iShouldHaveLeftCucumbers(int expectedNumberOfCucumbers) {
        Assertions.assertEquals(expectedNumberOfCucumbers, numberOfCucumbers);
    }
}
