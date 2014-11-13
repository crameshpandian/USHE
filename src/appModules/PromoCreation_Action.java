package appModules;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import pageObjects.Promo_OR;
import utility.Constant;
import utility.ExcelUtils;

public class PromoCreation_Action {
	
	public static String promotitle;
	
	public static void PromoCreate(WebDriver driver) throws Exception{
				
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Promo");
		
		for(int i=1;i<=ExcelUtils.getRowCount();i++)
		{
			
		Application_Navigations.crtPromo_Navigate(driver);
		
		Thread.sleep(20000);
		if(driver.getTitle().contains("Create Promo"))
        {
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Create Promo dialog']")));
		
		promotitle = ExcelUtils.getCellData(i, 0);
		Promo_OR.txtbx_Title(driver).sendKeys(promotitle);
		
//Image upload starts
		
        Promo_OR.btn_Image(driver).click();
        
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='media-modal-frame ui-dialog-content ui-widget-content']")));

        String imagepath = ExcelUtils.getCellData(i, 1);
        Promo_OR.txtbx_imgPath(driver).sendKeys(imagepath);
        
        Promo_OR.btn_Upload(driver).click();
        Thread.sleep(20000);
        
        Promo_OR.btn_Next(driver).click();
        Thread.sleep(20000);
        
        Promo_OR.btn_imagSave(driver).click();
        Thread.sleep(20000);
                                    
        driver.switchTo().defaultContent();
        
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Create Promo dialog']")));
        
// Description iFrame starts
       
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Rich Text AreaPress ALT-F10 for toolbar. Press ALT-0 for help']")));
        
        String titleBody = ExcelUtils.getCellData(i, 2);
        Promo_OR.txtbx_Descrption(driver).sendKeys(titleBody);
        
        driver.switchTo().defaultContent();
        
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Create Promo dialog']")));
 
        
        String ModState = ExcelUtils.getCellData(i, 3);
        Select mstate = new Select(Promo_OR.list_ModState(driver)); 
        mstate.selectByVisibleText(ModState);
        
        String assignTo = ExcelUtils.getCellData(i, 4);
        Promo_OR.txtbx_AssignTo(driver).sendKeys(assignTo.trim());
		
		String logMsg = ExcelUtils.getCellData(i, 5);
		Promo_OR.txtbx_Logmess(driver).sendKeys(logMsg.trim());
		
		Promo_OR.btn_Save(driver).click();
		
		Thread.sleep(20000);
		
		if(driver.getTitle().contains(promotitle))
	    {
           System.out.println("Promo "+promotitle+" has been created.");
           
           
        }
		}
		
		else
		{
			driver.quit();
		}
		             
		
		}
		
	}

}
