package sun.tpiv.wsm.runner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = { "src/test/resources/features/GoogleCalculator.feature" },
glue = {"sun.tpiv.wsm.definitions" }, 
plugin = { "pretty", "html:target/cucumber-html-report.html" })

@Test
public class GoogleCalculatorTests extends AbstractTestNGCucumberTests {

}
