//Activity 3
//Create a Class with a main() method.
//Create a WebDriver instance, named driver, with the FirefoxDriver().
//Open a browser with https://training-support.net/selenium/simple-form
//Get the title of the page using driver.getTitle() and print out the title.
//Use findElement() with name() to find the text fields - firstname and lastname.
//Use WebElement.sendKeys() to type in those text fields.
//Similarly, find and type into the email and contact number fields.
//Finally, submit the form by clicking the Submit button.
//Close the browser with driver.close()
package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/simple-form");
		System.out.println("Page Title: " + driver.getTitle());
		 
		WebElement firstName = driver.findElement(By.id("firstName"));
		firstName.sendKeys("Nimesh");
		
		WebElement lastName = driver.findElement(By.id("lastName"));
		lastName.sendKeys("Singhai");
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("nimesh.singhai@gmail.com");
		
		WebElement contact = driver.findElement(By.id("number"));
		contact.sendKeys("9980698804");
				
		WebElement clickToSubmit = driver.findElement(By.className("green"));
		clickToSubmit.click();
		
		Thread.sleep(1000);
		driver.close();
	}

}
