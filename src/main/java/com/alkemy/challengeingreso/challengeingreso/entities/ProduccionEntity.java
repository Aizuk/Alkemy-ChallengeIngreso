package com.alkemy.challengeingreso.challengeingreso.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "produccion")
@Getter
@Setter
public class ProduccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String titulo;

    @Column(name = "fecha_cracion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaCreacion;

    private Integer calificacion;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "genero_id", insertable = false, updatable = false)
    private GeneroEntity genero;

    @Column(name = "genero_id")
    private Long generoId;


}
