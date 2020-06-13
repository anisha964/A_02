package Yahoo_page_object;

import Resuable_Library.Abstract_Class;
import Resuable_Library.Resuable_Library2_Logger;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Yahoo_search_result extends Abstract_Class {
    ExtentTest logger;


    public Yahoo_search_result(WebDriver driver){

        super();

        PageFactory.initElements(driver,this);
        this.logger= super.logger;


    }

    public Yahoo_search_result scrolltoBottom(){
        JavascriptExecutor jse= (JavascriptExecutor)driver;
        logger.log(LogStatus.INFO,"scrolling to the bottom");
        jse.executeScript("scroll(0,10000)");
        return new Yahoo_search_result(driver);
    }

    public Yahoo_search_result searchNumber() throws InterruptedException {
        String searchResult= Resuable_Library2_Logger.captureText(driver,"//*[@class='compPagination']","Search Result",logger);
        String[] searchNumber= searchResult.split("Next");
        logger.log(LogStatus.INFO,"My search number is " + searchNumber[1]);
        return new Yahoo_search_result(driver);


    }




}
