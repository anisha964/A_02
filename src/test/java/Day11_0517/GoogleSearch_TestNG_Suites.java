package Day11_0517;

import Resuable_Library.Reusable_Library2;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class GoogleSearch_TestNG_Suites {
    // when using annotation method your local driver
//must be declared outside so I can call it
//on all my annotation method
    WebDriver driver;
    String getURL;


    @BeforeSuite
    public void callDriver() throws IOException, InterruptedException {
        driver = Reusable_Library2.setDriver();

    } //end of Before Method

    @AfterSuite

    public void quitDriver() {
        driver.quit();

    }// end of Aftermethod

    @Test(priority=1 )
    public void searchIngoogle() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        // enter keyword car on my search field
        Reusable_Library2.userKeys(driver, "//*[@name='q']", "Cars", "Search Field");
        Reusable_Library2.submit(driver, "//*[@name='btnK']", "Google Search Button");
        Thread.sleep(2000);
      getURL=driver.getCurrentUrl();
    }// end of test priority 1
    //when you use depenedOnMethods in your @Test that means your second test is dependant
    //on your first test if first test fails second test will be skipped
    //if all test has priorities they might or might not be not be dependant on each other

        @Test(dependsOnMethods="searchIngoogle")
        public void captureTheResult() throws InterruptedException {
        driver.navigate().to(getURL);
             Thread.sleep(2000);
            String searchResult = Reusable_Library2.captureText(driver, "//*[@id='result-stats']", "Search Results");
            //split
            String[] arraySearch = searchResult.split(" ");
            System.out.println("My search number is " + arraySearch[1]);
        }//end of priority 2




}//end of java class
