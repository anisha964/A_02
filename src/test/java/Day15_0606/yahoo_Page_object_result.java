package Day15_0606;

import Resuable_Library.Abstract_Class;
import Yahoo_page_object.Yahoo_Base_class;
import Yahoo_page_object.Yahoo_Homepage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class yahoo_Page_object_result extends Abstract_Class {

  @Test
  public void Yahoo_search_result() throws InterruptedException {
      logger.log(LogStatus.INFO,"navigate to yahoo");
      driver.navigate().to("https://www.yahoo.com");
      Thread.sleep(2500);
      Yahoo_Base_class.yahoo_homepage().searchField("cars");
      Yahoo_Base_class.yahoo_homepage().searchIcon();
      Thread.sleep(2500);
      Yahoo_Base_class.yahoo_search_result().scrolltoBottom();
      Yahoo_Base_class.yahoo_search_result().searchNumber();



  }



}
