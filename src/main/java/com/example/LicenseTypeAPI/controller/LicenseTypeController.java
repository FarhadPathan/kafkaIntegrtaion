package com.example.LicenseTypeAPI.controller;

import com.example.LicenseTypeAPI.model.LicenseType;
import com.example.LicenseTypeAPI.service.KafkaProducerService;
import com.example.LicenseTypeAPI.service.LicenseTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/license-types")
public class LicenseTypeController {
    private final LicenseTypeService service;
    private final KafkaProducerService kafkaProducerService;
    public LicenseTypeController(LicenseTypeService service,
                                 KafkaProducerService kafkaProducerService) {
        this.service = service;
        this.kafkaProducerService = kafkaProducerService;
    }
    @PostMapping
    public ResponseEntity<LicenseType> create(@RequestBody LicenseType
                                                      licenseType) {
        LicenseType saved = service.create(licenseType);
        kafkaProducerService.sendMessage("license-topic",
                saved.getLicenseTypeCode() + "," + saved.getMinistryCode() + "," +
                        saved.isCanBeUsedPartially());
        return ResponseEntity.ok(saved);
    }
    @PutMapping("/{code}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable String code)
    {
        service.deactivate(code);
        return ResponseEntity.noContent().build();
    }

}

