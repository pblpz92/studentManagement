package com.example.demo.controller;

import com.example.demo.model.Manager;
import com.example.demo.service.ManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/managers")
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping
    public List<Manager> getAllManagers() {
        return managerService.getAllManagers();
    }

    @PostMapping
    public ResponseEntity<Manager> createManager(@RequestBody Manager manager) {
        return ResponseEntity.status(HttpStatus.CREATED).body(managerService.saveManager(manager));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manager> getManagerById(@PathVariable Long id) {
        return ResponseEntity.ok(managerService.getManagerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manager> updateManager(@PathVariable Long id, @RequestBody Manager manager) {
        return ResponseEntity.ok(managerService.updateManager(id, manager));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManager(@PathVariable Long id) {
        managerService.deleteManager(id);
        return ResponseEntity.noContent().build();
    }
}

