Feature: Checking Sign up feature of the urbanladder webpage
Scenario Outline: Verify if user is able to sign up. 
	Given User first opens the website 
	When User click on sign up option 
	Then User should fill the <emailid> and <password> click sign up button
	
	Examples:
	|emailid 			    |password  |
	|vkurmude17@gmail.com   |Vinit@1998|
	
Scenario Outline: Verify if user is able to Log in. 
	Given User first redirects to the website 
	When User click on Log in option 
	Then User should fill the <emailid> and <password> click log in button
	
	Examples:
	|emailid 			    |password  |
	|vkurmude17@gmail.com   |Vinit@1998|

Scenario Outline: Verify if user is able to verify email 
	Given User is logged in on homepage
	When User click on profile option
	Then User should be able  to see user email id
	
Scenario Outline: Verify if user is able to search. 
	Given User is on the website 
	When User click on search box 
	Then User should fill text field with <Productname>
	Examples:
	|Productname|    
	|Sofa		|
	|Bed		|
	
Scenario Outline: Verify if store is there 
	Given User first goes to the website urbanladder 
	When User click on store option 
	Then User should see there

	
Scenario Outline: Verify if order tracking is working 
	Given User first goes to the website named urbanladder
	When User click on track order option and enter <trackid> <mobno> details
	Then User should be able to track shipment
	Examples:
	|trackid        |mobno        |
	|546546654		|7020284026	  |
	
Scenario Outline: Verify if gift card is working 
	Given User first comes on the website 
	When User click on goftcard option 
	Then User should be redirected to giftcard section section
	
Scenario Outline: Verify if subscribe feature is working 
	Given User first visits urbanladder
	When enters <email> and clicks on subscribe button
	Then User should be subscribed
	
	Examples:
	|email                 |
	|vkurmude14@gmail.com  |

Scenario Outline: Verify if help btn is working 
	Given User first goes to the website 
	When User click on help btn option 
	Then User should be redirected to QA section

Scenario Outline: Verify if user is able to Log out. 
	Given User should fill the <emailid> and <password> click login in button
	When User click on Log out option 
	Then user should be logged out
	
	Examples:
	|emailid 			    |password  |
	|vkurmude17@gmail.com   |Vinit@1998|
	
