package com.example.demo.service;

import com.example.demo.model.FP;
import com.example.demo.repository.FPRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FPService {

    private final FPRepository fpRepository;

    public FPService(FPRepository fpRepository) {
        this.fpRepository = fpRepository;
    }

    public List<FP> getAllFPs() {
        return fpRepository.findAll();
    }

    public FP getFPById(Long id) {
        return fpRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("FP not found with id: " + id));
    }

    public FP saveFP(FP fp) {
        return fpRepository.save(fp);
    }

    public FP updateFP(Long id, FP fpDetails) {
        FP fp = getFPById(id);
        fp.setName(fpDetails.getName());
        fp.setFpFamily(fpDetails.getFpFamily());
        return fpRepository.save(fp);
    }

    public void deleteFP(Long id) {
        fpRepository.deleteById(id);
    }
}

