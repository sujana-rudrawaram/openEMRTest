package com.google.openemrpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchOrAddPatientPage {
	
	private String patFrameLocator="pat";
	private By searchOrAddPatientHeaderLocator=By.xpath("//*[text()='Search or Add Patient']");
	private By formTitleLocator= By.xpath("//select[@id='form_title']");
	private By fillFirstNameLocator = By.id("form_fname");
	private By fillLastNameLocator = By.id("form_lname");
	private By fillDOBLocator = By.id("form_DOB");
	private By genderSelectLocator = By.id("form_sex");
	private By createPatientRecordLocator = By.id("create");
	private By switchToPopupFrameLocator = By.id("modalframe");
	private By clickOnCreateNewPatientLocator = By.xpath("//input[@value='Confirm Create New Patient']");
	private By closeFrameLocator = By.xpath("//div[@class='closeDlgIframe']");
	private By verifyPatientaddedLocator = By.xpath("//span[@data-bind='text: pname()']");
	


	private WebDriver driver;

	public SearchOrAddPatientPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getSearchOrAddPatientHeader() {
		String actualValue = driver.findElement(searchOrAddPatientHeaderLocator).getText();
		return actualValue;
	}
	
	public void switchToPatFrame()
	{
		driver.switchTo().frame(patFrameLocator);
	}
	
	public void titleOfTheName(String formTitle)
	{
		Select prefix = new Select(driver.findElement(formTitleLocator));
		prefix.selectByVisibleText(formTitle);
	}
	
	public void fillFirstName(String fname)
	{
		driver.findElement(fillFirstNameLocator).sendKeys(fname);
	}
	
	public void fillLastName(String lname)
	{
		driver.findElement(fillLastNameLocator).sendKeys(lname);;
	}
	
	public void selectDOB(String dob)
	{
		driver.findElement(fillDOBLocator).sendKeys(dob);;
	}
	
	public void selectGender(String selectgen)
	{
		Select gender = new Select(driver.findElement(genderSelectLocator));
		gender.selectByVisibleText(selectgen);
	}
	
	public void createPatientRecord()
	{
		driver.findElement(createPatientRecordLocator).click();
	}
	
	public void switchtoDefaultframe()
	{
		driver.switchTo().defaultContent();
	}
	
	public void switchtoPopupFrame()
	{
		driver.switchTo().frame(driver.findElement(switchToPopupFrameLocator));
	}
	
	public void confirmNewPatientbutton()
	{
		driver.findElement(clickOnCreateNewPatientLocator).click();
	}
	
	public void getTextandHandleAlert()
	{
	String alerttext = driver.switchTo().alert().getText();
	driver.switchTo().alert().accept();
	}
	
	public void closeFrame()
	{
		if(driver.findElements(closeFrameLocator).size()>0)
		{
			driver.findElement(closeFrameLocator).click();
		}
	}
	
	public String verifyPatientAdded()
	{
		String actualValue = driver.findElement(verifyPatientaddedLocator).getText();
		return actualValue;
	}
}
