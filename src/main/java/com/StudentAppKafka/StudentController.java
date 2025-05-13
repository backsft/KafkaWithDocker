package com.StudentAppKafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentProducer producer;

    @PostMapping
    public String createStudent(@RequestBody StudentDto dto) {
        producer.sendStudent(dto);
        return "Student create request sent to Kafka.";
    }

    @PutMapping
    public String updateStudent(@RequestBody StudentDto dto) {
        producer.sendStudent(dto);
        return "Student update request sent to Kafka.";
    }
}
