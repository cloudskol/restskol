package com.cloudskol.restskol.health;

import com.codahale.metrics.health.HealthCheckRegistry;
import com.codahale.metrics.servlets.HealthCheckServlet;

/**
 * @author tham
 */

public class RestSkolHealthCheckListener extends HealthCheckServlet.ContextListener {
    public static final HealthCheckRegistry healthCheckRegistry = new HealthCheckRegistry();

    @Override
    protected HealthCheckRegistry getHealthCheckRegistry() {
        return healthCheckRegistry;
    }
}
