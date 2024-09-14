package springboot_kafka.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import springboot_kafka.dto.Employee;


@Service
public class KafkaMessageListener {

	Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);
	
	@KafkaListener(topics = "my-topic-with-config", groupId="my-group-id")
	public void consume(String message) {
		logger.info("Consumer consumed the message: " +message);
	}

	@KafkaListener(topics = "employee-data", groupId="employee-group")
	public void consume(Employee employee) {
		logger.info("Consumer consumed the message: " +employee.toString());
	}

}
