package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + id));
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student student) {
        Student studentToModify = getStudentById(id);
        studentToModify.setNIF(student.getNIF());
        studentToModify.setName(student.getName());
        studentToModify.setSurnames(student.getSurnames());
        return studentRepository.save(studentToModify);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(getStudentById(id).getId());
    }
}