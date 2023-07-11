package sun.tpiv.wsm.definitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleCalculatorDefinitions {
	private WebDriver webDriver;
	private String baseUrl = "https://www.google.com";
	public final static int TIMEOUT = 10;

	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
		webDriver.manage().window().maximize();
	}

	@Given("Open google.com")
	public void open_google_com() {
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		webDriver.get(baseUrl);
	}

	@When("Entering number {int} and {int}")
	public void entering_number_and(Integer first, Integer second) {
		WebElement googleTextBox = webDriver.findElement(By.className("gLFyf"));
		googleTextBox.sendKeys(first + " + " + second);
	}

	@When("Press enter")
	public void press_enter() {
		WebElement searchButton = webDriver.findElement(By.className("gNO89b"));
		searchButton.click();
	}

	@Then("Result should be {int}")
	public void result_should_be(Integer result) {
		WebElement calculatorTextBox = webDriver.findElement(By.className("qv3Wpe"));
		Integer getResult = Integer.parseInt(calculatorTextBox.getText());
		Assert.assertEquals(getResult, result);
		webDriver.close();
	}

	@After
	public void end() {
		if (webDriver != null) {
			webDriver.quit();
		}
	}

}