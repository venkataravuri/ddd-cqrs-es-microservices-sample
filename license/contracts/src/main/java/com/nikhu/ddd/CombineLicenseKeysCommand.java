package com.nikhu.ddd;

import com.niku.ddd.Command;

import java.util.List;

/**
 * Created by vravuri on 07-Jul-17.
 */
public class CombineLicenseKeysCommand implements Command {

    private List<String> licenseIds;

    public CombineLicenseKeysCommand(List<String> licenseIds) {
        this.licenseIds = licenseIds;
    }

    @Override
    public String toString() {
        return "CombineLicenseKeysCommand{" +
                "licenseIds=" + licenseIds +
                '}';
    }
}
