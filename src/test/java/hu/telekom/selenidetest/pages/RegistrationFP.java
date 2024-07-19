package hu.telekom.selenidetest.pages;

import com.codeborne.selenide.SelenideElement;
import hu.telekom.pageobjects.BasePage;
import hu.telekom.pageobjects.RegSecondPageObject;
import hu.telekom.pageobjects.UserExistsPageObject;
import org.openqa.selenium.WebDriver;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationFP extends BasePage {
    private SelenideElement nextButton = $x("//button[@class='button button-primary']");
    private SelenideElement emailInput = $("#email");
    private SelenideElement passwordInput = $("#password");
    private SelenideElement passwordConfirmInput = $("#confirm-password");
    private SelenideElement atLeastOneNumberError = $x("//*[@id=\"content\"]/div/div[1]/div/div[2]/section/div/div/form/ul/li[2]/div/div/ul/li");
    private SelenideElement atLeastOneNumberAndCharacterError = $x("//*[@id=\"content\"]/div/div[1]/div/div[2]/section/div/div/form/ul/li[2]/div/div/ul/li[1]");
    private SelenideElement atLeastOneCharacter = $x("//*[@id=\"content\"]/div/div[1]/div/div[2]/section/div/div/form/ul/li[2]/div/div/ul/li");

    public RegistrationFP (WebDriver driver) {
        super(driver);
    }

    public void clickOnNext() {
        nextButton.click();
    }

    public String generatePassword() {
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

    public String generateRandomEmail() {
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

    public UserExistsPageObject registrationWithExisting(String email, String password) {
        emailInput.setValue(email);
        passwordInput.setValue(password);
        passwordConfirmInput.setValue(password);
        clickOnNext();
        return new UserExistsPageObject();
    }

    public RegSecondPageObject registration() {
        String password = generatePassword();
        emailInput.setValue(generateRandomEmail());
        passwordInput.setValue(password);
        passwordConfirmInput.setValue(password);
        clickOnNext();
        return new RegSecondPageObject();
    }

    public void validateErrorMessage(String expectedErrorMessage) {
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
}


