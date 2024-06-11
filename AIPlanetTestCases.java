package com.doubtclerance.apis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class AssignmentSubjectsGradeMappingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        // Setup method to prepare any pre-requisites for the tests
    }

    @Test
    public void testAssignmentSubjectsGradeMappingSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/assignmentSubjectsGradeMapping")
                .param("gradeId", "1")
                .param("tenantId", "1")
                .param("examId", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testAssignmentSubjectsGradeMappingNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/assignmentSubjectsGradeMapping")
                .param("gradeId", "999")
                .param("tenantId", "999")
                .param("examId", "999"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void testAssignmentSubjectsGradeMappingMissingParams() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/assignmentSubjectsGradeMapping")
                .param("gradeId", "1")
                .param("tenantId", "1"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
