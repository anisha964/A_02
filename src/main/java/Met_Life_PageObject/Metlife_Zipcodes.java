package Met_Life_PageObject;

import Resuable_Library.Abstract_Class;
import Resuable_Library.Resuable_Library2_Logger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Metlife_Zipcodes extends Abstract_Class {

    ExtentTest logger;

    public Metlife_Zipcodes(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        this.logger= super.logger;

    }

    public Metlife_Zipcodes EnteringZipcodes(String userValue) throws InterruptedException {
        Resuable_Library2_Logger.userTypeAndHitEnter(driver,"//*[@id='txtZipCode']",userValue,"zipcode",logger);

        return new Metlife_Zipcodes(driver);

    }

    public Metlife_Zipcodes ClickingOnGo() throws InterruptedException {
        Resuable_Library2_Logger.click(driver,"//*text()='GO']","click on go",logger);
        return new Metlife_Zipcodes(driver);

    }














}
