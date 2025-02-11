package com.example.demo.service;

import com.example.demo.model.Company;
import com.example.demo.model.WorkCenter;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.WorkCenterRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkCenterService {

    private final WorkCenterRepository workCenterRepository;
    private final CompanyService companyService;

    public WorkCenterService(WorkCenterRepository workCenterRepository, CompanyService companyService) {
        this.workCenterRepository = workCenterRepository;
        this.companyService = companyService;
    }

    public List<WorkCenter> getAllWorkCenters() {
        return workCenterRepository.findAll();
    }

    public WorkCenter getWorkCenterById(Long id) {
        return workCenterRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("WorkCenter not found with id: " + id));
    }

    public WorkCenter saveWorkCenter(WorkCenter workCenter, Long companyId) {
        Company company = companyService.getCompanyById(companyId);
        workCenter.setCompany(company);
        company.addWorkCenter(workCenter);
        return workCenterRepository.save(workCenter);
    }

    public WorkCenter updateWorkCenter(Long id, WorkCenter workCenterDetails, Long companyId) {
        WorkCenter workCenter = getWorkCenterById(id);

        if (!workCenterExistsInCompany(companyId, workCenter)) {
            throw new IllegalArgumentException("El workcenter con id " + id + " no pertenece a la compañia con id " + companyId);
        }

        workCenter.setName(workCenterDetails.getName());
        workCenter.setAddress(workCenterDetails.getAddress());

        return workCenterRepository.save(workCenter);
    }

    private static boolean workCenterExistsInCompany(Long companyId, WorkCenter workCenter) {
        return workCenter.getId().equals(companyId);
    }

    public void deleteWorkCenter(Long id, Long companyId) {
        WorkCenter workCenter = getWorkCenterById(id);

        if (!workCenterExistsInCompany(companyId, workCenter)) {
            throw new IllegalArgumentException("El workcenter con id " + id + " no pertenece a la compañia con id " + companyId);
        }

        workCenterRepository.deleteById(id);
    }
}
