package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.service.ExtentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks {

    private static final Logger logger = LogManager.getLogger(Hooks.class);
    private static boolean systemInfoSet = false;

    // ------------------------------
    // 1) Extent System Info
    // ------------------------------
    @Before(order = 0)
    public void setUpSystemInfo() {

        if (!systemInfoSet) {
            logger.info("Setting Extent system info...");

            ExtentService.getInstance().setSystemInfo("OS", System.getProperty("os.name"));
            ExtentService.getInstance().setSystemInfo("User", System.getProperty("user.name"));

            String env = System.getProperty("env", "QA").toUpperCase();
            ExtentService.getInstance().setSystemInfo("Environment", env);

            systemInfoSet = true;
            logger.info("Extent system info set successfully.");
        }
    }

    // ------------------------------
    // 2) WebDriver Setup
    // ------------------------------
    @Before(order = 1)
    public void setUp() {
        logger.info("Starting WebDriver...");
        DriverManager.initDriver();
    }

    // ------------------------------
    // 3) WebDriver Teardown + Screenshot
    // ------------------------------
    @After
    public void tearDown(Scenario scenario) {

        WebDriver driver = null;

        try {
            driver = DriverManager.getDriver();
        } catch (Exception ex) {
            logger.error("Driver was not initialized!");
        }

        if (driver != null && scenario.isFailed()) {
            logger.error("Scenario FAILED: " + scenario.getName());

            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failure Screenshot");

                logger.info("Screenshot captured and attached.");
            } catch (Exception e) {
                logger.error("Screenshot capture failed!", e);
            }
        }

        logger.info("Closing WebDriver...");
        DriverManager.quitDriver();
    }
}
