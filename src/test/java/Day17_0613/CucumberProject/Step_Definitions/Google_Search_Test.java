package Day17_0613.CucumberProject.Step_Definitions;

import Resuable_Library.Resuable_Library2_Logger;
import Resuable_Library.Reusable_Library2;
import com.cucumber.listener.Reporter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Google_Search_Test {
    WebDriver driver;
    // the annotation gherkin commands/methods are @Giver,@When,@And,@Then

    @Given("^I navigate to google home page$")
    public void navigate() throws IOException, InterruptedException {
        driver= Reusable_Library2.setDriver();
        //navigating to google
        driver.navigate().to("https://www.google.com");
    }// end

    @When("^I enter a keyword (.*) on search field$")
    public void SearchField(String Cars ){
     Reusable_Library2.userKeys(driver,"//*[@name='q']",Cars,"search field");

    }//end of search field

    @When("^I click on search icon$")
    public void SearchIcon(){
    Reusable_Library2.submit(driver,"//*[@name='btnK']","SearchIcon");
    }//end of searchIcon
    @When("^I capture search result and print it$")
    public void SearchResult() throws InterruptedException {
    Thread.sleep(2500);
    String result= Reusable_Library2.captureText(driver,"//*[@id='result-stats']","captureResult");
    String[]arraySearch= result.split(" ");
    Reporter.addStepLog("The number is " + arraySearch[1]);
    }//end of searchResult
    @When("^Click on more$")
    public void moreIcon(){
        Reusable_Library2.click(driver,"//span[contains(@class,'more-vert']","MoreIcon");
    }//end of searchIcon

    @Then("^I can select the value (.*)$")
    public void ExtractText(String More) throws InterruptedException {
        Thread.sleep(1500);
        Reusable_Library2.click(driver,"//*[text()='"+More+"']","more result");

    }//end of extract text













}//end of test
