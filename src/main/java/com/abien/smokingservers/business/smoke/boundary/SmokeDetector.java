package com.abien.smokingservers.business.smoke.boundary;

import com.abien.smokingservers.business.detection.control.SmokeSensor;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class SmokeDetector {

    @Inject
    SmokeSensor sensor;

    @Inject
    Event<Exception> events;

    @AroundInvoke
    public Object detectSmoke(InvocationContext ic) throws Exception {
        long start = System.currentTimeMillis();
        try {
            return ic.proceed();
        } catch (Exception e) {
            events.fire(e);
            throw e;
        } finally {
            long duration = System.currentTimeMillis() - start;
            sensor.reportCall("Method: " + ic.getMethod() + " took: " + duration + " ms");
        }
    }
}
