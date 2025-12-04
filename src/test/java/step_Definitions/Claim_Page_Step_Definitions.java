package step_Definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_Object.Claim_Page;
import page_Object.Recruitment_Page;
import utils.DriverManager;

public class Claim_Page_Step_Definitions {

    private static final Logger logger =
            LogManager.getLogger(Recruitment_Page_Step_Definitions.class);

    private WebDriver driver;
    private Claim_Page claimPage;

    @Given("User clicks on the claim option")
    public void user_clicks_on_the_claim_option() {
        logger.info("Step: User clicks on Claim option");
        driver = DriverManager.getDriver();
        claimPage = new Claim_Page(driver);
        claimPage.clickClaimMenu();
    }
    @And("User clicks on assign claim button")
    public void user_clicks_on_assign_claim_button() {
        logger.info("Clicking on Assign Claim Button");
        claimPage.clickAssignClaimButton();
    }
    @And("User searched by {string} and select the result in the search box")
    public void user_searched_by_and_select_the_result_in_the_search_box(String name) throws InterruptedException {
        logger.info("select the name on the search box");
        claimPage.selectEmployeeName(name);

    }

    @And("User selects {string} from the event dropdown")
    public void user_selects_from_the_event_dropdown(String EventName) {
        claimPage.selectEventDropdownlist(EventName);

    }


    @And("User selects US Dollar from the currency dropdown")
    public void user_selects_us_dollar_from_the_currency_dropdown() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @And("User inputs cooments in the remarks input field")
    public void user_inputs_cooments_in_the_remarks_input_field() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @When("User clicks on create button")
    public void user_clicks_on_create_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Then("User verifies the claims has been created successfully")
    public void user_verifies_the_claims_has_been_created_successfully() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
