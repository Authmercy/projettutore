package com.bibliotheque.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="download")
public class Download {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(name = "date_telechargerment")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "id_document")
    private Document document;
}
