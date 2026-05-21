package com.example.smartbusinessassistant.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RequestDto {

    private Long id;
    @NotBlank(message = "Text muss nicht leer sein")
    @Size(max = 1000, message = "Text darf maximal 1000 Zeichen haben")
    private String text;
    private String category;
    private String priority;
    private String status;

    public RequestDto() {}

    public RequestDto(Long id, String text, String category, String priority, String status) {
        this.id = id;
        this.text = text;
        this.category = category;
        this.priority = priority;
        this.status = status;
    }

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
