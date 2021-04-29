//Activity: 5
//Getting colors
//Goal: Get the color of the navigation menu

package CRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class CRM_Activity5 {
	WebDriver driver;
	
  @Test
  public void actualTest() {
	  //String getColour = driver.findElement(By.xpath("(//div[@class='container-fluid'])[1]")).getCssValue("color");
	  String getColor = driver.findElement(By.xpath("//div[@id='toolbar']")).getCssValue("color");
	  System.out.println("Colour of Navigation Menu: " + getColor);
	  
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
	  System.out.println("CRM Activity 5 completed");
	  driver.close();
  }

}
