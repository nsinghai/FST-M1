//Activity: 5_2: isSelected() Method
//Create a Package with a Class and a main() method
//Create a WebDriver instance, named driver, with the FirefoxDriver().
//Launch the web browser and open https://training-support.net/selenium/dynamic-controls using the get() method.
//Get the page title and print it to the console.
//Use findElement() to find the checkbox input element.
//Use the isSelected() method to check if the checkbox is selected.
//Click the checkbox to select it.
//Use the isSelected() method again and print the result

package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		
		//launch browser and open url
		driver.get("https://training-support.net/selenium/dynamic-controls");
		
		System.out.println("Page Title: " + driver.getTitle());
		
		WebElement checkbx = driver.findElement(By.xpath("//input[@class='willDisappear']"));
		System.out.println("Is the Checkbox selected?: " + checkbx.isSelected());
		
		//Click the checkbox to select it
		checkbx.click();
		
		Thread.sleep(2000);
		
		System.out.println("Is the Checkbox selected NOW?: " + checkbx.isSelected());
		
		driver.close();

	}

}
