package com.nikhu.ddd;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by vravuri on 10-Jul-17.
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class LicenseKeyRegisteredEvent {
    private String id;
    private String accountId;
    private String productId;
    private LicenseKey licenseKey;
    //private Integer quantity;
}
