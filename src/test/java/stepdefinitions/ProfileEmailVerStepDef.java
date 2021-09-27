package stepdefinitions;



import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mindtre.pageobject.LoginObj;
import com.mindtre.pageobject.ProfileEmailVerifyObj;
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
public class ProfileEmailVerStepDef {
	WebDriver driver;
	private ExtentTest extentTest;
	private Logger log = Log.logger(ProfileEmailVerStepDef.class.getName());
	private ExtentReports report= ExtentReport.generateReport();
    @Given("User is logged in on homepage")
    public void user_is_logged_in_on_homepage() throws Throwable {
    	driver =  ReusableComponents.loadDriver();
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		LoginObj.Login(driver, PropertyFileReader.loadFile().getProperty("email"),PropertyFileReader.loadFile().getProperty("pass"));
       
    }
    

    @When("^User click on profile option$")
    public void user_click_on_profile_option() throws Throwable {
    	ProfileEmailVerifyObj.ProfileMailVer(driver, PropertyFileReader.loadFile().getProperty("email"), log);
    	log.info("profile verified");
    }

    @Then("^User should be able  to see user email id$")
    public void user_should_be_able_to_see_user_email_id() throws Throwable {
       // System.out.println(PropertyFileReader.loadFile().getProperty("email"));
    	ReusableMethods.timelapse(driver);
    	extentTest = report.createTest("Profile verification TestCase");
    	ReusableMethods.TakeScreenshot(driver, "Email verify");
    	extentTest.pass("Profile verify testcase success");
    	driver.close();
    }


    

}