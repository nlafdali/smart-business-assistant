package com.example.smartbusinessassistant.controller;

import com.example.smartbusinessassistant.dto.RequestDto;
import com.example.smartbusinessassistant.service.RequestService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class RequestController {


    private final RequestService requestService;

    public RequestController(RequestService requestService){
        this.requestService = requestService;
    }
    @PostMapping
    public RequestDto CreatRequest(@Valid @RequestBody RequestDto dto){
        return requestService.createRequest(dto);
    }
    @GetMapping
    public List<RequestDto> GetAllRequest(){
        return requestService.GettAllRequest();
    }
    @GetMapping("/{id}")
    public RequestDto FindRequestById(@PathVariable Long id){
        return requestService.FindRequestById(id);
    }

    @PutMapping("/{id}")
    public RequestDto updateRequest(@PathVariable Long id, @Valid @RequestBody RequestDto dto){
        return requestService.updateRequest(id, dto);
    }
    @DeleteMapping("/{id}")
    public void deleteRequest(@PathVariable Long id){
        requestService.deleteRequest(id);
    }

}
