package actionitem;

import Resuable_Library.Reusable_Library2;
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
import java.net.BindException;
import java.util.ArrayList;

public class Kayak {

    WebDriver driver;

    Workbook readableFile;

    Sheet readableSheet;

    WritableWorkbook writableFile;

    WritableSheet wsheet;

    @BeforeSuite
    public void callDriver() throws IOException, BiffException, InterruptedException {
        //define the path
        readableFile = Workbook.getWorkbook(new File("src//main//resources/Kayak_Search.xls"));
        readableSheet = readableFile.getSheet(0);
        writableFile = Workbook.createWorkbook(new File("src//main//resources//Kayak_Search_Results.xls"), readableFile);
        wsheet = writableFile.getSheet(0);
        driver = Reusable_Library2.setDriver();

    }//end of before suite

    @Test
    public void KayakSearch() throws InterruptedException, IOException, WriteException {
        int row = wsheet.getRows();
        //for loop
        for (int i = 1; i < row; i++) {
            String airportName = wsheet.getCell(0, i).getContents();
            String startDate = wsheet.getCell(1, i).getContents();
            String startTime = wsheet.getCell(2, i).getContents();
            String endDate = wsheet.getCell(3, i).getContents();
            String endTime = wsheet.getCell(4, i).getContents();
            String vehiclesize = wsheet.getCell(5, i).getContents();
            String vehicleInfo = wsheet.getCell(6, i).getContents();

            //will navigate to kayak
            driver.navigate().to("https://www.kayak.com");
            Reusable_Library2.click(driver, "//*[@data-placeholder='Enter an airport or city']", "Search Field");
            //enter the airport
            Reusable_Library2.userKeys(driver, "//*[@name='pickup']", airportName, "Search Field");
            Thread.sleep(3000);
            //click on the first option
            Reusable_Library2.MouseClick(driver, "//li[@tabindex='0']", "click on airport");
            //this will click on end date
            Reusable_Library2.clickbyIndex(driver, "//*[@class='_isu _iad _iaf _iEc _iaa _iPK _iam _j0E _j0F _iai']", 1, "end date");
            Thread.sleep(2000);
            //enter the  end dates
            Reusable_Library2.userTypeAndHitEnter(driver, "//*[@class='Common-Widgets-Datepicker-StyleJamDateTimeInput-DateTimeInput__input DateTimeInput-range-modal-lightweight__input _id7 _ibU _ibV _idE _ii0 _itL _iCj _iax']", endDate, "end date");
            Thread.sleep(2000);
            // this will click outside
            Reusable_Library2.click(driver, "//*[@class='title dark']", "clickOutside");
            // this will click on end time
            Reusable_Library2.clickbyIndex(driver, "//*[@aria-haspopup='listbox']", 2, "click on end time");
            Thread.sleep(2000);
            //this will enter all the end time from excel
            Reusable_Library2.clickbyIndex(driver, "//li[@aria-label='" + endTime + "']", 1, "end time");
            Thread.sleep(2000);
            //this will click on start date
            Reusable_Library2.clickbyIndex(driver, "//*[@class='_isu _iad _iaf _iEc _iaa _iPK _iam _j0E _j0F _iai']", 0, "click on start date");
            Thread.sleep(2000);
            // this will enter all the start dates from excel
            Reusable_Library2.userTypeAndHitEnter(driver, "//div[contains(@id,'pickup-date-input')]", startDate, "startDate");
            //this will click outside
            Reusable_Library2.click(driver, "//*[@class='title dark']", "clickOutside");
            Thread.sleep(2000);
            // this will click on start date
            //Reusable_Library2.click(driver, "//*[@class='_iKN _j0E _iQh _j0F']", "click on start time");
            Thread.sleep(2000);
            //this will enter all the start time from excel
            Reusable_Library2.clickbyIndex(driver, "//li[@aria-label='" + startTime + "']", 0, "start time");
            Thread.sleep(2000);
            //this will click on search icon[
            Reusable_Library2.click(driver, "//*[@class='_h-2 _ivP _iv1']", "search icon");
            Thread.sleep(3000);
            Reusable_Library2.clickbyIndex(driver, "//div[contains(@id,'" + vehiclesize + "')]", 1, "Size");
            Thread.sleep(3000);
            Reusable_Library2.clickbyIndex(driver, "//*[text()='View Deal']", 1, "viewDeal");
            Thread.sleep(3000);
             ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
             Thread.sleep(2000);

            driver.switchTo().window(tabs.get(1));

          String result2=Reusable_Library2.captureText(driver,"//*[@class='ss_inner' or @class='bui-panel   ' or @class='Checkout-Common-Uicore-NormalText resetColor']","captureText");
          System.out.println("My  message is " + result2 );

            Label label= new Label(6,i,result2);
            wsheet.addCell(label);




             driver.close();

            driver.switchTo().window(tabs.get(0));

            driver.manage().deleteAllCookies();

        }//end of loop


    }//end of test

    @AfterSuite
    public void quitDriver() throws IOException, WriteException {
        writableFile.write();
        writableFile.close();
        readableFile.close();
        driver.quit();
    }//end of Aftermethod

}




