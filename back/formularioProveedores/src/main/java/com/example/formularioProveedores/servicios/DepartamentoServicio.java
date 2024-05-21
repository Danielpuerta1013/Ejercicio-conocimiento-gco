package com.example.formularioProveedores.servicios;

import com.example.formularioProveedores.helpers.ValidacionDepartamento;
import com.example.formularioProveedores.modelos.Departamento;
import com.example.formularioProveedores.repositorios.DepartamentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoServicio {
    @Autowired
    ValidacionDepartamento validacionDepartamento;
    @Autowired
    DepartamentoRepositorio departamentoRepositorio;

    public Departamento guardarDepartamento(Departamento datosDepartamento) throws Exception{
        try {
            if (ValidacionDepartamento.validarDepartamentoSave(datosDepartamento)) {
                return departamentoRepositorio.save(datosDepartamento);
            }
            return null;
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }

    public Departamento consultarDepartamentoId(Integer idDepartamento)throws Exception{
        try{
            if (departamentoRepositorio.findById(idDepartamento).isPresent()){
                return departamentoRepositorio.findById(idDepartamento).get();

            }else{
                throw new Exception("Departamento no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

    public List<Departamento> buscarTodosDepartamentos()throws Exception{
        try{
            return departamentoRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
