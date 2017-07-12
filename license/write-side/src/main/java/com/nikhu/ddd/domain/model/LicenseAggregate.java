package com.nikhu.ddd.domain.model;

import com.nikhu.ddd.*;
import org.apache.log4j.Logger;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.HashMap;
import java.util.UUID;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

/**
 * Created by vravuri on 10-Jul-17.
 */
@Aggregate
public class LicenseAggregate {
    private static final Logger LOG = Logger.getLogger(LicenseAggregate.class);

    @AggregateIdentifier
    private String id;
    private LicenseKey licenseKey;
    private Product product;
    //private Integer quantity;
    // TODO: Refactor to Label entity.
    // Some sample labels PO Number, Server Name, Data Center
    private HashMap<String, String> standardLabels;
    private HashMap<String, String> customLabels;
    private LicenseManagementModel licenseManagementModel;

    @SuppressWarnings("unused")
    private LicenseAggregate() {
    }

    @CommandHandler
    public LicenseAggregate(RegisterLicenseKeyCommand command) {
        LicenseKey licenseKey = new LicenseKey(command.getLicenseKey(), LicenseStatus.INACTIVE);
        LOG.debug("License key:" + licenseKey);
        String id = UUID.randomUUID().toString();
        apply(new LicenseKeyRegisteredEvent(id, command.getAccountId(), command.getProductId(), licenseKey));
    }

    @EventSourcingHandler
    public void on(LicenseKeyRegisteredEvent event) {
        this.id = event.getId();
        this.licenseKey = event.getLicenseKey();
    }
}
