package actionitem;

import Resuable_Library.Abstract_Class;
import Resuable_Library.Resuable_Library2_Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Weight_watchers_xml extends Abstract_Class {


        @Test
         public void weight_watcher_search() throws InterruptedException {
            //string variable
            String[] zipCodes = new String[3];
            zipCodes[0] = "11218";
            zipCodes[1] = "11201";
            zipCodes[2] = "11214";
            //for loop
            for (int i = 0; i < zipCodes.length; i++) {
                //this will navigate to website
                driver.navigate().to("https://www.weightwatchers.com/");
                //this will verify the title and print it
                Resuable_Library2_Logger.verifyTitle(driver,"WEIGHT WATCHERS",logger);
                // wait for 2 seconds
                Thread.sleep(2000);
                //this will click find a workshop
                Resuable_Library2_Logger.click(driver,"//*[text()='Find a Workshop']","find a workshop",logger);
                //wait for 2 seconds
                Thread.sleep(2000);
                //this will enter all the zipcodes
                Resuable_Library2_Logger.userKeys(driver,"//*[@id='meetingSearch']",zipCodes[i],"zipcodes",logger);
                //wait for 3.5 seconds
                Thread.sleep(3500);
                //this will submit all the zipcodes
                Resuable_Library2_Logger.submit(driver,"//*[@class='btn spice-translated']","submit",logger);

                // using if condition I will get specific address of each zipcode.
                if (i == 0) {
                    Resuable_Library2_Logger.clickbyIndex(driver,"//*[@class='location__name']",1,"address",logger);
                }

                if (i == 1) {
                    Resuable_Library2_Logger.clickbyIndex(driver,"//*[@class='location__name']",2,"address",logger);

                }

                if (i == 2) {
                    Resuable_Library2_Logger.clickbyIndex(driver,"//*[@class='location__name']",5,"address",logger);

                }
                // this will print all the zip code and address
                Resuable_Library2_Logger.captureText(driver,"//*[@class='location']","address print",logger);


                //this is will print all the zipcodes and timetables
                Resuable_Library2_Logger.captureText(driver,"//*[@class='meeting-schedule__schedule']","Print Timetable",logger);





            }// for loop


        } // end of test














}// end of java class

