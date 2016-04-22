package com.cloudskol.restskol.filters.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * @author tham
 */

public class RestSkolClientRequestFilter implements ClientRequestFilter {
    private static final Logger logger = LogManager.getLogger(RestSkolClientRequestFilter.class);

    @Override
    public void filter(ClientRequestContext clientRequestContext) throws IOException {
        logger.info("Client request called");
        final String methodName = clientRequestContext.getMethod();
        if (methodName.equals("PATCH")) {
            clientRequestContext.abortWith(
                    Response.status(Response.Status.METHOD_NOT_ALLOWED)
                            .entity("HTTP Patch is NOT supported")
                            .build());
        }
    }
}
