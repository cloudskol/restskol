package com.cloudskol.restskol.filters.client;

import com.sun.corba.se.pept.transport.ResponseWaitingRoom;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * @author tham
 */

public class RestSkolClientRequestFilter implements ClientRequestFilter {
    @Override
    public void filter(ClientRequestContext clientRequestContext) throws IOException {
        final String methodName = clientRequestContext.getMethod();
        if (methodName.equals("PATCH")) {
            clientRequestContext.abortWith(
                    Response.status(Response.Status.METHOD_NOT_ALLOWED)
                            .entity("HTTP Patch is NOT supported")
                            .build());
        }
    }
}