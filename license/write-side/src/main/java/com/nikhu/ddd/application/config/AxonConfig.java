package com.nikhu.ddd.application.config;

import com.nikhu.ddd.domain.LicenseCommandHandler;
import com.nikhu.ddd.domain.model.LicenseAggregate;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.messaging.interceptors.BeanValidationInterceptor;
import org.axonframework.spring.config.AxonConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by vravuri on 10-Jul-17.
 */
@Configuration
class AxonConfig {

    @Autowired
    private AxonConfiguration axonConfiguration;
    @Autowired
    private EventBus eventBus;

    @Bean
    public LicenseCommandHandler licenseCommandHandler() {
        return new LicenseCommandHandler(axonConfiguration.repository(LicenseAggregate.class), eventBus);
    }

    @Autowired
    public void configure(@Qualifier("localSegment") SimpleCommandBus simpleCommandBus) {
        simpleCommandBus.registerDispatchInterceptor(new BeanValidationInterceptor<>());
    }
}
