package com.example.demo.service;

import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found with id: " + id));
    }

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Long id, Teacher teacher) {
        Teacher teacherToModify = getTeacherById(id);
        teacherToModify.setName(teacher.getName());
        teacherToModify.setSurnames(teacher.getSurnames());
        teacherToModify.setPhoneNumber(teacher.getPhoneNumber());
        teacherToModify.setEmail(teacher.getEmail());
        return teacherRepository.save(teacherToModify);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    public List<String> getAllEmails() {
        List<Teacher> teachers = teacherRepository.findAll();
        List<String> emails = new ArrayList<>();

        for (Teacher teacher : teachers) {
            emails.add(teacher.getEmail());
        }

        return emails;
    }
}