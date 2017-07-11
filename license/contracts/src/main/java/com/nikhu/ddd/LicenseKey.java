package com.nikhu.ddd;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * Created by vravuri on 10-Jul-17.
 */
@Data
@AllArgsConstructor
public class LicenseKey {
    private String key;
    private LicenseStatus licenseStatus;
}