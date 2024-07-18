package hu.telekom.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserExistsPageObject extends BasePage {


    @FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/div/div[1]/h1")
    WebElement userExistLine;


    public UserExistsPageObject (WebDriver driver){
        super(driver);
    }


    public void verifyUserExistPage (String message) {
        assertEquals(userExistLine.getText(), message);

    }

}