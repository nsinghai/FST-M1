//Activity1:
//	This is a simple activity that shows the boilerplate of every test.
//	Create a Class with a main() method
//	Create a WebDriver instance, named driver, with the FirefoxDriver().
//	Open a browser with https://www.training-support.net
//	Close the browser with driver.close()
	
package SeleniumActivities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver(); 
		
		driver.get("https://www.training-support.net");
		driver.close();
	}

}
