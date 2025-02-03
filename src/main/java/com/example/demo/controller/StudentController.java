package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
<<<<<<< HEAD
@RequestMapping("/students")
=======
@RequestMapping("/api/students")
>>>>>>> main
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
<<<<<<< HEAD
    public ResponseEntity<Student> getCompanyById(@PathVariable Long id) {
=======
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
>>>>>>> main
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
<<<<<<< HEAD
    public ResponseEntity<Student> saveCompany(@RequestBody Student student) {
=======
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
>>>>>>> main
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.saveStudent(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable @NotNull Long id, @RequestBody Student student) {
        return ResponseEntity.ok(studentService.updateStudent(id, student));
    }

    @DeleteMapping("/{id}")
<<<<<<< HEAD
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
=======
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
>>>>>>> main
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

}