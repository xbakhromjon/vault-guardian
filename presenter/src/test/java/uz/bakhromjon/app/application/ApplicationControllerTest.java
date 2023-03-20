package uz.bakhromjon.app.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import uz.bakhromjon.app.application.application.port.in.CreateApplicationUseCase;
import uz.bakhromjon.app.application.application.port.in.response.ApplicationResponse;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ApplicationController.class)
class ApplicationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CreateApplicationUseCase createApplicationUseCase;

    @Test
    void create() throws Exception {
        CreateApplicationUseCase.ApplicationCreateRequest applicationCreateRequest =
                new CreateApplicationUseCase.ApplicationCreateRequest(1L, "M");
        BDDMockito.given(createApplicationUseCase.execute(eq(applicationCreateRequest))).willReturn(
                new ApplicationResponse(1L, 1L, "M")
        );

        mockMvc.perform(post("/application")
                .content(objectMapper.writeValueAsString(applicationCreateRequest))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}


