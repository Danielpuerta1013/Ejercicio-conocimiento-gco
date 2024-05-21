package com.example.formularioProveedores.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "ciudad")
public class Ciudad {
    /*
     * Definición de atrbutos y conexiones con otros modelos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCiudad;

    @Column(nullable = false)
    private String nombreCiudad;

    @ManyToOne
    @JoinColumn(name = "departamento_id", nullable = false)
    @JsonBackReference("ciudad-departamento")
    private Departamento departamento;

}
