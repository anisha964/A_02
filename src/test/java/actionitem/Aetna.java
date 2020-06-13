package actionitem;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class Aetna {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "src//Resource//chromedriver.exe");
        //set some pre conditions using chrome options
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for the driver
        options.addArguments("start-maximized", "incognito");
        //define your chrome driver
        WebDriver driver = new ChromeDriver(options);




        ArrayList<String> zipcode = new ArrayList<>();
        zipcode.add("11210");
        zipcode.add("11214");
        zipcode.add("11201");

        ArrayList<Integer> milesRange = new ArrayList<>();
        milesRange.add(55);
        milesRange.add(35);
        milesRange.add(45);



        for (int i = 0; i < 3; i++) {

            driver.navigate().to("https://www.aetna.com/");

            Thread.sleep(4000);


            String realTitle = driver.getTitle();
            if (realTitle.contains("Health")) {
                System.out.println("Title matches with expected ");
            } else {

                System.out.println("Title doesnt match " + realTitle);
            }//end

            Thread.sleep(4000);

            try {
                driver.findElement(By.xpath("//*[@class='megamenu__primary--item']")).click();

            } catch (Exception e) {
                System.out.println("Unable to click on Shop for plan" + e);

            }// end of search icon exception

            Thread.sleep(2000);

            Actions mouse = new Actions(driver);
            try {

             WebElement medicare= driver.findElement(By.xpath("//button[text()='Medicare']"));
            mouse.moveToElement(medicare).click().perform();

             } catch (Exception e) {
                System.out.println("Unable to hover over medicare" + e);
            }//end of search icon exception

          Thread.sleep(2000);

            try{

            WebElement medicare= driver.findElements(By.xpath("//*[@class='megamenu__tertiary--link link__text--inline--tertiary']")).get(1);
            mouse.moveToElement(medicare).click().perform();

            } catch (Exception e) {
            System.out.println("Unable to click find a doctor" + e);
            }//end of search icon exception

            Thread.sleep(2000);

            try{
                driver.findElement(By.xpath("//*[@class='primaryPurple BtnWidth mgbutton w400']")).click();

            } catch (Exception e) {
                System.out.println("Unable to click 2020 " + e);
            }//end of search icon exception

            Thread.sleep(2000);

            try{
              WebElement Zipcode = driver.findElement(By.xpath("//*[@id='medZip']"));
              Zipcode.clear();
              Zipcode.sendKeys(zipcode.get(i));

            } catch (Exception e) {
                System.out.println("Unable to hover over medicare" + e);
            }//end of search icon exception

            Thread.sleep(3000);


            try{
                driver.findElement(By.xpath("//li[@ng-show='zipFilter.length']")).click();

            } catch (Exception e) {
                System.out.println("Unable to hover over medicare" + e);
            }//end of search icon exception



            Thread.sleep(4000);
            Actions actions = new Actions(driver);
            int x= milesRange.get(i);

            WebElement slider = driver.findElement(By.xpath("//*[@class='rz-pointer rz-pointer-min']"));
            actions.moveToElement(slider).click().perform();
            //actions.dragAndDropBy(slider,-100,0).perform();
           // actions.dragAndDropBy(slider,(-100+5),0).perform();

            Thread.sleep(2000);

            for (int a =0; a<25;a++){

                actions.sendKeys(Keys.ARROW_LEFT).perform();

            }//end of for loop

            for (int a= 0; a<x; a++){
                actions.sendKeys(Keys.ARROW_RIGHT).perform();
            }


            Thread.sleep(1000);

            try{
                driver.findElement(By.xpath("//*[text()='Skip plan selection*']")).click();

            } catch (Exception e) {
                System.out.println("Unable to skip plan selection" + e);
            }//end of exception

            Thread.sleep(4000);

            try {

                driver.findElement(By.xpath("//div[@class='search-block-text']")).click();

            }catch (Exception e){
                System.out.println("Unable to go on Medical Doctor");
            }//end of exception

            Thread.sleep(3000);
            try {
                driver.findElement(By.xpath("//*[contains(text(),'Doctors (Primary')]")).click();
            }catch (Exception e){
                System.out.println("Unable to go on Doctor" + e);
            }//end of exception

            Thread.sleep(3000);
            try {
                driver.findElement(By.xpath("//*[contains(text(),'All Primary Care Physicians')]")).click();
            } catch (Exception e) {
                System.out.println("Unable to click all primary care physicians" + e);
            }//end of exception


            Thread.sleep(5000);
            try {
                WebElement results = driver.findElement(By.xpath("//*[@header='grid-hdr-name']"));
                System.out.println("These are the results " + results.getText());
            }catch (Exception e){
                System.out.println("Unable to print the results"+ e);
            }//end of exceptio

            Thread.sleep(3000);

        }// end of for loop

        driver.quit();




        } // end of for main method



    }// end of java class

