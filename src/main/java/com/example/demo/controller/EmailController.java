package com.example.demo.controller;

import com.example.demo.service.MentorService;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/emails")
public class EmailController {

    private final TeacherService teacherService;
    private final MentorService mentorService;
    private final StudentService studentService;

    public EmailController(TeacherService teacherService, MentorService mentorService, StudentService studentService) {
        this.teacherService = teacherService;
        this.mentorService = mentorService;
        this.studentService = studentService;
    }

    @GetMapping
    public Map<String, List<String>> getAllEmails() {
        Map<String, List<String>> emails = new HashMap<>();
        emails.put("teachers", teacherService.getAllEmails());
        emails.put("mentors", mentorService.getAllEmails());
        emails.put("students", studentService.getAllEmails());
        return emails;
    }
}

