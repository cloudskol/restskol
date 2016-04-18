package com.cloudskol.restskol.monitoring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.server.monitoring.ApplicationEvent;
import org.glassfish.jersey.server.monitoring.ApplicationEventListener;
import org.glassfish.jersey.server.monitoring.RequestEvent;
import org.glassfish.jersey.server.monitoring.RequestEventListener;

/**
 * @author tham
 */

public class RestSkolApplicationEventListener implements ApplicationEventListener {
    private static final Logger logger = LogManager.getLogger(RestSkolApplicationEventListener.class);

    @Override
    public void onEvent(ApplicationEvent applicationEvent) {
        switch (applicationEvent.getType()) {
            case INITIALIZATION_START:
                logger.info("Initialization started");
                break;
            case INITIALIZATION_FINISHED:
                logger.info("Initialization finished");
                break;
            case INITIALIZATION_APP_FINISHED:
                logger.info("Initialization of APP finished");
                break;
            case RELOAD_FINISHED:
                logger.info("Reload completed");
                break;
            case DESTROY_FINISHED:
                logger.info("Destroy completed");
                break;
        }
    }

    @Override
    public RequestEventListener onRequest(RequestEvent requestEvent) {
        return new RestSkolRequestListener();
    }
}
