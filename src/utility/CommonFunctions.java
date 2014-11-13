package utility;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CommonFunctions {
	
	public static WebDriver driver;
	public static void scrShot() throws IOException
	{
		 int i=0;	        
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        
	        System.out.println("start");
	        // now save the screenshto to a file some place
	        FileUtils.copyFile(scrFile, new File("C:\\Users\\ra821463\\workspace\\AutomationFramework\\ScreenShots\\screenshot"+i+".png"));
	        i=i+1;
	        		  
	}
	
	public static void dateTime(String date){
		WebElement dateWidget = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']"));
		List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));
		List<WebElement> columns=dateWidget.findElements(By.tagName("td"));

		for (WebElement cell: columns){
		//Select 13th Date
		if (cell.getText().equals(date)){
		cell.findElement(By.linkText(date)).click();
		break;
		}
		} 
	}
	
	public static void pageupdown(int up,int down)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(up, down)");
	}
	
//	public static File getScreenshot(String methodName) throws IOException {
//        File screenshot = null;
//        // to prevent "browser died" if there are too many issues and screenshots
//        try {Thread.sleep(3000);} catch (InterruptedException e1) {}
//        try {
//                screenshot = File.createTempFile(methodName + "_screenshot"
//                                + getCurrentDate(), ".png", new File("test-output"));
//                if (configuration.getDriverMode().equals("remote")) {
//                        TakesScreenshot augmentedDriver = (TakesScreenshot) new Augmenter()
//                                        .augment(driver);
//                        Files.copy(augmentedDriver.getScreenshotAs(OutputType.FILE),
//                                        screenshot);
//                } else {
//                        File scrFile = ((TakesScreenshot) driver)
//                                        .getScreenshotAs(OutputType.FILE);
//                        Files.copy(scrFile, screenshot);
//                }
//                
//        }catch(Exception e)
//        {
//        	
//        }
	//}

}
