package com.nikhu.ddd.web;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by vravuri on 12-Jul-17.
 */
@Getter
@AllArgsConstructor
public class LicenseVO {
    private String accountId;
    private String productId;
    private String licenseKey;
}
