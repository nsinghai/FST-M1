//Activity:6
//Menu checking
//Goal: Make sure that the “Activities” menu item exists and is clickable

package CRM;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class CRM_Activity6 {
	WebDriver driver;
	
  @Test
  public void actualTest() {
	  String activities = driver.findElement(By.xpath("//a[@id='grouptab_3']")).getText();
	  System.out.println("Text: " + activities);
	  Assert.assertEquals("ACTIVITIES", activities);
  }
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	driver = new FirefoxDriver();
	driver.get("http://alchemy.hguy.co/crm");
	System.out.println("Initial Title: " + driver.getTitle());
	  driver.findElement(By.id("user_name")).sendKeys("admin");
	  driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
	  driver.findElement(By.id("bigbutton")).click();
	  Thread.sleep(1000);	  
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("CRM Activity 6 completed");
	  driver.close();
  }

}
