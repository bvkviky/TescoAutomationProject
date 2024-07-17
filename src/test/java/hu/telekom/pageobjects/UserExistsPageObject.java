package hu.telekom.pageobjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserExistsPageObject {
    WebDriver driver;


//UI

    @FindBy(xpath = "//h1[text()='Ezt az email címet már regisztráltuk!']")
    WebElement userExistLine;


    public UserExistsPageObject (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //Methods
    public void  verifyUserExistPage (){

        assertEquals("Ezt az email címet már regisztráltuk!", userExistLine.getText());

    }
}
