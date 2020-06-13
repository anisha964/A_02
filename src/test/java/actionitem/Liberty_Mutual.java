package actionitem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Liberty_Mutual {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        // set some pre condition using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        // set the arguments you want for the driver
        options.addArguments("start-maximized","incognito");
        //define chrome driver
        WebDriver driver= new ChromeDriver(options);
        //string variable

        String[] zipCode = new String [4];
        zipCode[0]= "10012";
        zipCode[1]= "10013";
        zipCode[2]= "10003";
        zipCode[3]="10128";

        for(int i =0;i<zipCode.length;i++) {

            driver.navigate().to("https://www.libertymutual.com");

            String actualTitle = driver.getTitle();
            if (actualTitle.contains("Liberty")) {
                System.out.println("Title matches with expected ");
            } else {

                System.out.println("Title doesnt match " + actualTitle);
            }
            driver.findElement(By.xpath("//*[@name='location']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@name='location']")).sendKeys(zipCode[i]);

            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@class='submitButton btn-action lm-Button--medium lm-Button lm-Button--secondary']")).click();

             Thread.sleep(2000);
            if(i==0){
                driver.findElements(By.xpath("//*[@class='lm-Link lm-LinkStandalone']")).get(0).click();
            }
             Thread.sleep(2000);
            if(i==1){
                driver.findElements(By.xpath("//*[@class='lm-Link lm-LinkStandalone']")).get(2).click();
            }
            Thread.sleep(2000);
            if(i==2){
                driver.findElements(By.xpath("[//*@class='lm-Link lm-LinkStandalone']")).get(3).click();
            }

            if(i==3){
                driver.findElements(By.xpath("[//*@class='lm-Link lm-LinkStandalone']")).get(1).click();
            }

            String message = driver.findElement(By.xpath("[//*@class='jsx-188877792']")).getText();

            System.out.println("My zipcode is " + zipCode[i]+" and the address is "+ message);


        }//for loop

    }//end main method

}// end of java class
