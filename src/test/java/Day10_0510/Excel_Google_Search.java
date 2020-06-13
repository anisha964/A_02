package Day10_0510;

import Resuable_Library.Reusable_Library2;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Excel_Google_Search {

    public static void main(String[] args) throws IOException, BiffException, InterruptedException, WriteException {
        //Step 1
        //locate the readable file
        Workbook readableFile = Workbook.getWorkbook(new File("src/Resource/Google_Search.xls"));

        //Step 2
        //locate the readable worksheet by index
        Sheet readableSheet = readableFile.getSheet(0);

        //Step 3
        //we need create a writeable workbook to mimic readable file because we shouldn't be writing on readable file
        WritableWorkbook writableFile= Workbook.createWorkbook(new File("src/Resource/Google_Search_Result.xls"),readableFile);
        //create writable sheet
        WritableSheet writableSheet= writableFile.getSheet(0);
        //get the row cow count which are not empty
        int row = writableSheet.getRows();

        WebDriver driver = Reusable_Library2.setDriver();

        //define the web driver using resuable library
        for (int i=1;i<row;i++){

            //Step 4
            //store the cars column values as a String variable
            //column are always hard coded where as the rows are dynamic
            String cars = writableSheet.getCell(0,i).getContents();
            //
            driver.navigate().to("https://www.google.com");

            Reusable_Library2.userKeys(driver,"//*[@name='q']",cars,"Search Field");

            Reusable_Library2.submit(driver,"//*[@name='btnK']","Google Search");

            Thread.sleep(2500);

            String result= Reusable_Library2.captureText(driver,"//*[@id='result-stats']","Search Result");
            String[] resultArray= result.split(" ");
            System.out.println("My search number is "+ resultArray[1]);

            Label label= new Label(1,i,resultArray[1]+" "+ resultArray[3]+ " "+ resultArray[4]);
            writableSheet.addCell(label);


        }

        writableFile.write();
        writableFile.close();
        readableFile.close();























    }//end of main method





































}//end of java class

