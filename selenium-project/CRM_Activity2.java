//Activity2: 
//Get the url of the header image
//Goal: Print the url of the header image to the console

package CRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class CRM_Activity2 {
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
			driver.get("http://alchemy.hguy.co/crm");
	  }
	@Test
  public void actualTest() {
	  String imageURL = driver.findElement(By.xpath("//div[@class='companylogo']/img")).getAttribute("src");
	  System.out.println("Header image url: " + imageURL);
	  
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("CRM Activity 2 completed");
	  driver.close();
  }

}
