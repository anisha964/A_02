package Day13_0530;

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

public class List_boolean_Log {

    WebDriver driver;

    ExtentReports reports;
    //declare the logger (extent test)
    ExtentTest logger;

    @BeforeSuite
    public void defineDriver() throws IOException, InterruptedException {
        driver= Reusable_Library2.setDriver();
        reports= new ExtentReports("src//main//java//HTML_Report//AutomationReport.html",true);
    }//end of before suite


   //new changes

    @Test
    public void yahoo_verification() throws InterruptedException {
        logger=reports.startTest("yahoo verification");
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


        Reusable_Library2.click(driver, "//*[@id='header-signin-link']", "Sign In");

        boolean checkboxState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        if (checkboxState == false) {
            System.out.println("checkbox is not selected by default");
            logger.log(LogStatus.FAIL,"checkbox is selected by default");
        } else {
            System.out.println("checkbox is not selected by default");
            logger.log(LogStatus.PASS,"checkbox is selected by default");
        }//end of if else

        reports.endTest(logger);

    }// end test

        @AfterSuite
        public void close() {
        //flushing= going back to Automation report
         reports.flush();
       // driver.quit();

        } //end of after suite
































}
