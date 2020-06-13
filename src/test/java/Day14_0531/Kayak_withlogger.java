package Day14_0531;

import Resuable_Library.Resuable_Library2_Logger;
import Resuable_Library.Reusable_Library2;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Kayak_withlogger {

    WebDriver driver;

    Workbook readableFile;

    Sheet readableSheet;

    WritableWorkbook writableFile;

    WritableSheet wsheet;

    ExtentReports reports;
    ExtentTest logger;

    @BeforeSuite
    public void callDriver() throws IOException, BiffException, InterruptedException {
        //define the path
        readableFile = Workbook.getWorkbook(new File("src//main//resources/Kayak_Search.xls"));
        readableSheet = readableFile.getSheet(0);
        writableFile = Workbook.createWorkbook(new File("src//main//resources//Kayak_Search_Results.xls"), readableFile);
        wsheet = writableFile.getSheet(0);
        driver = Reusable_Library2.setDriver();
        Thread.sleep(1500);
        reports= new ExtentReports("src//main//java//HTML_Report//Kayak_Report.html", true);

    }//end of before suite

    @Test
    public void KayakSearch() throws InterruptedException, IOException, WriteException {
        logger= reports.startTest("kayak search result");
        int row = wsheet.getRows();
        //for loop
        for (int i = 1; i < 2; i++) {
            String airportName = wsheet.getCell(0, i).getContents();
            String startDate = wsheet.getCell(1, i).getContents();
            String startTime = wsheet.getCell(2, i).getContents();
            String endDate = wsheet.getCell(3, i).getContents();
            String endTime = wsheet.getCell(4, i).getContents();
            String vehiclesize = wsheet.getCell(5, i).getContents();
            String vehicleInfo = wsheet.getCell(6, i).getContents();

            //will navigate to kayak
            driver.navigate().to("https://www.kayak.com");
            Resuable_Library2_Logger.click(driver, "//*[@data-placeholder='Enter an airport or city']", "Search Field",logger);
            //enter the airport
            Resuable_Library2_Logger.userKeys(driver, "//*[@name='pickup']", airportName, "Search Field",logger);
            Thread.sleep(3000);
            //click on the first option
            Resuable_Library2_Logger.MouseClick(driver, "//li[@tabindex='0']", "click on airport",logger);
            //this will click on end date
            Resuable_Library2_Logger.clickbyIndex(driver, "//*[@class='_isu _iad _iaf _iEc _iaa _iPK _iam _j0E _j0F _iai']", 1, "end date",logger);
            Thread.sleep(2000);
            //enter the  end dates
            Resuable_Library2_Logger.userTypeAndHitEnter(driver, "//*[@class='Common-Widgets-Datepicker-StyleJamDateTimeInput-DateTimeInput__input DateTimeInput-range-modal-lightweight__input _id7 _ibU _ibV _idE _ii0 _itL _iCj _iax']", endDate, "end date", logger);
            Thread.sleep(2000);
            // this will click outside
            Resuable_Library2_Logger.click(driver, "//*[@class='title dark']", "clickOutside",logger);
            // this will click on end time
            Resuable_Library2_Logger.clickbyIndex(driver, "//*[@aria-haspopup='listbox']", 2, "click on end time",logger);
            Thread.sleep(2000);
            //this will enter all the end time from excel
            Resuable_Library2_Logger.clickbyIndex(driver, "//li[@aria-label='" + endTime + "']", 1, "end time",logger);
            Thread.sleep(2000);
            //this will click on start date
            Resuable_Library2_Logger.clickbyIndex(driver, "//*[@class='_isu _iad _iaf _iEc _iaa _iPK _iam _j0E _j0F _iai']", 0, "click on start date",logger);
            Thread.sleep(2000);
            // this will enter all the start dates from excel
            Resuable_Library2_Logger.userTypeAndHitEnter(driver, "//div[contains(@id,'pickup-date-input')]", startDate, "startDate",logger);
            //this will click outside
            Resuable_Library2_Logger.click(driver, "//*[@class='title dark']", "clickOutside",logger);
            Thread.sleep(2000);
            // this will click on start date
            //Reusable_Library2.click(driver, "//*[@class='_iKN _j0E _iQh _j0F']", "click on start time");
            Thread.sleep(2000);
            //this will enter all the start time from excel
            Resuable_Library2_Logger.clickbyIndex(driver, "//li[@aria-label='" + startTime + "']", 0, "start time",logger);
            Thread.sleep(2000);
            //this will click on search icon[
            Resuable_Library2_Logger.click(driver, "//*[@class='_h-2 _ivP _iv1']", "search icon",logger);
            Thread.sleep(3000);
            Resuable_Library2_Logger.clickbyIndex(driver, "//div[contains(@id,'" + vehiclesize + "')]", 1, "Size",logger);
            Thread.sleep(3000);
            Resuable_Library2_Logger.clickbyIndex(driver, "//*[text()='View Deal']", 1, "viewDeal",logger);
            Thread.sleep(3000);
             ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
             Thread.sleep(2000);

            driver.switchTo().window(tabs.get(1));

          String result2=Resuable_Library2_Logger.captureText(driver,"//*[@class='ss_inner' or @class='bui-panel   ' or @class='Checkout-Common-Uicore-NormalText resetColor']","captureText",logger);
          System.out.println("My  message is " + result2 );

            Label label= new Label(6,i,result2);
            wsheet.addCell(label);




             driver.close();

            driver.switchTo().window(tabs.get(0));

            driver.manage().deleteAllCookies();

        }//end of loop

        reports.endTest(logger);


    }//end of test

    @AfterSuite
    public void quitDriver() throws IOException, WriteException {
        writableFile.write();
        writableFile.close();
        readableFile.close();
        reports.flush();
        driver.quit();
    }//end of Aftermethod

}




