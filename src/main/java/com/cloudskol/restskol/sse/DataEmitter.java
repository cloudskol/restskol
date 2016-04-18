package com.cloudskol.restskol.sse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;

import java.io.IOException;

/**
 * @author tham on 15-04-2016.
 */
public class DataEmitter implements Runnable {
    private static final Logger logger = LogManager.getLogger(DataEmitter.class);

    private EventOutput eventOutput;

    public DataEmitter(EventOutput eventOutput) {
        this.eventOutput = eventOutput;
    }

    @Override
    public void run() {
        logger.info("Enters DataEmitter run()");

        for (int i = 0; i < 10; i++) {
            final OutboundEvent outboundEvent = new OutboundEvent.Builder()
                    .name("sse-data")
                    .data(String.class, "Data emitted from server for > " + i)
                    .build();

            try {
                eventOutput.write(outboundEvent);
            } catch (IOException e) {
                logger.error("Error while write content into Event output", e);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.error("Error while thread sleep", e);
            }
        }
    }
}
