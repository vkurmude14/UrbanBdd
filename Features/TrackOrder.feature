Feature: Checking track order feature of the urbanladder webpage
Scenario Outline: Verify if order tracking is working 
	Given User first goes to the website named urbanladder
	When User click on track order option and enter <trackid> <mobno> details
	Then User should be able to track shipment
	Examples:
	|trackid        |mobno        |
	|546546654		|7020284026	  |