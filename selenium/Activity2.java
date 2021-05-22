//Activity2:
//	Create a Class with a main() method
//	Create a WebDriver instance, named driver, with the FirefoxDriver().
//	Open a browser with https://www.training-support.net
//	Get the title of the page using driver.getTitle() and print out the title
//	Use findElement() with the following locators to find the "About Us" link:
//	id()
//	className()
//	linkText()
//	cssSelector()
//	Print the text in the WebElement using the getText() method.
//	Close the browser with driver.close()

package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver  = new FirefoxDriver();
		
		driver.get("https://www.training-support.net/");
		System.out.println("Title of the page is: "+driver.getTitle());
		
		//using id
		WebElement idLocator = driver.findElement(By.id("about-link"));
		System.out.print("\nText in element: " + idLocator.getText());
		
		//using className
		WebElement classNameLocator = driver.findElement(By.className("huge"));
		System.out.println("\nText in element using class name is: " + classNameLocator.getText());
		
		//using linkText
		WebElement linkText = driver.findElement(By.linkText("About Us"));
		System.out.println("\nComplete text using LinkText: " + linkText.getText());
		
		//using partial linkText
		WebElement partialLinkText = driver.findElement(By.partialLinkText("Us"));
		System.out.println("\nText using partialLinkText: " + partialLinkText.getText());
		
		//using cssSelector
		WebElement cssLocator1 = driver.findElement((By.cssSelector(".green")));
		System.out.println("\nText in css Locator1: " + cssLocator1.getText());
		
		//using css=tag#id
		WebElement cssSelector2 = driver.findElement((By.cssSelector("a#about-link")));
		System.out.println("\nText in css Locator2: " + cssSelector2.getText());
		
		//using css=tag.class
		WebElement cssSelector3 = driver.findElement((By.cssSelector("a.ui")));
		System.out.println("\nText in css Locator3: " + cssSelector3.getText());
		
		Thread.sleep(1000);
		driver.close();

	}

}