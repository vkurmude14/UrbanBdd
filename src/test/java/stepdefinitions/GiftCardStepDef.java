package stepdefinitions;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mindtre.pageobject.GiftCardObj;
import com.mindtree.reusablecomponents.ReusableComponents;
import com.mindtree.reusablecomponents.ReusableMethods;
import com.mindtree.utility.ExtentReport;
import com.mindtree.utility.Log;
import com.mindtree.utility.PropertyFileReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class GiftCardStepDef {
	WebDriver driver;
	private Logger log = Log.logger(ProfileEmailVerStepDef.class.getName());
	private ExtentTest extentTest;
	private ExtentReports report= ExtentReport.generateReport();
    @Given("User first comes on the website")
    public void user_first_comes_on_the_website() {
        // Write code here that turns the phrase above into concrete actions
    	driver =  ReusableComponents.loadDriver();
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
    }

    @When("User click on goftcard option")
    public void user_click_on_goftcard_option() {
        // Write code here that turns the phrase above into concrete actions
    	GiftCardObj.GiftVerify(driver, log);
    }

    @Then("User should be redirected to giftcard section section")
    public void user_should_be_redirected_to_giftcard_section_section() throws Throwable {
    	log.info("Gift cards");
    	extentTest = report.createTest("Gift card TestCase");
    	ReusableMethods.timelapse(driver);
    	ReusableMethods.TakeScreenshot(driver, "Gift Cards");
    	extentTest.pass("GiftCard testcase success");
    	driver.close();
    	
    }
    

}