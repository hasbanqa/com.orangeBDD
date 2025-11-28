package page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Page Object for the Recruitment page.
 */
public class Recruitment_Page extends Base_Page {

    // Locators
    private By recruitmentMenu      = By.xpath("//span[text()='Recruitment']");
    private By candidateNameInput   = By.xpath("//label[normalize-space()='Candidate Name']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private By autoSuggestOptions   = By.xpath("//div[contains(@class,'oxd-autocomplete-dropdown')]//div[contains(@class,'oxd-autocomplete-option')]");
    private By firstResultCheckbox  = By.xpath("//div[contains(@class,'oxd-autocomplete-dropdown')]//span[normalize-space()='John Doe']");
    private By searchButton         = By.xpath("//button[@type='submit']");
    private By deleteButton         = By.xpath("//button[@type='button']//i[contains(@class,'bi-trash')]/parent::button");
    private By popUpDelete         = By.xpath("//button[contains(@class, 'oxd-button--label-danger orangehrm-button-margin')]");
    private By deleteSuccessToast   = By.xpath("//div[contains(@class,'oxd-toast-content')]//p[contains(text(),'Successfully Deleted')]");

    /**
     * Constructor.
     *
     * @param driver WebDriver instance from DriverManager.
     */
    public Recruitment_Page(WebDriver driver) {
        super(driver); // sets driver + wait in Base_Page
    }

    /** Clicks on the Recruitment option in the left menu. */
    public void clickRecruitmentMenu() {
        logger.info("Clicking on Recruitment menu...");
        wait.until(ExpectedConditions.elementToBeClickable(recruitmentMenu)).click();
    }

    public void searchCandidateByName(String name) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(candidateNameInput));
        input.clear();
        input.sendKeys(name);
    }

    public void selectCandidateFromAutoSuggest(String fullNameToSelect) {
        // wait for dropdown to appear
        List<WebElement> options = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(autoSuggestOptions));

        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(fullNameToSelect)) {
                option.click();
                break;
            }
        }
    }

    public void selectFirstCandidateFromResultList() {
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(firstResultCheckbox));
        checkbox.click();
    }

    public void clickDeleteButton() {
        click(searchButton,"clicking search button");
        WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        deleteBtn.click();
        click(popUpDelete,"Clicking on the Pop Up Delete Button");

    }

    public boolean isDeleteSuccessMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(deleteSuccessToast)).isDisplayed();
    }
}


