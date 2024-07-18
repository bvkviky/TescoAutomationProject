package hu.telekom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObject extends BasePage{


    public HomePageObject (WebDriver driver) {
        super(driver);
    }



    //UI Elements
    @FindBy(xpath = "//button[@class='styled__StyledTextButton-sc-8hxn3m-0 jyQVJq ddsweb-cookies-notification__button ddsweb-button ddsweb-button--text-button' and span='Minden Cookie elfogadása']")
    WebElement privacyPolicyElement;

    @FindBy(xpath = "//a[@class='button button-secondary']")
    WebElement registrationButtonElement;





    //Methods
    public void acceptPolicy () {
        privacyPolicyElement.click();
    }

    public RegistrationFirstPageObject  navigateToRegistration() {
        registrationButtonElement.click();
        return new RegistrationFirstPageObject(driver);
    }
}
