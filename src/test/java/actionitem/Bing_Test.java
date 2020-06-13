package actionitem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bing_Test {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");

       //define the driver
        WebDriver driver= new ChromeDriver();


        String[]state= new String[5];
        state[0]="New York";
        state[1]="New Jersey";
        state[2]="California";
        state[3]="Ohio";
        state[4]="Miami";

        for(int i=0; i<state.length;i++) {
            // opening the browser automatically to go to bing home page
            driver.navigate().to("https://www.bing.com");

            Thread.sleep(2000);
            // wait for 2 seconds

            //maximize the browser
            driver.manage().window().maximize();


            // wait for 2 seconds
            Thread.sleep(2000);

            //locates the search field and enter all the "keywords"
            driver.findElement(By.name("q")).sendKeys(state[i]);


            // this will submit the "keywords"
            driver.findElement(By.id("sb_form_go")).submit();

            // wait for 2 seconds
            Thread.sleep(2000);

            //this will capture the text element
            String message = driver.findElement(By.id("b_tween")).getText();
            // this will extract the specific information
            String[] arrayResult = message.split(" ");
            System.out.println("my favorite state is " + state[i] + " and my search number is " + arrayResult[0]);

        }// end of for loop

       // this will quit the browser
       driver.quit();


    }//end of main method


}//end of java class
