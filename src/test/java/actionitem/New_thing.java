package actionitem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class New_thing {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");

        WebDriver driver= new ChromeDriver();

        String[] cars= new String[1];
        cars[0]="bmw";

        driver.navigate().to("https://www.google.com");

        driver.manage().window().maximize();

        Thread.sleep(2000);

        driver.findElement(By.name("q")).sendKeys(cars[0]);

        driver.findElement(By.name("btnK")).submit();

        Thread.sleep(2000);

        driver.navigate().to("https://www.bmw.com/en/index.html");

        Thread.sleep(2000);

        driver.navigate().to("https://www.bmw.com/en/bmw-models.html");

        Thread.sleep(2000);

        driver.findElement(By.className("i-amphtml-fill-content i-amphtml-replaced-content")).submit();

        Thread.sleep(2000);

        driver.quit();





    }


}

