package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.DriverHelper;
import utilities.FrameworkUtilities;

public class WaterFillerPurchase extends FrameworkUtilities {

	@Given("^user is in HomePage$")
	public void user_is_in_HomePage() {
		try {
			launchBrowser(propertyReader().getProperty("browser"));
			DriverHelper.getWebDriver().manage().window().maximize();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@And("^when they click on AllProducts->Batteries->Automotive Battery Maintainence$")
	public void when_they_click_on_AllProducts_Batteries_Automotive_Battery_Maintainence() {

		try {
			objProperty("HomePage", "menuItem_AllProducts").click();

			Actions builder = new Actions(DriverHelper.getWebDriver());

			builder.moveToElement(objProperty("HomePage", "menuSubItem_Batteries")).perform();
			// builder.moveToElement(DriverHelper.getWebDriver().findElement(By.xpath(FrameworkUtilities.propertyReader("HomePage").getProperty("menuSubItem_Batteries")))).perform();
			// builder.moveToElement(DriverHelper.getWebDriver().findElement(By.xpath(FrameworkUtilities.propertyReader("HomePage").getProperty("menuSubItem_AutomotiveBatteryMaintainence")))).click().perform();
			builder.moveToElement(objProperty("HomePage", "menuSubItem_AutomotiveBatteryMaintainence")).click()
					.perform();
			Thread.sleep(5000);

		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

	@When("^user picks Water Fillers from the categories$")
	public void user_picks_Water_Fillers_from_the_categories() {
		try {
			Thread.sleep(1000);

			objProperty("AutomotiveBatteryMaintainence", "link_WaterFillers").click();

		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

	@And("^add (\\d+)LBatteryFiller$")
	public void add_LBatteryFiller(int arg1) {
		try {
			Thread.sleep(2000);

			if (isElementPresent("WaterFillers", "button_NoThanks") == true) {
				objProperty("WaterFillers", "button_NoThanks").click();
			}

			WebElement element = objProperty("WaterFillers", "button_AddTwoLBatteryFiller");

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

			Thread.sleep(500);
			objProperty("WaterFillers", "button_AddTwoLBatteryFiller").click();
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					objProperty("WaterFillers", "icon_Cart"));
			objProperty("WaterFillers", "icon_Cart").click();

			Thread.sleep(1000);
			ExpectedConditions.textToBePresentInElement(objProperty("MyBasket", "twoLBatteryFiller"),
					"2L Battery Filler");

		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

	@Then("^checkoutsecurely as a guest using \"([^\"]*)\"$")
	public void checkoutsecurely_as_a_guest_using(String guestemail) {
		try {
			objProperty("MyBasket", "button_CheckOut").click();
			objProperty("MyBasket", "textBoxEmail").sendKeys(guestemail);
			objProperty("MyBasket", "buttonGuestCheckout").click();
			Thread.sleep(2000);
			Assert.assertEquals(DriverHelper.getWebDriver()
					.findElement(By.xpath("//*[@id='deliveryCollectionForm']/div/div[6]/span"))
					.getText(), "Delivery");
			DriverHelper.getWebDriver().quit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}
