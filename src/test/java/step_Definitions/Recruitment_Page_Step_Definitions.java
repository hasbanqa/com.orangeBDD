package step_Definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page_Object.Recruitment_Page;
import utils.DriverManager;

/**
 * Step definitions for Recruitment feature.
 */
public class Recruitment_Page_Step_Definitions {

    private static final Logger logger =
            LogManager.getLogger(Recruitment_Page_Step_Definitions.class);

    private WebDriver driver;
    private Recruitment_Page recruitmentPage;

    /** Creates page object when we first land on Recruitment. */
    @And("User clicks on Recruitment option")
    public void user_clicks_on_recruitment_option() {
        logger.info("Step: User clicks on Recruitment option");
        driver = DriverManager.getDriver();
        recruitmentPage = new Recruitment_Page(driver);   // <-- important
        recruitmentPage.clickRecruitmentMenu();
    }

    @And("User search {string} in the candidate name search box")
    public void user_search_in_the_candidate_name_search_box(String name) {
        recruitmentPage.searchCandidateByName(name);

    }
    @And("User selects the candidate name from the auto suggestive dropdown menu")
    public void user_selects_the_candidate_name_from_the_auto_suggestive_dropdown_menu() {
    recruitmentPage.selectCandidateFromAutoSuggest("John Doe");
    recruitmentPage.selectFirstCandidateFromResultList();
    }
    @And("User clicks on delete button")
    public void user_clicks_on_delete_button() {
    recruitmentPage.clickDeleteButton();
    }
    @Then("User verifies the candidate has been deleted successfully")
    public void user_verifies_the_candidate_has_been_deleted_successfully() {
        Assert.assertTrue(
                recruitmentPage.isDeleteSuccessMessageDisplayed(),
                "Success message was not displayed"
                );
    }
}
