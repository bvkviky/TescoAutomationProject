package hu.telekom.cucumber.steps;

import hu.telekom.pageobjects.HomePageObject;
import hu.telekom.pageobjects.RegistrationFirstPageObject;
import hu.telekom.tests.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegFirstPageExeptions extends BaseTest {


    private HomePageObject homePage;
    private RegistrationFirstPageObject registrationFirstPageObject;
    private String actualErrorMessage;



    public RegFirstPageExeptions(){
        this.registrationFirstPageObject= new RegistrationFirstPageObject(driver);
    }



    @When("register with user Information {string} and {string}")
    public void registerWithUserInformationEmailAndPassword (String email, String password) {
        registrationFirstPageObject.registration(email, password);
        actualErrorMessage = registrationFirstPageObject.getErrorMessage();


    }

    @Then("{string} appears")
    public void errorMessages (String expectedMessage) {
        assertEquals(expectedMessage, actualErrorMessage);

    }



}
