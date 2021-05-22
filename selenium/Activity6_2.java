//Activity: 6_2
//Create a Class and a main() method
//Create a WebDriver instance, named driver, with the FirefoxDriver().
//Open a browser with https://training-support.net/selenium/ajax
//Get the title of the page using driver.getTitle() and print out the title.
//Find and click the "Change content" button on the page.
//Wait for the text to say "HELLO!". Print the message that appears on the page.
//Wait for the text to change to contain "I'm late!". Print the new message on the page.
//Finally, close the browser.

package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6_2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		//launch browser and open url
		driver.get("https://training-support.net/selenium/ajax");
		
		System.out.println("Page Title: " + driver.getTitle());
		
		WebElement Btn = driver.findElement(By.xpath("//button[@class='ui violet button']"));
		Btn.click();
		
		//Wait for the text to say "HELLO!". Print the message that appears on the page.
		WebElement txt = driver.findElement(By.xpath("//div[@id='ajax-content']//h1"));
		wait.until(ExpectedConditions.visibilityOf(txt));
		System.out.println("Here is Hello Text: " + txt.getText());
		
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "I'm late!"));
		WebElement late = driver.findElement(By.xpath("//div[@id='ajax-content']//h3"));
		System.out.print("Here is late text: " + late.getText());
		
		Thread.sleep(2000);
		
		driver.close();

	}

}
