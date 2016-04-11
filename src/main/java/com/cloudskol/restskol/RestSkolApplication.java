package com.cloudskol.restskol;

import com.cloudskol.restskol.filters.server.APIKeyCheckRequestFilter;
import com.cloudskol.restskol.filters.server.PreMatchingFilter;
import com.cloudskol.restskol.filters.server.RestSkolResponseFilter;
import com.cloudskol.restskol.resources.BookResource;
import com.cloudskol.restskol.resources.VersionedAPI;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tham (zarub2k@gmail.com)
 */
public class RestSkolApplication extends ResourceConfig {
    private Set<Class<?>> classes = new HashSet<Class<?>>();

    public RestSkolApplication() {
        register(JacksonFeature.class); //Enable JSON media type support

        addProviders();
        addResources();

        registerClasses(classes);
    }

    private void addResources() {
        classes.add(BookResource.class);
        classes.add(VersionedAPI.class);
    }

    private void addProviders() {
        classes.add(APIKeyCheckRequestFilter.class);
        classes.add(RestSkolResponseFilter.class);
        classes.add(PreMatchingFilter.class);
    }
}
