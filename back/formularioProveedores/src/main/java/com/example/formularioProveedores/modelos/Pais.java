package com.example.formularioProveedores.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "pais")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pais {
    /*
     * Definición de atrbutos y conexiones con otros modelos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPais;

    @Column(nullable = false, unique = true)
    private String nombrePais;


    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("pais-departamento")
    private List<Departamento> departamentos;

}
