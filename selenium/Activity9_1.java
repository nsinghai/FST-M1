//Activity: 9_1
//Create a Class and a main() method
//Create a WebDriver instance, named driver, with the FirefoxDriver().
//Open the browser with https://training-support.net/selenium/selects using the get() method.
//Use findElement() to find the dropdown WebElement on the page.
//Create a new Select class object with the WebElement.
//On the dropdown,
//Select the second option using selectByVisibleText()
//Select the third option using selectByIndex()
//Select the fourth option using selectByValue()
//Finally, get all the options in the dropdown and print them one by one.

package SeleniumActivities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity9_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        //Open browser
        driver.get("https://training-support.net/selenium/selects");

        //Chosen option
        WebElement chosen = driver.findElement(By.id("single-value"));

        //Find dropdown
        Select dropdown = new Select(driver.findElement(By.id("single-select")));

        //Select second option by visible text
        dropdown.selectByVisibleText("Option 2");
        System.out.println(chosen.getText());

        //Select third option by index
        dropdown.selectByIndex(3);
        System.out.println(chosen.getText());

        //Select fourth option by value
        dropdown.selectByValue("4");
        System.out.println(chosen.getText());
        
        //Get all options
        List<WebElement> options = dropdown.getOptions();
        //Print them
        for(WebElement option : options) {
            System.out.println("Option: " + option.getText());
        }

        //Close browser
        driver.close();
    }
}