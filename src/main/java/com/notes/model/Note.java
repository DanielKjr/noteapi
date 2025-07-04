package com.notes.model;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;


@Entity
@Table(name= "Notes")
public class Note {
    @Id
    @Column(columnDefinition = "uuid")
    public UUID id;

    @PrePersist
    public void assignId() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "logId", referencedColumnName = "logId")
    public Log log;

    public String message;

    public Instant created = Instant.now();

    public Instant updated;

    public Note(){}

    public Note(String message){
        this.message = message;
    }

}
