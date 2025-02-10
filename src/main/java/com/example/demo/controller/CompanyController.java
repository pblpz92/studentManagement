package com.example.demo.controller;

import com.example.demo.model.Company;
import com.example.demo.model.Manager;
import com.example.demo.model.WorkCenter;
import com.example.demo.service.CompanyService;
import com.example.demo.service.ManagerService;
import com.example.demo.service.WorkCenterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;
    private final WorkCenterService workCenterService;
    private final ManagerService managerService;

    public CompanyController(CompanyService companyService, WorkCenterService workCenterService, ManagerService managerService) {
        this.companyService = companyService;
        this.workCenterService = workCenterService;
        this.managerService = managerService;
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        return ResponseEntity.ok(companyService.getCompanyById(id));
    }

    @PostMapping
    public ResponseEntity<Company> saveCompany(@RequestBody Company company) {
        return ResponseEntity.status(HttpStatus.CREATED).body(companyService.saveCompany(company));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        return ResponseEntity.ok(companyService.updateCompany(id, company));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{companyId}/managers")
    public ResponseEntity<Manager> createManager(@PathVariable Long companyId, @RequestBody Manager manager) {
        Manager savedManager = managerService.saveManager(manager, companyId);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedManager);
    }

    @PutMapping("/{companyId}/managers/{managerId}")
    public ResponseEntity<Manager> updateManager(@PathVariable Long companyId, @PathVariable Long managerId, @RequestBody Manager managerDetails) {
        Manager updatedManager = managerService.updateManager(managerId, managerDetails, companyId);
        return ResponseEntity.ok(updatedManager);
    }

    @DeleteMapping("/{companyId}/managers/{managerId}")
    public ResponseEntity<Void> deleteManager(@PathVariable Long companyId, @PathVariable Long managerId) {
        managerService.deleteManager(managerId, companyId);
        return ResponseEntity.noContent().build();
    }

    /*
    @PostMapping("/{companyId}/workcenters")
    public ResponseEntity<WorkCenter> createWorkCenter(@PathVariable Long companyId, @RequestBody WorkCenter workCenter) {
        Company company = companyService.getCompanyById(companyId);
        return ResponseEntity.status(HttpStatus.CREATED).body(workCenterService.saveWorkCenter(workCenter));
    }

    @PutMapping("/{companyId}/workcenters/{workCenterId}")
    public ResponseEntity<WorkCenter> updateWorkCenter(@PathVariable Long companyId, @PathVariable Long workCenterId, @RequestBody WorkCenter workCenterDetails) {
        WorkCenter existingWorkCenter = workCenterService.getWorkCenterById(workCenterId);
        WorkCenter updatedWorkCenter = workCenterService.updateWorkCenter(workCenterId, workCenterDetails);
        return ResponseEntity.ok(updatedWorkCenter);
    }

    @DeleteMapping("/{companyId}/workcenters/{workCenterId}")
    public ResponseEntity<Void> deleteWorkCenter(@PathVariable Long companyId, @PathVariable Long workCenterId) {
        workCenterService.getWorkCenterById(workCenterId);
        workCenterService.deleteWorkCenter(workCenterId);
        return ResponseEntity.noContent().build();
    }*/
}