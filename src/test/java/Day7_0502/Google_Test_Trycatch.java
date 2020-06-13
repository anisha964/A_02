package Day7_0502;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Google_Test_Trycatch {
    public static void main(String[] args) throws InterruptedException {

        //set the system chrome driver path at least in of your main method
        //webdriver.chrome.driver needs to be in lower case string followed by your driver path
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");

        //you declare and define the driver
        WebDriver driver= new ChromeDriver();

        //set the Arraylist for the cars
        //dont need to define the size/length and also dont need to define the index numbers
        ArrayList<String>cars=new ArrayList<>();
        cars.add("lexus");
        cars.add("toyota");
        cars.add("bmw");


        for (int i =0; i<cars.size();i++) {


            // navigate the browser automatically to go to google home page
            driver.navigate().to("https://www.google.com");

            //wait few seconds after navigation to a page so browser can lead properly
            //sleep statement handles in milliseconds so example 1 sec= 1000 milliseconds
            Thread.sleep(2000);

            //maximize your browser
            driver.manage().window().maximize();

            try {
                //locate the search field by inspecting in first and then enter a keyword lets say cars
              WebElement search = driver.findElement(By.name("q"));
                search.sendKeys(cars.get(i));
            } catch (Exception e) {
                System.out.println("Unable to enter data on search field " + e);
            }
            try {
                //click on google search
                driver.findElement(By.name("btnK")).submit();
            } catch (Exception e) {
                System.out.println("Unable to submit on Search Icon" + e);
            }// end of search icon exception


            //wait few seconds
            Thread.sleep(2000);
            try {
                //to capture a text from website you need to
                String message = driver.findElement(By.id("result-stats")).getText();
                //using array variable to split above message
                String[] arrayResult = message.split(" ");
                System.out.println("my search number is " + arrayResult[1]);
            } catch (Exception e) {
                System.out.println("Unable to capture on Search Result");
            }// end of search result exception

        }// end of for loop

            //close vs quit the session
            // quit will kill the driver from your task memory
            //close will only close the driver but not from your memory
            //i prefer to use quit
            driver.quit();




    }//end of main method


}//end of java class