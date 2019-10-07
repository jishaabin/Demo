package qa.automation.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.automation.demo.Base.Base;

public class Loginpage extends Base{
	
	@FindBy(xpath="//input[@id='email']")
			WebElement username;
	
	@FindBy(xpath="//input[@name='passwd']")
	WebElement password;
	
	@FindBy(xpath="//*[@id='SubmitLogin']")
	WebElement loginbtn;
	
	public Loginpage() {
		PageFactory.initElements(driver, this);
		System.out.println("Inside Loginpage constructor");
	}
	
	@FindBy(xpath="//*[text()='Authentication']")
	WebElement heading;
	
	
	
	public void login(String uname,String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginbtn.click();
		
		
	}
	
	public String  verifyheading() {
		 return heading.getText();
	}


}
