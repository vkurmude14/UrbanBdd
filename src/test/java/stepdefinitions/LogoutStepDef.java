package stepdefinitions;



import java.io.IOException;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mindtre.pageobject.LogOutObj;
import com.mindtre.pageobject.LoginObj;
import com.mindtree.reusablecomponents.ReusableComponents;
import com.mindtree.reusablecomponents.ReusableMethods;
import com.mindtree.utility.ExtentReport;
import com.mindtree.utility.PropertyFileReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class LogoutStepDef {
	WebDriver driver;
	private ExtentTest extentTest;
	private ExtentReports report= ExtentReport.generateReport();
	@Given("^User should fill the (.*) and (.*) click login in button$")
	public void user_should_fill_the_emailid_and_password_click_login_in_button(String email,String pass) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Going to homepage");
		driver =  ReusableComponents.loadDriver();
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		LoginObj.Login(driver, email, pass);
	}

	
	  @When("User click on Log out option")
	  public void user_click_on_log_out_option() {
	      // Write code here that turns the phrase above into concrete actions
	      System.out.println("Click");
	  }
    @Then("user should be logged out")
    public void user_should_be_logged_out() throws InterruptedException, IOException {
        // Write code here that turns the phrase above into concrete actions
    	
    	Assert.assertTrue(LogOutObj.Logout(driver));
    	System.out.println("Log out test Success");
    	extentTest = report.createTest("LogOut TestCase");
    	ReusableMethods.timelapse(driver);
    	ReusableMethods.TakeScreenshot(driver, "LogOut");
    	extentTest.pass("Logout testcase success");
    	driver.close();
    }

    

}