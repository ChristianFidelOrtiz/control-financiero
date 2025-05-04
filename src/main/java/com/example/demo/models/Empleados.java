package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "empleados")
@Data
public class Empleados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Long id;

    @NotNull
    @Size(max = 15)
    @Column(name = "legajo", nullable = false, length = 15)
    private String legajo;

    @ManyToOne
    @JoinColumn(name = "id_barrio", nullable = false)
    private Barrios barrio;

    @ManyToOne
    @JoinColumn(name = "id_nacionalidad", nullable = false)
    private Nacionalidades nacionalidad;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "id_estado_civil", nullable = false)
    private EstadoCivil estadoCivil;

    @NotNull
    @Size(max = 50)
    @Column(name = "nombres", nullable = false, length = 50)
    private String nombres;

    @NotNull
    @Size(max = 50)
    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;

    @NotNull
    @Size(max = 20)
    @Column(name = "cedula_identidad", nullable = false, length = 20)
    private String cedulaIdentidad;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nac", nullable = false)
    private Date fechaNacimiento;

    @Size(max = 1)
    @Column(name = "sexo", length = 1)
    private String sexo;

    @Size(max = 1)
    @Column(name = "estado", length = 1)
    private String estado;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_incorporacion")
    private Date fechaIncorporacion;

    @NotNull
    @Size(max = 100)
    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;

    @NotNull
    @Size(max = 20)
    @Column(name = "telefono", nullable = false, length = 20)
    private String telefono;

    @NotNull
    @Size(max = 50)
    @Email
    @Column(name = "email", nullable = false, length = 50)
    private String email;
}
