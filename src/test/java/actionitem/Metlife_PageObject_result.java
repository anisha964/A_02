package actionitem;

import Met_Life_PageObject.MetLife_CaptureText;
import Met_Life_PageObject.Met_Life_Base_Class;
import Resuable_Library.Abstract_Class;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Metlife_PageObject_result extends Abstract_Class {


    Workbook readableFile;

    Sheet readableSheet;

    WritableWorkbook writableFile;

    WritableSheet wsheet;


    @Test
    public void Metlife_PageObject_results() throws InterruptedException, IOException, BiffException, WriteException {


        //array variables for zipcode


        readableFile=Workbook.getWorkbook(new File("src//main//resources//Met_Life.xls"));
        readableSheet = readableFile.getSheet(0);
        writableFile = Workbook.createWorkbook(new File("src//main//resources//Met_Life_Results.xls"), readableFile);
        wsheet = writableFile.getSheet(0);
        int row = wsheet.getRows();

        for ( int i=1;i<row;i++) {
            String zipcode = wsheet.getCell(0, i).getContents();
            String referalCodes = wsheet.getCell(1, i).getContents();
            String dentalProgram = wsheet.getCell(2, i).getContents();
            String programs = wsheet.getCell(3,i).getContents();
        logger.log(LogStatus.INFO,"navigating to met life");
        driver.navigate().to("https://www.metlife.com");
            Met_Life_Base_Class.met_life_homepage().verifytitle("Insurance");
            Met_Life_Base_Class.met_life_homepage().clickingonSolutions();
            Thread.sleep(3000);
            Met_Life_Base_Class.met_life_homepage().clickingonmetlifedental();
            Met_Life_Base_Class.metLife_enrollNow().verifytitle("MetLife TakeAlong Dental");
            Thread.sleep(2000);
            Met_Life_Base_Class.metLife_enrollNow().clickingonEnrollNow();
            Thread.sleep(3000);
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            Met_Life_Base_Class.metlife_zipcodes().EnteringZipcodes(zipcode);
            Thread.sleep(3000);
            Met_Life_Base_Class.metlife_zipcodes().ClickingOnGo();
            Thread.sleep(3000);
            Met_Life_Base_Class.metLife_ppo().clickPPO(dentalProgram);
            Thread.sleep(3000);
            Met_Life_Base_Class.metLife_ppo().clickonenroll();
            Thread.sleep(3000);
            Met_Life_Base_Class.metLife_ppo().enterReferralcodes(referalCodes);
            Thread.sleep(3000);
            Met_Life_Base_Class.metLife_ppo().errorMessage();
            Thread.sleep(3000);
            Met_Life_Base_Class.metLife_ppo().clickOnRC();
            Thread.sleep(3000);
            String results=Met_Life_Base_Class.metLife_captureText().capturetext();


            Label label= new Label(3,i,results);
            wsheet.addCell(label);

            //closes the tab
            driver.close();
            //wait for 2 seconds
            Thread.sleep(2000);

            //switches to the default page
            driver.switchTo().window(tabs.get(0));










        }// end of loop
        writableFile.write();
        writableFile.close();
        readableFile.close();


    }//end of test




















}//end of java class

