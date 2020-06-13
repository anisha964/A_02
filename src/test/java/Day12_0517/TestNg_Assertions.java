package Day12_0517;

import Resuable_Library.Reusable_Library2;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class TestNg_Assertions {
    WebDriver driver;

    @BeforeSuite
    public void defineDriver() throws IOException, InterruptedException {

        driver= Reusable_Library2.setDriver();

    }//end of before suite

    @Test
    public void KayakTestCase() throws InterruptedException {
        driver.navigate().to("https://www.kayak.com");
        Thread.sleep(2000);
        //verify the title using hard assertion
        // Assert.assertEquals(driver.getTitle(),"Search Hotels, Cars");
        // using soft assertion
        SoftAssert sAssert = new SoftAssert();
        sAssert.assertEquals(driver.getTitle(), "Search Hotels,Cars");
        //click on airport or city
        Reusable_Library2.click(driver, "//*[@data-placeholder='Enter an airport or city']", "Search Field");
        //enter the airport
        Reusable_Library2.userKeys(driver, "//*[@name='pickup']", "JFK", "Search Field");
        Thread.sleep(3000);
        //doesnt miss any test steps
        sAssert.assertAll();
    }//end



    }//end of test










