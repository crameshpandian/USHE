package appModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.ApplicationLinks;
import pageObjects.Genre_OR;
import utility.Constant;
import utility.ExcelUtils;

public class GenreCreation_Action {
	
	public static String GenreName;
	
	public static void GenreCreation(WebDriver driver) throws Exception{
		
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Genre");
		
		for(int i=1;i<=ExcelUtils.getRowCount();i++)
		{
			
			Application_Navigations.crtGenre_Navigation(driver);
			Thread.sleep(20000);
			
			if(driver.getTitle().contains("Genre")){
				
				driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Genre dialog']")));
				GenreName = ExcelUtils.getCellData(i, 0);
				Genre_OR.txtbx_GenName(driver).sendKeys(GenreName);
								
				driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Rich Text AreaPress ALT-F10 for toolbar. Press ALT-0 for help']")));
				String GenDesc=ExcelUtils.getCellData(i, 1);
				Genre_OR.txtbx_GenDesc(driver).sendKeys(GenDesc);
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Genre dialog']")));
				
				Genre_OR.btn_Save(driver).click();
				Thread.sleep(20000);
				
				if(driver.findElement(By.cssSelector("body")).getText().contains(GenreName)){
			           
			         System.out.println("Created new term"+ GenreName+".");
			     }
				
				ApplicationLinks.link_CloseWindow(driver).click();
				Thread.sleep(10000);
				
				Application_Navigations.crtTitle_Navigate(driver);
				
				Thread.sleep(30000);
				
				driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Create Title dialog']")));
				
				if(driver.findElement(By.cssSelector("body")).getText().contains(GenreName)){
			       
			        System.out.println(GenreName +"is present in the page");
			     }
				
				ApplicationLinks.link_CloseWindow(driver).click();
				Thread.sleep(10000);
				
				driver.switchTo().defaultContent();
				
				
			}
			
			
			
		}
		
	}

}
