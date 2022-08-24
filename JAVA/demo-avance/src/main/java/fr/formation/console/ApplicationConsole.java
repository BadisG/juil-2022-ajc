package fr.formation.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import fr.formation.exception.FournisseurNotFoundException;
import fr.formation.exception.NotValidArgsException;
import fr.formation.service.FournisseurService;

@Service
public class ApplicationConsole implements CommandLineRunner {
	@Autowired
	private FournisseurService srvFournisseur;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application console");
		
		try {
			System.out.println(this.srvFournisseur.findById(2));
		}
		
		catch (FournisseurNotFoundException e) {
			System.out.println("Fournisseur non trouvé.");
		}
		
		catch (NotValidArgsException e) {
			System.out.println("ID incorrect.");
		}
	}
}
