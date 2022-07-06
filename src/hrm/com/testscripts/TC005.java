package hrm.com.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hrm.com.pages.HRMAddEmployee;
import hrm.com.utils.Browser;
import hrm.com.utils.ReadData;

public class TC005 {
    static WebDriver driver;
    
    @BeforeTest
	public void setup() throws IOException {
		 String browsername=ReadData.getData("Browserinfo", "browser1");
		 String url=ReadData.getData("Browserinfo", "url");
		 driver=Browser.LaunchBrowser(browsername);
		 Browser.openURL(url);
		//Browser.openURL("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	
	@AfterTest
	public void teartown() {
		
		Browser.closeBrowser();
	}
	@Test
	public void verifyAddEmployee() throws Exception {
		String fname=ReadData.getData("employeeinfo", "firstname");
	    String lname=ReadData.getData("employeeinfo", "lastname");
	    HRMAddEmployee add=new HRMAddEmployee(driver);
	    add.hrmAddEmployee(fname, lname);
	}

}
