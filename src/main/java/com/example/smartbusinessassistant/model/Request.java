package com.example.smartbusinessassistant.model;

import com.example.smartbusinessassistant.model.enums.Category;
import com.example.smartbusinessassistant.model.enums.Priority;
import com.example.smartbusinessassistant.model.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 1000)
    private String text;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime createdAt;

    // Default values setzen
    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();

        if(this.status == null){
            this.status= Status.OPEN;
        }
        if(this.category==null){
            this.category = Category.GENERAL;
        }
        if(this.priority == null){
            this.priority= Priority.MEDIUM;
        }
    }
//Getters und Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
