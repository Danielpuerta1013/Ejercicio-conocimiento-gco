package com.example.formularioProveedores.controladores;

import com.example.formularioProveedores.modelos.Proveedor;
import com.example.formularioProveedores.servicios.ProveedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("proveedorapi/v1/proveedor")
public class ProveedorControlador {


    @Autowired
    ProveedorServicio proveedorServicio;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> guardarProveedor(@RequestBody Proveedor datosProveedor){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(proveedorServicio.guardarProveedor(datosProveedor));
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
    public ResponseEntity<?> consultarProveedorPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(proveedorServicio.consultarProveedorId(id));

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
                    .body(proveedorServicio.buscarTodosProveedores());

        }catch (Exception error){
            Map<String, Object> errorDetails=new LinkedHashMap<>();
            errorDetails.put("timestamp", LocalDateTime.now());
            errorDetails.put("message",error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDetails);
        }

    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarProveedorPorid(@PathVariable Integer id){
        try{
            Map<String, Object> errorDetails=new LinkedHashMap<>();
            errorDetails.put("timestamp", LocalDateTime.now());
            errorDetails.put("message","proveedor eliminado con exito ");
            if (proveedorServicio.eliminarProveedor(id)){
                return ResponseEntity.status(HttpStatus.OK).body(errorDetails);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("proveedor no encontrado");
            }

        }catch (Exception error){
            Map<String, Object> errorDetails=new LinkedHashMap<>();
            errorDetails.put("timestamp", LocalDateTime.now());
            errorDetails.put("message",error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDetails);
        }

    }

    @PostMapping("/registro")
    public ResponseEntity<?> registrarProveedor(@RequestPart("proveedor") Proveedor proveedor, @RequestPart("rut") MultipartFile file) {
        try {
            Proveedor proveedorGuardado = proveedorServicio.guardarProveedorConRUT(proveedor, file);
            return ResponseEntity.status(HttpStatus.CREATED).body(proveedorGuardado);
        } catch (IOException e) {
            Map<String, Object> errorDetails = new LinkedHashMap<>();
            errorDetails.put("timestamp", LocalDateTime.now());
            errorDetails.put("message", "Error al guardar el archivo: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetails);
        } catch (Exception e) {
            Map<String, Object> errorDetails = new LinkedHashMap<>();
            errorDetails.put("timestamp", LocalDateTime.now());
            errorDetails.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
        }
    }





}
