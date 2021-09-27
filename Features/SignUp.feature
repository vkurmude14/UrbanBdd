Feature: Checking Sign up feature of the urbanladder webpage
Scenario Outline: Verify if user is able to sign up. 
	Given User first opens the website 
	When User click on sign up option 
	Then User should fill the <emailid> and <password> click sign up button
	
	Examples:
	|emailid 			    |password  |
	|vkurmude17@gmail.com   |Vinit@1998|