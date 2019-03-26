package runner;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


//@RunWith(Cucumber.class)
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = {"src/test/java/featureFiles/"},
		glue = {"stepDefinitions"},
		//format = {"html:target/site/cucumber-pretty"},
		//plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/cucumber-reports/report.html"},
       // tags = {"@Smoke"},
        monochrome = true,
        dryRun = false
		)
public class TestRunner {


}
