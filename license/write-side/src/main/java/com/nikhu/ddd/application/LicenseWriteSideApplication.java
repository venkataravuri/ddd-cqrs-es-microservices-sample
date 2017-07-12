package com.nikhu.ddd.application;

import com.nikhu.ddd.web.LicenseController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by vravuri on 10-Jul-17.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.nikhu.ddd.web", "com.nikhu.ddd.domain.model"})
public class LicenseWriteSideApplication {
    public static void main(String[] args) {
        SpringApplication.run(LicenseWriteSideApplication.class);
    }
}
