package com.cloudskol.restskol.filters.server;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

/**
 * @author tham
 */

public class APIKeyCheckRequestFilter implements ContainerRequestFilter {
    private static final String API_KEY = "X-API-KEY";

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        final String apiKey = containerRequestContext.getHeaders().getFirst(API_KEY);
        System.out.println("API KEY: " + apiKey);

        if (apiKey == null || apiKey.isEmpty()) {
            containerRequestContext
                    .abortWith(
                            Response
                                    .status(Response.Status.UNAUTHORIZED)
                    .entity("Please provide a valid API Key")
                    .build());
        }
    }
}
