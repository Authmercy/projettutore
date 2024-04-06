package com.bibliotheque.services;

import com.bibliotheque.exception.RessourcesNotFoundException;
import com.bibliotheque.model.Category;
import com.bibliotheque.model.Pret;
import com.bibliotheque.repository.CategoryRepository;
import com.bibliotheque.repository.PretRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@Service
public class PretService {
    private PretRepository pretRepository;
    public Pret addPret(Pret pret){
        Pret pret1 = new Pret();
        pret1.setDate_pret(pret.getDate_pret());
        pret1.setDate_limite_retour(pret.getDate_limite_retour());
        pret1.setDate_retour(pret.getDate_retour());
        pret1.setMatricule_etudiant(pret.getMatricule_etudiant());

        return this.pretRepository.save(pret1);
    }
    public Pret updatePret(Integer id, @RequestBody Pret pretDetails){
        Pret updatePret = pretRepository.findById(id)
                .orElseThrow(() -> new RessourcesNotFoundException("document not exit with id :" +id));

        updatePret.setDate_pret(pretDetails.getDate_pret());
        updatePret.setDate_limite_retour(pretDetails.getDate_limite_retour());
        updatePret.setDate_pret(pretDetails.getDate_pret());
        updatePret.setMatricule_etudiant(pretDetails.getMatricule_etudiant());

        return this.pretRepository.save(updatePret);
    }

}
