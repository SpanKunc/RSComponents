package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

public class FrameworkUtilities {

	public String browser = null;
	public static WebDriver driver;

	public static void launchBrowser(String browser) {

		switch (browser) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "resources"
					+ File.separator + "drivers" + File.separator + "chromedriver.exe");
			driver = new ChromeDriver();
			DriverHelper.setWebDriver(driver);
			break;
		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "resources"
					+ File.separator + "drivers" + File.separator + "geckodriver.exe");
			driver = new FirefoxDriver();
			DriverHelper.setWebDriver(driver);
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + File.separator + "resources"
					+ File.separator + "drivers" + File.separator + "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			DriverHelper.setWebDriver(driver);
			break;

		}
		DriverHelper.getWebDriver().get(FrameworkConstants.appURL);

	}

	public static Properties propertyReader(String screen)

	{
		try {
			Properties obj = new Properties();
			/*System.out.println(FrameworkConstants.getCurrentDirectory + "resources" + File.separator
					+ "objectRepository" + File.separator + screen + ".properties");*/
			FileInputStream objfile = new FileInputStream(FrameworkConstants.getCurrentDirectory + File.separator
					+ "resources" + File.separator + "objectRepository" + File.separator + screen + ".properties");
			obj.load(objfile);
			return obj;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return null;

	}

	public static Properties propertyReader()

	{
		try {
			Properties obj = new Properties();
			FileInputStream objfile = new FileInputStream(
					FrameworkConstants.getCurrentDirectory + File.separator + "src" + File.separator + "test"
							+ File.separator + "resources" + File.separator + "environmental.properties");
			obj.load(objfile);
			return obj;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return null;

	}

	public static WebElement objProperty(String ScreenName, String ObjProperty) {

		WebDriverWait dynamicwait = null;
		WebElement webElement = null;
		try {
			webElement = DriverHelper.getWebDriver()
					.findElement(By.xpath(propertyReader(ScreenName).getProperty(ObjProperty)));
			dynamicwait = new WebDriverWait(DriverHelper.getWebDriver(), FrameworkConstants.objTimeOut);
			dynamicwait.until(ExpectedConditions.visibilityOf(webElement));
			dynamicwait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath(propertyReader(ScreenName).getProperty(ObjProperty))));
			return webElement;
		} catch (Exception exception) {
			exception.printStackTrace();

		}
		return null;

	}

	public static boolean isElementPresent(String ScreenName, String ObjProperty) {

		WebDriverWait dynamicwait = null;
		WebElement webElement = null;
		try {
			
			dynamicwait = new WebDriverWait(DriverHelper.getWebDriver(), 30);
			dynamicwait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath(propertyReader(ScreenName).getProperty(ObjProperty))));
			return true;
		} catch (Exception exception) {
			return false;

		}

	}

	public static void assertByText(String text) {
		WebElement webElement = null;
		try {
			webElement = DriverHelper.getWebDriver().findElement(By.xpath("//*[text()='"+text+"']"));

			DriverHelper.getWebDriver().quit();

		} catch (Exception exception) {
			exception.printStackTrace();

		}

	}

}
