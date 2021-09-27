package stepdefinitions;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mindtre.pageobject.TrackOrderObj;
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
public class TrackOrderStepDef {
	WebDriver driver;
	private Logger log = Log.logger(ProfileEmailVerStepDef.class.getName());
	private ExtentTest extentTest;
	private ExtentReports report= ExtentReport.generateReport();


	  @Given("^User first goes to the website named urbanladder$")
	    public void user_first_goes_to_the_website_named_urbanladder() throws Throwable {
		  driver =  ReusableComponents.loadDriver();
			driver.get(PropertyFileReader.loadFile().getProperty("url"));
	    }

	    @When("^User click on track order option and enter (.+) (.+) details$")
	    public void user_click_on_track_order_option_and_enter_details(String trackid, String mobno) throws Throwable {
	       TrackOrderObj.Track(driver, trackid, mobno, log);
	    }

	    @Then("^User should be able to track shipment$")
	    public void user_should_be_able_to_track_shipment() throws Throwable {
	    	System.out.println("Tracked success");
	    	ReusableMethods.timelapse(driver);
	    	 extentTest = report.createTest("Track order TestCase");
	    	ReusableMethods.TakeScreenshot(driver, "Trackorder");
	       	extentTest.pass("TrackOrder testcase success");
	    	driver.close();
	    }
    

}