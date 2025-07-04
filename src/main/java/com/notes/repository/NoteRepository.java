package com.notes.repository;

import com.notes.model.Note;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class NoteRepository {
    @Inject
    EntityManager em;


    @Transactional
    public void createNote(String message){
        Note note = new Note(message);
        em.persist(note);
    }
}
