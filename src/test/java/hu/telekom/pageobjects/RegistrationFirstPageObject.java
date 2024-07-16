package hu.telekom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

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

    public String  generateRandomEmail(){
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder email = new StringBuilder();
        Random random = new Random();
        for(int i =10; i < 10; i++ ) {
            email.append(characters.charAt(random.nextInt(characters.length())));

        }
        String[] domains = {"example.com", "test.com", "demo.com"};
        email.append("@").append(domains[random.nextInt(domains.length)]);

        return email.toString();
    }


    public void fillOutRegistrationForm (String email, String password, String passwordConfirm) {

        }

    }

