package com.nikhu.ddd.domain.model;

import com.nikhu.ddd.CreateLicenseKeyCommand;
import com.nikhu.ddd.LicenseKey;
import com.nikhu.ddd.LicenseKeyCreatedEvent;
import com.nikhu.ddd.LicenseStatus;
import com.nikhu.ddd.domain.LicenseCommandHandler;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by vravuri on 10-Jul-17.
 */
public class LicenseAggregateTest {

    private FixtureConfiguration<LicenseAggregate> testFixture;

    @Before
    public void setUp() throws Exception {
        testFixture = new AggregateTestFixture<>(LicenseAggregate.class);

        testFixture.registerAnnotatedCommandHandler(new LicenseCommandHandler(testFixture.getRepository(),
                testFixture.getEventBus()));
    }

    @Test
    public void testCreateLicense() throws Exception {
        String id = "bankAccountId";

        testFixture.givenNoPriorActivity()
                .when(new CreateLicenseKeyCommand(id, "acc-1", "prod-1", 10, "/home"))
                .expectEvents(new LicenseKeyCreatedEvent("acc-1", "prod-1", new LicenseKey("3b6b1416-ea55-4bb6-85b0-f7a8b38e3860", LicenseStatus.INACTIVE), 10));
    }
}
