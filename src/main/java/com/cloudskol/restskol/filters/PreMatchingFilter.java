package com.cloudskol.restskol.filters;

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
    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
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
