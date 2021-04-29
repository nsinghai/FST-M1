//Activity 3: Get the copyright text
//Goal: Print the first copyright text in the footer to the console

package CRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class CRM_Activity3 {
	WebDriver driver;
	
  @Test
  public void actualTest() {
	  String text = driver.findElement(By.id("admin_options")).getText();
	  System.out.println("Copyright Text: " + text);
  }
    
  @BeforeMethod
  public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/crm");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("CRM Activity 3 completed");
	  driver.close();
  }
}
