package Met_Life_PageObject;

import Resuable_Library.Abstract_Class;
import Resuable_Library.Resuable_Library2_Logger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_EnrollNow extends Abstract_Class {

    ExtentTest logger;

    public MetLife_EnrollNow(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        this.logger= super.logger;

    }
    public MetLife_EnrollNow  verifytitle(String userValue) throws InterruptedException {

        Resuable_Library2_Logger.verifyTitle(driver,userValue,logger);

        return new MetLife_EnrollNow(driver);



    }



    public MetLife_EnrollNow  clickingonEnrollNow() throws InterruptedException {

        Resuable_Library2_Logger.click(driver,"//*[contains(text(),'Enroll Now')]","click on enroll now",logger);


        return new MetLife_EnrollNow(driver);

    }








}
