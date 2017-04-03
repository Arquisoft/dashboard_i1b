package hello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import dashboard.model.Voter;

@Controller
public class MainController {

	private static final Logger logger = Logger.getLogger(MainController.class);
	// public static List<String> users = new ArrayList<>();
	private List<SseEmitter> sseEmitters = Collections.synchronizedList(new ArrayList<>());
	// public static List<String> votes = new ArrayList<>();
	// public static List<String> comments = new ArrayList<>();

	public static List<Voter> votersLike = new ArrayList<>();
	public static List<Voter> votersDislike = new ArrayList<>();

	@RequestMapping("/")
	public String landing(Model model) {

		System.out.println("--------------------------------------------------------------VOTE (like) NUM: " + votersLike.size());
		System.out.println("--------------------------------------------------------------VOTE (dislike) NUM: " + votersDislike.size());
		model.addAttribute("votersLike", votersLike);
		model.addAttribute("votersDislike", votersDislike);
		model.addAttribute("numberOfVotesLike", votersLike.size());
		model.addAttribute("numberOfVotesDislike", votersDislike.size());

		// model.addAttribute("voters", users);
		// model.addAttribute("votes",votes);
		// model.addAttribute("comments", comments);
		// model.addAttribute("numberOfVotes", votes.size());
		// System.out.println("-----------------------------------------------------------------------------"+votes.size());
		return "index";
	}

}