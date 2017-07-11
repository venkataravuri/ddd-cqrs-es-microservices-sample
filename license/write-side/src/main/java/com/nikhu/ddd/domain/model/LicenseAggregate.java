package com.nikhu.ddd.domain.model;

import com.nikhu.ddd.CreateLicenseKeyCommand;
import com.nikhu.ddd.LicenseKey;
import com.nikhu.ddd.LicenseKeyCreatedEvent;
import com.nikhu.ddd.LicenseStatus;
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
    @AggregateIdentifier
    private String id;
    private LicenseKey licenseKey;
    private Product product;
    private Integer quantity;
    // TODO: Refactor to Label entity.
    // Some sample labels PO Number, Server Name, Data Center
    private HashMap<String, String> standardLabels;
    private HashMap<String, String> customLabels;
    private LicenseManagementModel licenseManagementModel;

    @SuppressWarnings("unused")
    private LicenseAggregate() {
    }

    @CommandHandler
    public LicenseAggregate(CreateLicenseKeyCommand command) {
        // TODO: Generate license key, for now mocking
        LicenseKey licenseKey = new LicenseKey("3b6b1416-ea55-4bb6-85b0-f7a8b38e3860", LicenseStatus.INACTIVE);
        apply(new LicenseKeyCreatedEvent(command.getAccountId(), command.getProductId(), licenseKey, command.getQuantity()));
    }

    @EventSourcingHandler
    public void on(LicenseKeyCreatedEvent event) {
        this.id = event.getId();
        this.licenseKey = event.getLicenseKey();
        this.quantity = event.getQuantity();
    }
}
