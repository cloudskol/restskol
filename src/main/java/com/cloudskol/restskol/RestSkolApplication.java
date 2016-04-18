package com.cloudskol.restskol;

import com.cloudskol.restskol.async.RestSkolAsyncResource;
import com.cloudskol.restskol.filters.server.APIKeyCheckRequestFilter;
import com.cloudskol.restskol.filters.server.PreMatchingFilter;
import com.cloudskol.restskol.filters.server.RestSkolResponseFilter;
import com.cloudskol.restskol.interceptors.RestSkolReaderInterceptor;
import com.cloudskol.restskol.interceptors.RestSkolWriterInterceptor;
import com.cloudskol.restskol.resources.BookResource;
import com.cloudskol.restskol.resources.VersionedAPI;
import com.cloudskol.restskol.sse.RestSkolSSEResource;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.sse.SseFeature;
import org.glassfish.jersey.server.ResourceConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tham (zarub2k@gmail.com)
 */
public class RestSkolApplication extends ResourceConfig {
    private Set<Class<?>> classes = new HashSet<Class<?>>();

    public RestSkolApplication() {
        initializeApplication();
    }

    private void initializeApplication() {
        registerFeatures(); //Register features
        registerProviders(); // Register providers
        registerResources(); // Register resources

        registerClasses(classes);
    }

    private void registerFeatures() {
        register(JacksonFeature.class); //Enable Jackson parsing support
        register(SseFeature.class); //Enable Server sent events
    }

    private void registerResources() {
        classes.add(BookResource.class);
        classes.add(VersionedAPI.class);
        classes.add(RestSkolAsyncResource.class);
        classes.add(RestSkolSSEResource.class);
    }

    private void registerProviders() {
//        classes.add(APIKeyCheckRequestFilter.class);
        classes.add(RestSkolResponseFilter.class);
        classes.add(PreMatchingFilter.class);

//        classes.add(RestSkolWriterInterceptor.class);
//        classes.add(RestSkolReaderInterceptor.class);
    }
}
