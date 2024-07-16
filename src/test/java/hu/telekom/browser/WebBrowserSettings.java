package hu.telekom.browser;

public class WebBrowserSettings {
    private static final String pathToGeckoDriver = "c:\\DT\\WebBrowsers\\FirefoxDriver\\126\\geckodriver.exe";
    private static final String pathToFirefox = "c:\\DT\\WebBrowsers\\FirefoxBin\\126\\App\\Firefox64\\firefox.exe";
    private static final String pathToChromeDriver = "c:\\DT\\WebBrowsers\\ChromeDriver\\125\\chromedriver.exe";
    private static final String pathToChrome = "c:\\DT\\WebBrowsers\\ChromeBin\\125\\App\\Chrome-bin\\chrome.exe";
    private static final String baseURL = "https://bevasarlas.tesco.hu/groceries/en-GB";
    private static final String pathToScreenshots = "c:\\DT\\Screenshots\\";

    private static final String EMAIL = "";
    private static final String PASSWORD = "";

    public WebBrowserSettings() {
    }

    public static String getPathToGeckoDriver() {
        return pathToGeckoDriver;
    }

    public static String getPathToFirefox() {
        return pathToFirefox;
    }

    public static String getPathToChromeDriver() {
        return pathToChromeDriver;
    }

    public static String getPathToChrome() {
        return pathToChrome;
    }

    public static String getBaseURL() {
        return baseURL;
    }

    public static String getPathToScreenshots() {
        return pathToScreenshots;
    }

    public static String getEmail() {
        return EMAIL;
    }
    public static String getPassword() {
        return PASSWORD;
    }
}



