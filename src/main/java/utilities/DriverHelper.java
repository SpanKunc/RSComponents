package utilities;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;

public class DriverHelper {

	public static Map<Long, WebDriver> threadToDriver = new HashMap<Long, WebDriver>();

	public static void setWebDriver(WebDriver driver) {
		try {
			Long threadID;
			System.out.println(getClassMethodName());

			threadID = Thread.currentThread().getId();
			if (!threadToDriver.containsKey(driver)) {
				threadToDriver.put(threadID, driver);

			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

	public static WebDriver getWebDriver() {
		Long threadID;
		try {
			threadID = Thread.currentThread().getId();
			if (threadToDriver.containsKey(threadID)) {
				return threadToDriver.get(threadID);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}

	private static String getClassMethodName() {
		String className, classSimpleName, methodName, classMethodName;
		className = Thread.currentThread().getStackTrace()[1].getClassName();
		classSimpleName = className.replace(".", "/").split("/")[className.replace(".", "/").split("/").length - 1];
		methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		classMethodName = "[" + classSimpleName + ":" + methodName + "]";
		return classMethodName;
	}

}
