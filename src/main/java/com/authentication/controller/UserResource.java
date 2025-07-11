package com.authentication.controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.SecurityContext;

@Path("/api/users")
public class UserResource {


    @GET
    @RolesAllowed("user")
    @Path("/me")
    public String me(@Context SecurityContext sc){
        return sc.getUserPrincipal().getName();
    }
}
