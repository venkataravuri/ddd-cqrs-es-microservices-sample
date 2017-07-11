package com.nikhu.ddd;

/**
 * Created by vravuri on 10-Jul-17.
 */
public enum LicenseStatus {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    SUSPENDED("Suspended"),
    UNKNOWN("");

    private String status;

    LicenseStatus(String status) {
        this.status = status;
    }

    public String status() {
        return status;
    }
}
