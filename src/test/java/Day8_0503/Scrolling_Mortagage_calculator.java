package Day8_0503;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scrolling_Mortagage_calculator {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        //set some pre conditions using chrome options
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for the driver
        options.addArguments("start-maximized","incognito");
        //now simply define your chrome driver
        WebDriver driver= new ChromeDriver(options);
        //navigate to met life homepage

        //navigate to mortgage calculator
        driver.navigate().to("https://www.mortgagecalculator.org/");

        Thread.sleep(2500);
        //declare and define the java script
        JavascriptExecutor jse= (JavascriptExecutor)driver;
        //scroll all the way to the bottom of the page
        jse.executeScript("scroll(0,5000)");

        Thread.sleep(1000);
        //scroll all the way to the top of the page again
        jse.executeScript("scroll(0,-5000)");


        //scrolling to an element view

        Thread.sleep(2000);

        try {
            WebElement LoanTerm= driver.findElement(By.xpath("//*[@id='loanterm']"));
            jse.executeScript("arguments[0].scrollIntoView(true);",LoanTerm);
        }catch (Exception e ){
            System.out.println("Unable to located the term" + e);
        }// end of exception









    }










}