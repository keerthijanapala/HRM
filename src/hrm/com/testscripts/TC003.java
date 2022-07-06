package hrm.com.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hrm.com.pages.HRMAddEmployee;
import hrm.com.pages.HRMLogin;
import hrm.com.utils.Browser;
import hrm.com.utils.ReadData;

public class TC003 {

private WebDriver driver;
	
	@BeforeClass(groups="sanity")
	public void setup() throws IOException {
		 String browsername=ReadData.getData("Browserinfo", "browser1");
		 String url=ReadData.getData("Browserinfo", "url");
		 driver=Browser.LaunchBrowser(browsername);
		 Browser.openURL(url);
		//Browser.openURL("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	
	@AfterClass(groups="sanity")
	public void teartown() {
		
		Browser.closeBrowser();
	}
	@Test(priority=1,groups="integration")
	public void verifyHRMLogin() throws IOException {
		String uname=ReadData.getData("logininfo", "username2");
	    String pass=ReadData.getData("logininfo", "password");
		HRMLogin login=new HRMLogin(driver);
		login.hrmLogin(uname,pass,"validation1");
		
	}
	@Test(priority=2, dependsOnMethods="verifyHRMLogin")
	public void verifyAddEmployee() throws Exception {
		String fname=ReadData.getData("employeeinfo", "firstname");
	    String lname=ReadData.getData("employeeinfo", "lastname");
	    HRMAddEmployee add=new HRMAddEmployee(driver);
	    add.hrmAddEmployee(fname, lname);
	}
}
