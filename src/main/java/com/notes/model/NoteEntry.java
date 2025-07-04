package com.notes.model;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name="NoteEntries")
public class NoteEntry {

    @Id
    @GeneratedValue
    public Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Note> notes;


    public Instant created = Instant.now();

    public Instant updated;

}
