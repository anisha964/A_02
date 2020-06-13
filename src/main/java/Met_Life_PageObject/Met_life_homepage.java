package Met_Life_PageObject;

import Resuable_Library.Abstract_Class;
import Resuable_Library.Resuable_Library2_Logger;
import Yahoo_page_object.Yahoo_Homepage;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Met_life_homepage extends Abstract_Class {

        ExtentTest logger;


    public Met_life_homepage(WebDriver driver) {

            super();

            PageFactory.initElements(driver, this);
            this.logger = super.logger;

    }

    public Met_life_homepage  verifytitle(String userValue) throws InterruptedException {

        Resuable_Library2_Logger.verifyTitle(driver,userValue,logger);

        return new Met_life_homepage(driver);



    }


    public Met_life_homepage  clickingonSolutions() throws InterruptedException {
        Resuable_Library2_Logger.click(driver,"//*[contains(text(),'SOLUTIONS')]","click on solutions",logger);

        return new Met_life_homepage(driver);



    }

    public Met_life_homepage  clickingonmetlifedental() throws InterruptedException {
        Resuable_Library2_Logger.click(driver,"//*[contains(text(),'MetLife TakeAlong Dental')]","click on Metlife Dental",logger);

        return new Met_life_homepage(driver);



    }







}
