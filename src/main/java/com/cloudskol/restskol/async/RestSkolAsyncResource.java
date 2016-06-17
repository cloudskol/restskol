package com.cloudskol.restskol.async;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

/**
 * @author tham
 *
 * Async resource for producing response without blocking the request
 */

@Path("async")
public class RestSkolAsyncResource {
    private static final Logger logger = LogManager.getLogger(RestSkolAsyncResource.class);

    @GET
    public void getAsync(@Suspended final AsyncResponse asyncResponse) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                final String result = longPendingTask();
                asyncResponse.resume(result);
            }

        }).start();
    }

    private String longPendingTask() {
        logger.info("Long pending tasks started");
        try {
            Thread.sleep(200000);
        } catch (InterruptedException e) {
            logger.error("Error while thread sleep");
        }

        logger.info("Long pending tasks completed");

        return "Execution is completed";
    }
}
