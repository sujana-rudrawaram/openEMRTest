package com.hope.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Addpatientpage {
	private By switchToFrameLocator = By.xpath("//iframe[@src='/b/openemr/interface/main/finder/dynamic_finder.php']");
	private By clickonCreatePatientLocator = By.id("create_patient_btn1");
	
	 private WebDriver driver;
		
		public Addpatientpage(WebDriver driver)
		{
			this.driver=driver;
		}
		
	public void switchToFrame()
	{
		driver.switchTo().frame(driver.findElement(switchToFrameLocator));
	}
	
	public void clickOnCreatePatient()
	{
		driver.findElement(clickonCreatePatientLocator).click();
	}
}
