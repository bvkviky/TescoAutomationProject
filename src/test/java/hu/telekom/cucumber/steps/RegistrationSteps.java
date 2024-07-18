package hu.telekom.cucumber.steps;

import hu.telekom.pageobjects.HomePageObject;
import hu.telekom.pageobjects.RegistrationFirstPageObject;
import hu.telekom.pageobjects.UserExistsPageObject;
import hu.telekom.tests.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationSteps extends BaseTest {


    private HomePageObject homePage;
    private RegistrationFirstPageObject registrationFirstPageObject;
    private UserExistsPageObject userExistsPageObject;


    @Before
    public void setup () {
        super.setup();

    }

    @After
    public void tearDown () {
        super.tearDown();
    }


    @Given("Open TESCO website")
    public void openHomePage () {
        homePage = new HomePageObject(driver);
        driver.get(baseURL);
    }

    @Given("Accept privacy policy")
    public void acceptPolicy () {
        homePage.acceptPolicy();
    }

    @Given("navigate to Registration Page")
    public void navigateToRegistrationPage () {
        registrationFirstPageObject = homePage.navigateToRegistration();

    }

    @And("click on next")
    public void clickOnNext () {
        registrationFirstPageObject.nextButton();
    }



    @When("register with User Information {string} and {string}")
    public void registration (String email, String password) {
        registrationFirstPageObject.registration(email, password);


    }

    @Then("New Page opens with User exists Message {string}")
    public void navigateUserExistPage (String message) {
        userExistsPageObject.verifyUserExistPage(message);
    }

    @Then("{string} appears")
    public void errorMessages (String expectedMessage) {
        registrationFirstPageObject.validateErrorMessage();


    }

}