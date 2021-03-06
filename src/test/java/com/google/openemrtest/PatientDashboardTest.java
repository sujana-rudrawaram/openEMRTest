package com.google.openemrtest;

import org.testng.annotations.Test;

import com.google.openemrbase.WebDriverWrapper;
import com.google.openemrpages.Loginpage;
import com.google.openemrpages.MainPage;
import com.google.openemrpages.PatientFinderPage;
import com.google.openemrpages.SearchOrAddPatientPage;

public class PatientDashboardTest extends WebDriverWrapper {
	
	
	@Test
	public void PatientAddedVerificationTest() {
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
			
			//AboutTab
			
				
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
	}

}
