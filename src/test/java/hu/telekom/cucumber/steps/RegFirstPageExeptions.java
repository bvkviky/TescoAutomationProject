package hu.telekom.cucumber.steps;

import hu.telekom.pageobjects.HomePageObject;
import hu.telekom.pageobjects.RegistrationFirstPageObject;
import hu.telekom.tests.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegFirstPageExeptions extends BaseTest {
   
    private RegistrationFirstPageObject registrationFirstPageObject;
    private String actualErrorMessage;

    public  RegistrationFirstPageObject getRegistrationFirstPageObject () {
        return registrationFirstPageObject;
    }



    @When("register with user Information <email> and <password>")
    public void registerWithUserInformationEmailAndPassword (String email, String password) {

    }

    @Then("<ErrorMessage> appears")
    public void errormessageAppears () {

    }

}
