//Activity: 8
//Traversing tables
//Goal: Open the accounts page and print the contents of the table.

package CRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class CRM_Activity8 {
	WebDriver driver;
	
  @Test
  public void actualTest() throws InterruptedException {
	  //click on sales
	  driver.findElement(By.xpath("//a[@id='grouptab_0']")).click();
	  Thread.sleep(2000);
	  
	  //click on Accounts
	  driver.findElement(By.xpath("//a[@id='moduleTab_9_Accounts']")).click();
	  Thread.sleep(2000);
	  
	  //print the names of the first 5 odd-numbered rows
	  for (int i=1;i<10;i+=2)
		{
		System.out.println(driver.findElement(By.xpath("//form[@id='MassUpdate']/div/table/tbody/tr["+i+"]/td[3]/b/a")).getText());
		}
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
	  System.out.println("CRM Activity 8 completed");
	  driver.close();
  }

}
