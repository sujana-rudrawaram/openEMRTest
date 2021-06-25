package com.hope.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Homepage {
	private By movetoPatientLocator = By.xpath("//div[text()='Patient/Client']");
	private By clickonPatientsLocator = By.xpath("(//div[@class='menuLabel'])[5]");
	
	
    private WebDriver driver;
	
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void moveToPatientClient()
	{
		Actions action = new Actions(driver);
		WebElement target = driver.findElement(movetoPatientLocator);
		action.moveToElement(target).perform();
	}
	
	public void clickonPatients()
	{
		driver.findElement(clickonPatientsLocator).click();
	}
	
}
