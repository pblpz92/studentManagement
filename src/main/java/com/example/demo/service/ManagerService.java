package com.example.demo.service;

import com.example.demo.model.Manager;
import com.example.demo.repository.ManagerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    public Manager saveManager(Manager manager) {
        return managerRepository.save(manager);
    }

    public Manager getManagerById(Long id) {
        return managerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Manager not found with id: " + id));
    }

    public Manager updateManager(Long id, Manager updatedManager) {
        Manager manager = getManagerById(id);
        manager.setName(updatedManager.getName());
        manager.setSurnames(updatedManager.getSurnames());
        manager.setEmail(updatedManager.getEmail());
        manager.setPhoneNumber(updatedManager.getPhoneNumber());
        return managerRepository.save(manager);
    }

    public void deleteManager(Long id) {
        managerRepository.deleteById(id);
    }
}

