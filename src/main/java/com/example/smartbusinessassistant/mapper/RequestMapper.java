package com.example.smartbusinessassistant.mapper;

import com.example.smartbusinessassistant.dto.RequestDto;
import com.example.smartbusinessassistant.model.Request;
import com.example.smartbusinessassistant.model.enums.Category;
import com.example.smartbusinessassistant.model.enums.Priority;
import com.example.smartbusinessassistant.model.enums.Status;


public class RequestMapper {

    public static RequestDto toDTO(Request request) {
        return new RequestDto(
                request.getId(),
                request.getText(),
                request.getCategory().name(),
                request.getPriority().name(),
                request.getStatus().name()
        );
    }
    public static Request toEntity(RequestDto dto) {
        Request request = new Request();

        request.setText(dto.getText());
        try {
            if (dto.getCategory() != null) {
                request.setCategory(Category.valueOf(dto.getCategory()));
            }
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Erlaubte Werte für category: GENERAL, HARDWARE, SOFTWARE");
        }
        try {
            if (dto.getPriority() != null) {
                request.setPriority(Priority.valueOf(dto.getPriority()));
            }
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Erlaubte Werte für priority: LOW, MEDIUM, HIGH");
        }

        try {
            if (dto.getStatus() != null) {
                request.setStatus(Status.valueOf(dto.getStatus()));
            }
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Erlaubte Werte für status: OPEN, IN_PROGRESS, CLOSED");
        }


        return request;
    }
}


