package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = { "StepDefinitions" }, monochrome = true, plugin = {
		"pretty", "junit:target/JunitReports/report.xml", "json:target/JSONReports/report.json",
		"html:target/HtmlReports/report.html" }, tags = "@regressiontest")
public class TestRunner {

}
