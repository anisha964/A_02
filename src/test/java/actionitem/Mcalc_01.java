package actionitem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Mcalc_01 {


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
        String[] Price = new String[3];
        Price [0]="400000";
        Price[1]= "500000";
        Price[2]= "600000";

        String[] Payment = new String[3];
        Payment[0]="15";
        Payment[1]="15";
        Payment[2]="15";

        String[] Rate= new String [3];
        Rate[0]="3.5";
        Rate[1]="4.5";
        Rate[2]="2.5";

        String[]Insurance= new String[3];
        Insurance[0]="1500";
        Insurance[1]="2000";
        Insurance[2]="3000";

        String[] month = new String[3];
        month[0] = "Jul";
        month[1] = "May";
        month[2] = "Jan";

        String[] yearArray = new String[3];
        yearArray[0]= "2015";
        yearArray[1]="2016";
        yearArray[2]="2019";

        //while loop
        int i=0;
        while (i<3) {



            // navigate to mlcalc
            driver.navigate().to("https://www.mlcalc.com/");
            Thread.sleep(4000);
            //verify the actual title
            String actualTitle = driver.getTitle();
            if (actualTitle.contains("Mortgage")) {
                System.out.println("Title matches with expected ");
            } else {

                System.out.println("Title doesnt match " + actualTitle);
            }
            //wait for 4 seconds
            Thread.sleep(4000);

            //clear the purchase price and enter data
            WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
            pPrice.clear();
            pPrice.sendKeys(Price[i]);
             //wait for two seconds
            Thread.sleep(3500);

            //clear the down payment and enter the data
            WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));
            dPayment.clear();
            dPayment.sendKeys(Payment[i]);
            //wait for 3.5 seconds
            Thread.sleep(3500);
            //clear the interest rate and enter the data
            WebElement intRate= driver.findElement(By.xpath("//*[@name='ir']"));
            intRate.clear();
            intRate.sendKeys(Rate[i]);
            //wait for 3.4 seconds
            Thread.sleep(3500);
            //clear the property insurance and enter the data
            WebElement propInsurance = driver.findElement(By.xpath("//*[@name='pi']"));
            propInsurance.clear();
            propInsurance.sendKeys(Insurance[i]);
            //it will select the month from the string variables
            //wait for 3.5 seconds
            Thread.sleep(3500);
            WebElement mMonth= driver.findElement(By.xpath("//*[@name='sm']"));
            Select mMonthList = new Select(mMonth);
            mMonthList.selectByVisibleText(month[i]);
            //wait for 4 seconds
            Thread.sleep(4000);
            //it will select the year from the string variables
            WebElement sYear= driver.findElement(By.xpath("//*[@name='sy']"));
            Select sYearList= new Select(sYear);
            sYearList.selectByVisibleText(yearArray[i]);
             //wait for two seconds
            Thread.sleep(2000);
            // this will click on the calculate
            driver.findElement(By.xpath("//*[@class='button-calculate action']")).click();
           // this will capture the element
          String message= driver.findElements(By.xpath("//*[@class='big']")).get(0).getText();
          //this will capture the element
         String date = driver.findElements(By.xpath("//*[@class='big']")).get(3).getText();
         //
          System.out.println("my monthly payment is  "+ message + " my pay off date is " + date);









            i=i+1;



        }//end of while loop





































    }//main method






















}// end of java class
