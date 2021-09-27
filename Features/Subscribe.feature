Feature: Checking Subscribe feature of the urbanladder webpage
Scenario Outline: Verify if subscribe feature is working 
	Given User first visits urbanladder
	When enters <email> and clicks on subscribe button
	Then User should be subscribed
	
	Examples:
	|email                 |
	|vkurmude14@gmail.com  |