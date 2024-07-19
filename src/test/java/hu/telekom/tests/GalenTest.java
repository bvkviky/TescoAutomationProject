package hu.telekom.tests;

import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import hu.telekom.browser.WebBrowser;
import hu.telekom.browser.WebBrowserType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GalenTest extends BaseTest {

    WebDriver driver;
    LayoutReport layoutReport;

    @BeforeEach
    public void initializeDriver () {
        driver = WebBrowser.createDriver(WebBrowserType.Chrome);
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @Test
    public void layoutTest () throws IOException {
        String pathToSpecFile ="src/test/java/hu/telekom/galen/specs/homePageLayout.gspec";
        String[] tags = {"desktop"};
        layoutReport = Galen.checkLayout(driver, pathToSpecFile, Arrays.asList(tags));
        System.out.println(layoutReport);
    }

    public void buildReport () throws IOException {
        List<GalenTestInfo> testInfoList = new ArrayList<>();
        GalenTestInfo testInfo = GalenTestInfo.fromString("Tesco GalenTest");
        testInfo.getReport().layout(layoutReport, "Tesco HamePage oldal layout tesztje");
        testInfoList.add(testInfo);
        new HtmlReportBuilder().build(testInfoList, "target/galen-test-report");
    }

    @AfterEach
    public void close () throws IOException {
        buildReport();
        driver.quit();
    }

}


