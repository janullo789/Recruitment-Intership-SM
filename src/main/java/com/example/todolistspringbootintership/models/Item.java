package com.example.todolistspringbootintership.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "items")
public class Item implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_sequence")
    @SequenceGenerator(name = "item_sequence", sequenceName = "ITEM_SEQUENCE")
    private Long id;

    private String description;
    private Boolean isReady;
    private LocalDateTime timeOfCreated;
    private LocalDateTime timeOfUpdated;

    @Override
    public String toString() {
        return String.format("Item{id=%d, description='%s', isReady='%s', timeOfCreated='%s', timeOfUpdated='%s'",
                id, description, isReady, timeOfCreated, timeOfUpdated);
    }

}
