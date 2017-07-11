package com.nikhu.ddd.domain;

import com.nikhu.ddd.CreateLicenseKeyCommand;
import com.nikhu.ddd.LicenseKeyNotFoundEvent;
import com.nikhu.ddd.domain.model.LicenseAggregate;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.Aggregate;
import org.axonframework.commandhandling.model.AggregateNotFoundException;
import org.axonframework.commandhandling.model.Repository;
import org.axonframework.eventhandling.EventBus;

import static org.axonframework.eventhandling.GenericEventMessage.asEventMessage;

/**
 * Created by vravuri on 10-Jul-17.
 */
public class LicenseCommandHandler {

    private Repository<LicenseAggregate> repository;
    private EventBus eventBus;

    public LicenseCommandHandler(Repository<LicenseAggregate> repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

//    @CommandHandler
//    public void handle(CreateLicenseKeyCommand command) {
//        try {
//            Aggregate<LicenseAggregate> licenseAggregate = repository.load(command.getId());
//        } catch (AggregateNotFoundException exception) {
//            eventBus.publish(asEventMessage(new LicenseKeyNotFoundEvent(command.getId())));
//        }
//    }


}