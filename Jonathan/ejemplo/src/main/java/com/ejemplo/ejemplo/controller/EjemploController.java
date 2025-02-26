package com.ejemplo.ejemplo.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.ejemplo.dto.AnidacionDto;
import com.ejemplo.ejemplo.dto.EjemploDto;

@RestController
@RequestMapping("/ejemplo")
public class EjemploController {

    @GetMapping("/saludo1")
    public String saludo() {
        return "Hola mundo";
    }

    @GetMapping("/saludo2")
    public String saludo2() {
        return "Hola ppp";
    }

    @GetMapping("/json/hashmap")
    public HashMap<String, String> json() {
        HashMap<String, String> jsonData = new HashMap<>();
        jsonData.put("nombre", "Juan");
        jsonData.put("apellido", "Ramos");
        jsonData.put("Edad", "18");
        return jsonData;
    }

    @GetMapping("/json/dto")
    public EjemploDto jsonDto() {
        AnidacionDto anidacionDto = new AnidacionDto("Anidado", 1000.0);
        return new EjemploDto("Juan", "Ramos", 18, anidacionDto);
    }

}
