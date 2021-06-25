package com.google.openemrtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.openemrbase.WebDriverWrapper;
import com.google.openemrpages.Loginpage;
import com.google.utilities.DataproviderUtilities;

public class LoginTest extends WebDriverWrapper{ 
	
	@Test(priority=1, dataProvider = "validCredentialData", dataProviderClass = DataproviderUtilities.class )
	public void validCredentialTest(String username, String password, String language, String expectedvalue)
	{
		Loginpage login = new Loginpage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.selectLanguage(language);
		login.loginButton();
		Assert.assertEquals(login.getPagename(), expectedvalue );
//		login.enterUserName("admin");
//		login.enterPassword("pass");
//		login.selectLanguage("English (Standard)");
//		login.loginButton();
//		Assert.assertEquals(login.getPagename(), "Patient: None" );
//	}
	}

}
