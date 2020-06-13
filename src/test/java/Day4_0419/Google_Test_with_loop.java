package Day4_0419;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_Test_with_loop {
    public static void main(String[] args) throws InterruptedException {

        //set the system chrome driver path at least in of your main method
        //webdriver.chrome.driver needs to be in lower case string followed by your driver path
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");

        //you declare and define the driver
        WebDriver driver= new ChromeDriver();

        //create dynmamic array city to loop through certain values from the array
        String[]city= new String[3];
        city[0]="Bronx";
        city[1]="Brooklyn";
        city[2]="Queens";

        //this is where you will start your loop from navigate up until before quit
         int i= -1 ;
             while(i<city.length) {

             i=i+1;
            // opening the browser automatically to go to google home page
            driver.navigate().to("https://www.google.com");

            //wait few seconds after navigation to a page so browser can lead properly
            //sleep statement handles in milliseconds so example 1 sec= 1000 milliseconds
            Thread.sleep(2000);

            //maximize your browser
            driver.manage().window().maximize();

            //locate the search field by inspecting in first and then enter a keyword lets say cars
            driver.findElement(By.name("q")).sendKeys(city[i]);

            //click on google search
            driver.findElement(By.name("btnK")).submit();

            //wait few seconds
            Thread.sleep(2000);

            //to capture a text from website you need to
            String message = driver.findElement(By.id("result-stats")).getText();
            //using array variable to split above message
            String[] arrayResult = message.split(" ");
            System.out.println("my city is " + city[i] + " and my search number is " + arrayResult[1]);

        }// end of for loop

       //close vs quit the session
        // quit will kill the driver from your task memory
        //close will only close the driver but not from your memory
        //i prefer to use quit
       driver.quit();


    }//end of main method


}//end of java class
