package hu.telekom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {
    WebDriver driver;


    //UI Elements
    @FindBy(xpath = "//span[text()='Accept all cookies']")
    WebElement privacyPolicyElement;

    @FindBy(xpath = "//span[text()='Register']")
    WebElement registrationButtonElement;




    public HomePageObject (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //Methods
    public void clickOnPrivacyPolicy () {
        privacyPolicyElement.click();
    }

    public void clickOnRegistrationButton () {
        registrationButtonElement.click();
    }
}
