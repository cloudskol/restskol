package com.cloudskol.restskol.health;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.servlets.MetricsServlet;

/**
 * @author tham
 */

public class RestskolMetricsListener extends MetricsServlet.ContextListener {
    public static final MetricRegistry metricRegistry = new MetricRegistry();

    @Override
    protected MetricRegistry getMetricRegistry() {
        return metricRegistry;
    }
}
