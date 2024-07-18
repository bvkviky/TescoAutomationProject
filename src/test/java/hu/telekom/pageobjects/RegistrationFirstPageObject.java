package hu.telekom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class RegistrationFirstPageObject {
    WebDriver driver;
    private String errorMessage;
    private WebDriverWait wait;



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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//li[text()='A jelszónak tartalmaznia kell legalább egy számot.']")
    WebElement atLeastOneNumberError;

    @FindBy(xpath = "//li[text()='A jelszónak legalább 8 karakter hosszúnak kell lennie és tartalmaznia kell legalább egy betűt és egy számot.']")
    WebElement atLeastOneNumberAndCharacterError;


    //Methods
    public void nextButton () {
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

   /* public boolean isEmailValid(String email){
        String regex= "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return  matcher.matches();
    }*/


    public void registration (String email, String password) {


        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        passwordConfirmInput.sendKeys(password);


        if (password.length() < 8) {
            errorMessage = "A jelszónak legalább 8 karakter hosszúnak kell lennie és tartalmaznia kell legalább egy betűt és egy számot.";

        } else if (!password.matches(".*\\d.*")) {
            errorMessage = "A jelszónak tartalmaznia kell legalább egy számot.";
        } else if (!password.matches(".*[a-zA-Z].*")) {
        } else {
            errorMessage = "";
            WebElement nextB = wait.until(ExpectedConditions.elementToBeClickable(nextButton));
            nextB.click();


        }
    }


    public void registrationWithRandom () {
        registration(generateRandomEmail(), generatePassword());

    }

    public void navigateUserExistPage () {
        new UserExistsPageObject(driver);

    }


    public String getErrorMessage () {
        return errorMessage;
    }

}



