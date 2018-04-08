package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.FrameworkUtilities;

public class SearchItem extends FrameworkUtilities {

	
	@Given("^enter \"([^\"]*)\" keyword in the search box present in the HomePage$")
	public void enter_keyword_in_the_search_box_present_in_the_HomePage(String item) {
		try {

			objProperty("HomePage", "textbox_Search").sendKeys(item);

		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

	@When("^clicks on the search button$")
	public void clicks_on_the_search_button() {
		try {
			objProperty("HomePage", "iconSearch").click();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@Then("^user should see the list of \"([^\"]*)\"$")
	public void user_should_see_the_list_of(String item){
		try {
			assertByText(item);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}
