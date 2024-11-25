package com.example.LicenseTypeAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LicenseType {
    @Id
    private String licenseTypeCode;
    private String description;
    private String descriptionTranslated;
    private String ministryCode;
    private String ministryDescription;
    private boolean canBeUsedPartially;
    private boolean active;

    public String getLicenseTypeCode() {
        return licenseTypeCode;
    }

    public void setLicenseTypeCode(String licenseTypeCode) {
        this.licenseTypeCode = licenseTypeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionTranslated() {
        return descriptionTranslated;
    }

    public void setDescriptionTranslated(String descriptionTranslated) {
        this.descriptionTranslated = descriptionTranslated;
    }

    public String getMinistryCode() {
        return ministryCode;
    }

    public void setMinistryCode(String ministryCode) {
        this.ministryCode = ministryCode;
    }

    public String getMinistryDescription() {
        return ministryDescription;
    }

    public void setMinistryDescription(String ministryDescription) {
        this.ministryDescription = ministryDescription;
    }

    public boolean isCanBeUsedPartially() {
        return canBeUsedPartially;
    }

    public void setCanBeUsedPartially(boolean canBeUsedPartially) {
        this.canBeUsedPartially = canBeUsedPartially;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
