package hu.telekom.tests;

import hu.telekom.browser.WebBrowser;
import hu.telekom.browser.WebBrowserSettings;
import hu.telekom.browser.WebBrowserType;
import hu.telekom.pageobjects.HomePageObject;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected WebDriver driver;
    protected String baseURL;
    protected WebBrowserType webBrowserType;
    protected HomePageObject homePageObject;

    @BeforeAll
    public void setup () {
        webBrowserType = WebBrowserType.Chrome;
        driver = WebBrowser.createDriver(webBrowserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        baseURL = WebBrowserSettings.getBaseURL();
        driver.get(baseURL);


    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}


