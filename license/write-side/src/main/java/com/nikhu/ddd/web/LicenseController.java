package com.nikhu.ddd.web;

import com.nikhu.ddd.RegisterLicenseKeyCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    // TODO: Is using VO pattern in DDD right?
    public void registerLicense(@RequestBody LicenseVO input) {
        String id = UUID.randomUUID().toString();
        RegisterLicenseKeyCommand command = new RegisterLicenseKeyCommand(id, input.getAccountId(), input.getProductId(), input.getLicenseKey(), "/home");
        commandGateway.send(command);
    }
}
