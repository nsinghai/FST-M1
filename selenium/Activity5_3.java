//Activity: 5_3 : isEnabled() Method
//Create a Package with a Class and a main() method
//Create a WebDriver instance, named driver, with the FirefoxDriver().
//Launch the web browser and open https://training-support.net/selenium/dynamic-controls using the get() method.
//Get the page title and print it to the console.
//Use findElement() to find the text field.
//Use the isEnabled() method to check if the text field is enabled.
//Click the "Enable Input" button to enable the input field.
//Use the isEnabled() method again and print the result.

package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		
		//launch browser and open url
		driver.get("https://training-support.net/selenium/dynamic-controls");
		
		System.out.println("Page Title: " + driver.getTitle());
		
		WebElement inputtxt = driver.findElement(By.xpath("//input[@id='input-text']"));
		System.out.println("Is the Input Text enabled?: " + inputtxt.isEnabled());
		
		//Click the "Enable Input" button to enable the input field.
		driver.findElement(By.xpath("//button[@id='toggleInput']")).click();
					
		Thread.sleep(2000);
		
		System.out.println("Is the Input Text enabled NOW?: " + inputtxt.isEnabled());
		
		driver.close();

	}

}
