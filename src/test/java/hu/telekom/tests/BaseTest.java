package hu.telekom.tests;

import hu.telekom.browser.WebBrowser;
import hu.telekom.browser.WebBrowserSettings;
import hu.telekom.browser.WebBrowserType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaseTest {


        protected WebDriver driver;
        protected String baseURL;
        protected WebBrowserType webBrowserType;

        @BeforeEach
        public void setup() {
            webBrowserType = WebBrowserType.Chrome;
            driver = WebBrowser.createDriver(webBrowserType);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            baseURL = WebBrowserSettings.getBaseURL();
        }

        @AfterEach
        public void tearDown() {
            driver.quit();
        }
    }


