package com.example.demo.controller;

import com.example.demo.model.FCT;
import com.example.demo.service.FCTService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fcts")
public class FCTController {

    private final FCTService fctService;

    public FCTController(FCTService fctService) {
        this.fctService = fctService;
    }

    @GetMapping
    public List<FCT> getAllFCTs() {
        return fctService.getAllFCTs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FCT> getFCTById(@PathVariable Long id) {
        return ResponseEntity.ok(fctService.getFCTById(id));
    }

    @PostMapping
    public ResponseEntity<FCT> createFCT(@RequestBody FCT fct) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fctService.saveFCT(fct));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FCT> updateFCT(@PathVariable Long id, @RequestBody FCT fct) {
        return ResponseEntity.ok(fctService.updateFCT(id, fct));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFCT(@PathVariable Long id) {
        fctService.deleteFCT(id);
        return ResponseEntity.noContent().build();
    }
}

