package com.cloudskol.restskol.interceptors;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;
import java.io.IOException;

/**
 * @author tham
 */

public class RestSkolWriterInterceptor implements WriterInterceptor {
    @Override
    public void aroundWriteTo(WriterInterceptorContext writerInterceptorContext)
            throws IOException, WebApplicationException {

    }
}
