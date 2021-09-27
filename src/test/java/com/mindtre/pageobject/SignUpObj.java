package com.mindtre.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mindtree.reusablecomponents.ReusableMethods;
import com.mindtree.uistore.SignUpUI;

public class SignUpObj {
	public static boolean signUp(WebDriver driver, String email,String pass) throws InterruptedException {
		 ReusableMethods.timelapse(driver);
		 //Email id locator :
		 ReusableMethods.sendKeys(SignUpUI.SignUp_mail, email, driver);
	     //Password locator :
		 ReusableMethods.sendKeys(SignUpUI.SignUp_pass, pass, driver);
		 //SignUp button
		 ReusableMethods.click(SignUpUI.SignUp_btn, driver);
		    try
		    {
		    	System.out.println(driver.findElement(By.xpath("//*[@id=\"ulerrors\"]/ul/li")).getText());
		    	
		    }catch(Exception e) {
		    	System.out.println("You have been signed up!");
		    }
		return true;
		
	}
}
