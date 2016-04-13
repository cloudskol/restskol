package com.cloudskol.restskol.interceptors;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import java.io.IOException;

/**
 * @author tham
 */

public class RestSkolReaderInterceptor implements ReaderInterceptor {
    @Override
    public Object aroundReadFrom(ReaderInterceptorContext readerInterceptorContext)
            throws IOException, WebApplicationException {
        return null;
    }
}
