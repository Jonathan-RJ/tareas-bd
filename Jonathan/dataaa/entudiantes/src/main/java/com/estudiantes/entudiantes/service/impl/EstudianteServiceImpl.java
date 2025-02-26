package com.estudiantes.entudiantes.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.estudiantes.entudiantes.dto.EstudianteDto;
import com.estudiantes.entudiantes.entity.EstudianteEntity;
import com.estudiantes.entudiantes.handlerException.CustomException;
import com.estudiantes.entudiantes.repository.EstudianteRepository;
import com.estudiantes.entudiantes.service.EstudianteService;
import com.estudiantes.entudiantes.utils.dto.ResponseDto;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public ResponseEntity<ResponseDto> createStudent(EstudianteDto estudianteDto) {
        try {
            EstudianteEntity estudianteEntity = new EstudianteEntity();
            estudianteEntity.setNombre(estudianteDto.getNombre());
            estudianteEntity.setApellidoPaterno(estudianteDto.getApellidoPaterno());
            estudianteEntity.setApellidoMaterno(estudianteDto.getApellidoMaterno());
            estudianteEntity.setEdad(estudianteDto.getEdad());

            Long estudinateId = estudianteRepository.save(estudianteEntity).getId();

            ResponseDto responseDto = new ResponseDto();
            responseDto.setMessage("Estudiante creado correctamente");
            responseDto.setCode(201);

            HashMap<String, Object> data = new HashMap<>();
            data.put("id", estudinateId);
            responseDto.setBody(data);
            return ResponseEntity.status(201).contentType(MediaType.APPLICATION_JSON).body(responseDto);
        } catch (Exception e) {
            throw new CustomException("Error al crear el estudiante", 500, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseDto getStudents() {
        try {
            List<EstudianteEntity> estudiantes = estudianteRepository.findAll();
            ResponseDto responseDto = new ResponseDto();
            responseDto.setMessage("Estudiantes encontrados");
            responseDto.setCode(200);
            responseDto.setBody(estudiantes);
            return responseDto;
        } catch (Exception e) {
            throw new CustomException("Error al consultar los estudiantes", 500, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseDto getStudentById(Long id) {
        try {
            Optional<EstudianteEntity> estudiante = estudianteRepository.findById(id);
            if (estudiante.isEmpty()) {
                throw new CustomException("El usuario no existe", 404, HttpStatus.NOT_FOUND);
            }
            return new ResponseDto(200, "Estudiante encontrado", estudiante.get());
        } catch (Exception e) {
            throw new CustomException("Error al consultar el estudiante", 500, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseDto updateStudent(Long id, EstudianteDto estudianteDto) {
        try {
            Optional<EstudianteEntity> estudiante = estudianteRepository.findById(id);
            if (estudiante.isEmpty()) {
                throw new CustomException("El usuario no existe", 404, HttpStatus.NOT_FOUND);
            }

            EstudianteEntity estudianteEntity = estudiante.get();
            estudianteEntity.setId(id);
            estudianteEntity.setNombre(estudianteDto.getNombre());
            estudianteEntity.setApellidoPaterno(estudianteDto.getApellidoPaterno());
            estudianteEntity.setApellidoMaterno(estudianteDto.getApellidoMaterno());
            estudianteEntity.setEdad(estudianteDto.getEdad());

            estudianteRepository.save(estudianteEntity);
            ResponseDto responseDto = new ResponseDto();
            responseDto.setMessage("Estudiante actualizado correctamente");
            responseDto.setCode(200);
            return responseDto;
        } catch (Exception e) {
            throw new CustomException("Error al actualizar el estudiante", 500, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseDto deleteStudent(Long id) {
        try {
            Optional<EstudianteEntity> estudiante = estudianteRepository.findById(id);
            if (estudiante.isEmpty()) {
                throw new CustomException("El usuario no existe", 404, HttpStatus.NOT_FOUND);
            }
            estudianteRepository.deleteById(id);
            ResponseDto responseDto = new ResponseDto();
            responseDto.setMessage("Estudiante eliminado correctamente");
            responseDto.setCode(200);
            return responseDto;
        } catch (Exception e) {
            throw new CustomException("Error al eliminar el estudiante", 500, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
