package reusable;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public WebDriver driver;
    public String baseurl;

    @BeforeMethod
    public void setup(@Optional("chrome") String browser){

        switch(browser) {
            case "chrome" :
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default :
                Reporter.log("No driver chosen", true);
                break;
        }
        baseurl = "https://www.labcorp.com/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if(driver !=null) {
            driver.get(baseurl);
        }
        else
            Assert.fail("driver object is null");
    }

    public void wait(By locator, int waitTime)
    {
        WebDriverWait wait = new WebDriverWait(driver,waitTime);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click(WebElement element, String eleTxt)
    {
        element.click();
        log("Clicked "+eleTxt);
    }

    public void log(String txt)
    {
        System.out.println(txt);
    }
    public String getWindowHandles(int window) throws InterruptedException {
        //switch to new window
        // hold all window handles in array list
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(newTb.get(window));
        Thread.sleep(10);
        String newPageTitle = driver.getTitle();
        log("Switched to the page: " + newPageTitle);
        return newPageTitle;
    }

    public String getText(WebElement ele)
    {
        String elemTxt = ele.getText();
        log("Actual Element Text is: " + elemTxt);
        return elemTxt;
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
        log("Lab Corp Assessment Test Completed");
    }
}

