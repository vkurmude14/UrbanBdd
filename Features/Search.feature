Feature: Checking Login feature of the urbanladder webpage
Scenario Outline: Verify if user is able to search. 
	Given User is on the website 
	When User click on search box 
	Then User should fill text field with <Productname>
	Examples:
	|Productname|    
	|Sofa		|
	|Bed		|