Feature: Checking Login feature of the urbanladder webpage
Scenario Outline: Verify if user is able to Log in. 
	Given User first redirects to the website 
	When User click on Log in option 
	Then User should fill the <emailid> and <password> click log in button
	
	Examples:
	|emailid 			    |password  |
	|vkurmude17@gmail.com   |Vinit@1998|