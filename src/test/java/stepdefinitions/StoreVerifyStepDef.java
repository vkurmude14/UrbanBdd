package stepdefinitions;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mindtre.pageobject.SubscribeObj;
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
public class StoreVerifyStepDef {
	WebDriver driver;
	private ExtentReports report= ExtentReport.generateReport();
	private Logger log = Log.logger(ProfileEmailVerStepDef.class.getName());
	private ExtentTest extentTest;
    @Given("^User first visits urbanladder$")
    public void user_first_visits_urbanladder() throws Throwable {
    	driver =  ReusableComponents.loadDriver();
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
    }

    @When("^enters (.+) and clicks on subscribe button$")
    public void enters_and_clicks_on_subscribe_button(String email) throws Throwable {
        SubscribeObj.Subscribe(driver, email);
    }

    @Then("^User should be subscribed$")
    public void user_should_be_subscribed() throws Throwable {
        log.info("Subscribed");
        extentTest = report.createTest("Store verification TestCase");
        ReusableMethods.timelapse(driver);
        ReusableMethods.TakeScreenshot(driver, "Store Verification");
    	extentTest.pass("Store Verification testcase success");
        driver.close();
    }

    

}