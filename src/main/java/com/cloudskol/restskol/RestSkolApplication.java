package com.cloudskol.restskol;

import com.cloudskol.restskol.async.RestSkolAsyncResource;
import com.cloudskol.restskol.filters.server.APIKeyCheckRequestFilter;
import com.cloudskol.restskol.filters.server.PreMatchingFilter;
import com.cloudskol.restskol.filters.server.RestSkolResponseFilter;
import com.cloudskol.restskol.interceptors.RestSkolReaderInterceptor;
import com.cloudskol.restskol.interceptors.RestSkolWriterInterceptor;
import com.cloudskol.restskol.monitoring.RestSkolApplicationEventListener;
import com.cloudskol.restskol.resources.BookResource;
import com.cloudskol.restskol.resources.PersonResource;
import com.cloudskol.restskol.resources.VersionedAPI;
import com.cloudskol.restskol.sse.RestSkolSSEResource;
import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.jersey2.InstrumentedResourceMethodApplicationListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.sse.SseFeature;
import org.glassfish.jersey.server.ResourceConfig;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author tham (zarub2k@gmail.com)
 *
 * Configuration file for our application
 *
 * Features, Providers, Listeners and resources is registered here
 */
public class RestSkolApplication extends ResourceConfig {
    private static final Logger logger = LogManager.getLogger(RestSkolApplication.class);

    private Set<Class<?>> classes = new HashSet<Class<?>>();

    public RestSkolApplication() {
        initializeApplication();
    }

    private void initializeApplication() {
        registerFeatures(); //Register features
        registerProviders(); // Register providers
        registerListeners(); // Register listeners
        registerResources(); // Register resources

        registerClasses(classes);
    }

    private void registerListeners() {
//        classes.add(RestSkolApplicationEventListener.class);
//        final MetricRegistry metricRegistry = new MetricRegistry();
//        register(new InstrumentedResourceMethodApplicationListener(metricRegistry));
//
//        ConsoleReporter.forRegistry(metricRegistry)
//                .convertRatesTo(TimeUnit.SECONDS)
//                .convertDurationsTo(TimeUnit.MILLISECONDS)
//                .build()
//                .start(1, TimeUnit.MINUTES);
//
//        logger.info("Console reporter is enabled successfully!");
    }

    /**
     * Method to register additional feature for our application
     */
    private void registerFeatures() {
        register(JacksonFeature.class); //Enable Jackson parsing support
        register(SseFeature.class); //Enable Server sent events
    }

    /**
     * Method to register resource implementations
     */
    private void registerResources() {
        classes.add(BookResource.class);
        classes.add(VersionedAPI.class);
        classes.add(PersonResource.class);
//        classes.add(RestSkolAsyncResource.class);
//        classes.add(RestSkolSSEResource.class);
    }

    /**
     * Method to register providers
     */
    private void registerProviders() {
        classes.add(APIKeyCheckRequestFilter.class);
        classes.add(RestSkolResponseFilter.class);
        classes.add(PreMatchingFilter.class);

//        classes.add(RestSkolWriterInterceptor.class);
//        classes.add(RestSkolReaderInterceptor.class);
    }
}
