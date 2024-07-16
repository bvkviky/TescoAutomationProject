package hu.telekom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {
    WebDriver driver;


    //UI Elements
    @FindBy(xpath = "//button[@class='styled__StyledTextButton-sc-8hxn3m-0 jyQVJq ddsweb-cookies-notification__button ddsweb-button ddsweb-button--text-button' and span='Accept all cookies']")
    WebElement privacyPolicyElement;

    @FindBy(xpath = "//a[@class='button button-secondary']")
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
