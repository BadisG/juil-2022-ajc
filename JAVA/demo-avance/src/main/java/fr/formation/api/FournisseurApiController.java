package fr.formation.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.model.Fournisseur;
import fr.formation.service.FournisseurService;

@RestController
public class FournisseurApiController {
	@Autowired
	private FournisseurService srvFournisseur;
	
	@GetMapping("/api/fournisseur/{id}")
	public Fournisseur findById(@PathVariable int id, Model model) {
		return this.srvFournisseur.findById(id);
	}
}
