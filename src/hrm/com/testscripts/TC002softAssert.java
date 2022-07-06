
package hrm.com.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hrm.com.pages.HRMLogin;
import hrm.com.utils.Browser;
import hrm.com.utils.ReadData;

public class TC002softAssert {
  private WebDriver driver;
	
	@BeforeMethod(groups="sanity")
	public void setup() throws IOException {
		 String browsername=ReadData.getData("Browserinfo", "browser1");
		 String url=ReadData.getData("Browserinfo", "url");
		 driver=Browser.LaunchBrowser(browsername);
		 Browser.openURL(url);
		//Browser.openURL("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	
	@AfterMethod(groups="sanity")
	public void teartown() {
		
		Browser.closeBrowser();
	}
	@Test(groups="sanity")
	public void verifyHRMLogin() throws IOException {
		String uname=ReadData.getData("logininfo", "username2");
	    String pass=ReadData.getData("logininfo", "password");
		HRMLogin login=new HRMLogin(driver);
		login.hrmLogin(uname,pass,"validation2");
		
	}
}
