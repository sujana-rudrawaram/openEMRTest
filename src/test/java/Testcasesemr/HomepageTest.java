package Testcasesemr;

import org.testng.annotations.Test;

import com.base.test.WebDriverWrapper;
import com.hope.pages.Homepage;

public class HomepageTest extends WebDriverWrapper{

		@Test(priority = 2)
		public void homeEmrPageTest()
		{
			Homepage home = new Homepage(driver);
			home.moveToPatientClient();	
			home.clickonPatients();
		}	
		
}
