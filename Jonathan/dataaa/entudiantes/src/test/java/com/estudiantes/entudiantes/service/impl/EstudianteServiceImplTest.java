package com.estudiantes.entudiantes.service.impl;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.estudiantes.entudiantes.dto.EstudianteDto;
import com.estudiantes.entudiantes.entity.EstudianteEntity;
import com.estudiantes.entudiantes.handlerException.CustomException;
import com.estudiantes.entudiantes.repository.EstudianteRepository;
import com.estudiantes.entudiantes.utils.dto.ResponseDto;

@ExtendWith(MockitoExtension.class)
public class EstudianteServiceImplTest {

    @Mock
    private EstudianteRepository estudianteRepository;

    @InjectMocks
    private EstudianteServiceImpl estudianteService;

    private EstudianteDto estudianteDto;

    private EstudianteEntity estudianteEntity;

    @BeforeEach
    void setUp() {
        estudianteDto = new EstudianteDto();
        estudianteDto.setNombre("Juan");
        estudianteDto.setApellidoPaterno("Perez");
        estudianteDto.setApellidoMaterno("Gomez");
        estudianteDto.setEdad(20);

        estudianteEntity = new EstudianteEntity();
        estudianteEntity.setId(1L);
        estudianteEntity.setNombre("Juan");
        estudianteEntity.setApellidoPaterno("Perez");
        estudianteEntity.setApellidoMaterno("Gomez");
        estudianteEntity.setEdad(20);
    }

    @Test
    @DisplayName("Test create student")
    void testCreateStudent() {
        when(estudianteRepository.save(any(EstudianteEntity.class))).thenReturn(estudianteEntity);

        ResponseEntity<ResponseDto> response = estudianteService.createStudent(estudianteDto);

        assertEquals(201, response.getBody().getCode());
        assertEquals("Estudiante creado correctamente", response.getBody().getMessage());
        assertTrue(((HashMap<String, Object>) response.getBody().getBody()).containsKey("id"));
    }

    @Test
    @DisplayName("Test get students")
    void testGetStudents() {

        when(estudianteRepository.findAll()).thenReturn(List.of(estudianteEntity));

        ResponseDto response = estudianteService.getStudents();

        assertEquals(200, response.getCode());
        assertEquals("Estudiantes encontrados", response.getMessage());
        assertEquals(1, ((List<EstudianteEntity>) response.getBody()).size());
    }

    @Test
    void testGetStudentById() {
        when(estudianteRepository.findById(1L)).thenReturn(Optional.of(estudianteEntity));
        ResponseDto response = estudianteService.getStudentById(1L);

        assertEquals(200, response.getCode());
        assertEquals("Estudiante encontrado", response.getMessage());
        assertEquals(estudianteEntity, response.getBody());
    }

    @Test
    void testGetStudentByIdNotFound() {
        when(estudianteRepository.findById(2L)).thenReturn(Optional.empty());
        assertThrows(CustomException.class, () -> estudianteService.getStudentById(2L));
    }

    @Test
    void testUpdateStudent() {
        when(estudianteRepository.findById(1L)).thenReturn(Optional.of(estudianteEntity));
        when(estudianteRepository.save(any(EstudianteEntity.class))).thenReturn(estudianteEntity);

        ResponseDto response = estudianteService.updateStudent(1L, estudianteDto);

        assertEquals(200, response.getCode());
        assertEquals("Estudiante actualizado correctamente", response.getMessage());
    }

    @Test
    void testDeleteStudent() {
        when(estudianteRepository.findById(1L)).thenReturn(Optional.of(estudianteEntity));
        doNothing().when(estudianteRepository).deleteById(1L);

        ResponseDto response = estudianteService.deleteStudent(1L);

        assertEquals(200, response.getCode());
        assertEquals("Estudiante eliminado correctamente", response.getMessage());

    }

}
