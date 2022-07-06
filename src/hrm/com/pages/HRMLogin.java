package hrm.com.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
//import org.testng.asserts.SoftAssert;

import hrm.com.locators.LoginPage;
import hrm.com.utils.Browser;
import hrm.com.utils.ReadData;

public class HRMLogin extends LoginPage{

	private WebDriver driver;
	
	public HRMLogin(WebDriver driver) {
		this.driver=driver;
	}
	
	//WebElement hrm_username=driver.findElement(hrm_username_locator);
	//WebElement hrm_password=driver.findElement(hrm_password_locator);
	//WebElement hrm_loginbtn=driver.findElement(hrm_loginbutton_locator);
	
	private void setusername(String uname) {
		WebElement hrm_username=driver.findElement(hrm_username_locator);
		hrm_username.sendKeys(uname);
	}
	
	private void setpassword(String pass) {
		WebElement hrm_password=driver.findElement(hrm_password_locator);
		hrm_password.sendKeys(pass);
	}
	
	private void clickLogin() {
		WebElement hrm_loginbtn=driver.findElement(hrm_loginbutton_locator);
		hrm_loginbtn.click();
	}
	
	
	public void hrmLogin(String uname, String pass, String validationname) throws IOException {
		
		Reporter.log("HRM Login method started execution.");
		this.setusername(uname);
		this.setpassword(pass);
		this.clickLogin();
		Reporter.log("HRM Login button clicked.");
		String expectedURL=ReadData.getData("logininfo", "expectedURL");
		System.out.println(validationname);
		String validation=ReadData.getData("Browserinfo", validationname);
		System.out.println(validation);
		if(validation.equals("soft"))
			Browser.verifyOutput(expectedURL);
		else if(validation.equals("hard"))
		{
			Browser.verifyURLsoftAssert(expectedURL);
			
		}
		Reporter.log("HRM Login method executed successfully");
		//verifyURLHARDAssert();
	}
	
	/*private void verifyURLHARDAssert() throws IOException
	{
		String expectedURL=ReadData.getData("logininfo", "expectedURL");
		Browser.verifyOutput(expectedURL);
		Reporter.log("HRM Login method successfully executed.");
	}
	
	private void verifyURLsoftAssert() throws IOException
	{
		String expectedURL=ReadData.getData("logininfo", "expectedURL");
		String actualURL=driver.getCurrentUrl();
		boolean status=actualURL.contains(expectedURL);
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(status, true);
		//sa.assertAll();
		Reporter.log("HRM Login method successfully executed.");
	}*/
/*public void hrmLogin2(String uname, String pass) throws IOException {
		
		Reporter.log("HRM Login method started execution.");
		this.setusername(uname);
		this.setpassword(pass);
		this.clickLogin();
		Reporter.log("HRM Login button clicked.");
		this.verifyURLsoftAssert();
}*/
}