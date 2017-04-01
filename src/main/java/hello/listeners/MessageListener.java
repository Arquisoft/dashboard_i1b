package hello.listeners;

import javax.annotation.ManagedBean;

import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;

import hello.MainController;

/**
 * Created by herminio on 28/12/16.
 */
@ManagedBean
public class MessageListener {

    private static final Logger logger = Logger.getLogger(MessageListener.class);

    @KafkaListener(topics = "test")
    public void listen(String data) {
        logger.info("New message received: \"" + data + "\"");
        String[] message = data.split(",");
        MainController.users.add(message[0]);
        MainController.votes.add(message[1]);
        MainController.comments.add(message[2]);
        System.out.println(data);
    }


}
