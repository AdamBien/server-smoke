package com.abien.smokingservers.business.smoke.boundary;

import com.abien.smokingservers.business.smoke.control.FireState;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@Stateless
@Path("alert")
public class AlertResource {

    @Inject
    FireState fireState;

    @GET
    public JsonObject get() {
        return Json.createObjectBuilder().add("Smoke?:", fireState.isSmoke()).build();
    }
}
