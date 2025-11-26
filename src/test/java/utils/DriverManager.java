package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static final Logger logger = LogManager.getLogger(DriverManager.class);
    private static WebDriver driver;

    public static void initDriver() {
        if (driver == null) {
            String browser = Config.getProperty("browser");
            logger.info("Initializing WebDriver. Browser from config: {}", browser);

            if (browser == null || browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                logger.info("Chrome browser launched and maximized.");
            } else {
                logger.error("Unsupported browser: {}", browser);
                throw new RuntimeException("Unsupported browser: " + browser);
            }
        } else {
            logger.warn("Driver already initialized. Reusing existing instance.");
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            logger.error("getDriver() called but driver is null. Did you forget to call initDriver()?");
            throw new IllegalStateException("Driver not initialized. Call initDriver() first.");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            logger.info("Quitting WebDriver...");
            driver.quit();
            driver = null;
            logger.info("WebDriver quit successfully.");
        } else {
            logger.warn("quitDriver() called but driver was already null.");
        }
    }
}
