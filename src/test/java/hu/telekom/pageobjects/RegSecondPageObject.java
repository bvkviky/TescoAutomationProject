package hu.telekom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegSecondPageObject extends BasePage {


    @FindBy(xpath = "//div[@class='progress-bar__stage-number' and text()='2']")
    WebElement secondStepFinder;


    public RegSecondPageObject (WebDriver driver) {
        super(driver);
    }

    public void checkSecondPage () {

        secondStepFinder.isDisplayed();

    }
}
