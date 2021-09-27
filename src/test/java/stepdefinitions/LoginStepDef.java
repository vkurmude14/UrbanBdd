package stepdefinitions;



import java.io.IOException;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
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
public class LoginStepDef {
	WebDriver driver;
	private ExtentTest extentTest;
	private ExtentReports report= ExtentReport.generateReport();

	@Given("User first redirects to the website")
	public void user_first_redirects_to_the_website() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Going to homepage");
		driver =  ReusableComponents.loadDriver();
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
	}

    @When("User click on Log in option")
    public void user_click_on_Log_in_option() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
    	//Thread.sleep(10000);
    	System.out.println("When");
    }
    @Then("^User should fill the (.*) and (.*) click log in button$")
    public void User_should_fill_the_emailid_and_password_click_log_in_button(String emailid,String password) throws InterruptedException, IOException {
        // Write code here that turns the phrase above into concrete actions
    	
    	Assert.assertTrue(LoginObj.Login(driver, emailid, password));
    	System.out.println("Log in test Success");
    	extentTest = report.createTest("Login TestCase");
    	ReusableMethods.timelapse(driver);
    	ReusableMethods.TakeScreenshot(driver, "Login Tese");
    	extentTest.pass("Help button testcase success");
    	driver.close();
    }

    

}