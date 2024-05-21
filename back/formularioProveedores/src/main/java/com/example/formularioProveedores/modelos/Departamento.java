package com.example.formularioProveedores.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "departamento")
public class Departamento {
    /*
     * Definición de atrbutos y conexiones con otros modelos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDepartamento;

    @Column(nullable = false)
    private String nombreDepartamento;

    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false)
    @JsonBackReference("pais-departamento")
    private Pais pais;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("ciudad-departamento")
    private List<Ciudad> ciudades;



}
