package com.estudiantes.entudiantes.service;

import org.springframework.http.ResponseEntity;

import com.estudiantes.entudiantes.dto.EstudianteDto;
import com.estudiantes.entudiantes.utils.dto.ResponseDto;

public interface EstudianteService {
    public ResponseEntity<ResponseDto> createStudent(EstudianteDto estudianteDto);

    public ResponseDto getStudents();

    public ResponseDto getStudentById(Long id);

    public ResponseDto updateStudent(Long id, EstudianteDto estudianteDto);

    public ResponseDto deleteStudent(Long id);
}
