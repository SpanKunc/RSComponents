package testrunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.TestNGCucumberRunner;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "stepDefinations" }, plugin = {
		"com.cucumber.listener.ExtentCucumberFormatter:reports/ExtentReport.html" }

)

public class TestRunner {

	private TestNGCucumberRunner testNGCucumberRunner;

	/*
	 * @AfterClass public static void writeExtentReport() {
	 * 
	 * Reporter.loadXMLConfig(new
	 * File(FrameworkConstants.getCurrentDirectory+File.separator + "src" +
	 * File.separator + "test" + File.separator + "resources" + File.separator +
	 * "config.xml")); System.out.println("I am at the brgging");
	 * 
	 * }
	 */

	/*@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		System.out.println(" I am in Before");
	}

	@Test(groups = "cucumber", description = "Runs Cucumber Feature")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		testNGCucumberRunner.finish();
	}*/

}
