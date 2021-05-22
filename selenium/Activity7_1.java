//Activity: 7_1
//Create a Class and a main() method
//Create a WebDriver instance, named driver, with the FirefoxDriver().
//Open a browser with https://training-support.net/selenium/dynamic-attributes
//Get the title of the page using driver.getTitle() and print out the title.
//Find the username and password input fields. Type in the credentials:
//username: admin
//password: password
//Wait for login message to appear and print the login message to the console.
//Finally, close the browser.

package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity7_1 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		//launch browser and open url
		driver.get("https://training-support.net/selenium/dynamic-attributes");
		
		System.out.println("Page Title: " + driver.getTitle());
		
		//Find the username and password input fields.
		WebElement username = driver.findElement(By.xpath("//input[starts-with(@class,'username')]"));
		username.sendKeys("admin");
		
		WebElement pwd = driver.findElement(By.xpath("//input[contains(@class,'password')]"));
		pwd.sendKeys("password");
		
		//click login button
		driver.findElement(By.xpath("//button[@class='ui button']")).click();
		
		//Wait for login message to appear
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("action-confirmation"), "Welcome Back, admin"));
		
		System.out.println("Login message: " + driver.findElement(By.id("action-confirmation")).getText());
		
		//close the browser
		driver.close();
	}

}
