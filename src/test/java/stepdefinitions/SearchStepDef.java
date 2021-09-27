package stepdefinitions;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mindtre.pageobject.SearchObj;
import com.mindtree.reusablecomponents.ReusableComponents;
import com.mindtree.reusablecomponents.ReusableMethods;
import com.mindtree.utility.ExtentReport;
import com.mindtree.utility.PropertyFileReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class SearchStepDef {
	WebDriver driver;
	private ExtentTest extentTest;
	private ExtentReports report= ExtentReport.generateReport();
	@Given("User is on the website")
	public void user_is_on_the_website() {
		driver =  ReusableComponents.loadDriver();
		driver.get(PropertyFileReader.loadFile().getProperty("url"));

		
	}


	@When("User click on search box")
	public void user_click_on_search_box() {


	}

	@Then("^User should fill text field with (.*)$")
	public void user_should_fill_text_field_with_product_name(String productName) throws IOException {
		SearchObj.search(driver,productName );
		ReusableMethods.timelapse(driver);
		extentTest = report.createTest("Search TestCase");
		ReusableMethods.TakeScreenshot(driver, "Searching"+productName);
    	extentTest.pass("Search testcase success");
		driver.close();
	    
	}

}
