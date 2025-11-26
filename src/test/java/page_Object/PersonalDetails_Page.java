package page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PersonalDetails_Page extends Base_Page {

    public PersonalDetails_Page(WebDriver driver) {
        super(driver);
    }
    private final By myInfoMenu        = By.xpath("//span[text()='My Info']");
    private By firstNameField          = By.name("firstName");
    private By middleNameField         = By.name("middleName");
    private By lastNameField           = By.name("lastName");
    private By maritalStatusDrop       = By.xpath("//label[text()='Marital Status']//../following-sibling::div//div[contains(@class,'select-text-input')]");
    private By maritalStatusOption (String status){
        return By.xpath("//div[@role='listbox']//span[text()='"+status+"']");
    }
    private By saveButton = By.xpath("//button[@type='submit']");
    private final By successToast      = By.xpath("//p[contains(@class,'oxd-text--toast-title')]");

    /*
     * Opens the My Info Page by clicking on the menu
     */

    public void openMyInfo(){
        logger.info("Clicking on My Info Menu");
        click(myInfoMenu, "My info Menu");
    }

    /*
     * Inputs First Name
     */

    public void enterFirstName(String firstName){
        logger.info("Entering First Name");
        type(firstNameField, firstName, "First Name Field");

    }
    /*
     * Types the given middle name into the middle name field.
     */
    public void enterMiddleName(String middleName) {
        logger.info("Entering middle name");
        type(middleNameField, middleName, "Middle name field");
    }

    /*
     * Types the given last name into the last name field.
     */
    public void enterLastName(String lastName) {
        logger.info("Entering last name");
        type(lastNameField, lastName, "Last name field");
    }

    /*
     * Selects the given marital status from the dropdown.
     */
    public void selectMaritalStatus(String status) {
        logger.info("Selecting marital status");
        click(maritalStatusDrop, "Marital status dropdown");
        click(maritalStatusOption(status), "Marital status option " + status);
    }

    /*
     * Clicks the Save button.
     */
    public void clickSave() {
        logger.info("Clicking Save button.");
        click(saveButton, "Save button");
    }

}
