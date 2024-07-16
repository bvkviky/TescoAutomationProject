package hu.telekom.tests;

import hu.telekom.pageobjects.RegistrationFirstPageObject;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SampleTest extends BaseTest {


    @Test
    public void sampleTest () throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(2000);
    }
}

