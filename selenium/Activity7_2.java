//Activity: 7_2
//Create a Class and a main() method
//Create a WebDriver instance, named driver, with the FirefoxDriver().
//Open a browser with https://training-support.net/selenium/dynamic-attributes
//Get the title of the page using driver.getTitle() and print out the title.
//Find the input fields of the Sign Up form. Fill in the details in the fields with your own data.
//Wait for success message to appear and print it to the console.
//Finally, close the browser.

package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7_2 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
				
		//launch browser and open url
		driver.get("https://training-support.net/selenium/dynamic-attributes");
		
		System.out.println("Page Title: " + driver.getTitle());
		
		//Find the username 
		WebElement username = driver.findElement(By.xpath("//input[contains(@class,'-username')]"));
		username.sendKeys("Nimesh");
		
		//Find the password
		WebElement pwd = driver.findElement(By.xpath("//input[contains(@class,'-password')]"));
		pwd.sendKeys("password");
		
		//confirm password
		WebElement pwd_confirm = driver.findElement(By.xpath("//label[text() = 'Confirm Password']/following::input"));
		pwd_confirm.sendKeys("password");
		
		//enter Email
		WebElement email = driver.findElement(By.xpath("//label[text() = 'Email']/following::input"));
		email.sendKeys("nimesh@gmail.com");
		
		//click login button
		driver.findElement(By.xpath("//label[text() = 'Email']/following::button")).click();
		
		
		System.out.println("Signup message: " + driver.findElement(By.id("action-confirmation")).getText());
		
		//close the browser
		driver.close();

	}

}
