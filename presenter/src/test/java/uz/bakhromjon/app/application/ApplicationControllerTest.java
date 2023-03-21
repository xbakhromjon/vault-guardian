package uz.bakhromjon.app.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import uz.bakhromjon.app.application.application.port.in.CreateApplicationUseCase;
import uz.bakhromjon.app.application.application.port.in.DeleteApplicationUseCase;
import uz.bakhromjon.app.application.application.port.in.GetApplicationQuery;
import uz.bakhromjon.app.application.application.port.in.UpdateApplicationUseCase;
import uz.bakhromjon.app.application.application.port.in.response.ApplicationResponse;

import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ApplicationController.class)
class ApplicationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CreateApplicationUseCase createApplicationUseCase;

    @MockBean
    private GetApplicationQuery getApplicationQuery;

    @MockBean
    private UpdateApplicationUseCase updateApplicationUseCase;

    @MockBean
    private DeleteApplicationUseCase deleteApplicationUseCase;

    @Test
    void create() throws Exception {
        CreateApplicationUseCase.ApplicationCreateRequest applicationCreateRequest =
                new CreateApplicationUseCase.ApplicationCreateRequest(1L, "M");
        givenCreateRequestWillSuccess(applicationCreateRequest);
        mockMvc.perform(post("/application")
                        .content(objectMapper.writeValueAsString(applicationCreateRequest))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    void get() throws Exception {
        Long applicationId = 1L;
        BDDMockito.given(getApplicationQuery.execute(eq(applicationId))).willReturn(
                new ApplicationResponse(1L, 1L, "M")
        );

        mockMvc.perform(MockMvcRequestBuilders.get("/application/1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }


    @Test
    void update() throws Exception {
        UpdateApplicationUseCase.ApplicationUpdateRequest applicationUpdateRequest =
                new UpdateApplicationUseCase.ApplicationUpdateRequest(1L, "M");

        givenUpdateRequestWillSuccess(applicationUpdateRequest);
        mockMvc.perform(post("/application")
                        .content(objectMapper.writeValueAsString(applicationUpdateRequest))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void delete() throws Exception {
        Long applicationId = 1L;
        BDDMockito.given(deleteApplicationUseCase.execute(eq(applicationId))).willReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.delete("/application")
                        .param("applicationId", String.valueOf(applicationId)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    void givenCreateRequestWillSuccess(CreateApplicationUseCase.ApplicationCreateRequest applicationCreateRequest) {
        BDDMockito.given(createApplicationUseCase.execute(eq(applicationCreateRequest))).willReturn(
                new ApplicationResponse(1L, 1L, "M")
        );
    }

    void givenUpdateRequestWillSuccess(UpdateApplicationUseCase.ApplicationUpdateRequest updateRequest) {
        BDDMockito.given(updateApplicationUseCase.execute(eq(updateRequest))).willReturn(
                new ApplicationResponse(1L, 1L, "M")
        );
    }

}


