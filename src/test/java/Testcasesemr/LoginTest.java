package Testcasesemr;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.test.WebDriverWrapper;
import com.hope.pages.Loginpage;

public class LoginTest extends WebDriverWrapper{ 
	
	@Test(priority=1)
	public void loginEmrPageTest()
	{
		Loginpage login = new Loginpage(driver);
		login.enterUserName("admin");
		login.enterPassword("pass");
		login.selectLanguage("English (Standard)");
		login.loginButton();
		Assert.assertEquals(login.getPagename(), "Patient: None" );
	}

}
