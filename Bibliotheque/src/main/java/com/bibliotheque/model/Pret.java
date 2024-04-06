package com.bibliotheque.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pret")
@Data
public class Pret {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "date_pret")
    private Date date_pret;
    @Column(name = "date_limite_retour")
    private Date date_limite_retour;
    private String matricule_etudiant;

    @Column(name = "date_retour", nullable = true)
    private Date date_retour;

    @ManyToMany
    @JoinTable(name = "pret_ouvrage", joinColumns = @JoinColumn(name = "pret_id"), inverseJoinColumns = @JoinColumn(name = "documents_id"))
    private List<Document> documents;
}
