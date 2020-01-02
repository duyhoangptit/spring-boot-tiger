package vn.tiger.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.tiger.kafka.model.Student;
import vn.tiger.kafka.service.KafkaSender;

@RestController
@RequestMapping("message")
public class SendMessageController {

    @Autowired
    private KafkaSender kafkaSender;

    @PostMapping("producer")
    public ResponseEntity<String> sendMessage(@RequestBody Student student) {
        this.kafkaSender.sendMessage(student);
        return new ResponseEntity<>("Data sent to Kafka", HttpStatus.OK);
    }
}
