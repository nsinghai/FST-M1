//Activity: 6_1
//Create a Class and a main() method
//For this activity import the following classes
//org.openqa.selenium.support.ui.ExpectedConditions
//org.openqa.selenium.support.ui.WebDriverWait
//Create a WebDriver instance, named driver, with the FirefoxDriver().
//Open a browser with https://training-support.net/selenium/dynamic-controls
//Get the title of the page using driver.getTitle() and print out the title.
//Find the checkbox toggle button and click it.
//Wait till the checkbox disappears.
//Click the button again. Wait till it appears and check the checkbox.
//Finally, close the browser.

package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6_1 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		//launch browser and open url
		driver.get("https://training-support.net/selenium/dynamic-controls");
		
		System.out.println("Page Title: " + driver.getTitle());
		
		WebElement checkbox = driver.findElement(By.xpath("//input[@class='willDisappear']"));
		
		//Find the checkbox toggle button and click it.
		WebElement checkboxBtn = driver.findElement(By.id("toggleCheckbox"));
		checkboxBtn.click();
				
		wait.until(ExpectedConditions.invisibilityOf(checkbox));
		
		checkboxBtn.click();
		wait.until(ExpectedConditions.visibilityOf(checkbox));
				
		checkboxBtn.click();
		wait.until(ExpectedConditions.invisibilityOf(checkbox));		
				
		driver.close();

	}

}
