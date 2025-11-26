package step_Definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page_Object.PIM_Page;
import utils.DriverManager;

public class PIM_Page_Step_Definitions {

    private static final Logger logger =
            LogManager.getLogger(PIM_Page_Step_Definitions.class);

    private WebDriver driver;
    private PIM_Page pimPage;

    // We’ll keep the generated ID so you can use it later if needed
    private String generatedEmployeeId;

    // -----------------------------
    // PIM navigation + Add employee
    // -----------------------------

    @And("User navigates to PIM options")
    public void user_navigates_to_pim_options() {
        driver = DriverManager.getDriver();
        pimPage = new PIM_Page(driver);

        logger.info("Navigating to PIM menu...");
        pimPage.navigateToPIM();
    }

    @And("User clicks on Add Employee button")
    public void user_clicks_on_add_employee_button() {
        logger.info("Clicking on 'Add Employee' button...");
        pimPage.clickAddEmployee();
    }

    // -----------------------------
    // Name fields
    // -----------------------------

    @And("User inserts first name in the first name field")
    public void user_inserts_first_name_in_the_first_name_field() {
        String firstName = "John";  // simple example
        logger.info("Entering first name: {}", firstName);
        pimPage.enterFirstName(firstName);
    }

    @And("User inserts middle name in the middle name field")
    public void user_inserts_middle_name_in_the_middle_name_field() {
        String middleName = "A";
        logger.info("Entering middle name: {}", middleName);
        pimPage.enterMiddleName(middleName);
    }

    @And("User inserts last name in the last name field")
    public void user_inserts_last_name_in_the_last_name_field() {
        String lastName = "Doe";
        logger.info("Entering last name: {}", lastName);
        pimPage.enterLastName(lastName);
    }

    // -----------------------------
    // Employee ID
    // -----------------------------

    @And("User inserts a random employee ID in the employee ID field")
    public void user_inserts_a_random_employee_id_in_the_employee_id_field() {
        // Very simple random ID
        generatedEmployeeId = "EMP" + System.currentTimeMillis();
        logger.info("Entering random employee ID: {}", generatedEmployeeId);
        pimPage.enterRandomEmployeeId(generatedEmployeeId);
    }

    // -----------------------------
    // Login details
    // -----------------------------

    @And("user clicks on create login details toggle on options")
    public void user_clicks_on_create_login_details_toggle_on_options() {
        logger.info("Clicking on 'Create Login Details' toggle...");
        pimPage.toggleCreateLoginDetails();
    }

    @And("user inputs user name in the user name field")
    public void user_inputs_user_name_in_the_user_name_field() {
        // You can build username from generatedEmployeeId if you want
        String username = "emp_" + (generatedEmployeeId != null ? generatedEmployeeId : "user");
        logger.info("Entering login username: {}", username);
        pimPage.enterLoginUsername(username);
    }

    @And("user inputs password in the password field")
    public void user_inputs_password_in_the_password_field() {
        String password = "Password!1";
        logger.info("Entering login password.");
        pimPage.enterLoginPassword(password);
    }

    @And("user inputs password in the confirm password field")
    public void user_inputs_password_in_the_confirm_password_field() {
        String password = "Password!1";
        logger.info("Entering confirm password.");
        pimPage.enterConfirmPassword(password);
    }

    // -----------------------------
    // Save + verification
    // -----------------------------

    @When("User clicks on the save button")
    public void user_clicks_on_the_save_button() {
        logger.info("Clicking Save button...");
        pimPage.clickSave();
    }

    @Then("User verifies the employee has been added successfully")
    public void user_verifies_the_employee_has_been_added_successfully() {
        logger.info("Verifying that employee was added successfully...");
        boolean success = pimPage.isEmployeeAddedSuccessfully();

        Assert.assertTrue(
                success,
                "Employee was NOT added successfully – Personal Details header not visible."
        );

        logger.info("Employee added successfully.");
    }
}
