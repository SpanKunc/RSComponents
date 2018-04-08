@WaterFillerPurchase
Feature: WaterFiller Purchase
	
Scenario: Add any water fillers product to the cart and check out.
Given user is in HomePage
	And when they click on AllProducts->Batteries->Automotive Battery Maintainence
When user picks Water Fillers from the categories 
	And add 1LBatteryFiller
Then checkoutsecurely as a guest using "sk@gmail.com"

