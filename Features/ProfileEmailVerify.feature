Feature: Checking Profile view feature of the urbanladder webpage
Scenario Outline: Verify if user is able to verify email
	Given User is logged in on homepage
	When User click on profile option
	Then User should be able  to see user email id
	
