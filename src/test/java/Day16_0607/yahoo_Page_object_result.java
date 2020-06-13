package Day16_0607;

import Resuable_Library.Abstract_Class;
import Yahoo_page_object.Yahoo_Base_class;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class yahoo_Page_object_result extends Abstract_Class {


    @Test
    public void Yahoo_search_result() throws InterruptedException {

        ArrayList<String> cars = new ArrayList<>();
        cars.add("BMW");
        cars.add("Lexus");
        cars.add("Mercedes");

        for (int i = 0; i < cars.size(); i++) {

            logger.log(LogStatus.INFO, "navigate to yahoo");
            driver.navigate().to("https://www.yahoo.com");
            Thread.sleep(2500);
            Yahoo_Base_class.yahoo_homepage().searchField(cars.get(i));
            Yahoo_Base_class.yahoo_homepage().searchIcon();
            Thread.sleep(2500);
            Yahoo_Base_class.yahoo_search_result().scrolltoBottom();
            Yahoo_Base_class.yahoo_search_result().searchNumber();


        }


    }
}
