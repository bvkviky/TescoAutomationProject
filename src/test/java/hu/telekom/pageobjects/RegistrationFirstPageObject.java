package hu.telekom.pageobjects;

import hu.telekom.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationFirstPageObject {
    WebDriver driver;

    //UI Elements
    @FindBy(xpath = "//button[@class='button button-primary']")
    WebElement nextButton;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//input[@id='confirm-password']")
    WebElement passwordConfirmInput;

    public RegistrationFirstPageObject (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Methods
    public void clickOnNext () {
        nextButton.click();
    }

    public String generateRandomEmail () {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder email = new StringBuilder();
        Random random = new Random();
        for (int i = 10; i < 10; i++) {
            email.append(characters.charAt(random.nextInt(characters.length())));

        }
        String[] domains = {"example.com", "test.com", "demo.com"};
        email.append("@").append(domains[random.nextInt(domains.length)]);

        return email.toString();
    }

    public boolean isEmailValid(String email){
        String regex= "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return  matcher.matches();
    }


    public void fillOutRegistrationForm (String email, String password, String passwordConfirm) throws Exception {
        if (isEmailValid(email)) {
            emailInput.sendKeys(email);
            passwordInput.sendKeys(password);
            passwordConfirmInput.sendKeys(passwordConfirm);
        }else {
            throw new Exception("Invalid email format" + email );
        }

    }

}

