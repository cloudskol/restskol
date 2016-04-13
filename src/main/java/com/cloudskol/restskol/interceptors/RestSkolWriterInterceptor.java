package com.cloudskol.restskol.interceptors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author tham
 */

public class RestSkolWriterInterceptor implements WriterInterceptor {
    private static final Logger logger = LogManager.getLogger(RestSkolWriterInterceptor.class);

    @Override
    public void aroundWriteTo(WriterInterceptorContext writerInterceptorContext)
            throws IOException, WebApplicationException {
        logger.info("Enters RestSkolWriterInterceptor.aroundWriterTo()");

        final OutputStream outputStream = writerInterceptorContext.getOutputStream();
        writerInterceptorContext.setOutputStream(new GZIPOutputStream(outputStream));
        writerInterceptorContext.proceed();
    }
}
