//Activity:2
//    Create a TestNG Class with the annotations
//        @Test
//        @BeforeClass
//        @AfterClass
//    In the @BeforeClass method, create the a driver instance for FirefoxDriver
//    Also use the get() method to open the browser with https://www.training-support.net/selenium/target-practice
//    In the @AfterClass method, use close() to close the browser once the test is done.
//    Add 4 @Test methods.
//    In the first @Test method, use getTitle() to get and assert the title of the page.
//    In the second @Test method, use findElement() to look for the black button. Make an incorrect assertion. (This test case is meant to throw an error)
//    For the third @Test method, skip it by setting it's enabled parameter to false.
//        The third method will be skipped, but will not be shown as skipped.
//    For the fourth @Test method, skip it by throwing a SkipException inside the method.
//        The fourth method will be skipped and it will be shown as skipped.
//    Observe the result in the console.


package testNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;
    
    @BeforeTest
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
            
        //Open the browser
        driver.get("https://www.training-support.net/selenium/target-practice");
    }
    
    @Test
    public void testCase1() {
        //This test case will pass
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertEquals(title, "Target Practice");
    }
    
    @Test
    public void testCase2() {
        //This test case will Fail
        WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
        Assert.assertTrue(blackButton.isDisplayed());
        Assert.assertEquals(blackButton.getText(), "black");
    }
    
    @Test(enabled = false)
    public void testCase3() {
        //This test will be skipped and not counted
        String subHeading = driver.findElement(By.className("sub")).getText();
        Assert.assertTrue(subHeading.contains("Practice"));
    }
    
    @Test
    public void testCase4() {
        //This test will be skipped and will be be shown as skipped
        throw new SkipException("Skipping test case");      
    }

    @AfterTest
    public void afterMethod() {
        //Close the browser
        driver.close();
    }

}
