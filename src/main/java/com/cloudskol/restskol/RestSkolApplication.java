package com.cloudskol.restskol;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author tham (zarub2k@gmail.com)
 */
public class RestSkolApplication extends ResourceConfig {
    public RestSkolApplication() {
        register(JacksonFeature.class); //Enable JSON media type support
    }
}
