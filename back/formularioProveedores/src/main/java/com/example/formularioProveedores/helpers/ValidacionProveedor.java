package com.example.formularioProveedores.helpers;

import com.example.formularioProveedores.modelos.Pais;
import com.example.formularioProveedores.modelos.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacionProveedor {


    public static boolean validarTipoPersona(String tipoPersona)throws Exception{
        if (tipoPersona.isEmpty()){
            throw new Exception("El tipo de persona no puede estar vacio");
        }
        if (tipoPersona.length()>10){
            throw new Exception("El tipo de persona no puede tener mas de 10 caracteres");
        }

        return true;
    }

    public static boolean validarNit(String nit)throws Exception{
        if (nit.isEmpty()){
            throw new Exception("El nit no puede estar vacio");
        }
        if (nit.length()>11){
            throw new Exception("El nit no puede tener mas de 11 caracteres");
        }

        return true;
    }

    public static boolean validarRazonSocial(String razonSocial)throws Exception{
        if (razonSocial.isEmpty()){
            throw new Exception("La razon social no puede estar vacia");
        }
        if (razonSocial.length()>100){
            throw new Exception("La razon social no puede tener mas de 100 caracteres");
        }

        return true;
    }

    public static boolean validarNombreRepresentante(String nombre)throws Exception{
        if (nombre.isEmpty()){
            throw new Exception("El nombre no puede estar vacio");
        }
        if (nombre.length()>100){
            throw new Exception("El nombre no puede tener mas de 100 caracteres");
        }
        if (!nombre.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+")) {
            throw new IllegalArgumentException("Revisa el nombre ingresado ya que solo puede contener letras y espacios");
        }
        return true;
    }

    public static boolean validarTelefono(String telefono)throws Exception{
        if (telefono.isEmpty()){
            throw new Exception("El telefono no puede estar vacio");
        }
        if (telefono.length()>10){
            throw new Exception("El telefono no puede tener mas de 10 caracteres");
        }

        // evaluo si el nombre coincide con la expresion
        if (!telefono.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("Revisa el telefono ingresado ya que solo puede contener numeros");
        }
        return true;
    }

    public static boolean validarCorreo(String correo)throws Exception{
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (!correo.trim().matches(regex)) {
            throw new IllegalArgumentException("El formato del correo electrónico no es válido");
        }
        if (correo.isEmpty()){
            throw new Exception("la longitud del correo no puede ser cero");
        }
        if (correo.length()>50){
            throw new Exception("El correo no puede tener mas de 50 caracteres");
        }

        return true;
    }


    public static boolean validarDireccion(String direccion)throws Exception{
        if (direccion.isEmpty()){
            throw new Exception("La direccion no puede estar vacia");
        }
        if (direccion.length()>100){
            throw new Exception("La direccion no puede tener mas de 50 caracteres");
        }

        return true;
    }



    public static boolean validarProveedor(Proveedor proveedor) throws Exception {
        return validarTipoPersona(proveedor.getTipoPersona()) &&
                validarNit(proveedor.getNit()) &&
                validarRazonSocial(proveedor.getRazonSocial()) &&
                validarNombreRepresentante(proveedor.getNombreRepresentanteLegal()) &&
                validarTelefono(proveedor.getTelefono()) &&
                validarCorreo(proveedor.getEmail()) &&
                validarDireccion(proveedor.getDireccion());
    }


}
