package Day17_0613.CucumberProject.Runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
features = {"src/test/java/Day17_0613/CucumberProject/Features/Google_Test.feature"} ,
glue = {"Day17_0613.CucumberProject.Step_Definitions"},
plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"}


)
public class Runner {
    //this is empty
}
