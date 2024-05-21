package com.example.formularioProveedores.servicios;

import com.example.formularioProveedores.helpers.ValidacionCiudad;
import com.example.formularioProveedores.helpers.ValidacionPais;
import com.example.formularioProveedores.modelos.Ciudad;
import com.example.formularioProveedores.modelos.Pais;
import com.example.formularioProveedores.repositorios.CiudadRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadServicio {
    @Autowired
    ValidacionCiudad validacionCiudad;
    @Autowired
    CiudadRepositorio ciudadRepositorio;

    public Ciudad guardarCiudad(Ciudad datosCiudad) throws Exception{
        try {
            if (ValidacionCiudad.validarCiudadSave(datosCiudad)) {
                return ciudadRepositorio.save(datosCiudad);
            }
            return null;
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }

    public Ciudad consultarCiudadId(Integer idCiudad)throws Exception{
        try{
            if (ciudadRepositorio.findById(idCiudad).isPresent()){
                return ciudadRepositorio.findById(idCiudad).get();

            }else{
                throw new Exception("Ciudad no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

    public List<Ciudad> buscarTodosCiudad()throws Exception{
        try{
            return ciudadRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
