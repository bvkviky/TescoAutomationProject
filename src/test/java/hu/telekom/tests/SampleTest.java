package hu.telekom.tests;

import org.junit.jupiter.api.Test;

public class SampleTest extends BaseTest {
    @Test
    public void sampleTest() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(2000);
    }
}
