package com.example.smartbusinessassistant.service;

import com.example.smartbusinessassistant.dto.RequestDto;
import com.example.smartbusinessassistant.model.Request;
import com.example.smartbusinessassistant.model.enums.Category;
import com.example.smartbusinessassistant.model.enums.Priority;
import com.example.smartbusinessassistant.model.enums.Status;
import com.example.smartbusinessassistant.repository.RequestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

public class RequestServiceTest {
    @Mock
    private RequestRepository requestRepository;
    @InjectMocks
    private RequestService requestService;
    private RequestDto dto;
    private Request savedRequest;

    @BeforeEach
    void setUp(){
        dto = createTestRequest();
        savedRequest = createSavedRequest();
    }

    public RequestServiceTest(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void shouldCreateRequest(){

        when(requestRepository.save(any(Request.class)))
                .thenReturn(savedRequest);

        requestService.createRequest(dto) ;

        verify(requestRepository, times(1)).save(any(Request.class));

    }
    @Test
    void shouldReturnCorrectRequest(){

        when(requestRepository.save(any(Request.class)))
                .thenReturn(savedRequest);

        RequestDto result = requestService.createRequest(dto);
        assertNotNull(result);

        assertEquals("Drucker kaputt", result.getText() );

        assertEquals("OPEN", result.getStatus());
        assertEquals("GENERAL", result.getCategory());
        assertEquals("HIGH", result.getPriority());
    }
    private RequestDto createTestRequest(){
        RequestDto dto = new RequestDto();

        dto.setText("Drucker kaputt");
        dto.setStatus("OPEN");
        dto.setCategory("GENERAL");
        dto.setPriority("HIGH");
        return dto;
    }
    private Request createSavedRequest(){
        Request request = new Request();

        request.setId(1L);
        request.setText("Drucker kaputt");
        request.setCategory(Category.GENERAL);
        request.setPriority(Priority.HIGH);
        request.setStatus(Status.OPEN);
        return request;

    }
}
