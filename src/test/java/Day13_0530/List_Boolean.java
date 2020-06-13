package Day13_0530;

import Resuable_Library.Reusable_Library2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class List_Boolean {

    WebDriver driver;

    @BeforeSuite
    public void defineDriver() throws IOException, InterruptedException {
        driver= Reusable_Library2.setDriver();
    }//end of before suite


    @Test
    public void yahoo_verification() throws InterruptedException {
        driver.navigate().to("https://www.yahoo.com");

        Thread.sleep(3500);

        List<WebElement> linkcount = driver.findElements(By.xpath("//*[contains(@class,'D(ib) Mstart(21px) Mend(17px)')]"));

        if (linkcount.size() == 12) {
            System.out.println("my yahoo home page link count matches and it is" + linkcount.size());
        } else {
            System.out.println("My yahoo home page link count doesnt matches and actual is" + linkcount.size());

        }//end of if else


        Reusable_Library2.click(driver, "//*[@id='header-signin-link']", "Sign In");

        boolean checkboxState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        if (checkboxState == true) {
            System.out.println("checkbox is selected by default");
        } else {
            System.out.println("checkbox is not selected by default");
        }//end of if else

    }// end test

        @AfterSuite
        public void close() {

       // driver.quit();

        } //end of after suite
































}
