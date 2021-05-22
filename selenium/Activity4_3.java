//Activity: 4_3
//Create a Class and a main() method
//Create a WebDriver instance, named driver, with the FirefoxDriver().
//Open a browser with https://www.training-support.net/selenium/target-practice
//Get the title of the page using driver.getTitle() and print out the title.
//Use findElement() with xpath() to
//Find the third header on the page.
//Find the fifth header on the page and get it's 'colour' CSS Property.
//Find the violet button on the page and print all the class attribute values.
//Find the grey button on the page with Absolute XPath

package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/target-practice");
		System.out.println("Page Title: " + driver.getTitle());
		
		WebElement third  = driver.findElement(By.xpath("//h3[@id='third-header']"));
		System.out.println("Third Header Text: " + third.getText());
		
		String fifthElement = driver.findElement(By.xpath("//h5[@class='ui green header']")).getCssValue("color");
		System.out.println("Colour of Fifth Header: " + fifthElement);
		
		String violet = driver.findElement(By.xpath("//button[@class='ui violet button']")).getAttribute("class");
		System.out.println("Attributes of violet: " + violet);
		
		String grey = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]")).getText();
		System.out.println("Grey button Text: " + grey);
		
		Thread.sleep(2000);
		driver.close();
	}
}
