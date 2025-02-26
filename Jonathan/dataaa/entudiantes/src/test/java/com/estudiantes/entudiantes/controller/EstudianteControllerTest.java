package com.estudiantes.entudiantes.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.estudiantes.entudiantes.dto.EstudianteDto;
import com.estudiantes.entudiantes.service.EstudianteService;
import com.estudiantes.entudiantes.utils.dto.ResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EstudianteController.class)
public class EstudianteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EstudianteService estudianteService;

    private EstudianteDto estudianteDto;
    private ResponseDto responseDto;

    @BeforeEach
    void setUp() {
        estudianteDto = new EstudianteDto();
        estudianteDto.setNombre("Juan");
        estudianteDto.setApellidoPaterno("Perez");
        estudianteDto.setApellidoMaterno("Gomez");
        estudianteDto.setEdad(20);
        responseDto = new ResponseDto();
        responseDto.setMessage("Success");
        responseDto.setCode(200);
    }

    /*
     * 
     * @Test
     * void setNombreEstudianteDto() {
     * EstudianteDto estudianteDto = new EstudianteDto();
     * estudianteDto.setNombre("Juan");
     * assertEquals("Juan", estudianteDto.getNombre());
     * }
     */
    @Test
    @DisplayName("Create student")
    void testCreateStudent() throws Exception {
        when(estudianteService.createStudent(estudianteDto)).thenReturn(ResponseEntity.ok(responseDto));
        mockMvc.perform(post("/api/estudiante/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(estudianteDto)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Get all students")
    void testGetStudents() throws Exception {
        when(estudianteService.getStudents()).thenReturn(responseDto);
        mockMvc.perform(get("/api/estudiante/get-all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Get student by id")
    void testGetStudentById() throws Exception {
        when(estudianteService.getStudentById(1L)).thenReturn(responseDto);
        mockMvc.perform(get("/api/estudiante/get-by/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Update student")
    void testUpdateStudent() throws Exception {
        when(estudianteService.updateStudent(1L, estudianteDto)).thenReturn(responseDto);
        mockMvc.perform(put("/api/estudiante/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(estudianteDto)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Delete student")
    void testDeleteStudent() throws Exception {
        when(estudianteService.deleteStudent(1L)).thenReturn(responseDto);
        mockMvc.perform(delete("/api/estudiante/delete/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
