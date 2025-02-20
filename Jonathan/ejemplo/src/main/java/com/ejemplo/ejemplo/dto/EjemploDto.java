package com.ejemplo.ejemplo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EjemploDto {
    private String nombre;
    private String apellido;
    @JsonProperty("edadCambiaNombre")
    private int edad;
    private AnidacionDto anidacion;
}
