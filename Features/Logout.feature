Feature: Checking Logout feature of the urbanladder webpage
Scenario Outline: Verify if user is able to Log out. 
	Given User should fill the <emailid> and <password> click login in button
	When User click on Log out option 
	Then user should be logged out
	
	Examples:
	|emailid 			    |password  |
	|vkurmude17@gmail.com   |Vinit@1998|