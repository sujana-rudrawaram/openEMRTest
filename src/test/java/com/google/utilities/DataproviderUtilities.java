package com.google.utilities;

import org.testng.annotations.DataProvider;

public class DataproviderUtilities {
	
	@DataProvider
	public Object[][] validCredentialData()
	{
		Object main[][] = new Object[2][4];
		main[0][0]= "admin";
		main[0][1]= "pass";
		main[0][2]= "English (Standard)";	
		main[0][3]= "Patient: None";
		
		main[1][0]= "physician";
		main[1][1]= "physician";
		main[1][2]= "English (Standard)";	
		main[1][3]= "Patient: None";
		
		return main;
		
	}
	
	
	@DataProvider
	public Object[][] AddpatientEmrpageData()
	{
		Object main[][] = new Object[2][9];
		main[0][0]= "admin";
		main[0][1]= "pass";
		main[0][2]= "English (Standard)";	
		main[0][3]= "Ms.";
		main[0][4]= "samara";
		main[0][5]= "Wills";
		main[0][6]= "2021-06-23";
		main[0][7]= "Female";
		main[0][8]= "Samara Wills";
		
		main[1][0]= "physician";
		main[1][1]= "physician";
		main[1][2]= "English (Standard)";	
		main[1][3]= "Ms.";
		main[1][4]= "sara";
		main[1][5]= "Wills";
		main[1][6]= "2021-06-23";
		main[1][7]= "Female";
		main[1][8]= "Sara Wills";
		
		return main;
		
	}
	
	@DataProvider
	public Object[][] patientsMenuData()
	{
		Object main[][] = new Object[2][4];
		main[0][0]= "admin";
		main[0][1]= "pass";
		main[0][2]= "English (Standard)";	
		main[0][3]= "Patient Finder";
		
		main[1][0]= "physician";
		main[1][1]= "physician";
		main[1][2]= "English (Standard)";	
		main[1][3]= "Patient Finder";
		
		return main;
	}
	
	@DataProvider
	public Object[][] newSearchMenuData()
	{
		Object main[][] = new Object[2][4];
		main[0][0]= "admin";
		main[0][1]= "pass";
		main[0][2]= "English (Standard)";	
		main[0][3]= "Search or Add Patient";
		
		main[1][0]= "physician";
		main[1][1]= "physician";
		main[1][2]= "English (Standard)";	
		main[1][3]= "Search or Add Patient";
		
		return main;
	}
	
	

}
