package page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

public class PIM_Page extends Base_Page {

    // Left menu
    private By pimMenu = By.xpath("//span[text()='PIM']");

    // PIM screen
    private By addEmployeeButton = By.xpath("//a[contains(@href,'pim/addEmployee') or .='Add Employee' or .//button[text()='Add']]");
    // In OrangeHRM demo, the Add button is usually:
    // private By addEmployeeButton = By.xpath("//button[.=' Add ']");

    // Add Employee fields
    private By firstNameField  = By.name("firstName");
    private By middleNameField = By.name("middleName");
    private By lastNameField   = By.name("lastName");
    private By employeeIdField = By.xpath("//label[text()='Employee Id']/../following-sibling::div//input");

    // Create Login Details toggle + fields
    private By createLoginToggle = By.xpath("//input[@type='checkbox']/following-sibling::span[contains(@class,'oxd-switch-input')]");
    private By loginUsernameField = By.xpath("//label[text()='Username']/../following-sibling::div//input");
    private By loginPasswordField = By.xpath("//label[text()='Password']/../following-sibling::div//input");
    private By loginConfirmPasswordField = By.xpath("//label[text()='Confirm Password']/../following-sibling::div//input");

    // Save button
    private By saveButton = By.xpath("//button[@type='submit']");

    // Success indicator – simple approach: success toast or Personal Details header
    private By successToast = By.xpath("//p[contains(@class,'oxd-text--toast-title') and text()='Success']");
    private By personalDetailsHeader = By.xpath("//h6[text()='Personal Details']");

    public PIM_Page(WebDriver driver) {
        super(driver);
    }

    public void navigateToPIM() {
        click(pimMenu, "PIM menu");
    }

    public void clickAddEmployee() {
        click(addEmployeeButton, "Add Employee button");
    }

    public void enterFirstName(String firstName) {
        type(firstNameField, firstName, "First name field");
    }

    public void enterMiddleName(String middleName) {
        type(middleNameField, middleName, "Middle name field");
    }

    public void enterLastName(String lastName) {
        type(lastNameField, lastName, "Last name field");
    }

    public String enterRandomEmployeeId(String generatedEmployeeId) {
        String randomId = UUID.randomUUID().toString().substring(0, 6);
        type(employeeIdField, randomId, "Employee ID field");
        logger.info("Random Employee ID used: {}", randomId);
        return randomId;
    }

    public void toggleCreateLoginDetails() {
        click(createLoginToggle, "Create Login Details toggle");
    }

    public void enterLoginUsername(String username) {
        type(loginUsernameField, username, "Login username field");
    }

    public void enterLoginPassword(String password) {
        // Only type into the login password field
        type(loginPasswordField, password, "Login password field");
    }

    public void enterConfirmPassword(String password) {
        // Only type into the confirm password field
        type(loginConfirmPasswordField, password, "Confirm password field");
    }


    public void clickSave() {
        click(saveButton, "Save button");
    }

    public boolean isEmployeeAddedSuccessfully() {
        try {
            // Check either toast or Personal Details header
            try {
                waitForVisible(successToast);
                logger.info("Success toast is visible.");
                return true;
            } catch (Exception e) {
                // fallback
                waitForVisible(personalDetailsHeader);
                logger.info("Personal Details header is visible.");
                return true;
            }
        } catch (Exception e) {
            logger.error("Employee add success indicator not found.", e);
            return false;
        }
    }
}
