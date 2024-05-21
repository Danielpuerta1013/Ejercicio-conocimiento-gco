package com.example.formularioProveedores.repositorios;

import com.example.formularioProveedores.modelos.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepositorio extends JpaRepository<Departamento,Integer> {
}
