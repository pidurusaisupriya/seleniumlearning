package fourthtestngproject;

import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.Toolkit;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.lf5.PassingLogRecordFilter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

@SuppressWarnings("unused")
public class FourthTestNGProject {
	
	public String driverPath = Utils4.DRIVER_PATH;
	public String baseUrl = Utils4.BASE_URL;
	public WebDriver driver;
/*	
	@DataProvider(name = "Test")
	public String[][] testData() throws Exception{
		
		return Utils4.getDataFromExcel(Utils4.FILE_PATH, Utils4.SHEET_NAME,
				Utils4.TABLE_NAME);
	}

	*/	
	  @BeforeTest
	  public WebDriver openHomePage(){
		  
		  System.setProperty(Utils4.DRIVER_NAME, driverPath);
		  
		   driver = new ChromeDriver();
		  
		 driver.get(baseUrl);
		 driver.manage().timeouts()
			.implicitlyWait(Utils4.WAIT_TIME, TimeUnit.SECONDS);
		  return driver;
		  
		  
		  }

	  


	
@Parameters({"uname","pwd"})
@Test
public void testLogin(String username, String password) throws Exception  {
	
	//System.out.println(username);
	
	//driver.findElement(By.name("uid")).clear();
    driver.findElement(By.name("uid")).sendKeys(username);
    
    //driver.findElement(By.name("uid")).clear();
    driver.findElement(By.name("password")).sendKeys(password);

    driver.findElement(By.name("btnLogin")).click();
   
    
    
    getscreenshot(username+"_"+password+"New");
    
    
    
   
	
   
	} 
/*
@Test(dataProvider="Test")
public void testCase04(String username, String password) throws Exception{
	  	
	  	String actualBoxMsg;
	  	String actualTitle;
	  	
	  	
		// Enter Username
		driver.findElement(By.name("uid")).clear();
	    driver.findElement(By.name("uid")).sendKeys(username);
	   
	    // Enter Password
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys(password);
	    
	    getscreenshot(username+"_"+password);
		 
	    
	    // Login 
	    driver.findElement(By.name("btnLogin")).click();
	    
	    
	 
	    
	    try{ 
		    
	       	Alert alt = driver.switchTo().alert();
			actualBoxMsg = alt.getText(); // get content of the Alter Message
			alt.accept();
			 // Compare Error Text with Expected Error Value					
			assertEquals(actualBoxMsg,Utils4.EXPECT_ERROR);
			
		}    
	    catch (NoAlertPresentException Ex){ 
	    	actualTitle = driver.getTitle();
			// On Successful login compare Actual Page Title with Expected Title
	    	assertEquals(actualTitle,Utils4.EXPECT_TITLE);
	    	String searchID = "//td[. = 'Manger Id : "+Utils4.EXPECT_ID+"']";
	    	//String actualId = driver.findElement(By.xpath("//td[. = 'Manger Id : mngr137052']")).getText();
	    	String actualId = driver.findElement(By.xpath(searchID)).getText();
	    	if(actualId.contains(Utils4.EXPECT_ID)) {
	    		System.out.println("Id is correct");
	    	}else {
	    		System.out.println("Id is incorrect");
	    	}
	    	
	    	
	    	
      } 
	  
}

*/
public void getscreenshot(String name) throws Exception 
{
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     //The below method will save the screen shot in d drive with name "screenshot.png"
       

       FileUtils.copyFile(scrFile, new File("./screenshots/"+name+".png"));
	
	
	
}



@AfterTest
public void closeHomePage() {
	

	  
	 driver.quit();
 }

}
