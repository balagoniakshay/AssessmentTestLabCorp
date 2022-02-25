package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplyPageObjects {

    public ApplyPageObjects(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public By jobTitle = By.xpath("//span[text()='Software QA Automation Engineer (Remote)']");
    public By jobLocation = By.xpath("//span[@class='resultfootervalue']");
    public By jobID = By.xpath("//span[@class='jobnum']");
    public By cancelFormEle = By.xpath("//div[@class='popover-content']//button[@data-ng-click='onOverlayClick($event)']");
    public By jobRequirement = By.xpath("//li[contains(text(),'5+ years of hands on experience in a Quality Assur')]");
    public By returnToSearch = By.xpath("//span[normalize-space()='Return to Job Search']");

    @FindBy(xpath = "//span[text()='Software QA Automation Engineer (Remote)']")
    public WebElement lblJobTitle;

    @FindBy(xpath = "//span[@class='resultfootervalue']")
    public WebElement lblJobLocation;

    @FindBy(xpath = "//span[@class='jobnum']")
    public WebElement lblJobID;

    @FindBy(xpath = "//div[@class='popover-content']//button[@data-ng-click='onOverlayClick($event)']")
    public WebElement cancelForm;

    @FindBy(xpath = "//li[contains(text(),'5+ years of hands on experience in a Quality Assur')]")
    public WebElement lblJobRequirement;

    @FindBy(xpath = "//span[normalize-space()='Return to Job Search']")
    public WebElement btnReturnToJobSearch;

}
