package hrm.com.locators;

import org.openqa.selenium.By;

public class AddEmployeePage {

  protected By hrm_pim_locator=By.xpath("//b[text()='PIM']");
  protected By pim_addemp_locator=By.linkText("Add Employee");
  protected By addemp_firstname_locator=By.id("firstName");
  protected By addemp_lastname_locator=By.id("lastName");
  protected By addemp_savebtn_locator=By.id("btnSave");
}
