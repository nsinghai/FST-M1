//Activity: 4_2
//Create a Class and a main() method
//Create a WebDriver instance, named driver, with the FirefoxDriver().
//Open a browser with https://www.training-support.net/selenium/simple-form
//Get the title of the page using driver.getTitle() and print out the title.
//Use findElement() with xpath() to find all the input fields on the page.
//Fill in the details in the fields using the sendKeys() method.
//Click the submit button at the end of the form to submit the form.

package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.training-support.net/selenium/simple-form");
		System.out.print("Page Title: " + driver.getTitle());
		
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Nimesh");
				
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Singhai");
				
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("nimesh.singhai@gmail.com");
				
		driver.findElement(By.xpath("//input[@id='number']")).sendKeys("1234567890");
		
		driver.findElement(By.xpath("//textarea")).sendKeys("Hello, this is a xyz message!!!");
				
		driver.findElement(By.xpath("//input[@type='submit']")).click();
				
		Thread.sleep(5000);
		driver.close();
	}

}
