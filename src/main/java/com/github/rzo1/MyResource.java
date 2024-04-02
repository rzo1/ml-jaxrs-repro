package com.github.rzo1;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("myresource")
public class MyResource {

    @GET
    public Response test() {
        return Response.ok("yolo").build();
    }
}
