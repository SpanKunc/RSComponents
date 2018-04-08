@SearchItem
Feature: Search for items by brand name and search Keywords
	
Scenario: Search for lamps and check if search results are mathing search criteria
Given user is in HomePage
	And enter "lamp" keyword in the search box present in the HomePage
When clicks on the search button
Then user should see the list of "lamp"

Scenario: Search for item by brand and check if search results are mathing search criteria
Given user is in HomePage
	And enter "Vishay" keyword in the search box present in the HomePage
When clicks on the search button
Then user should see the list of "Vishay"

Scenario: Search for Clocks and check if search results are mathing search criteria
Given user is in HomePage
	And enter "Clocks" keyword in the search box present in the HomePage
When clicks on the search button
Then user should see the list of "Clocks"

