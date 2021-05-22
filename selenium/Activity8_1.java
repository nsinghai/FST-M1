//Activity: 8_1
//Create a Class and a main() method
//Create a WebDriver instance, named driver, with the FirefoxDriver().
//Open the browser with https://training-support.net/selenium/tables using get() method.
//Use findElements() in combination with xpath() to find the number of columns and rows (not counting the table header) and print them.
//Find and print all the cell values of the third row of the table.
//Find and print the cell value at the second row and second column.
//Close the browser.

package SeleniumActivities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity8_1 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
				
		//launch browser and open url
		driver.get("https://training-support.net/selenium/tables");
		
		System.out.println("Page Title: " + driver.getTitle());
		
		//find the number of columns and rows and print them.
		List <WebElement> cols = driver.findElements(By.xpath("//table[contains(@class,'striped')]//tbody/tr[1]/td"));
		List <WebElement> rows = driver.findElements(By.xpath("//table[contains(@class,'striped')]//tbody/tr[1]/td"));
		
		System.out.println("Number of Columns: " + cols.size());
		System.out.println("Number of Rows: " + rows.size());
		
		
        //Get third row values and print them
        List<WebElement> thirdRow = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[3]/td"));
        for(WebElement cellValue : thirdRow) {
            System.out.println("Cell Value: " + cellValue.getText());
        }
 
        //Cell value of second row, second column
        WebElement cellValue2_2 = driver.findElement(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second column value: " + cellValue2_2.getText());
		
		
		//close browser
		driver.close();
	}

}
