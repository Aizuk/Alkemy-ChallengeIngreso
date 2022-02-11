package com.alkemy.challengeingreso.challengeingreso.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "personaje")
@Getter
@Setter
public class PersonajeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;

    private Integer edad;

    private Integer peso;

    private String historia;

    @ManyToMany(mappedBy = "personajes", cascade = CascadeType.ALL)
    private Set<ProduccionEntity> producciones = new HashSet<>();


}
