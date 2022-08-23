package fr.formation;

import fr.formation.service.FichierService;

public class ApplicationFichier {

	public static void main(String[] args) {
		FichierService srvFichier = new FichierService();
		
		String contenu = srvFichier.getFileContent("D:/test.epr");
		System.out.println(contenu);
	}

}
