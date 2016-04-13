package com.cloudskol.restskol.interceptors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/**
 * @author tham
 */

public class RestSkolReaderInterceptor implements ReaderInterceptor {
    private static final Logger logger = LogManager.getLogger(RestSkolReaderInterceptor.class);

    @Override
    public Object aroundReadFrom(ReaderInterceptorContext readerInterceptorContext)
            throws IOException, WebApplicationException {
        logger.info("Enters RestSkolReaderInterceptor.aroundReadFrom()");

        final InputStream inputStream = readerInterceptorContext.getInputStream();
        readerInterceptorContext.setInputStream(new GZIPInputStream(inputStream));

        return readerInterceptorContext.proceed();
    }
}
