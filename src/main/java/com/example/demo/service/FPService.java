package com.example.demo.service;

import com.example.demo.model.FP;
<<<<<<< HEAD
import com.example.demo.repository.FPRepository;
=======
import com.example.demo.model.Student;
import com.example.demo.repository.FPRepository;
import com.example.demo.repository.StudentRepository;
>>>>>>> main
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FPService {

    private final FPRepository fpRepository;
<<<<<<< HEAD

    public FPService(FPRepository fpRepository) {
        this.fpRepository = fpRepository;
=======
    private final StudentRepository studentRepository;

    public FPService(FPRepository fpRepository, StudentRepository studentRepository) {
        this.fpRepository = fpRepository;
        this.studentRepository = studentRepository;
>>>>>>> main
    }

    public List<FP> getAllFPs() {
        return fpRepository.findAll();
    }

    public FP getFPById(Long id) {
        return fpRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("FP not found with id: " + id));
    }

    public FP saveFP(FP fp) {
        return fpRepository.save(fp);
    }

    public FP updateFP(Long id, FP fpDetails) {
        FP fp = getFPById(id);
        fp.setName(fpDetails.getName());
        fp.setFpFamily(fpDetails.getFpFamily());
        return fpRepository.save(fp);
    }

    public void deleteFP(Long id) {
        fpRepository.deleteById(id);
    }
<<<<<<< HEAD
=======

    public FP addStudentToFP(Long fpId, Long studentId) {
        FP fp = fpRepository.findById(fpId)
                .orElseThrow(() -> new RuntimeException("FP not found with id " + fpId));
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + studentId));

        if (!fp.getStudents().contains(student)) {
            fp.getStudents().add(student);
            student.getStudentFPs().add(fp);
        }

        fpRepository.save(fp);
        studentRepository.save(student);

        return fp;
    }

    public void removeStudentFromFP(Long fpId, Long studentId) {
        FP fp = fpRepository.findById(fpId)
                .orElseThrow(() -> new RuntimeException("FP not found with id " + fpId));
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + studentId));

        if (fp.getStudents().contains(student)) {
            fp.getStudents().remove(student);
            student.getStudentFPs().remove(fp);
        } else {
            throw new RuntimeException("The student is not enrolled in this FP");
        }

        fpRepository.save(fp);
        studentRepository.save(student);
    }
>>>>>>> main
}

