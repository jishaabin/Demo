package qa.automation.demo.utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	public static ExtentReports extent;
	
public static ExtentReports getInstance(){
		
		if(extent==null){
			
			
			extent = new ExtentReports(System.getProperty("user.dir")+"//target//extentreports//html//extent.html",true,DisplayOrder.OLDEST_FIRST);
			System.out.println("Inside Extend ReportsManager");
			extent.loadConfig(new File(System.getProperty("user.dir")+"//src//main//java//automation//demo//utilities//ReportsConfig.xml"));
			
		}
		
		return extent;
		
	}

	
	

}
