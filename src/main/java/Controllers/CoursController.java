package Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Services.CoursService;
import classess.Cours;
	@RestController
	@RequestMapping("/api/cours")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public class CoursController {
@Autowired
	 CoursService coursService;

	    public CoursController(CoursService coursService) {
	        this.coursService = coursService;
	    }
	    @PostMapping("/ajouterCours")
	    public void ajouterCours(@RequestBody Cours cours) {
	    	coursService.ajouterCours(cours);
	    	
	    }
	    @GetMapping("/ConsulterCours")
	    public List<Cours> getCours() {
	        return coursService.getAllCours();
	    }
}