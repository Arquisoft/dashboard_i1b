package hello.listeners;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import dashboard.model.Voter;

public class KafkaVoterSender {
	
	private static final Logger logger = Logger.getLogger(KafkaVoterSender.class);

    @Autowired
    private KafkaTemplate<String, Voter> kafkaTemplate;

    public void send(String topic, Voter data) {
        ListenableFuture<SendResult<String, Voter>> future = kafkaTemplate.send(topic, data);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Voter>>() {
            @Override
            public void onSuccess(SendResult<String, Voter> result) {
                logger.info("Message Send \"" + data + "\" to topic " + topic);
            }

            @Override
            public void onFailure(Throwable ex) {
                logger.error("Error on message \"" + data + "\", stacktrace " + ex.getMessage());
            }
        });
    }
    
    public void sendTestVoter(Voter voter) {
        send("Voter", voter);
    }
}
