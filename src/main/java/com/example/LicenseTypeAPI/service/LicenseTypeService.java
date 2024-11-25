package com.example.LicenseTypeAPI.service;

import com.example.LicenseTypeAPI.model.LicenseType;
import com.example.LicenseTypeAPI.repository.LicenseTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LicenseTypeService {
    private final LicenseTypeRepository repository;
    public LicenseTypeService(LicenseTypeRepository repository) {
        this.repository = repository;
    }
    public LicenseType create(LicenseType licenseType) {
        Optional<LicenseType> existing =
                repository.findByLicenseTypeCodeAndActiveTrue(licenseType.getLicenseTypeCode());
        if (existing.isPresent()) {
            throw new IllegalStateException("Active license type with the same code already exists.");
        }
        licenseType.setActive(true);
        return repository.save(licenseType);
    }
    public void deactivate(String licenseTypeCode) {
        LicenseType licenseType =
                repository.findByLicenseTypeCodeAndActiveTrue(licenseTypeCode).orElseThrow(()-> new IllegalArgumentException("Active license type not found."));
        licenseType.setActive(false);
        repository.save(licenseType);
    }
}

