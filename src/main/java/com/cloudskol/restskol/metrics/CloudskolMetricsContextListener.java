package com.cloudskol.restskol.metrics;

import com.codahale.metrics.health.HealthCheckRegistry;
import com.codahale.metrics.servlets.HealthCheckServlet;

/**
 * @author tham
 */

public class CloudskolMetricsContextListener extends HealthCheckServlet.ContextListener {
    public static final HealthCheckRegistry healthCheckRegistry = new HealthCheckRegistry();

    @Override
    protected HealthCheckRegistry getHealthCheckRegistry() {
        return healthCheckRegistry;
    }
}
