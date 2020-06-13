package Met_Life_PageObject;

import Resuable_Library.Abstract_Class;
import Yahoo_page_object.Yahoo_Homepage;
import org.apache.commons.lang3.mutable.Mutable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Met_Life_Base_Class extends Abstract_Class {

    public Met_Life_Base_Class(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);

    }

    public static Met_life_homepage met_life_homepage(){
        Met_life_homepage met_life_homepage = new Met_life_homepage(driver);
        return met_life_homepage;
    }


    public static MetLife_EnrollNow metLife_enrollNow(){
        MetLife_EnrollNow metLife_enrollNow = new MetLife_EnrollNow(driver);
        return metLife_enrollNow;
    }

    public static Metlife_Zipcodes metlife_zipcodes(){
        Metlife_Zipcodes metlife_zipcodes = new Metlife_Zipcodes(driver);
        return metlife_zipcodes;
    }

    public static MetLife_PPO metLife_ppo(){
        MetLife_PPO metLife_ppo = new MetLife_PPO(driver);
        return metLife_ppo;
    }

    public static MetLife_CaptureText metLife_captureText(){
        MetLife_CaptureText metLife_captureText = new MetLife_CaptureText(driver);
        return metLife_captureText;
    }


}//end of java class
