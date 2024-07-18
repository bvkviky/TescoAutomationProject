package hu.telekom.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserExistsPageObject extends BasePage {


    @FindBy(xpath = "//h1[text()='Ezt az email címet már regisztráltuk!']")
    WebElement userExistLine;


    public UserExistsPageObject (WebDriver driver){
        super(driver);
    }


    public void verifyUserExistPage (String message) {
        assertEquals(userExistLine, message);

    }
}
