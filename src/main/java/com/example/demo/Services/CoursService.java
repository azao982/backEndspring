package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Repositories.CoursRepository;
import com.example.demo.classess.Cours;

@Service
public class CoursService {

    private CoursRepository coursRepository;

    public CoursService(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    public Cours ajouterCours(Cours cours) {
        return coursRepository.save(cours);
    }

    public List<Cours> getAllCours() {
        return coursRepository.findAll();
    }
    public void supprimerCours(Long coursId) {
        coursRepository.deleteById(coursId);
    }
    public Cours getById(Long id) {

        return coursRepository.findById(id).orElse(null);

    }

    public boolean updateCours(Cours cours, long id) {
        Optional<Cours> coursOptional = coursRepository.findById((long) id);
        
        if (coursOptional.isPresent()) {
            Cours coursToUpdate = coursOptional.get();
            
            // Mettre à jour les champs du cours avec les nouvelles valeurs
            coursToUpdate.setNomDuCours(cours.getNomDuCours());
            coursToUpdate.setPrix(cours.getPrix());
            coursToUpdate.setImage(cours.getImage());
            
            
            // Enregistrer les modifications dans la base de données
            coursRepository.save(coursToUpdate);
            return true;
        } else 
        	return false ;  
    }
}
