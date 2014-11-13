package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class Product_Creation_Page {
	
	static WebElement element = null;
	
	public static WebElement txtbx_ProdTitle(WebDriver driver){
		 
        element = driver.findElement(By.id("edit-title"));

        Log.info("ProductTitle text box found");

        return element;

        }
	
	public static WebElement txtbx_ProdDesc(WebDriver driver){
		 
        element = driver.findElement(By.id("tinymce"));

        Log.info("ProductDesc text box found");

        return element;

        }
	
	public static WebElement list_ProdSize(WebDriver driver){
		 
        element = driver.findElement(By.id("edit-field-product-und-form-field-size-und"));

        Log.info("ProductSize text box found");

        return element;

        }

	public static WebElement list_ProdColor(WebDriver driver){
		 
        element = driver.findElement(By.id("edit-field-product-und-form-field-color-und"));

        Log.info("ProductColor text box found");

        return element;

        }
	
	public static WebElement txtbx_ProdSKu(WebDriver driver){
		 
        element = driver.findElement(By.id("edit-field-product-und-form-sku"));

        Log.info("ProductSku text box found");

        return element;

        }
	
	public static WebElement txtbx_ProdPrice(WebDriver driver){
		 
        element = driver.findElement(By.id("edit-field-product-und-form-commerce-price-und-0-amount"));
        									
        Log.info("ProductPrice text box found");

        return element;

        }
	
	public static WebElement radio_ProdStatus(WebDriver driver){
		 
        element = driver.findElement(By.id("edit-field-product-und-form-status-1"));

        Log.info("ProductStatus radi button found");

        return element;

        }
	
	public static WebElement txtbx_Prodimage(WebDriver driver){
		 
        element = driver.findElement(By.id("edit-field-product-und-form-field-images-und-0-upload"));

        Log.info("Productimage textbox found");

        return element;

        }
	
	
	public static WebElement btn_Save(WebDriver driver){
		 
        element = driver.findElement(By.id("edit-field-product-und-form-actions-ief-add-save"));

        Log.info("save buttonfound");

        return element;

        }
	
	
	public static WebElement list_ProdCateg(WebDriver driver){
		 
        element = driver.findElement(By.id("edit-field-categories-und"));

        Log.info("list box found");

        return element;

        }
	
	
	public static WebElement list_ProdModStatsu(WebDriver driver){
		 
        element = driver.findElement(By.id("edit-event"));

        Log.info("list box found");

        return element;

        }
	
	public static WebElement txtbx_ProdLogmes(WebDriver driver){
		 
        element = driver.findElement(By.id("edit-event-comment"));

        Log.info("text box found");

        return element;

        }
	
	public static WebElement btn_Submit(WebDriver driver){
		 
        element = driver.findElement(By.id("edit-submit"));

        Log.info("submit button found");

        return element;

        }

}
