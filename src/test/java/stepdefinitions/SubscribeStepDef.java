package stepdefinitions;
import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mindtre.pageobject.StoreVerObj;
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
public class SubscribeStepDef {
	WebDriver driver;
	private Logger log = Log.logger(ProfileEmailVerStepDef.class.getName());
	private ExtentTest extentTest;
	private ExtentReports report= ExtentReport.generateReport();
	  @Given("User first goes to the website urbanladder")
	  public void user_first_goes_to_the_website_urbanladder() {
	      // Write code here that turns the phrase above into concrete actions
			driver =  ReusableComponents.loadDriver();
			driver.get(PropertyFileReader.loadFile().getProperty("url"));
	  }
	  @When("User click on store option")
	  public void user_click_on_store_option() {
	      // Write code here that turns the phrase above into concrete actions
	      System.out.println("Clicked");
	  }

	    @Then("User should see there")
	    public void user_should_see_hadapsar_pune_there() throws IOException {
	        // Write code here that turns the phrase above into concrete actions
	    	StoreVerObj.Store(driver, PropertyFileReader.loadFile().getProperty("store"), log);
	    	ReusableMethods.timelapse(driver);
	    	 extentTest = report.createTest("Subscribe TestCase");
	    	ReusableMethods.TakeScreenshot(driver, "SubScribe");
	    	extentTest.pass("Subscribe testcase success");
	    	driver.close();
	    }

    

}