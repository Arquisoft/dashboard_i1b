package steps;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import dashboard.Application;
import dashboard.model.Voter;
import hello.listeners.KafkaVoterSender;

/**
 * Created by Alvaro Suarez.
 */
@ContextConfiguration
@SpringBootTest(classes = Application.class)
public class LandingSteps {

	@Autowired
	KafkaVoterSender sender;

	// -----------------------------------
	@Autowired
	private WebApplicationContext context;
	private MvcResult result;
	// ---------------------------------------

	String name;
	String vote;
	String proposal;
	String comment;

	@Given("^a list of proposals:$")
	public void aListOfProposals(List<Voter> votes) throws Throwable {
		name = votes.get(0).getName();
		vote = votes.get(0).getVote();
		proposal = votes.get(0).getProposal();
		comment = votes.get(0).getComment();
		Voter v = new Voter(name, vote, proposal, comment);
		// mandamos el voter definidio en landing.feature a kafka
		sender.sendTestVoter(v);
		Thread.sleep(5000);

	}

	@Then("^the webpage contains that proposal$")
	public void databaseContainsAtLeastOneProposal() throws Throwable {
		
		MockMvc mvc = MockMvcBuilders.webAppContextSetup(context).build();

		Voter v = new Voter("Luis", "like", "cucumber", "comentarioNuevo");
		Voter v2 = new Voter("Pedro", "dislike", "cucumber", "comentarioNuevo");
		sender.sendTestVoter(v);
		Thread.sleep(2000);
		
		// assertEquals(v.getName(), name);
		// assertEquals(v.getVote(), vote);
		// assertEquals(v.getProposal(), proposal);
		// assertEquals(v.getComment(), comment);

		
		result = mvc.perform(get("/")).andReturn();
		assertTrue(result.getResponse().getContentAsString()
				.contains("<td th:text=Luis></td><td th:text=cucumber></td><td th:text=comentarioNuevo></td>"));
		
		sender.sendTestVoter(v2);
		Thread.sleep(2000);
		assertTrue(result.getResponse().getContentAsString()
				.contains("<td th:text=Pedro></td><td th:text=cucumber></td><td th:text=comentarioNuevo></td>"));
		
	}

}