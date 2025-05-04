package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "tipo_documentos")
@Data
public class TipoDeDocumento {

    @Id
    @Column(name = "id_tipo_documento")
    private Long id;

    @Column(name = "descripcion", nullable = true, unique = false, length = 50)
    @Size(max = 50)
    private String descripcion;
}