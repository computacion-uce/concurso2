package com.concurso.avanzado.reto2.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String provincia;

    @Column
    private String canton;

    @Column
    private Integer sexo;

    @Column
    private Integer edad;

    @Column(name = "anio_nacimiento")
    private Integer anioNacim;

    @Column(name = "mes_nacimiento")
    private Integer mesNacim;
}
