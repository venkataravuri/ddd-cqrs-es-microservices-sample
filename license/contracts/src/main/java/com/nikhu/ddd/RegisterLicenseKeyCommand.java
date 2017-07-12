package com.nikhu.ddd;

import com.niku.ddd.Command;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

/**
 * Created by vravuri on 10-Jul-17.
 */

@Value
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class RegisterLicenseKeyCommand implements Command {
    private String id;
    private String accountId;
    private String productId;
    private String licenseKey;
    private String placeInFolder;
}
