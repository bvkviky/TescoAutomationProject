package hu.telekom.pageobjects;

import hu.telekom.tests.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegSecondPageObject {

    WebDriver driver;



    //UI Elements
    @FindBy(xpath = "//div[@class='progress-bar__stage-number' and text()='2']")
    WebElement secondStepFinder;


    public RegSecondPageObject (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Methods
    @Then("Registration SecondPage will open")
    public void registrationSecondPageWillOpen () {
        secondStepFinder.isDisplayed();

    }
}
