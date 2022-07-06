package hrm.com.utils;

import java.io.IOException;

//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
//import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

//import cucumber.api.java.After;
//import cucumber.api.java.Before;

public class Browser {

	private static WebDriver driver;
	
	public static WebDriver LaunchBrowser(String browsername) {
		if(browsername.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver.exe");
		driver=new ChromeDriver();
		}else {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		return driver;
	}
	public static  void openURL(String url) {
		//driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.get(url);
	}
	/*public  static void verifyURL() {
		
		String expectedURL="dashboard";
		String actualURL=driver.getCurrentUrl();
		boolean status=actualURL.contains(expectedURL);
		Assert.assertEquals(true, status);
	}
	*/
	public static void closeBrowser() {
		
		driver.close();
	}
	public static void verifyOutput(String expectedURL) {
		String actualURL=driver.getCurrentUrl();
		boolean status=actualURL.contains(expectedURL);
		Assert.assertEquals(status, true,"\nExpected URL : "+expectedURL+"\nDoes not match with ActualURL :"+actualURL);
		
	}
	public static void verifyURLsoftAssert(String expectedURL) throws IOException
	{
		//String expectedURL=ReadData.getData("logininfo", "expectedURL");
		String actualURL=driver.getCurrentUrl();
		boolean status=actualURL.contains(expectedURL);
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(status, true);
		//sa.assertAll();
		//Reporter.log("HRM Login method successfully executed.");
	}
}
