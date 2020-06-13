package Day11_0517;

import Resuable_Library.Reusable_Library2;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class GoogleSearch_NG {
    // when using annotation method your local driver
//must be declared outside so I can call it
//on all my annotation method
    WebDriver driver;


    @BeforeMethod
    public void callDriver() throws IOException, InterruptedException {
        driver = Reusable_Library2.setDriver();
        driver.navigate().to("https://www.google.com");
    } //end of Before Method

    @AfterMethod

    public void quitDriver() {
        driver.quit();

    }// end of Aftermethod

    @Test
    public void googleSearch() throws InterruptedException {
    // enter keyword car on my search field
        Reusable_Library2.userKeys(driver,"//*[@name='q']","Cars","Search Field");
        Reusable_Library2.submit(driver,"//*[@name='btnK']","Google Search Button");
        Thread.sleep(2000);
        String searchResult = Reusable_Library2.captureText(driver,"//*[@id='result-stats']","Search Results");
        //split
        String[] arraySearch = searchResult.split(" ");
        System.out.println("My search number is "+ arraySearch[1]);


    }// end of google test


}//end of java class
