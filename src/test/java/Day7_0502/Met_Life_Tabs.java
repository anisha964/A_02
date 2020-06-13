package Day7_0502;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Met_Life_Tabs {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        //set some pre conditions using chrome options
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for the driver
        options.addArguments("start-maximized","incognito");
        //now simply define your chrome driver
        WebDriver driver= new ChromeDriver(options);


        driver.navigate().to("https://www.metlife.com");
        //wait for few seconds
        Thread.sleep(2500);


        Thread.sleep(1500);
        try {
            //click on google search
            driver.findElement(By.xpath("//*[contains(text(),'MetLife TakeAlong Dental')]")).click();
        } catch (Exception e) {
            System.out.println("Unable to submit on Search Icon" + e);
    }//end of search exception

        Thread.sleep(1500);
            try {
                //click on google search
                driver.findElement(By.xpath("//*[contains(text(),'Enroll Now')]")).click();
            } catch (Exception e) {
                System.out.println("Unable to submit on Search Icon" + e);
            }// end of search icon exception

        // now define the ArrayList to all current tabs that are open

        ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

        try {
            //click on google search
            driver.findElement(By.xpath("//*[@id='txtZipCode']")).sendKeys("11218");
        } catch (Exception e) {
            System.out.println("Unable to submit on Search Icon" + e);
        }// end of search icon exception

        Thread.sleep(1500);


        driver.close();


        driver.switchTo().window(tabs.get(0));



































    }
}
