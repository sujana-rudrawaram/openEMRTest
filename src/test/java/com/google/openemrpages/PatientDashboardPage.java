package com.google.openemrpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PatientDashboardPage {
	private String patFrameLocator="pat";
	private By headingLocator = By.xpath("//h2");
	
	private WebDriver driver;

	public PatientDashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitForPresenceOfAlert()
	{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void alerttext()
	{
		String alerttext = driver.switchTo().alert().getText();
	}
	
	public void acceptalert()
	{
		driver.switchTo().alert().accept();
	}
	
	public void defaultframe()
	{
		driver.switchTo().defaultContent();
	}
	
	public void switchToPatFrame()
	{
		driver.switchTo().frame(patFrameLocator);
	}
	
	public void confirmPatientName()
	{
		String heading = driver.findElement(headingLocator).getText();
	}

}
