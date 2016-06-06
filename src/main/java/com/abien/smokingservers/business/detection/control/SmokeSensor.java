package com.abien.smokingservers.business.detection.control;

import javax.enterprise.event.Observes;

/**
 *
 * @author airhacks.com
 */
public class SmokeSensor {

    public void reportCall(String call) {
        System.out.println("-->#" + call);
    }

    public void onException(@Observes Exception exception) {
        System.out.println("exception = " + exception);
    }

}
