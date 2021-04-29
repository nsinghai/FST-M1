//Activity:4
//Logging into the site
//Goal: Open the site and login with the credentials provided

package CRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class CRM_Activity4 {
	WebDriver driver;
	
  @Test
  public void actualTest() throws InterruptedException {
	  driver.findElement(By.id("user_name")).sendKeys("admin");
	  driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
	  driver.findElement(By.id("bigbutton")).click();
	  Thread.sleep(2000);
	  
	   boolean newPage =driver.findElement(By.id("tab0")).isDisplayed();
	   
	   	    if(newPage == true)
	    {
	    	System.out.println("Home Page has opened");
	    }
  }
  
  @BeforeTest
  public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/crm");
		System.out.println("Initial Title: " + driver.getTitle());
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("CRM Activity 4 completed");
	  driver.close();
  }
}
