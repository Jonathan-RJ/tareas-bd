package com.estudiantes.entudiantes.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDto {
    @NotNull(message = "El nombre es requerido")
    private String nombre;
    @Size(min = 3, max = 20, message = "El apellido paterno debe tener entre 3 y 20 caracteres")
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int edad;
}
