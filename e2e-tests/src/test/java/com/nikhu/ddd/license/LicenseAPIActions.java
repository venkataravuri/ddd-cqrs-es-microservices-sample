package com.nikhu.ddd.license;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vravuri on 12-Jul-17.
 */
public class LicenseAPIActions {
    private static final String LICENSE_API_URL = "http://localhost:8080/api/license";

    @Step
    public void saveVmwareAccountDetails(String accountId, String productId) {
        Serenity.getCurrentSession().put("accountId", accountId);
        Serenity.getCurrentSession().put("productId", productId);
    }

    @Step
    public void requestRegisterLicense(String licenseKey) {
        Map<String, String> params = new HashMap<>();
        params.put("accountId", Serenity.getCurrentSession().get("accountId").toString());
        params.put("productId", Serenity.getCurrentSession().get("productId").toString());
        params.put("licenseKey", licenseKey);
        SerenityRest.given().contentType("application/json")
                .and().body(params)
                .when().post(LICENSE_API_URL);
    }

    @Step
    public int getStatusCode(){
        return SerenityRest.then().extract().statusCode();
    }
}
