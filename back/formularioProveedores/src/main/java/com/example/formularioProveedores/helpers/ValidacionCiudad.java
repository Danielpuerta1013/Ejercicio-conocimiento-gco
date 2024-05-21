package com.example.formularioProveedores.helpers;

import com.example.formularioProveedores.modelos.Ciudad;
import com.example.formularioProveedores.modelos.Proveedor;
import org.springframework.stereotype.Component;

@Component
public class ValidacionCiudad {
    public static boolean validarCiudad(String ciudad)throws Exception{
        if (ciudad.isEmpty()){
            throw new Exception("La ciudad no puede estar vacio");
        }
        if (ciudad.length()>50){
            throw new Exception("La ciudad no puede tener mas de 50 caracteres");
        }

        return true;
    }

    public static boolean validarCiudadSave(Ciudad ciudad) throws Exception {
        return validarCiudad(ciudad.getNombreCiudad());

    }

}
