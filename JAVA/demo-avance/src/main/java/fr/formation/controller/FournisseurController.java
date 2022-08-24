package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.exception.FournisseurNotFoundException;
import fr.formation.exception.NotValidArgsException;
import fr.formation.service.FournisseurService;

@Controller
public class FournisseurController {
	@Autowired
	private FournisseurService srvFournisseur;
	
	@GetMapping("/fournisseur")
	public String findById(@RequestParam int id, Model model) {
		try {
			model.addAttribute("fournisseur", this.srvFournisseur.findById(id));			
		}
		
		catch (FournisseurNotFoundException e) {
			model.addAttribute("error", "Fournisseur non trouvé.");
		}
		
		catch (NotValidArgsException e) {
			model.addAttribute("error", "Id non valide.");
		}
		
		return "fournisseur";
	}
}
