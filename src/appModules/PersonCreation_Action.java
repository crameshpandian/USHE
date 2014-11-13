package appModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import pageObjects.Person_OR;
import utility.Constant;
import utility.ExcelUtils;

public class PersonCreation_Action {
	
	public static String per_Title;
	public static void PersonCreate(WebDriver driver) throws Exception{
		
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Person");
		
		for(int i=1;i<=ExcelUtils.getRowCount();i++)
		{
			Application_Navigations.crtPerson_Navigate(driver);
			
			Thread.sleep(10000);
					
			if(driver.getTitle().contains("Create Person"))
			{
				driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Create Person dialog']")));
				
			    per_Title = ExcelUtils.getCellData(i, 0);
				Person_OR.txtbx_PerTitle(driver).sendKeys(per_Title);
				
				driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Rich Text AreaPress ALT-F10 for toolbar. Press ALT-0 for help']")));
				
				String desc = ExcelUtils.getCellData(i, 1);
				Person_OR.txtbx_PerDesc(driver).sendKeys(desc);
				
				driver.switchTo().defaultContent();
				
				driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Create Person dialog']")));
							
				Thread.sleep(10000);
                Person_OR.btn_PerImage(driver).click();
				
				Thread.sleep(20000);
							
				driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='media-modal-frame ui-dialog-content ui-widget-content']")));
				                                                                         
				String imagepath = ExcelUtils.getCellData(i, 2);
				Person_OR.txtbx_imgPath(driver).sendKeys(imagepath);
				
				Person_OR.btn_Upload(driver).click();
				Thread.sleep(30000);
				
				Person_OR.btn_Next(driver).click();
				Thread.sleep(20000);
				
				Person_OR.btn_imagSave(driver).click();
				Thread.sleep(20000);
								
				driver.switchTo().defaultContent();
				
				driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Create Person dialog']")));
				
				String modstat= ExcelUtils.getCellData(i, 3);
				Select ModStatus=new Select(Person_OR.list_ModStat(driver));
	     		ModStatus.selectByVisibleText(modstat);
	     		
	     		String assignto = ExcelUtils.getCellData(i, 4);
	     		Person_OR.txtbx_AssingTo(driver).clear();
	     		Person_OR.txtbx_AssingTo(driver).sendKeys(assignto);
				
				String logmsg = ExcelUtils.getCellData(i, 5);
				Person_OR.txtbx_Logmsg(driver).sendKeys(logmsg);
				
				Person_OR.btn_Save(driver).click();
				
				Thread.sleep(10000);
				
				if(driver.getTitle().contains(per_Title))
			    {
		           System.out.println("Person "+per_Title+" has been created.");
		           
		           
		        }
								
			}
			else{
				driver.quit();
			}
		}
		
	}
	
	
		
}


