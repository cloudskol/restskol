package com.cloudskol.restskol.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import java.io.IOException;

/**
 * @author tham
 */

public class RestSkolResponseFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext,
                       ContainerResponseContext containerResponseContext) throws IOException {

    }
}
