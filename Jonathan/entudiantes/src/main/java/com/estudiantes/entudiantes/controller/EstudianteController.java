package com.estudiantes.entudiantes.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudiantes.entudiantes.dto.EstudianteDto;
import com.estudiantes.entudiantes.service.EstudianteService;
import com.estudiantes.entudiantes.utils.dto.ResponseDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createStudent(@RequestBody EstudianteDto estudianteDto) {

        return estudianteService.createStudent(estudianteDto);
    }

    @GetMapping("/get-all")
    public ResponseDto getStudents() {
        return estudianteService.getStudents();
    }

    @GetMapping("/get-by/{id}")
    public ResponseDto getStudentById(@PathVariable Long id) {
        return estudianteService.getStudentById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseDto updateStudent(@PathVariable Long id, @RequestBody EstudianteDto estudianteDto) {
        return estudianteService.updateStudent(id, estudianteDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto deleteStudent(@PathVariable Long id) {
        return estudianteService.deleteStudent(id);
    }

}
