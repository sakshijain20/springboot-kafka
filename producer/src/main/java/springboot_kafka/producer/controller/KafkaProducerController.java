package springboot_kafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot_kafka.dto.Employee;
import springboot_kafka.producer.service.KafkaMessagePublisher;

@RestController
@RequestMapping("/producer-app")
public class KafkaProducerController {
	
	@Autowired
	private KafkaMessagePublisher publisher;

	@GetMapping("/publish/{message}")
	public ResponseEntity<?> publishMessage(@PathVariable String message){
       try {
//			for(int i=1;i<=1000;i++) {
//				publisher.sendMessageToTopic(message + " :" +i);
//			}
			publisher.sendMessageToTopic(message);
			return ResponseEntity.ok("Message published successfully");
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping("/employee")
	public void publishEmployee(@RequestBody Employee employee){
			publisher.publishEmployee(employee);
	}
}
