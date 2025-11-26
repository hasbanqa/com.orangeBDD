package page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Config;

public class Login_Page extends Base_Page {

    // Locators for OrangeHRM login page
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton   = By.xpath("//button[@type='submit']");
    private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");

    public Login_Page(WebDriver driver) {
        super(driver);
    }

    public void openHomePage() {
        String url = Config.getBaseUrl();
        logger.info("Navigating to OrangeHRM login page: {}", url);
        driver.get(url);
    }

    public void loginAs(String username, String password) {
        logger.info("Logging in with username: {}", username);
        type(usernameField, username, "Username field");
        type(passwordField, password, "Password field");
        click(loginButton, "Login button");
    }

    public boolean isDashboardVisible() {
        try {
            waitForVisible(dashboardHeader);
            logger.info("Dashboard header is visible.");
            return true;
        } catch (Exception e) {
            logger.error("Dashboard header is NOT visible.", e);
            return false;
        }
    }
}
