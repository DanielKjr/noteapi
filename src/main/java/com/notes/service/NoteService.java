package com.notes.service;

import com.notes.model.Note;
import com.notes.repository.NoteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class NoteService {

    @Inject
    NoteRepository noteRepository;


    public String createNote(String message){
        noteRepository.createNote(message);
        return "note created";
    }
}
