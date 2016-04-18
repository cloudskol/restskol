package com.cloudskol.restskol.monitoring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.server.monitoring.RequestEvent;
import org.glassfish.jersey.server.monitoring.RequestEventListener;

/**
 * @author tham
 */

public class RestSkolRequestListener implements RequestEventListener {
    private static final Logger logger = LogManager.getLogger(RestSkolRequestListener.class);
    private final long startTime;

    public RestSkolRequestListener() {
        startTime = System.currentTimeMillis();
    }

    @Override
    public void onEvent(RequestEvent requestEvent) {
        switch (requestEvent.getType()) {
            case RESOURCE_METHOD_START:
                logger.info("Resource method started");
                break;

            case FINISHED:
                logger.info("Resource method finished");
                long endTime = System.currentTimeMillis();

                logger.info("Time taken....{} ms.", endTime - startTime);

                break;
        }
    }
}
