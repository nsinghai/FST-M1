//Activity1: Goal: Read the title of the website and verify the text

package CRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class CRM_Activity1 {
	
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/crm");
	}
	
  @Test
  public void actualTest() {
	  String title = driver.getTitle();
	  System.out.println("Page Title: " + title);
	  
	  Assert.assertEquals("SuiteCRM", title);
  }
  
  @AfterMethod
  public void afterMethod() {
	  System.out.println("CRM Activity 1 completed");
	  driver.close();
  }
}
