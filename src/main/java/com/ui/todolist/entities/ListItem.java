package com.ui.todolist.entities;

import javax.persistence.*;

@Entity
@Table(name = "listitem")
public class ListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "message")
    private String message;

    public ListItem() {}

    public ListItem(String message) {
        this.message = message;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
