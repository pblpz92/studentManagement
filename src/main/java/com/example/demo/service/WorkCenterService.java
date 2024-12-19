package com.example.demo.service;

import com.example.demo.model.WorkCenter;
import com.example.demo.repository.WorkCenterRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkCenterService {

    private final WorkCenterRepository workCenterRepository;

    public WorkCenterService(WorkCenterRepository workCenterRepository) {
        this.workCenterRepository = workCenterRepository;
    }

    public List<WorkCenter> getAllWorkCenters() {
        return workCenterRepository.findAll();
    }

    public WorkCenter getWorkCenterById(Long id) {
        return workCenterRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("WorkCenter not found with id: " + id));
    }

    public WorkCenter saveWorkCenter(WorkCenter workCenter) {
        return workCenterRepository.save(workCenter);
    }

    public WorkCenter updateWorkCenter(Long id, WorkCenter workCenterDetails) {
        WorkCenter workCenter = getWorkCenterById(id);

        workCenter.setName(workCenterDetails.getName());
        workCenter.setCompany(workCenterDetails.getCompany());
        workCenter.setAddress(workCenterDetails.getAddress());

        return workCenterRepository.save(workCenter);
    }

    public void deleteWorkCenter(Long id) {
        workCenterRepository.deleteById(id);
    }
}
