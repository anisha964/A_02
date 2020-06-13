package Day14_0531;

import Resuable_Library.Abstract_Class;
import Resuable_Library.Resuable_Library2_Logger;
import Resuable_Library.Reusable_Library2;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class Boolean_Abstract extends Abstract_Class {





    @Test
    public void yahoo_verification() throws InterruptedException {
        driver.navigate().to("https://www.yahoo.com");
        logger.log(LogStatus.INFO,"navigating to homepage");
        Thread.sleep(3500);
        logger.log(LogStatus.INFO,"getting the the list count");
        List<WebElement> linkcount = driver.findElements(By.xpath("//*[contains(@class,'D(ib) Mstart(21px) Mend(17px)')]"));

        if (linkcount.size() == 12) {
            System.out.println("my yahoo home page link count matches and it is" + linkcount.size());
            logger.log(LogStatus.PASS,"my yahoo home page link count matches and it is");
        } else {
            System.out.println("My yahoo home page link count doesnt match and actual is" + linkcount.size());
            logger.log(LogStatus.FAIL,"My yahoo home page link count doesnt match and actual is");
        }//end of if else


        Resuable_Library2_Logger.click(driver, "Boo", "Sign In",logger);

        boolean checkboxState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        if (checkboxState == false) {
            System.out.println("checkbox is not selected by default");
            logger.log(LogStatus.FAIL,"checkbox is selected by default");
        } else {
            System.out.println("checkbox is not selected by default");
            logger.log(LogStatus.PASS,"checkbox is selected by default");
        }//end of if else

       // "//*[@id='header-signin-link']"

    }// end test

































}
