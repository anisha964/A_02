package Resuable_Library;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Log;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class Resuable_Library2_Logger {

    static int timeout = 20;


    //method to re use chrome driver and chrome options
    public static WebDriver setDriver() throws IOException, InterruptedException {
        //set the chrome path
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver2.exe");
        Thread.sleep(1000);
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver2.exe /T");
        Thread.sleep(1000);
        //set some pre conditions using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for the driver
        options.addArguments("start-maximized","incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);

        return driver;
    }

    //method to compare expected with actual title
    public static void verifyTitle(WebDriver driver,String expectedTitle,ExtentTest logger) throws InterruptedException {
        String actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            logger.log(LogStatus.INFO,"Expected title matches with Actual"+ expectedTitle);
            System.out.println("Expected title matches with Actual " + expectedTitle);
        } else {
            System.out.println("Expected doesn't match actual title. Actual title is " + actualTitle);
            logger.log(LogStatus.FAIL,"Expected doesn't match actual title. Actual title is"+ actualTitle);
            Thread.sleep(1000);
            getScreenShot(driver,logger,"actual title");
        }
    }//end of verify title method


    //method to select a drop down value by visible text
    public static void dropdownByText(WebDriver driver,String locator, String userInput, String elementName,ExtentTest logger) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            logger.log(LogStatus.INFO,"Selecting a value on element"+ elementName);
            System.out.println("Selecting a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Select dDown = new Select(element);
            dDown.selectByVisibleText(userInput);
        } catch (Exception e) {
            System.out.println("Unable to select element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to select element"+ elementName + " " + e);
            Thread.sleep(1000);
            getScreenShot(driver,logger,elementName);
        }
    }//end of drop down by text method

    //method to enter user input on send keys
    public static void userKeys(WebDriver driver,String locator, String userInput, String elementName,ExtentTest logger) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            logger.log(LogStatus.INFO,"Entering a value on element"+ elementName);
            System.out.println("Entering a value on element " + elementName);
            Reporter.log("Entering a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userInput);
        } catch (Exception e) {
            System.out.println("Unable to enter element " + elementName + " " + e);
            Reporter.log("Unable to enter element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to enter element"+ elementName + " " + e);
            Thread.sleep(1000);
            getScreenShot(driver,logger,elementName);
        }
    }//end of sendkeys method

    //method to click on an element
    public static void click(WebDriver driver, String locator, String elementName, ExtentTest logger) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Clicking a value on element " + elementName);
            logger.log(LogStatus.INFO,"Clicking a value on element"+ elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click element "+ elementName + " "+ e);
            Thread.sleep(1000);
            getScreenShot(driver,logger,elementName);
        }
    }//end of click method

    //method to submit on an element
    public static void submit(WebDriver driver,String locator,String elementName, ExtentTest logger) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            logger.log(LogStatus.INFO,"Submitting a value on element "+ elementName);
            System.out.println("Submitting a value on element " + elementName);
            Reporter.log("Submitting a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.submit();
        } catch (Exception e) {
            System.out.println("Unable to submit element " + elementName + " " + e);
            Reporter.log("Unable to submit element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to submit element " + elementName + " " + e);
            Thread.sleep(1000);
            getScreenShot(driver,logger,elementName);
        }
    }//end of click method

    //method to return text from an element
    public static String captureText(WebDriver driver,String locator,String elementName, ExtentTest logger) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String result = null;
        try {
            logger.log(LogStatus.INFO,"Capturing a text from element " + elementName);
            System.out.println("Capturing a text from element " + elementName);
            Reporter.log("Capturing a text from element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            result = element.getText();
            System.out.println("My Text result is " + result);
        } catch (Exception e) {
            System.out.println("Unable to capture text on element " + elementName + " " + e);
            Reporter.log("Unable to capture text on element " + elementName + " " + e);
            logger.log(LogStatus.INFO,"Unable to capture text on element " + elementName + " " + e);
            Thread.sleep(1000);
            getScreenShot(driver,logger,elementName);
        }

        return result;
    }//end of capture text  method
    //method to Mouse Hover on a element
    public static void Hover(WebDriver driver,String locator,String elementName,ExtentTest logger) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            logger.log(LogStatus.INFO,"Hovering over an element" + elementName);
            System.out.println("Hovering over an element" + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("unable to Hover the mouse" + elementName + " " + e);
            logger.log(LogStatus.FAIL,"unable to Hover the mouse" + elementName + " " + e);
            Thread.sleep(1000);
            getScreenShot(driver,logger,elementName);
        }//end of try and catch
    }//end of Mouse Hover on element



    //method to perform MouseClick
    public static void MouseClick(WebDriver driver,String locator, String elementName, ExtentTest logger) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            logger.log(LogStatus.INFO,"hover and click " + elementName);
            System.out.println("hover and click " + elementName);
            Reporter.log("hover and click " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Actions action = new Actions(driver);
            action.click(element).perform();
        } catch (Exception e) {
            System.out.println("unable to hover and click " + elementName + " " + e);
            Reporter.log("unable to hover and click " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"unable to hover and click " + elementName + " " + e);
            Thread.sleep(1000);
            getScreenShot(driver,logger,elementName);
        }//end of try catch
        }

        //method to click by index on an element
        public static void clickbyIndex(WebDriver driver,String locator, int index,String elementName,ExtentTest logger) throws InterruptedException {
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            try{
                logger.log(LogStatus.INFO,"Clicking a value by index " + index + " on element " + elementName);
                System.out.println("Clicking a value by index " + index + " on element " + elementName);
                Reporter.log("Clicking a value by index " + index + " on element " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(index);
                element.click();
            } catch (Exception e) {
                System.out.println("Unable to click by index " + index +  " on element " + elementName + " " + e);
                Reporter.log("Unable to click by index " + index +  " on element " + elementName + " " + e);
                logger.log(LogStatus.FAIL,"Unable to click by index " + index +  " on element " + elementName + " " + e);
                Thread.sleep(1000);
                getScreenShot(driver,logger,elementName);
            }
        }//end of click method
    //method to enter user input on send keys
    public static void userTypeAndHitEnter(WebDriver driver,String locator, String userInput, String elementName,ExtentTest logger) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            logger.log(LogStatus.INFO,"Entering a value on element " + elementName);
            System.out.println("Entering a value on element " + elementName);
            Reporter.log("Entering a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userInput);
            element.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            System.out.println("Unable to enter element " + elementName + " " + e);
            Reporter.log("Unable to enter element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to enter element " + elementName + " " + e);
            Thread.sleep(1000);
            getScreenShot(driver,logger,elementName);
        }
    }//end of userTypeAndHitEnter method
    //method to capture screenshot when logger fails
    public static void getScreenShot(WebDriver wDriver,ExtentTest logger,String imageName) {
        try {
            String fileName = imageName + ".png";
            String directory = "src//main//java//HTML_Report//Screenshots//";
            File sourceFile = ((TakesScreenshot) wDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture("Screenshots//" + fileName);
            logger.log(LogStatus.FAIL, "", image);
            Thread.sleep(1000);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of screenshot method


    }//end of java class


