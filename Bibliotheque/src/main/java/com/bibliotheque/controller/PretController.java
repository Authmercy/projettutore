package com.bibliotheque.controller;

import com.bibliotheque.exception.RessourcesNotFoundException;
import com.bibliotheque.model.Category;
import com.bibliotheque.model.Pret;
import com.bibliotheque.repository.CategoryRepository;
import com.bibliotheque.repository.PretRepository;
import com.bibliotheque.services.CategoryService;
import com.bibliotheque.services.PretService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/prets")
@RestController
@AllArgsConstructor
public class PretController {
    @Autowired
    private PretRepository pretRepository;
    @Autowired
    private PretService pretService;

    @GetMapping
    public List<Pret> getAllPret(Pret pret){
        return  pretRepository.findAll();
    }

    @PostMapping
    public Pret createPret(@RequestBody Pret pret){
        return  this.pretService.addPret(pret);
    }

    @PutMapping("/update/{id}")
    public Pret updatePret(@PathVariable("id") Integer id, @RequestBody Pret updatePret){
        return  this.pretService.updatePret(id,updatePret);

    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Pret> getPretById(@PathVariable Integer id){
        Pret pret = pretRepository.findById(id)
                .orElseThrow(() -> new RessourcesNotFoundException("document not exit with id :" +id));
        return ResponseEntity.ok(pret);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Pret> deletePret(@PathVariable Integer id){
        Pret pret = pretRepository.findById(id)
                .orElseThrow(() -> new RessourcesNotFoundException("document not exit with id :" +id));
        pretRepository.delete(pret);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
