package dashboard.serviceTest;

import org.junit.runner.RunWith;
import org.springframework.stereotype.Component;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import dashboard.Application;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features" )
public class CucumberTest {
	
	
}