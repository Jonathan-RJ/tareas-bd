package com.estudiantes.entudiantes.utils.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private int code;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object body;
}
