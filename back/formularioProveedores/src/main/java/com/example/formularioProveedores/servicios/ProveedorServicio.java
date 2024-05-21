package com.example.formularioProveedores.servicios;

import com.example.formularioProveedores.helpers.ValidacionProveedor;
import com.example.formularioProveedores.modelos.Proveedor;
import com.example.formularioProveedores.repositorios.ProveedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServicio {
    @Autowired
    ValidacionProveedor validacionProveedor;
    @Autowired
    ProveedorRepositorio proveedorRepositorio;
    private static final String UPLOAD_DIR = "uploads/";

    public Proveedor guardarProveedor(Proveedor datosProveedor) throws Exception{
        try {
            if (ValidacionProveedor.validarProveedor(datosProveedor)) {
                return proveedorRepositorio.save(datosProveedor);
            }
            return null;
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }

    public Proveedor consultarProveedorId(Integer idProveedor)throws Exception{
        try{
            if (proveedorRepositorio.findById(idProveedor).isPresent()){
                return proveedorRepositorio.findById(idProveedor).get();

            }else{
                throw new Exception("usuario no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

    public List<Proveedor> buscarTodosProveedores()throws Exception{
        try{
            return proveedorRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public boolean eliminarProveedor(Integer idProveedor)throws Exception{
        try{
            Optional<Proveedor> proveedorOptional = proveedorRepositorio.findById(idProveedor);
            if (proveedorOptional.isPresent()) {
                proveedorRepositorio.deleteById(idProveedor);
                return true;
            }else {
                throw new Exception("usuario no encontrado");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

    public Proveedor guardarProveedorConRUT(Proveedor proveedor, MultipartFile file) throws IOException {
        File directory = new File(UPLOAD_DIR);
        if (!directory.exists()) {
            boolean dirCreated = directory.mkdirs();
            if (dirCreated) {
                System.out.println("La carpeta 'uploads' se ha creado correctamente.");
            } else {
                System.err.println("Error al crear la carpeta 'uploads'. Verifica los permisos del sistema de archivos.");
                throw new IOException("No se pudo crear la carpeta 'uploads'.");
            }
        }

        String fileName = file.getOriginalFilename();
        Path filePath = Paths.get(UPLOAD_DIR, fileName);
        Files.write(filePath, file.getBytes());

        proveedor.setRutaRut(filePath.toString());
        return proveedorRepositorio.save(proveedor);
    }




}
