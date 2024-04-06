package com.bibliotheque.services;

import com.bibliotheque.exception.RessourcesNotFoundException;
import com.bibliotheque.model.Document;
import com.bibliotheque.repository.DocumentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@AllArgsConstructor
public class DocumentService {
    private DocumentRepository documentRepository;

    public Document addDocument(Document document){
        Document document1 = new Document();
        document1.setNom(document.getNom());
        document1.setAuteur(document.getAuteur());
        document1.setStatus(document.getStatus());
        document1.setPrix(document.getPrix());
        document1.setPhoto(document.getPhoto());
        document1.setFichier(document.getFichier());
        document1.setIsbn(document.getIsbn());
        document1.setCategorie(document.getCategorie());
        document1.setTitre(document.getTitre());
        document1.setQuantite(document.getQuantite());
        document1.setDate_depot(document.getDate_depot());

        return this.documentRepository.save(document1);
    }
    public Document updateDocument(Integer id,@RequestBody Document documentDetails){
        Document updateDocument = documentRepository.findById(id)
                .orElseThrow(() -> new RessourcesNotFoundException("document not exit with id :" +id));

        updateDocument.setNom(documentDetails.getNom());
        updateDocument.setTitre(documentDetails.getTitre());
        updateDocument.setQuantite(documentDetails.getQuantite());
        updateDocument.setCategorie(documentDetails.getCategorie());
        updateDocument.setDate_depot(documentDetails.getDate_depot());
        updateDocument.setAuteur(documentDetails.getAuteur());
        updateDocument.setStatus(documentDetails.getStatus());
        updateDocument.setPrix(documentDetails.getPrix());
        updateDocument.setPhoto(documentDetails.getPhoto());
        updateDocument.setFichier(documentDetails.getFichier());
        updateDocument.setIsbn(documentDetails.getIsbn());

        return this.documentRepository.save(updateDocument);
    }

}
