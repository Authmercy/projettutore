package com.bibliotheque.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @Column(nullable = false, length = 15)
    private Integer isbn;
    private String nom;
    private String prix;
    private String position;
    private String photo;
    private String description;
    private String status;
    private String auteur;
    @Column(nullable = false, unique = true, length = 45,name = "titre")
    private String titre;
    @Column(nullable = false, length = 15, name = "date_depot")
    private Date date_depot;
    @Column(nullable = false, length = 15,name = "categorie")
    private String categorie;
    @Column(nullable = false, length = 15,name = "quantite")
    private  Integer quantite;

    @ManyToOne
    @JoinColumn(name="id_categorie")
    private Category category;
}
