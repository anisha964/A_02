package Day5_0425;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locate_By_Xpath {


    public static void main(String[] args) throws InterruptedException {
       //line below store
        String searchPath= "//*[@id='twotabsearchtextbox']";

        String searchIcon= "//*[@value='Go']";

        String imagePath= "//img[contains(@class,'s-image')]";




        //define your property
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        //define the driver
        WebDriver driver = new ChromeDriver();
        //navigate to amazon homepage
        driver.navigate().to("https://www.amazon.com");
        //maximize your window
        driver.manage().window().maximize();
        //wait few seconds
        Thread.sleep(2000);
        // enter a keyword laptop on amazon search field by using path
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("laptop");

       //click on search icon
       driver.findElement(By.xpath("//*[@value='Go']")).submit();

       Thread.sleep(2500);
       //click on the second image item of the same elements within the page using index number
       driver.findElements(By.xpath(imagePath)).get(4).click();










    }//end of main method





}// end of java class
