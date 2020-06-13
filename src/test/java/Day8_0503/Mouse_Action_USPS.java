package Day8_0503;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Mouse_Action_USPS {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        //set some pre conditions using chrome options
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for the driver
        options.addArguments("start-maximized","incognito");
        //now simply define your chrome driver
        WebDriver driver= new ChromeDriver(options);
        //navigate to met life homepage

        driver.navigate().to("https://www.usps.com/");


        //call your mouse action
        Actions mouse = new Actions(driver);

        //hover to Mail&Ship
        try {
            WebElement mailAndShip = driver.findElement(By.xpath("//*[text()= 'Mail & Ship']"));
            mouse.moveToElement(mailAndShip).perform();
        } catch (Exception e){
            System.out.println( " Unable to locate Main & Ship "+ e);
        }
            Thread.sleep(1500);

        try {
            WebElement clickAndShip = driver.findElement(By.xpath("//*[@class ='tool-cns']/a[text()='Click-N-Ship']"));
            //call your Actions command move to the element and then click
            //this is to submit using mouse action
            //clickAndShip.submit();
            //mouse.moveToElement(clickAndShip).sendKeys(Keys.ENTER).perform();
            mouse.moveToElement(clickAndShip).click().perform();
        } catch (Exception e){
            System.out.println( " Unable to locate Click N Ship "+ e);
        }














    }//main method
}
