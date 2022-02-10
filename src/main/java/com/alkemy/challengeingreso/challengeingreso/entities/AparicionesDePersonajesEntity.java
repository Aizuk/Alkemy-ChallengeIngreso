package com.alkemy.challengeingreso.challengeingreso.entities;

import lombok.Setter;
import lombok.Getter;

import javax.persistence.*;


@Entity
@Table(name = "apariciones_de_personajes")
@Getter
@Setter
public class AparicionesDePersonajesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "personaje_id", insertable = false, updatable = false)
    private PersonajeEntity personaje;

    @Column(name = "personaje_id",nullable = false)
    private Long personajeId;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "produccion_id", insertable = false, updatable = false)
    private ProduccionEntity produccion;

    @Column(name = "produccion_id", nullable = false)
    private Long produccionId;

}
