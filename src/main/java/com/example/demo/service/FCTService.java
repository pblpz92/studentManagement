package com.example.demo.service;

import com.example.demo.model.FCT;
import com.example.demo.repository.FCTRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FCTService {

    private final FCTRepository fctRepository;

    public FCTService(FCTRepository fctRepository) {
        this.fctRepository = fctRepository;
    }

    public List<FCT> getAllFCTs() {
        return fctRepository.findAll();
    }

    public FCT getFCTById(Long id) {
        return fctRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("FCT not found with id: " + id));
    }

    public FCT saveFCT(FCT fct) {
        return fctRepository.save(fct);
    }

    public FCT updateFCT(Long id, FCT fctDetails) {
        FCT fct = getFCTById(id);
        fct.setStudent(fctDetails.getStudent());
        fct.setCompany(fctDetails.getCompany());
        fct.setWorkCenter(fctDetails.getWorkCenter());
        fct.setMentor(fctDetails.getMentor());
        fct.setTeacher(fctDetails.getTeacher());
        fct.setStartDate(fctDetails.getStartDate());
        fct.setWorkSchedule(fctDetails.getWorkSchedule());
        fct.setDepartment(fctDetails.getDepartment());
        fct.setWorkMode(fctDetails.getWorkMode());
        return fctRepository.save(fct);
    }

    public void deleteFCT(Long id) {
        fctRepository.deleteById(id);
    }
}
