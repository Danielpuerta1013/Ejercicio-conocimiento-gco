package com.example.formularioProveedores.controladores;

import com.example.formularioProveedores.modelos.Pais;
import com.example.formularioProveedores.servicios.PaisServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("proveedorapi/v1/pais")
public class PaisControlador {
    @Autowired
    PaisServicio paisServicio;

    @PostMapping
    public ResponseEntity<?> guardarPais(@RequestBody Pais datosPais){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(paisServicio.guardarPais(datosPais));
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
    public ResponseEntity<?> consultarPaisPorPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(paisServicio.consultarPaisId(id));

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
    public ResponseEntity<?> consultarPais(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(paisServicio.buscarTodosPaises());

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
