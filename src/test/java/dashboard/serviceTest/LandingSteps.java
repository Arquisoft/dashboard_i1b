package dashboard.serviceTest;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import dashboard.Application;
import dashboard.model.Citizen;
import dashboard.model.Proposal;
import dashboard.model.Vote;
import dashboard.model.Voter;
import dashboard.persistence.CitizenRepositoy;
import dashboard.persistence.ProposalRepository;
import dashboard.persistence.VoteRepository;
@ContextConfiguration
@SpringBootTest(classes = Application.class)
public class LandingSteps {
	@Autowired
	private VoteRepository votes;
	@Autowired
	private CitizenRepositoy citizen;
	@Autowired
	private ProposalRepository proposal;
	private Citizen c1, c2, c3;
	private Proposal p1, p2, p3;
	private Vote v1, v2, v3;

	@Given("^a list of proposals:$")
	public void aListOfProposals(List<Voter> voters) throws Throwable {
		votes.deleteAll();
		proposal.deleteAll();
		citizen.deleteAll();
		
		c1 = new Citizen("Pablo","Roncero","password",new Date(),"Roncero@email.com","minif1","miaddress","spain",1);
		c2 = new Citizen("David","Villamil","password",new Date(),"Villamil@email.com","minif2","miaddress","spain",1);
		c3 = new Citizen("Alvalo","Suarez","password",new Date(),"Suarez@email.com","minif3","miaddress","spain",1);
		p1 = new Proposal("p1", c1);
		p2 = new Proposal("p2", c2);
		p3 = new Proposal("p3", c3);
		v1 = new Vote(c1, p1, true);
		v2 = new Vote(c2, p2, true);
		v3 = new Vote(c3, p3, false);
		
		v1 = votes.save(v1);
		assertTrue(votes.findAll().size()==1);
	}

	@Then("^the webpage contains that proposal$")
	public void databaseContainsAtLeastOneProposal() throws Throwable {

	}

}