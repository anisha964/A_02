package Met_Life_PageObject;

import Resuable_Library.Abstract_Class;
import Resuable_Library.Resuable_Library2_Logger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_PPO extends Abstract_Class {


    ExtentTest logger;

    public MetLife_PPO(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        this.logger= super.logger;

    }

    public MetLife_PPO clickPPO(String userValue) throws InterruptedException {
        Resuable_Library2_Logger.click(driver,"//*[@class='" + userValue + "']","click on PPO", logger);

        return new MetLife_PPO(driver);


    }

    public MetLife_PPO clickonenroll() throws InterruptedException {
        Resuable_Library2_Logger.click(driver,"//*[@class='btn btn-success']","Enroll into a program",logger);

        return new MetLife_PPO(driver);


    }

    public MetLife_PPO enterReferralcodes(String userValue) throws InterruptedException {
        Resuable_Library2_Logger.userTypeAndHitEnter(driver,"//*[@id='txtBxPromocode']",userValue,"referral codes",logger);

        return new MetLife_PPO(driver);
    }



    public MetLife_PPO errorMessage() throws InterruptedException {
        Resuable_Library2_Logger.captureText(driver,"//*[@id='lblRefCodeError']","error message ",logger);

        return new MetLife_PPO(driver);
    }

    public MetLife_PPO clickOnRC() throws InterruptedException {
        Resuable_Library2_Logger.click(driver,"//*[@class='btn btn-primaryborder']","click on enroll",logger);

        return new MetLife_PPO(driver);
    }






}
