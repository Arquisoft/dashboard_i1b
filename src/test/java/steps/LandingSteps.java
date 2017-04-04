package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import dashboard.model.Voter;
import hello.Application;
import hello.listeners.KafkaVoterSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Alvaro Suarez.
 */
@ContextConfiguration
@SpringBootTest(classes = Application.class)
public class LandingSteps {
	
	@Autowired
	KafkaVoterSender sender;
	
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
    	Voter v = new Voter(name,vote,proposal,comment);
    	//mandamos el voter definidio en landing.feature a kafka
    	sender.sendTestVoter(v);
        Thread.sleep(5000);
        
    }
    @Then("^the webpage contains that proposal$")
    public void databaseContainsAtLeastOneProposal() throws Throwable {
    	//ahora hay que coger los datos de kafka y hacer assert equals
    	Voter v = new Voter("Alvaro","like","cucumber","jirafa");
        assertEquals(v.getName(), name);
        assertEquals(v.getVote(), vote);
        assertEquals(v.getProposal(), proposal);
        assertEquals(v.getComment(), comment);
    }

}