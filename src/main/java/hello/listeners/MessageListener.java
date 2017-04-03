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

//    @KafkaListener(topics = "test")
//    public void listen(String data) {
//        logger.info("New message received: \"" + data + "\"");
//        System.out.println(data);
//    }



}
