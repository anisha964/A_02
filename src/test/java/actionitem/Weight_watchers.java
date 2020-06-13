package actionitem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Weight_watchers {
    public static void main(String[] args) throws InterruptedException {
        //set the chrome path
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        // set some pre condition using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        // set the arguments you want for the driver
        options.addArguments("start-maximized","incognito");
        //define chrome driver
        WebDriver driver= new ChromeDriver(options);

        //string variable
        String[]zipCodes= new String[3];
        zipCodes[0]="11218";
        zipCodes[1]="11201";
        zipCodes[2]="11214";
        //for loop
        for(int i=0;i<zipCodes.length;i++){
            //this will navigate to website
            driver.navigate().to("https://www.weightwatchers.com/");
            //this will verify the title and print it
            String title = driver.getTitle();
            if(title.equals(" WEIGHT WATCHERS ")){
                System.out.println("Title matches with expected ");
            } else {

                System.out.println("Title doesnt match "+title);
            }
            // wait for 2 seconds
            Thread.sleep(2000);
            //this will click find a workshop
            driver.findElement(By.xpath("//*[@class='last leaf menu-link-find-a-workshop']")).click();
            //wait for 2 seconds
            Thread.sleep(2000);
            //this will enter all the zipcodes
            driver.findElement(By.xpath("//*[@id='meetingSearch']")).sendKeys(zipCodes[i]);
            //wait for 3.5 seconds
            Thread.sleep(3500);
            //this will submit all the zipcodes
            driver.findElement(By.xpath("//*[@class='btn spice-translated']")).submit();

            // using if condition I will get specific address of each zipcode.
            if (i==0) {
                driver.findElements(By.xpath("//*[@class='location__name']")).get(1).click();
            }

            if (i==1){
                driver.findElements(By.xpath("//*[@class='location__name']")).get(2).click();

            }

            if(i==2) {
                driver.findElements(By.xpath("//*[@class='location__name']")).get(5).click();

            }
            // this will print all the zip code and address
            String message= driver.findElement(By.xpath("//*[@class='location']")).getText();

            System.out.println("my zipcode is "+zipCodes[i]+ " and the address "+ message);

           //this is will print all the zipcodes and timetables
           String timetable= driver.findElement(By.xpath("//*[@class='meeting-schedule__schedule']")).getText();

           System.out.println("My location is " + zipCodes[i] + " my time table is " + timetable);

















            }// for loop





























































    }// end of main method




















}// end of java class

