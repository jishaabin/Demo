package qa.automation.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.automation.demo.Base.Base;
import qa.automation.demo.pages.Loginpage;

public class IndexPage extends Base {
	
	Loginpage login;
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='login']")
     WebElement signinbtn;
	
	/*@FindBy(xpath="//*[text()='Authentication']")
	WebElement heading;
	*/
	
	
	public Loginpage clickSiginbtn() {
		System.out.println("Inside click...");
		signinbtn.click();
		return  new Loginpage();
	}
}
