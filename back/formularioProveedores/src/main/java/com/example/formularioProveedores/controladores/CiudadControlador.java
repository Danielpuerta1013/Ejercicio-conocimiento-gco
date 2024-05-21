package com.example.formularioProveedores.controladores;

import com.example.formularioProveedores.modelos.Ciudad;
import com.example.formularioProveedores.servicios.CiudadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("proveedorapi/v1/ciudad")
public class CiudadControlador {
    @Autowired
    CiudadServicio ciudadServicio;

    @PostMapping
    public ResponseEntity<?> guardarCiudad(@RequestBody Ciudad datosCiudad){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ciudadServicio.guardarCiudad(datosCiudad));
        }catch(Exception error){
            Map<String, Object> errorDetails=new LinkedHashMap<>();
            errorDetails.put("timestamp", LocalDateTime.now());
            errorDetails.put("message",error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDetails);
        }

    }

    @GetMapping("{id}")
    public ResponseEntity<?> consultarCiudadPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ciudadServicio.consultarCiudadId(id));

        }catch (Exception error){
            Map<String, Object> errorDetails=new LinkedHashMap<>();
            errorDetails.put("timestamp", LocalDateTime.now());
            errorDetails.put("message",error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDetails);
        }
    }

    @GetMapping
    public ResponseEntity<?> consultarCiudad(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ciudadServicio.buscarTodosCiudad());

        }catch (Exception error){
            Map<String, Object> errorDetails=new LinkedHashMap<>();
            errorDetails.put("timestamp", LocalDateTime.now());
            errorDetails.put("message",error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDetails);
        }

    }
}
