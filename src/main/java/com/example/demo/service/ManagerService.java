package com.example.demo.service;

import com.example.demo.model.Company;
import com.example.demo.model.Manager;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.ManagerRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {

    private final ManagerRepository managerRepository;
    private final CompanyService companyService;

    public ManagerService(ManagerRepository managerRepository, CompanyService companyService) {
        this.managerRepository = managerRepository;
        this.companyService = companyService;
    }

    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    public Manager saveManager(Manager manager, Long companyId) {
        Company company = companyService.getCompanyById(companyId);
        manager.setCompany(company);
        company.addManager(manager);
        return managerRepository.save(manager);
    }

    public Manager getManagerById(Long id) {
        return managerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Manager not found with id: " + id));
    }

    public Manager updateManager(Long id, Manager updatedManager, Long companyId) {
        Manager manager = getManagerById(id);

        if (!managerExistsInCompany(companyId, manager)) {
             throw new IllegalArgumentException("El manager con id " + id + " no pertenece a la empresa con id " + companyId);
        }

        manager.setName(updatedManager.getName());
        manager.setSurnames(updatedManager.getSurnames());
        manager.setEmail(updatedManager.getEmail());
        manager.setPhoneNumber(updatedManager.getPhoneNumber());
        return managerRepository.save(manager);
    }

    private boolean managerExistsInCompany(Long companyId, Manager manager) {
        return manager.getCompany().getId().equals(companyId);
    }

    public void deleteManager(Long id, Long companyId) {
        Manager manager = getManagerById(id);

        if (!managerExistsInCompany(companyId, manager)) {
            throw new IllegalArgumentException("El manager con id " + id + " no pertenece a la empresa con id " + companyId);
        }

        managerRepository.deleteById(id);
    }
}

