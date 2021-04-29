//Activity: 9
//Traversing tables 2
//Goal: Open the leads page and print the usernames and full names from the table.

package CRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class CRM_Activity9 {
	WebDriver driver;
	
  @Test
  public void actualTest() throws InterruptedException {
	  //click on sales
	  driver.findElement(By.xpath("//a[@id='grouptab_0']")).click();
	  Thread.sleep(2000);
	  
	  //click on Leads
	  driver.findElement(By.xpath("//a[@id='moduleTab_9_Leads']")).click();
	  Thread.sleep(2000);
	  
	  for (int i=1;i<11;i++)
		{
		String name = driver.findElement(By.xpath("//form[@id='MassUpdate']/div[3]/table/tbody/tr["+i+"]/td[3]/b/a")).getText();
		String user = driver.findElement(By.xpath("//form[@id='MassUpdate']/div[3]/table/tbody/tr["+i+"]/td[8]/a")).getText();
		System.out.println(name + "  " + user);
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
	  System.out.println("CRM Activity 9 completed");
	  driver.close();
  }

}
