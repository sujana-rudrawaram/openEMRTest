package Testcasesemr;

import org.testng.annotations.Test;

import com.base.test.WebDriverWrapper;
import com.hope.pages.Addpatientpage;

public class AddpatientpageTest extends WebDriverWrapper {
	
	
	@Test(priority = 3)
	public void AddpatientEmrpageTest()
	{
		Addpatientpage patient= new Addpatientpage(driver);
		patient.switchToFrame();
		patient.clickOnCreatePatient();
	}

}
