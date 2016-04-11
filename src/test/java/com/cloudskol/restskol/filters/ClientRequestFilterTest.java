package com.cloudskol.restskol.filters;

import com.cloudskol.restskol.filters.client.RestSkolClientRequestFilter;
import org.junit.Ignore;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * @author tham
 */

public class ClientRequestFilterTest {

    @Ignore
    @Test
    public void testClientRequestFilter() {
        final Client client = ClientBuilder.newBuilder()
                .register(RestSkolClientRequestFilter.class)
                .build();

        final WebTarget webTarget = client.target("http://localhost:8080/restskol/api")
                .path("books");

        final Invocation.Builder request = webTarget
                .request(MediaType.APPLICATION_JSON)
                .header("X-API-KEY", "RESTSkol");
        final String response = request.build("PATCH").invoke().readEntity(String.class);
        System.out.println(response);
    }
}
