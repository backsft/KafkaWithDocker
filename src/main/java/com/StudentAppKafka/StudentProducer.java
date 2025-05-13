package com.StudentAppKafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentProducer {

    private static final String TOPIC = "student-topic";

    @Autowired
    private KafkaTemplate<String, StudentDto> kafkaTemplate;

    public void sendStudent(StudentDto studentDto) {
        kafkaTemplate.send(TOPIC, studentDto);
    }
}
