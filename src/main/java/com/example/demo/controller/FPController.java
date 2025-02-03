package com.example.demo.controller;

import com.example.demo.model.FP;
import com.example.demo.service.FPService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fps")
public class FPController {

    private final FPService fpService;

    public FPController(FPService fpService) {
        this.fpService = fpService;
    }

    @GetMapping
    public List<FP> getAllFPs() {
        return fpService.getAllFPs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FP> getFPById(@PathVariable Long id) {
        return ResponseEntity.ok(fpService.getFPById(id));
    }

    @PostMapping
    public ResponseEntity<FP> saveFP(@RequestBody FP fp) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fpService.saveFP(fp));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FP> updateFP(@PathVariable Long id, @RequestBody FP fp) {
        return ResponseEntity.ok(fpService.updateFP(id, fp));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFP(@PathVariable Long id) {
        fpService.deleteFP(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{fpId}/students/{studentId}")
    public ResponseEntity<FP> addStudentToFP(
            @PathVariable Long fpId,
            @PathVariable Long studentId) {
        FP updatedFP = fpService.addStudentToFP(fpId, studentId);
        return ResponseEntity.ok(updatedFP);
    }

    @DeleteMapping("/{fpId}/students/{studentId}")
    public ResponseEntity<Void> removeStudentFromFP(
            @PathVariable Long fpId,
            @PathVariable Long studentId) {
        fpService.removeStudentFromFP(fpId, studentId);
        return ResponseEntity.noContent().build();
    }
}

