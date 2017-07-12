package com.nikhu.ddd.license.stepdefinitions;

import com.nikhu.ddd.license.LicenseAPIActions;
import net.thucydides.core.annotations.Steps;
import org.apache.http.HttpStatus;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by vravuri on 11-Jul-17.
 */
public class LicenseStepDefinitions {
    @Steps
    LicenseAPIActions licenseAPIActions;

    @Given("I have a active MyVMware <account> with a registered VMware Fusion/Workstation <product>")
    public void precondition(@Named("account") String accountId, @Named("product") String productId) {
        licenseAPIActions.saveVmwareAccountDetails(accountId, productId);
    }

    @When("I request to register a <licenseKey>")
    public void perform(@Named("licenseKey") String licenseKey) {
        licenseAPIActions.requestRegisterLicense(licenseKey);
    }

    @Then("I expect license key should be registered")
    public void checkResultFor() {
        assertThat("Wrong response status code", licenseAPIActions.getStatusCode(), equalTo(HttpStatus.SC_CREATED));
    }
}