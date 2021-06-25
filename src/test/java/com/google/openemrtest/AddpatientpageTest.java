package com.google.openemrtest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.openemrbase.WebDriverWrapper;
import com.google.openemrpages.Loginpage;
import com.google.openemrpages.MainPage;
import com.google.openemrpages.PatientDashboardPage;
import com.google.openemrpages.PatientFinderPage;
import com.google.openemrpages.SearchOrAddPatientPage;
import com.google.utilities.DataproviderUtilities;

public class AddpatientpageTest extends WebDriverWrapper {
	
	
	//admin,pass,English (Standard),"Ms.","samara","Wills","2021-06-23","Female","Samara Wills"
	
	@Test(dataProvider = "AddpatientEmrpageData", dataProviderClass = DataproviderUtilities.class)
	public void AddpatientEmrpageTest(String username, String password, String language, String title, String firstname, String lastname, String dob, String gender, String expectedvalue)
	{
		//Loginpage
		Loginpage login = new Loginpage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.selectLanguage(language);
		login.loginButton();
		
		//MainPage
		MainPage main=new MainPage(driver);
		main.moveToPatientClient();
		main.clickonPatients();
			
		//PatientFinderPage
		PatientFinderPage patient= new PatientFinderPage(driver);
		patient.switchToFinFrame();
		patient.clickOnAddNewPatient();
		patient.switchOutOfFrame();
		
		
		//SearchOrAddPatientPage
		SearchOrAddPatientPage sapPage=new SearchOrAddPatientPage(driver);
		sapPage.switchToPatFrame();
		sapPage.titleOfTheName(title);
		sapPage.fillFirstName(firstname);
		sapPage.fillLastName(lastname);
		sapPage.selectDOB(dob);
		sapPage.selectGender(gender);
		sapPage.createPatientRecord();
		sapPage.switchtoDefaultframe();
		sapPage.switchtoPopupFrame();
		sapPage.confirmNewPatientbutton();
		sapPage.switchtoDefaultframe();
	
		//PatientDashboardPage
		PatientDashboardPage pdPage=new PatientDashboardPage(driver);
		pdPage.waitForPresenceOfAlert();

		//create method getTextandHandleAlert
		sapPage.getTextandHandleAlert();
		sapPage.closeFrame();		
		Assert.assertEquals(sapPage.verifyPatientAdded(),expectedvalue);
	}

}
