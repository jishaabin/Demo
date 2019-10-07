package qa.automation.demo.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qa.automation.demo.Base.Base;
import qa.automation.demo.pages.Loginpage;

public class Logintest extends Base{
	
	Loginpage login;
	
	@BeforeMethod
	public void setup()
	{       //login=new Loginpage();
			Initialize();
			

	}
	
	@Test
	public void Signin()
	{  login= Base.index.clickSiginbtn();
		login.login(prop.getProperty("un"),prop.getProperty("pwd"));
		AssertJUnit.assertTrue(true);
		
	}
	
	@Test
	public void  verifyTitle() {
	login= Base.index.clickSiginbtn();
	String heading=	login.verifyheading();
	Assert.assertEquals("AUTHENTICTION", heading);
	}
	
	@AfterMethod
	public void Teardown() {
		driver.quit();
	}
	

}
