package com.nikhu.ddd.domain.model;

/**
 * Created by vravuri on 10-Jul-17.
 */
public enum LicenseManagementModel {
    CONSOLIDATED("Consolidated"),
    DISTRIBUTED("Distributed"),
    UNKNOWN("");

    private String model;

    LicenseManagementModel(String model) {
        this.model = model;
    }

    public void model(String model) {
        this.model = model;
    }
}
