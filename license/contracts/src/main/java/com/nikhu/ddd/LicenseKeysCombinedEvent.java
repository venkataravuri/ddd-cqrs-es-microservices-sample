package com.nikhu.ddd;

import com.niku.ddd.Event;

import java.util.List;

/**
 * Created by vravuri on 07-Jul-17.
 */
public class LicenseKeysCombinedEvent implements Event {

    private List<String> licenseIds;

    public LicenseKeysCombinedEvent(List<String> licenseIds) {
        this.licenseIds = licenseIds;
    }

    @Override
    public String toString() {
        return "LicenseKeysCombinedEvent{" +
                "licenseIds=" + licenseIds +
                '}';
    }
}
