package com.example.smartbusinessassistant.service;

import com.example.smartbusinessassistant.dto.RequestDto;
import com.example.smartbusinessassistant.exception.ResourceNotFoundException;
import com.example.smartbusinessassistant.mapper.RequestMapper;
import com.example.smartbusinessassistant.model.Request;
import com.example.smartbusinessassistant.model.enums.Category;
import com.example.smartbusinessassistant.model.enums.Priority;
import com.example.smartbusinessassistant.model.enums.Status;
import com.example.smartbusinessassistant.repository.RequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    private final RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository){
        this.requestRepository = requestRepository;
    }

    public RequestDto CreatRequest(RequestDto requestDto){
        Request request = RequestMapper.toEntity(requestDto);
        Request saved = requestRepository.save(request);
        return RequestMapper.toDTO(saved);
    }

    public void deleteRequest(Long requestId){

        Request existRequest =  requestRepository.findById(requestId)
                .orElseThrow(()-> new RuntimeException("request not found"));
        requestRepository.deleteById(requestId);

    }
    public List<RequestDto> GettAllRequest(){

        return requestRepository.findAll()
                .stream()
                .map(RequestMapper::toDTO)
                .toList();
    }

    public RequestDto FindRequestById(Long id){
        Request request = requestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Request with ID " + id+ " not found"));
        return RequestMapper.toDTO(request);

    }

    public RequestDto updateRequest(long id, RequestDto dto){
        Request existingRequest = requestRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Request not found"));

        existingRequest.setText(dto.getText());
        if(dto.getCategory()!= null){
            existingRequest.setCategory(Category.valueOf(dto.getCategory().toUpperCase()));
        }


        if (dto.getPriority() != null){
            existingRequest.setPriority(Priority.valueOf(dto.getPriority().toUpperCase()));
        }
        if (dto.getStatus() != null){
            existingRequest.setStatus(Status.valueOf(dto.getStatus().toUpperCase()));
        }
        Request updated = requestRepository.save(existingRequest);
        return RequestMapper.toDTO(updated) ;

    }

}
