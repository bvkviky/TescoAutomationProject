package hu.telekom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationFirstPageObject extends BasePage {

    public RegistrationFirstPageObject (WebDriver driver) {
        super(driver);
        isLoaded(emailInput);
        isLoaded(emailInput);


    }

    //UI Elements
    @FindBy(xpath = "//button[@class='button button-primary']")
    WebElement nextButton;

    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement emailInput;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//input[@id='confirm-password']")
    WebElement passwordConfirmInput;


    @FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/div/div[2]/section/div/div/form/ul/li[2]/div/div/ul/li")
    WebElement atLeastOneNumberError;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/div/div[2]/section/div/div/form/ul/li[2]/div/div/ul/li[1]")
    WebElement atLeastOneNumberAndCharacterError;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/div/div[2]/section/div/div/form/ul/li[2]/div/div/ul/li")
    WebElement atLeastOneCharacter;


    //Methods
    public void clickOnNext () {
        nextButton.click();
    }

    public String generatePassword () {
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String allCharacters = upperCaseLetters + lowerCaseLetters + numbers;

        StringBuilder password = new StringBuilder();
        Random random = new Random();

        password.append(upperCaseLetters.charAt(random.nextInt(upperCaseLetters.length())));
        password.append(lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length())));
        password.append(numbers.charAt(random.nextInt(numbers.length())));

        for (int i = 3; i < 8; i++) {
            password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }
        char[] passwordArray = password.toString().toCharArray();
        for (int i = 0; i < passwordArray.length; i++) {
            int randomIndex = random.nextInt(passwordArray.length);
            char temp = passwordArray[i];
            passwordArray[i] = passwordArray[randomIndex];
            passwordArray[randomIndex] = temp;
        }

        return new String(passwordArray);

    }

    public String generateRandomEmail () {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder email = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            email.append(characters.charAt(random.nextInt(characters.length())));

        }
        String[] domains = {"example.com", "test.com", "demo.com"};
        email.append("@").append(domains[random.nextInt(domains.length)]);

        return email.toString();
    }


    public UserExistsPageObject registration (String email, String password) {

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        passwordConfirmInput.sendKeys(password);
        nextButton.click();
        return new UserExistsPageObject(driver);

    }


    public void registrationWithRandom () {
        registration(generateRandomEmail(), generatePassword());

    }


    public void validateErrorMessage (String expectedErrorMessage) {


        if (atLeastOneNumberError.isDisplayed()) {
            assertEquals(expectedErrorMessage, atLeastOneNumberError.getText());
        } else if (atLeastOneCharacter.isDisplayed()) {
            assertEquals(expectedErrorMessage, atLeastOneCharacter.getText());
        } else if (atLeastOneNumberAndCharacterError.isDisplayed()) {
            assertEquals(expectedErrorMessage, atLeastOneNumberAndCharacterError.getText());
        } else {
            throw new AssertionError("Valami nem jó...");
        }
    }

    public RegSecondPageObject navigateToSecondStep () {
        nextButton.click();
        return new RegSecondPageObject(driver);
    }
}



