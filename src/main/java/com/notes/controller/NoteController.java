package com.notes.controller;

import com.notes.service.NoteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/notes")
public class NoteController {

    @Inject
    NoteService noteservice;


    @GET
    @Path("/create/{message}")
    public String createNote(String message){
        return noteservice.createNote(message);
    }
}
