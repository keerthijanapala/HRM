package hrm.com.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import hrm.com.locators.AddEmployeePage;
import hrm.com.utils.Browser;
import hrm.com.utils.ReadData;

public class HRMAddEmployee extends AddEmployeePage{

	private WebDriver driver;
	public HRMAddEmployee(WebDriver driver) {
		this.driver=driver;
	}
	private void mousehover() {
		WebElement hrm_pimtab=driver.findElement(hrm_pim_locator);
		Actions action=new Actions(driver);
		action.moveToElement(hrm_pimtab).build().perform();
		
	}
	private void clickAddEmp() {
		WebElement pim_addempLink=driver.findElement(pim_addemp_locator);
		pim_addempLink.click();
	}
	private void setFirstname(String fname) {
		WebElement addemp_firstname=driver.findElement(addemp_firstname_locator);
		addemp_firstname.sendKeys(fname);
	}
	private void setLastname(String lname) {
		WebElement addemp_lastname=driver.findElement(addemp_lastname_locator);
		addemp_lastname.sendKeys(lname);
	}
	private void clicksave() {
		WebElement addemp_savebtn=driver.findElement(addemp_savebtn_locator);
		addemp_savebtn.click();
	}
	public void hrmAddEmployee(String fname,String lname) throws Exception {
		Reporter.log("Add employee method started execution");
		this.mousehover();
		this.clickAddEmp();
		this.setFirstname(fname);
		this.setLastname(lname);
		this.clicksave();
		Reporter.log("Add employee save button clicked");
		String expectedURL=ReadData.getData("employeeinfo", "expectedURL");
		Browser.verifyOutput(expectedURL);
		Reporter.log("Employee Added successfully...");
	}
}
