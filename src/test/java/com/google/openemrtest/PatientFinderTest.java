package com.google.openemrtest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.openemrbase.WebDriverWrapper;
import com.google.openemrpages.Loginpage;
import com.google.openemrpages.MainPage;
import com.google.openemrpages.PatientFinderPage;
import com.google.openemrpages.SearchOrAddPatientPage;

public class PatientFinderTest extends WebDriverWrapper {
	
	@Test
	public void getPatientFinderHeader() {
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
				
				SearchOrAddPatientPage sap = new SearchOrAddPatientPage(driver);
				sap.switchToPatFrame();		
				
				String actualValue=driver.findElement(By.xpath("//h2[text()='Search or Add Patient']")).getText();
				
				Assert.assertEquals(actualValue, "Search or Add Patient");
	}

}
