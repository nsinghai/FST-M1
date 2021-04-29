//Activity: 7
//Reading additional information
//Goal: Reading a popup that contains additional information about the account/lead.
package CRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class CRM_Activity7 {
	WebDriver driver;
	
  @Test
  public void actualTest() throws InterruptedException {
	  //click on sales
	  driver.findElement(By.xpath("//a[@id='grouptab_0']")).click();
	  
	  //click on Leads
	  driver.findElement(By.xpath("//a[@id='moduleTab_9_Leads']")).click();
	  Thread.sleep(2000);
	  
	  //click on information
	  driver.findElement(By.xpath("//*[@id='adspan_e3b6f9f3-b87c-2486-fa8c-6061ba037e94']/span")).click();
	  Thread.sleep(2000);
	  
	  //get phone number
	  String phone = driver.findElement(By.xpath("//span[@class='phone']")).getText();
	  System.out.println("Phone Number: " + phone);
	  
	  
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
	  System.out.println("CRM Activity 7 completed");
	  driver.close();
  }
}
