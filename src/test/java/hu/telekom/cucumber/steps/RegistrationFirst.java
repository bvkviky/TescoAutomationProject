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

public class RegistrationFirst extends BaseTest {


    private HomePageObject homePage;
    private RegistrationFirstPageObject registrationFirstPageObject;


    @Before
    public void setup () {
        super.setup();
        homePage = new HomePageObject(driver);
    }

    @After
    public void tearDown () {
        super.tearDown();
    }




    @Given("Open TESCO website")
    public void openHomePage () {
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
        registrationFirstPageObject.clickOnNext();
    }

    @When("Register with User Information <email> and <password> and <passwordConfirm>")
    public void registration () {
        registrationFirstPageObject.registrationWithRandom();


    }
    @Then("<ErrorMessage> appears")
    public void errorMessageAppears () {
    }

    @When("register with {string} and {string}")
    public void registerWithTestData(String email, String password, String passwordConfirm) {
        registrationFirstPageObject.registration(email, password, passwordConfirm);


    }



  /*  @When("I fill out the Registration Page with user Information <email> and <password> and <passwordConfirm>")
    public void fillAllUserInformation (String email, String password, String passwordConfirm) throws Exception {
        if (email.equals("test@test.de")) {
            email = registrationFirstPageObject.generateRandomEmail();

            registrationFirstPageObject.fillOutRegistrationForm(email, password, passwordConfirm);
        }
        throw new Exception("Some Error");
    }*/


   /* @When("I fill out the Registration Page with user Information <email> and <password>")
    public void fillOutEmailPW () throws Exception {

        String randomEmail = registrationFirstPageObject.generateRandomEmail();
        String password = registrationFirstPageObject.generatePassword();

        registrationFirstPageObject.registration(randomEmail, password, password);
    }*/



   /* @When("I fill out the Registration Page with user Information <email>")
    public void fillOutEmailOnly () throws Exception {
        String randomEmail = registrationFirstPageObject.generateRandomEmail();

        registrationFirstPageObject.fillOutRegistrationForm(randomEmail, "", "");
    }*/
}