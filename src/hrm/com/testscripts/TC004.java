package hrm.com.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import hrm.com.pages.HRMLogin;
import hrm.com.utils.ReadData;

public class TC004 {
	
	@Test
	public void verifyHRMLogin() throws IOException {
		String uname=ReadData.getData("logininfo", "username");
	    String pass=ReadData.getData("logininfo", "password");
		HRMLogin login=new HRMLogin(TC005.driver);
		login.hrmLogin(uname,pass,"validation1");
		
	}
}
