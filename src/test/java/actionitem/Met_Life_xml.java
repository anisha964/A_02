package actionitem;

import Resuable_Library.Abstract_Class;
import Resuable_Library.Resuable_Library2_Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Met_Life_xml extends Abstract_Class {


     @Test
      public void MetLife_Search() throws InterruptedException {

         //array variables for zipcode
         ArrayList<String> zipcode = new ArrayList<>();
         zipcode.add("11218");
         zipcode.add("11214");
         zipcode.add("11201");
         //array variable for referral code
         ArrayList<String> referralCode = new ArrayList<>();
         referralCode.add("2243345");
         referralCode.add("2233478");
         referralCode.add("2233452");
         //array variable for dental program
         ArrayList<String> dentalProgram = new ArrayList<>();
         dentalProgram.add("PPO-LOW");
         dentalProgram.add("PPO-MEDIUM");
         dentalProgram.add("PPO-HIGH");
         //for loop


         for (int i = 0; i < 3; i++) {
             //navigate to met =life
             driver.navigate().to("https://metlife.com/");
             //wait for 2 seconds
             Thread.sleep(2000);

             Resuable_Library2_Logger.verifyTitle(driver,"Insurance",logger);

             // click on solutions

             Resuable_Library2_Logger.click(driver,"//*[contains(text(),'SOLUTIONS')]","click on solutions",logger);


             // click on Metlife TakeAlong Dental


             Resuable_Library2_Logger.click(driver,"//*[contains(text(),'MetLife TakeAlong Dental')]","click on Metlife Dental",logger);

             Resuable_Library2_Logger.verifyTitle(driver,"Dental",logger);

             Thread.sleep(3000);
             // click on Enroll Now


             Resuable_Library2_Logger.click(driver,"//*[contains(text(),'Enroll Now')]","click on enroll now",logger);


             // defining the tabs
             ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
             driver.switchTo().window(tabs.get(1));

             Thread.sleep(4000);


                Resuable_Library2_Logger.userTypeAndHitEnter(driver,"//*[@id='txtZipCode']",zipcode.get(i),"zipcode",logger);


             //Wait for 3 seconds
             Thread.sleep(3000);

             Resuable_Library2_Logger.click(driver,"//*text()='GO']","click on go",logger);
                 Thread.sleep(6000);


                 Resuable_Library2_Logger.click(driver,"//*[@class='" + dentalProgram.get(i) + "']","click on PPO", logger);
                 Thread.sleep(6000);

             //Click on PPO High,Medium,Low

             //click on enroll into a program

               Resuable_Library2_Logger.click(driver,"//*[@class='btn btn-success']","Enroll into a program",logger);
                 Thread.sleep(3000);

             //being able to enter all the referral codes

                  Resuable_Library2_Logger.userTypeAndHitEnter(driver,"//*[@id='txtBxPromocode']",referralCode.get(i),"referral codes",logger);

                 Thread.sleep(3000);

             //Clicking GO after entering the referral codes

                 Resuable_Library2_Logger.click(driver,"//*[@name='btnEnroll']","click on go",logger);
                 Thread.sleep(3000);

             //wait time for two seconds
             Thread.sleep(2000);
             //Printing the error message

                 Resuable_Library2_Logger.captureText(driver,"//*[@id='lblRefCodeError']","error message ",logger);


             // clicking on enrolling without referral codes

                Resuable_Library2_Logger.click(driver,"//*[@class='btn btn-primaryborder']","click on enroll",logger);
                 Thread.sleep(3000);

             //wait for 4 seconds
             Thread.sleep(4000);
             // PPO matches with dental program variables
             try {
                 WebElement Actualresults = driver.findElement(By.xpath("//div[@class='col-sm-8']"));
                 if (Actualresults.getText().contains(dentalProgram.get(i))) {

                     System.out.println("Actual PP0 matches with expected PPO" + Actualresults.getText());

                 } else {
                     System.out.println("does not match" + Actualresults.getText());
                 }

                 Thread.sleep(3000);
             } catch (Exception e) {
                 System.out.println("Unable to submit on Search Icon" + e);
             }


             //closes the tab
             driver.close();
             //wait for 2 seconds
             Thread.sleep(2000);

             //switches to the default page
             driver.switchTo().window(tabs.get(0));


         }//end of for loop


     }//end test







}//end of java class

