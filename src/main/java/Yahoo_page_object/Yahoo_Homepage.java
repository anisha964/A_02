package Yahoo_page_object;

import Resuable_Library.Abstract_Class;
import Resuable_Library.Resuable_Library2_Logger;
import Resuable_Library.Reusable_Library2;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Yahoo_Homepage extends Abstract_Class {

    //we need to create constructor method that define
    //driver and logger to be re used locally this page

    ExtentTest logger;


    public Yahoo_Homepage(WebDriver driver){

        super();

        PageFactory.initElements(driver,this);
        this.logger= super.logger;

    }

    public Yahoo_Homepage searchField(String userValue) throws InterruptedException {
        Resuable_Library2_Logger.userKeys(driver,"//*[@id='header-search-input']",userValue,"Search field",logger);
        return new Yahoo_Homepage(driver);
        //the driver that I used us returning you the same
        //yahoo_homepage


    }

    public Yahoo_Homepage searchIcon() throws InterruptedException {
        Resuable_Library2_Logger.click(driver,"//*[@id='header-desktop-search-button']","",logger);

        return new Yahoo_Homepage(driver);
    }



























}//end of java class

