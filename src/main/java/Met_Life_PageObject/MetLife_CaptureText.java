package Met_Life_PageObject;

import Resuable_Library.Abstract_Class;
import Resuable_Library.Resuable_Library2_Logger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_CaptureText extends Abstract_Class {

    ExtentTest logger;

    public MetLife_CaptureText(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        this.logger= super.logger;
    }

    public String capturetext() throws InterruptedException {

       String Text= Resuable_Library2_Logger.captureText(driver,"//div[@class='col-sm-8']","PPo",logger);


        return Text;
    }






}

