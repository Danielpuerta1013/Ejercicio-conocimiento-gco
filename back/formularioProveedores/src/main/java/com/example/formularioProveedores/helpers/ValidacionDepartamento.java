package com.example.formularioProveedores.helpers;

import com.example.formularioProveedores.modelos.Departamento;
import com.example.formularioProveedores.modelos.Proveedor;
import org.springframework.stereotype.Component;

@Component
public class ValidacionDepartamento {
    public static boolean validarDepartamento(String departamento)throws Exception{
        if (departamento.isEmpty()){
            throw new Exception("El departamento no puede estar vacio");
        }
        if (departamento.length()>50){
            throw new Exception("El departamento no puede tener mas de 50 caracteres");
        }

        return true;
    }

    public static boolean validarDepartamentoSave(Departamento departamento) throws Exception {
        return validarDepartamento(departamento.getNombreDepartamento());

    }

}
