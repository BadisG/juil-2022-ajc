package fr.formation.service;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class FichierService {
	/**
	 * Lire le contenu du fichier, et retourner son résultat ou un message d'erreur
	 * @param filename Le nom du fichier à lire
	 * @return Le contenu ou un message d'erreur
	 */
	public String getFileContent(String filename) {
		Path path = Path.of(filename);
		
		try {
			String contenu = Files.readString(path);
			return contenu;
		}
		
		catch (AccessDeniedException e) {
			return "Accès refusé";
		}
		
		catch (NoSuchFileException e) {
			return "Fichier non trouvé";
		}
		
		catch (IOException e) {
			// Peut être intéressant à garder en "mode débug"
//			e.printStackTrace(); // permet d'imprimer toute la trace d'erreur
			return "Autre erreur de lecture / écriture";
		}
	}
}
