package com.StudentAppKafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StudentConsumer {

    @Autowired
    private StudentRepository studentRepository;

    @KafkaListener(topics = "student-topic", groupId = "student-group")
    public void consume(StudentDto dto) {
        Student student;

        if (dto.getId() != null && studentRepository.existsById(dto.getId())) {
            student = studentRepository.findById(dto.getId()).orElse(new Student());
        } else {
            student = new Student();
        }

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setCourse(dto.getCourse());

        studentRepository.save(student);
        System.out.println("Student saved or updated: " + dto.getName());
    }
}
