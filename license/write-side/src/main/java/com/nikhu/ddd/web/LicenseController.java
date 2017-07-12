package com.nikhu.ddd.web;

import com.nikhu.ddd.CreateLicenseKeyCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by vravuri on 11-Jul-17.
 */
@RestController
@RequestMapping(value = "/api/license")
public class LicenseController {

    private final CommandGateway commandGateway;

    public LicenseController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createLicense() {
        String id = UUID.randomUUID().toString();
        CreateLicenseKeyCommand command = new CreateLicenseKeyCommand(id, "acc-1", "prod-1", 10, "/home");
        commandGateway.send(command);
    }
}
