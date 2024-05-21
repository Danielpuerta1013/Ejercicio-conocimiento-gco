package com.example.formularioProveedores.repositorios;

import com.example.formularioProveedores.modelos.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepositorio extends JpaRepository<Ciudad,Integer> {
}
