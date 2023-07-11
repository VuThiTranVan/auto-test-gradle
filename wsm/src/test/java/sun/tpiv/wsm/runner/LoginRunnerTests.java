package sun.tpiv.wsm.runner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/*
 * AbstractTestNGCucumberTests – Chạy từng kịch bản cucumber được tìm thấy trong
 * các tính năng dưới dạng thử nghiệm riêng biệt.
 */
@CucumberOptions(tags = "", features = { "src/test/resources/features/LoginPage.feature" }, glue = {
		"sun.tpiv.wsm.definitions" }, plugin = { "pretty", "html:target/cucumber-html-report.html"})
@Test
public class LoginRunnerTests extends AbstractTestNGCucumberTests {

}