package com.google.openemrtest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.openemrbase.WebDriverWrapper;
import com.google.openemrpages.Loginpage;
import com.google.openemrpages.MainPage;
import com.google.openemrpages.PatientFinderPage;
import com.google.openemrpages.SearchOrAddPatientPage;
import com.google.utilities.DataproviderUtilities;

public class MainPageTest extends WebDriverWrapper {


	@Test(priority = 1, dataProvider = "patientsMenuData", dataProviderClass = DataproviderUtilities.class)
	public void patientsMenuTest(String username, String password, String language, String expectedvalue) {
		Loginpage login = new Loginpage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.selectLanguage(language);
		login.loginButton();

		MainPage main = new MainPage(driver);
		main.moveToPatientClient();
		main.clickonPatients();
		// assertion
		PatientFinderPage pfPage=new PatientFinderPage(driver);
		Assert.assertEquals(pfPage.getPatientFinderHeader(), expectedvalue);
	}
	
	@Test(priority = 2, dataProvider = "newSearchMenuData", dataProviderClass = DataproviderUtilities.class)
	public void newSearchMenuTest(String username, String password, String language, String expectedvalue)
	{
		Loginpage login = new Loginpage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.selectLanguage(language);
		login.loginButton();
		
		MainPage main = new MainPage(driver);
		main.moveToPatientClient();
		main.clickOnNewSearchMenu();
		
		SearchOrAddPatientPage searchAddPage=new SearchOrAddPatientPage(driver);
		
		Assert.assertEquals(searchAddPage.getSearchOrAddPatientHeader(), expectedvalue);
	}
	
	

}
