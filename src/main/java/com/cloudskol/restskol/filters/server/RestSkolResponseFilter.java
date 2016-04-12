package com.cloudskol.restskol.filters.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import java.io.IOException;

/**
 * @author tham
 */

public class RestSkolResponseFilter implements ContainerResponseFilter {
    private static final Logger logger = LogManager.getLogger(RestSkolResponseFilter.class);

    @Override
    public void filter(ContainerRequestContext containerRequestContext,
                       ContainerResponseContext containerResponseContext) throws IOException {
        logger.info("Container response filter");
        containerResponseContext.getHeaders().add("X-Powered-By", "RESTSkol");
    }
}
