package step_Definitions;


import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_Object.PersonalDetails_Page;
import utils.DriverManager;

public class PersonalDetails_Step_Definitions {

    private static final Logger logger =
            LogManager.getLogger(PersonalDetails_Step_Definitions.class);


    private WebDriver driver;
    private PersonalDetails_Page personalDetails_page;

    @And("User navigates to My Info page")
    public void user_navigates_to_my_info_page() {

        driver = DriverManager.getDriver();
        personalDetails_page = new PersonalDetails_Page(driver);
        personalDetails_page.openMyInfo();

    }
    @And("User inputs first name {string} in the first name field")
    public void user_inputs_first_name_in_the_first_name_field(String firstName) {
    personalDetails_page.enterFirstName(firstName);
    }

    @And("User inputs middle name {string} in the middle name field")
    public void user_inputs_middle_name_in_the_middle_name_field(String middleName) {
        personalDetails_page.enterMiddleName(middleName);
    }

    @And("User inputs last name {string} in the last name field")
    public void user_inputs_last_name_in_the_last_name_field(String lastName) {
        personalDetails_page.enterLastName(lastName);
    }

    @And("User selects marital status {string} in the dropdown")
    public void user_selects_marital_status_in_the_dropdown(String status) {

        personalDetails_page.selectMaritalStatus(status);
    }

    @And("User clicked on save button")
    public void user_clicked_on_save_button() {

    personalDetails_page.clickSave();
    }
    @And("User verifies the information has been saved")
    public void user_verifies_the_information_has_been_saved() {

    }


}
