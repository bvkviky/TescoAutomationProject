package hu.telekom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationFirstPageObject {
    WebDriver driver;

    //UI Elements
    @FindBy(xpath = "//span[text()='Next']")
    WebElement nextButton;

    public RegistrationFirstPageObject (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Methods
    public void clickOnNext () {
        nextButton.click();
    }
}
