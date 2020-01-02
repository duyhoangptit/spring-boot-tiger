package vn.tiger.kafka.reciever;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import vn.tiger.kafka.model.Student;

@Service
public class KafkaReciever {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaReciever.class);

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.consumer.group.id}")
    public void recieverMessage(Student student) {
        LOGGER.info("Data: " + student.toString() + " recieved");
    }

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.consumer.group.id}")
    public void recieverMessage1(Student student) {
        LOGGER.info("Data: " + student.toString() + " recieved");
    }
}
