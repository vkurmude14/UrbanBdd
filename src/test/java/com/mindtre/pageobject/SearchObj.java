package com.mindtre.pageobject;

import org.openqa.selenium.WebDriver;

import com.mindtree.reusablecomponents.ReusableMethods;
import com.mindtree.uistore.SignUpUI;

public class SearchObj {
	public static boolean search(WebDriver driver, String searchKey) {
		if(ReusableMethods.getElement(SignUpUI.searchBox, driver)) {
			//log.info("Clicked on searchbox");
			ReusableMethods.sendKeys(SignUpUI.searchBox, searchKey,driver);
			if(ReusableMethods.sendKeyEnter(SignUpUI.searchBox, driver)) {
					return true;
				
			}
		}
		return false;
	}

}
