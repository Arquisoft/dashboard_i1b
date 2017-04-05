package dashboard.serviceTest;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.context.ConfigurableApplicationContext;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import dashboard.model.Voter;

public class LandingSteps {


	protected ConfigurableApplicationContext appContext;
	protected WebDriver driver = new HtmlUnitDriver();
	protected String baseUrl = "http://localhost:8080/";

	@Given("^a list of proposals:$")
	public void aListOfProposals(List<Voter> voters) throws Throwable {
		driver.get(baseUrl);
		Thread.sleep(2000);
		assertTrue(driver.findElement(By.id("myTableLike"))!=null);
	}

	@Then("^the webpage contains that proposal$")
	public void databaseContainsAtLeastOneProposal() throws Throwable {

	}

}