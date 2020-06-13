package Day9_0509;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class google_methods {

    public static void main(String[] args) {
        //set the chrome path
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver80.exe");
        //set some pre conditions using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for the driver
        options.addArguments("start-maximized","incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);

        //driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        //navigate to mortgage calculator home page
        driver.navigate().to("https://www.google.com");

        //call my reusable method to compare title
        reusable_library.verifyTitle(driver,"Google");
        //call my reusable method to enter a Search Field
        reusable_library.userKeys(driver,"//*[@name='q']","Cars","Search Field");
        //call my reusable method to submit on google search
        reusable_library.submit(driver,"//*[@name='btnK']","Google Search");


    }




}
