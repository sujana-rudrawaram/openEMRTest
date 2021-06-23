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

public class AddpatientpageTest extends WebDriverWrapper {
	
	
	@Test
	public void AddpatientEmrpageTest()
	{
		//Loginpage
		Loginpage login = new Loginpage(driver);
		login.enterUserName("admin");
		login.enterPassword("pass");
		login.selectLanguage("English (Standard)");
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
		sapPage.titleOfTheName("Ms.");
		sapPage.fillFirstName("samara");
		sapPage.fillLastName("Wills");
		sapPage.selectDOB("2021-06-23");
		sapPage.selectGender("Female");
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
		Assert.assertEquals(sapPage.verifyPatientAdded(),"Samara Wills");
	}

}
