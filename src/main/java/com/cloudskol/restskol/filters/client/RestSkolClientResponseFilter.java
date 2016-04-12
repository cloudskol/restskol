package com.cloudskol.restskol.filters.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import java.io.IOException;

/**
 * @author tham
 */

public class RestSkolClientResponseFilter implements ClientResponseFilter {
    private static final Logger logger = LogManager.getLogger(RestSkolClientResponseFilter.class);

    @Override
    public void filter(ClientRequestContext clientRequestContext, ClientResponseContext clientResponseContext) throws IOException {
        logger.info("Client response filter");
    }
}
