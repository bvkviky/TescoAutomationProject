package hu.telekom.browser;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebBrowser {
    public WebBrowser() {
    }

    public static WebDriver createDriver(WebBrowserType type) {
        WebDriver driver = null;
        FirefoxOptions ffOptions = null;
        ChromeOptions chromeOptions = null;
        EdgeOptions edgeOptions = null;
        switch (type) {
            case Chrome:
                System.setProperty("webdriver.gecko.driver", WebBrowserSettings.getPathToChromeDriver());
                chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation", "disable-logging"});
                chromeOptions.setBinary(WebBrowserSettings.getPathToChrome());
                chromeOptions.addArguments(new String[]{"--remote-allow-origins=*"});
                chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
                driver = new ChromeDriver(chromeOptions);
                break;
            case Firefox:
                System.setProperty("webdriver.gecko.driver", WebBrowserSettings.getPathToGeckoDriver());
                ffOptions = new FirefoxOptions();
                ffOptions.setBinary(WebBrowserSettings.getPathToFirefox());
                ffOptions.addArguments("--disable-blink-features=AutomationControlled");
                driver = new FirefoxDriver(ffOptions);
                break;

            case EdgeWDM:
                edgeOptions = new EdgeOptions();
                edgeOptions.addArguments(new String[]{"--remote-allow-origins=*"});
                edgeOptions.setCapability("acceptInsecureCerts", true);
                edgeOptions.addArguments("--disable-blink-features=AutomationControlled");
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver(edgeOptions);
        }

        Capabilities capabilities = ((RemoteWebDriver)driver).getCapabilities();
        String webBrowserName = capabilities.getBrowserName();
        String webBrowserVersion = capabilities.getBrowserVersion();
        System.out.println("Browser is: " + webBrowserName + "  " + webBrowserVersion);
        return (WebDriver)driver;
    }
}