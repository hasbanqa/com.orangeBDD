package page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Claim_Page extends Base_Page {


    private By claimMenu      = By.xpath("//span[text()='Claim']");
    private By assignClaimButton      = By.xpath("//button[normalize-space()='Assign Claim']");
    private By employeeNameSearchField =By.xpath("//input[@placeholder='Type for hints...']");
    private By suggestedNameList = By.xpath("//div[@role='listbox']//div[@role='option']");
    private By eventDropdown = By.xpath("//Label[normalize-space()='Event']//../following-sibling::div//div[contains(@class,'oxd-select-text oxd-select')]");
    private By eventListOption = By.xpath("//div[@role='listbox']//span");


    public Claim_Page(WebDriver driver) {
        super(driver);
    }

    public void clickClaimMenu(){
        logger.info("clicking on Claim Menu");
        wait.until(ExpectedConditions.elementToBeClickable(claimMenu)).click();
    }
    public void clickAssignClaimButton(){
        logger.info("clicking on Assign Claim Button");
        wait.until(ExpectedConditions.elementToBeClickable(assignClaimButton)).click();
    }

    public void selectEmployeeName(String name) throws InterruptedException {
        logger.info("Typing employee name: "+name);
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(employeeNameSearchField));
        input.click();
        input.clear();
        input.sendKeys(name);
        Thread.sleep(5000);

    //wait for suggested name list

        List <WebElement> list = Collections.singletonList(wait.until(ExpectedConditions.visibilityOfElementLocated(suggestedNameList)));

        if(!list.isEmpty()){
            logger.info("Selecting first suggestion from dropdown");
            list.get(0).click();
        }else {
            logger.error("No suggested name list appered" + name);
            throw new RuntimeException("No suggestion found");
        }
        Thread.sleep(5000);

    }

    public void selectEventDropdownlist(String EventName){
        logger.info("Selecting Event: Travel Allowance");
        wait.until(ExpectedConditions.elementToBeClickable(eventDropdown)).click();
        List <WebElement>options = Collections.singletonList(wait.until(ExpectedConditions.visibilityOfElementLocated(eventListOption)));
        for (WebElement option:options){
            if (option.getText().trim().equalsIgnoreCase("Travel Allowance"));
            option.click();
            logger.info("Event Selected: Travel Allowance");
            return;
        }
        throw new RuntimeException("Travel Allowance option is not found");
    }

}
