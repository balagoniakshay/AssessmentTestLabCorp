package lapcorpTests;

import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.ApplyPageObjects;
import pageobjects.CareersPageObjects;
import pageobjects.LabCorpHomePageObjects;
import reusable.BaseClass;

public class LabCorpCareersTest extends BaseClass {

    private CareersPageObjects careersPO;
    private LabCorpHomePageObjects labCorpPO;
    private ApplyPageObjects applyPO;
    private Constants testData;

    @Test
    public void applyLabCorpJobTest() throws InterruptedException {
        labCorpPO = new LabCorpHomePageObjects(driver);
        careersPO = new CareersPageObjects(driver);
        applyPO = new ApplyPageObjects(driver);
        testData = new Constants();

        log("Lab Corp Assessment Test Started");
        //find and click on careers link
        click(labCorpPO.lnkCareers,"Careers Link");

        String carrersPageTitle = getWindowHandles(1);

        if (carrersPageTitle.equals(testData.CAREERS_PAGE_TITLE))
        {

            //Search for any position (that is currently active on the site)
            careersPO.inputSearchBox.sendKeys(testData.QA_POSITION);
            click(careersPO.btnSearch,"Search Button");

            //Select and browse to the position
            click(careersPO.lnkQAAutomation, "QA Position");

            /*
            Add assertions to confirm
            a.	Job Title
            b.	Job Location
            c.	Job Id
            d.	Any 3 other assertions of your choice (could be text in the requirements
             */
            String actJobTitle = getText(careersPO.lblJobTitle);
            String expJobTitle = testData.EXPECTED_POSITION;

            Assert.assertEquals(expJobTitle,actJobTitle,"Expected Job Title Not Matching with Actual Job Title");

            String actJobLocation = getText(careersPO.lblJobLocation);
            String expJobLocation = testData.EXPECTED_LOCATION;

            Assert.assertTrue(actJobLocation.contains(expJobLocation),"Expected Job Location Not Matching with Actual Job Location");

            String actJobID = getText(careersPO.lblJobID);
            String expJobID = testData.EXPECTED_JOB_ID;

            Assert.assertTrue(actJobID.contains(expJobID),"Expected Job ID Not Matching with Actual Job ID");

            String actJobRequirement = getText(careersPO.lblJobRequirement);
            String expRequirement = testData.EXPECTED_JOB_REQUIREMENT;

            Assert.assertTrue(expRequirement.contains(actJobRequirement),"Expected Job Description Text is NOT Displayed");

            String actURL = driver.getCurrentUrl();

            String expURL = testData.EXPECTED_URL;

            Assert.assertEquals(actURL,expURL,"Expected URL does NOT match actual URL");

            boolean imgDisplayed = careersPO.imgJob.isDisplayed();

            Assert.assertTrue(imgDisplayed,"Image: In Pursuit of Answers is NOT displayed");

            /*
            Click Apply Now and confirm Job Title, Job Location, Job ID and another text of choice to match the previous page in the proceeding page
             */

            wait(careersPO.lnkApplyCareersPage,10);
            click(careersPO.lnkApply,"Apply Button");

            getWindowHandles(2);

            wait(applyPO.jobTitle,15);

            String jobTitle = getText(applyPO.lblJobTitle);

            Assert.assertEquals(jobTitle, actJobTitle);

            String jobLocation = getText(applyPO.lblJobLocation);

            Assert.assertTrue(jobLocation.contains(testData.EXPECTED_CITY));

            String jobID = getText(applyPO.lblJobID);

            Assert.assertTrue(jobID.contains(testData.EXPECTED_JOB_ID));

            wait(applyPO.cancelFormEle,20);

            boolean applyFormDisplayed = applyPO.cancelForm.isDisplayed();
            if (applyFormDisplayed) {
                click(applyPO.cancelForm, "Cancel Button");
            }

            String jobRequirement = applyPO.lblJobRequirement.getText();

            Assert.assertTrue(jobRequirement.contains(testData.EXPECTED_JOB_REQUIREMENT));

            //Click to Return to Job Search
            click(applyPO.btnReturnToJobSearch,"Return to Job Search");
        }
    }
}
