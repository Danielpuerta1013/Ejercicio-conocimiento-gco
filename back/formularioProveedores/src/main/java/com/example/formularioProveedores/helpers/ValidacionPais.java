package com.example.formularioProveedores.helpers;

import com.example.formularioProveedores.modelos.Pais;
import com.example.formularioProveedores.modelos.Proveedor;
import org.springframework.stereotype.Component;

@Component
public class ValidacionPais {
    public static boolean validarPais(String pais)throws Exception{
        if (pais.isEmpty()){
            throw new Exception("El pais no puede estar vacio");
        }
        if (pais.length()>50){
            throw new Exception("El pais no puede tener mas de 50 caracteres");
        }

        return true;
    }

    public static boolean validarPaisSave(Pais pais) throws Exception {
        return validarPais(pais.getNombrePais());
    }
}
