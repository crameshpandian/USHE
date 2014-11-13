package mainFlows;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.Constant;
import utility.Log;
import utility.Result_Excel;
import utility.TestCaseNames;
import appModules.LogOut_Action;
import appModules.MainNavCreation_Action;
import appModules.PersonCreation_Action;
import appModules.PromoCreation_Action;
import appModules.RetailerCreation_Action;
import appModules.SecNavCreation_Action;
import appModules.SignIn_Action;
import appModules.TitleCreation_Action;
import appModules.TitleWithBonusandTechinical_Action;

public class Person_Title {

	public static WebDriver driver=null;
	public static Logger logger = Logger.getLogger(Person_Title.class.getName());
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		
				PropertyConfigurator.configure(Constant.Path_Logfile);
				
				//open the xcel sheet and focus on the particular sheet
				Result_Excel.setExcelFile(Constant.Path_TestData + Constant.File_Result,"Result");

				
		     	driver=new FirefoxDriver();
		     	driver.manage().window().maximize();
			
				//calling chrome driver
			    // System.setProperty("webdriver.chrome.driver", "C://Users//ra821463//Desktop//New Auto Jars//chromedriver.exe");
				
				//open the chrome
			    // driver = new ChromeDriver();
				
				Log.startTestCase("Create_Title");
				
				//call the url and launching
				driver.get(Constant.URL);
				
				//print the log message
				 Log.info("Url launched");
				 
				 Thread.sleep(10000);
				 
				 //ScreenShot.scrShot();
				 
				 				
		 	
				//verify the title then logged into the page
			        if(driver.getTitle().contains("Site-Install"))
			        {
			        	  //print the log message
			               Log.info("entered into if cond");
			               
			               //enter the username and pwd
			               SignIn_Action.Execute(driver);
			               
			               //print the log message
			               Log.info("Logged to home page");
			               
			               
			        }
			        else
			        {
			        	//condition failed...then print the log message
			        	   Log.info("exited into if cond");
			        	
			        	//quit the driver
			        	   driver.quit();
			        }
			        
			            //synchronization               
				        //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			        
			   
			            
			           		            			            
			      	                       
			            for(int i=1;i<=Result_Excel.getRowCount();i++)
			    		{
			            	
			            	String TestCase=Result_Excel.getCellData(i, 0);
			            	String Flag=Result_Excel.getCellData(i, 1);
			            	
			            	
			            	if(TestCase.equals(TestCaseNames.Person_TestCase) & Flag.equals(TestCaseNames.Flag_Yes))
			            	{
			            		PersonCreation_Action.PersonCreate(driver);
			            		System.out.println(PersonCreation_Action.per_Title);
			            		
			            		Result_Excel.setResultData("Pass", i, 2);
			            	}
			            	
			            	if(TestCase.equals(TestCaseNames.Promo_TestCase) & Flag.equals(TestCaseNames.Flag_Yes))
			            	{
			            		PromoCreation_Action.PromoCreate(driver);
			            		Result_Excel.setResultData("Pass", i, 2);
			            	}
			            	
			            	if(TestCase.equals(TestCaseNames.Title_TestCase) & Flag.equals(TestCaseNames.Flag_Yes))
			            	{
			            		TitleCreation_Action.TitleCreate(driver);
			            		Result_Excel.setResultData("Pass", i, 2);
			            	}
			            	
			            	if(TestCase.equals(TestCaseNames.Retailer_TestCase) & Flag.equals(TestCaseNames.Flag_Yes))
			            	{
			            		RetailerCreation_Action.RetailerCreate(driver);
			            		Result_Excel.setResultData("Pass", i, 2);
			            	}
			            	
			            	if(TestCase.equals(TestCaseNames.MainNav_TestCase) & Flag.equals(TestCaseNames.Flag_Yes))
			            	{
			            		MainNavCreation_Action.MainNavigationCreate(driver);
			            		Result_Excel.setResultData("Pass", i, 2);
			            	}
			            	
			            	if(TestCase.equals(TestCaseNames.SecNav_TestCase) & Flag.equals(TestCaseNames.Flag_Yes))
			            	{
			            		SecNavCreation_Action.SecNavigationCreate(driver);
			            		Result_Excel.setResultData("Pass", i, 2);
			            	}
			            	

			            	if(TestCase.equals(TestCaseNames.Titlewithbonusretailer_TestCase) & Flag.equals(TestCaseNames.Flag_Yes))
			            	{
			            		TitleWithBonusandTechinical_Action.TitlewithBonusTechincalinfo(driver);
			            		Result_Excel.setResultData("Pass", i, 2);
			            	}
			            	
			            	
			    		}
			            
			               if(driver.getTitle().contains("Site-Install"))
				   	        {
				   	        	  //print the log message
				   	               Log.info("entered into if cond");
				   	               
				   	              //log out the application
				   		           LogOut_Action.SignOut(driver);  
				   		           
				   		           Thread.sleep(10000);
				   		        
				   	               //print the log message
				   	               Log.info("Logged out from home page");
				   	        }
				                        
				        //quit the driver              
				        driver.quit();
		


	}

}
