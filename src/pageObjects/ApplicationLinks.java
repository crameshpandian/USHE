package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class ApplicationLinks {
	
static WebElement element = null;
	
	public static WebElement link_MyWorBench(WebDriver driver) {
		 
        element = driver.findElement(By.linkText("My Workbench"));

        Log.info("workbench link found");

        return element;

        }
	
	public static WebElement link_CrtContent(WebDriver driver) {
		 
        element = driver.findElement(By.linkText("Create content"));

        Log.info("Content link found");

        return element;

        }
	
	public static WebElement link_CrtPerson(WebDriver driver) {
		 
        element = driver.findElement(By.linkText("Person"));

        Log.info("Person link found");

        return element;

        }
	
	public static WebElement link_CrtTitle(WebDriver driver) { 
        
        element = driver.findElement(By.linkText("Title"));  

            Log.info("Title link found"); 

         return element; 

}
	public static WebElement link_AddContent(WebDriver driver) {

        

        element = driver.findElement(By.linkText("Add content"));

        Log.info("Add Content link found");

        return element;

        }
	

	public static WebElement link_CrtPromo(WebDriver driver) {
		 
        element = driver.findElement(By.linkText("Promo"));

        Log.info("Promo link found");

        return element;

        }
	
	public static WebElement link_CrtRetailer(WebDriver driver) {
		 
        element = driver.findElement(By.linkText("Retailer"));

        Log.info("Promo link found");

        return element;

        }
	
	public static WebElement link_CrtPost(WebDriver driver) {
		 
        element = driver.findElement(By.linkText("Post"));

        Log.info("Post link found");

        return element;

        }
	
/*	------------------object for Main Navigation starts here-------------------------- */
	
	
	public static WebElement link_Structure(WebDriver driver) {      //common for main and Secondary Navigation
		 
        element = driver.findElement(By.linkText("Structure"));

        Log.info("Structure link found");

        return element;

        }
	
	public static WebElement link_Menus(WebDriver driver) {          //common for main and Secondary Navigation
		 
        element = driver.findElement(By.linkText("Menus"));

        Log.info("Menus link found");

        return element;

        }
	
	public static WebElement link_Taxonomy(WebDriver driver) {          
		 
        element = driver.findElement(By.linkText("Taxonomy"));

        Log.info("Taxonomy link found");

        return element;

        }
	
	public static WebElement link_AddLink(WebDriver driver) {
		 
        element = driver.findElement(By.xpath(".//*[@id='block-system-main']/div/table[2]/tbody/tr[4]/td[4]/a"));

        Log.info("Add link found for navigation");

        return element;

        }
	
	/*	------------------object for Main Navigation ends here-------------------------- */	
	
	
	
    /*	------------------object for Secondary Navigation starts here-------------------------- */
	
	
	public static WebElement link_SecNavAddLink(WebDriver driver) {
		 
        element = driver.findElement(By.xpath(".//*[@id='block-system-main']/div/table[2]/tbody/tr[5]/td[4]/a"));

        Log.info("Add link found for Sec. navigation");

        return element;

        }
	
	/*	------------------object for Main Navigation ends here-------------------------- */	
	
	public static WebElement link_CloseWindow(WebDriver driver) {
        
        element = driver.findElement(By.xpath(".//*[@id='overlay-close']"));
 
        Log.info("Close image found");
 
        return element;
 
        }
	
	public static WebElement link_AddTermForGenre(WebDriver driver){
		
		element=driver.findElement(By.xpath(".//*[@id='edit-6-add']"));
		
		Log.info("Addterm link found");
		return element;
	}
	
	
}
