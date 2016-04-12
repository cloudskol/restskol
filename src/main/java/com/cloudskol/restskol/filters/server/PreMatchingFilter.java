package com.cloudskol.restskol.filters.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author tham
 */

@PreMatching
public class PreMatchingFilter implements ContainerRequestFilter {
    private static final Logger logger = LogManager.getLogger(PreMatchingFilter.class);

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        logger.info("Pre matching container request filter");

        final URI absolutePath = containerRequestContext.getUriInfo().getAbsolutePath();
        String path = absolutePath.getPath();
        System.out.println("Path: " + path);

        if (path.contains("/books/v1")) {
            path = path.replace("/books/v1", "/books/v2");
        }

        System.out.println("After replaced Path: " + path);

        try {
            containerRequestContext.setRequestUri(new URI(path));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
