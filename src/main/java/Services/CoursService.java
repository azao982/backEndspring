package Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Repositories.CoursRepository;
import classess.Cours;

@Service
public class CoursService {

    private CoursRepository coursRepository;

    public CoursService(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    public Cours ajouterCours(Cours cours) {
        return coursRepository.save(cours);
    }

    public Cours getById(Long id) {
        Optional<Cours> optionalCours = coursRepository.findById(id);
        return optionalCours.orElse(null);
    }

    public List<Cours> getAllCours() {
        return coursRepository.findAll();
    }
}
