package com.bibliotheque.repository;

import com.bibliotheque.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document,Integer> {
}
