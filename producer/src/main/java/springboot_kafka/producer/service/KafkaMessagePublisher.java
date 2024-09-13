package springboot_kafka.producer.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessagePublisher {

	@Autowired
	private KafkaTemplate<String, Object> template;
	
	public void sendMessageToTopic(String message) {
		CompletableFuture<SendResult<String, Object>> future = template.send("my-topic-with-config", message);
	    future.whenComplete((result, ex) -> {
	    	if( ex == null) {
	    		System.out.println("Sent message: " + message + " with offsetvalue: " +result.getRecordMetadata().offset());
	    	}
	    	else {
	    		System.out.println("Unable to send message: " +message + " due to" +ex.getMessage());
	    	}
	    });
		
	}
}
