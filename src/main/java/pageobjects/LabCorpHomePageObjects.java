package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LabCorpHomePageObjects {


    public LabCorpHomePageObjects(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='login-container']//a[text()='Careers']")
    public WebElement lnkCareers;
}
