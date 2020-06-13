package actionitem;

import Resuable_Library.Abstract_Class;
import Resuable_Library.Resuable_Library2_Logger;
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

public class GoogleSearch_TestNG_Excel_xml extends Abstract_Class {

    //readable workbook
    Workbook readableFile;
    //readable sheet
    Sheet readableSheet;
    //writable workbook
    WritableWorkbook writableFile;
    //writable sheet
    WritableSheet wSheet;



    @Test
    public void googleSearch() throws InterruptedException, WriteException, IOException, BiffException {
        //define the path of readable file
        readableFile = Workbook.getWorkbook(new File("src//main//resources//Google_Search.xls"));
        //define readable sheet
        readableSheet = readableFile.getSheet(0);
        //define the path to create writable file
        writableFile = Workbook.createWorkbook(new File("src//main//resources//Google_Search_Results.xls"), readableFile);
        //define the writable sheet
        wSheet = writableFile.getSheet(0);

        int row = wSheet.getRows();
        for (int i = 1; i < row; i++) {
            String cars = wSheet.getCell(0, i).getContents();
            driver.navigate().to("https://www.google.com");
            Thread.sleep(2000);
            //enter keyword car on my search field
            Resuable_Library2_Logger.userKeys(driver, "//*[@name='q']", cars, "Search Field",logger);
            //click on submit
            Resuable_Library2_Logger.submit(driver, "//*[@name='btnK']", "Google Search Button",logger);
            Thread.sleep(2000);
            //capture text and print out the search number
            String searchResult = Resuable_Library2_Logger.captureText(driver, "//*[@id='result-stats']", "Search Results",logger);
            //split the text and print the number
            String[] arraySearch = searchResult.split(" ");
            //Reporter.log("My search number for car is " + arraySearch[1]);
            System.out.println("My search number for car is " + arraySearch[1]);
            //add the label
            Label label = new Label(1, i, arraySearch[1]);
            wSheet.addCell(label);
        }//end of for loop


        writableFile.write();
        writableFile.close();
        readableFile.close();

    } //end of google test


}//end of java class
