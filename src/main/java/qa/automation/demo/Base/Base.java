package qa.automation.demo.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import qa.automation.demo.pages.IndexPage;
import qa.automation.demo.utilities.ExcelReader;
import qa.automation.demo.utilities.ExtentManager;
import qa.automation.demo.utilities.util;

public class Base {
	
	//http://automationpractice.com/index.php
	public static WebDriver driver;
	public static Properties prop;
	public static IndexPage index;
	public static ExcelReader excel;
	public static ExtentTest test;
	public ExtentReports rep = ExtentManager.getInstance();
	public static Logger log = Logger.getLogger("devpinoyLogger");


	
	public Base()
	{
		prop=new  Properties();
	   try {
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//qa//automation//demo//properties//config.properties");
		prop.load(fis);
		System.out.println(Thread.currentThread().getContextClassLoader().getResource(".") );
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public static void Initialize() {
		System.out.println("Inside Initia;ize");
		
		if(prop.getProperty("browser").equals("chrome")){
			WebDriverManager.chromedriver().setup();
			System.out.println("After webdrivermanager");
			driver=new ChromeDriver();
			log.info("Initializing Chrome driver.....");
			
		}
		System.out.println("After chrome");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(util.TIME_OUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(util.PAGE_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		index=new IndexPage();
		
	}

}
