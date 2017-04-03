package hello;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Controller
public class MainController {

	private static final Logger logger = Logger.getLogger(MainController.class);
	public static List<String> messages = new ArrayList<>();
	private List<SseEmitter> sseEmitters = Collections.synchronizedList(new ArrayList<>());
	//private SseEmitter ssemiter = new SseEmitter();

	@RequestMapping("/")
	public String landing(Model model) {
		return "index";
	}

	@RequestMapping("/messages")
	SseEmitter sendMessages() {
		SseEmitter emiter = new SseEmitter();
		synchronized (this.sseEmitters) {
			this.sseEmitters.add(emiter);
			emiter.onCompletion(() -> {
				synchronized (this.sseEmitters) {
					this.sseEmitters.remove(emiter);
				}
			});
			return emiter;
		}
	}

	@KafkaListener(topics = "test")
	public String listen(String data) {
		logger.info("New message received: \"" + data + "\"");
		for (SseEmitter sseEmitter : sseEmitters)
			try {
				sseEmitter.send("Message: " + data);
			} catch (IOException e) {
				e.printStackTrace();
			}
		System.out.println(data);
		return data;
	}

}