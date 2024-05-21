package com.example.formularioProveedores.repositorios;

import com.example.formularioProveedores.modelos.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor,Integer> {
}
