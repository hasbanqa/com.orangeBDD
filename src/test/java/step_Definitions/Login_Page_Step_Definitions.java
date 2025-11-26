package step_Definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page_Object.Login_Page;
import utils.DriverManager;

public class Login_Page_Step_Definitions {

    private static final Logger logger = LogManager.getLogger(Login_Page_Step_Definitions.class);

    private WebDriver driver;
    private Login_Page loginPage;

    @Given("User is on the Orange Home Page")
    public void user_is_on_the_orange_home_page() {
        logger.info("Step: User is on the Orange home page");
        driver = DriverManager.getDriver();
        loginPage = new Login_Page(driver);
        loginPage.openHomePage();
    }
     @When("User logs in with {string} and {string}")
    public void user_logs_in_with_and(String username, String password) {
        logger.info("Step: User logs in with username '{}' and password '********'", username);
        loginPage.loginAs(username, password);
    }

    @Then("User should see the dashboard")
    public void user_should_see_the_dashboard() {
        logger.info("Step: User should see the dashboard");
        boolean visible = loginPage.isDashboardVisible();
        Assert.assertTrue(visible, "Dashboard was not displayed after login.");
        logger.info("Dashboard visibility assertion passed.");
    }
}
