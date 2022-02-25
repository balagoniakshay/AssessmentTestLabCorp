package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CareersPageObjects {

    public CareersPageObjects(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public By lnkApplyCareersPage = By.xpath("//div[@data-ph-at-id='job-actions']//a[@ph-tevent='apply_click']");

    @FindBy(xpath = "//input[@placeholder='Search for job']")
    public WebElement inputSearchBox;

    @FindBy(xpath = "//input[@placeholder='Search for job']//ancestor::div[@data-ph-at-id='keyword-category']//following-sibling::span/button[@type='submit']")
    public WebElement btnSearch;

    @FindBy(xpath = "//span[text()='Software QA Automation Engineer (Remote) ']")
    public WebElement lnkQAAutomation;

    @FindBy(xpath = "//h1[text()='Software QA Automation Engineer (Remote)']")
    public WebElement lblJobTitle;

    @FindBy(xpath = "//h1[text()='Software QA Automation Engineer (Remote)']//parent::div//span[@class='au-target job-location']")
    public WebElement lblJobLocation;

    @FindBy(xpath = "//h1[text()='Software QA Automation Engineer (Remote)']//parent::div//span[@class='au-target jobId']")
    public WebElement lblJobID;

    @FindBy(xpath = "//li[contains(text(),'5+ years of hands on experience in a Quality Assur')]")
    public WebElement lblJobRequirement;

    @FindBy(xpath = "//img[@instance-id='AvlXsi']")
    public WebElement imgJob;

    @FindBy(xpath = "//div[@data-ph-at-id='job-actions']//a[@ph-tevent='apply_click']")
    public WebElement lnkApply;
}
