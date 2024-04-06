package com.bibliotheque.controller;

import com.bibliotheque.exception.RessourcesNotFoundException;
import com.bibliotheque.model.Document;
import com.bibliotheque.repository.DocumentRepository;
import com.bibliotheque.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/document")
public class DocumentController {
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private DocumentService documentService;

    @GetMapping
    public List<Document>getAllDocument(Document document){

        return  documentRepository.findAll();
    }
    @PostMapping
    public Document createDocument(@RequestBody Document document){
        return  this.documentService.addDocument(document);
    }
    @PutMapping("/update/{id}")
    public Document updateDocument(@PathVariable("id") Integer id,@RequestBody Document updateDocument){
        return  this.documentService.updateDocument(id,updateDocument);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable Integer id){
        Document document = documentRepository.findById(id)
                .orElseThrow(() -> new RessourcesNotFoundException("document not exit with id :" +id));
        return ResponseEntity.ok(document);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Document> deleteDocument(@PathVariable Integer id){
        Document document = documentRepository.findById(id)
                .orElseThrow(() -> new RessourcesNotFoundException("document not exit with id :" +id));
        documentRepository.delete(document);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
