package com.example.formularioProveedores.controladores;

import com.example.formularioProveedores.modelos.Departamento;
import com.example.formularioProveedores.servicios.DepartamentoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("proveedorapi/v1/departamento")
public class DepartamentoControlador {
    @Autowired
    DepartamentoServicio departamentoServicio;

    @PostMapping
    public ResponseEntity<?> guardarDepartamento(@RequestBody Departamento datosDepartamento){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(departamentoServicio.guardarDepartamento(datosDepartamento));
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
    public ResponseEntity<?> consultarDepartamentoPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(departamentoServicio.consultarDepartamentoId(id));

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
    public ResponseEntity<?> consultarProveedores(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(departamentoServicio.buscarTodosDepartamentos());

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
