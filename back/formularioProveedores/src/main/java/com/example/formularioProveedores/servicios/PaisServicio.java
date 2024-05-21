package com.example.formularioProveedores.servicios;

import com.example.formularioProveedores.helpers.ValidacionPais;
import com.example.formularioProveedores.helpers.ValidacionProveedor;
import com.example.formularioProveedores.modelos.Pais;
import com.example.formularioProveedores.modelos.Proveedor;
import com.example.formularioProveedores.repositorios.PaisRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisServicio {
    @Autowired
    ValidacionPais validacionPais;
    @Autowired
    PaisRepositorio paisRepositorio;

    public Pais guardarPais(Pais datosPais) throws Exception{
        try {
            if (ValidacionPais.validarPaisSave(datosPais)) {
                return paisRepositorio.save(datosPais);
            }
            return null;
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }

    public Pais consultarPaisId(Integer idPais)throws Exception{
        try{
            if (paisRepositorio.findById(idPais).isPresent()){
                return paisRepositorio.findById(idPais).get();

            }else{
                throw new Exception("pais no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

    public List<Pais> buscarTodosPaises()throws Exception{
        try{
            return paisRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
