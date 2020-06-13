package Yahoo_page_object;

import Resuable_Library.Abstract_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Yahoo_Base_class extends Abstract_Class {


    public Yahoo_Base_class(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);

    }
    //object for yahoo homepage
    public static Yahoo_Homepage yahoo_homepage(){
        Yahoo_Homepage yahoo_homepage = new Yahoo_Homepage(driver);
        return yahoo_homepage;
    }// end of object reference for yahoo search result page

    public static Yahoo_search_result yahoo_search_result(){
        Yahoo_search_result yahoo_search_result  = new Yahoo_search_result(driver);
        return yahoo_search_result;
    }// end of object reference for yahoo search result page











}
