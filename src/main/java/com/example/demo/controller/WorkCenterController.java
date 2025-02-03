package com.example.demo.controller;

import com.example.demo.model.WorkCenter;
import com.example.demo.service.WorkCenterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workcenters")
public class WorkCenterController {

    private final WorkCenterService workCenterService;

    public WorkCenterController(WorkCenterService workCenterService) {
        this.workCenterService = workCenterService;
    }

    @GetMapping
    public List<WorkCenter> getAllWorkCenters() {
        return workCenterService.getAllWorkCenters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkCenter> getWorkCenterById(@PathVariable Long id) {
        return ResponseEntity.ok(workCenterService.getWorkCenterById(id));
    }

    @PostMapping
    public ResponseEntity<WorkCenter> saveWorkCenter(@RequestBody WorkCenter workCenter) {
        return ResponseEntity.status(HttpStatus.CREATED).body(workCenterService.saveWorkCenter(workCenter));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkCenter> updateWorkCenter(@PathVariable Long id, @RequestBody WorkCenter workCenter) {
        return ResponseEntity.ok(workCenterService.updateWorkCenter(id, workCenter));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkCenter(@PathVariable Long id) {
        workCenterService.deleteWorkCenter(id);
        return ResponseEntity.noContent().build();
    }
}

