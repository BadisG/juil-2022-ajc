package fr.formation;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import fr.formation.exception.ChiffreNegatifException;

public class ApplicationException {
	
	// Pour gérer les Exceptions
	// Utilisation des mot-clés : try, catch, finally
	// try : essayer d'exécuter une ou plusieurs instructions
	// catch : attraper une ou plusieurs natures d'Exception qui ont été jetées
	// finally : d'exécuter un bloc d'instructions dans tous les cas
	// throw : permet de jeter une Exception
	
	// En JAVA, on a 2 types d'Exceptions : Checked Exception, Unchecked Exception
	// Les checked sont des Exceptions qui vont être captées au moment dans la compilation
	// > Si l'exception checked est pas gérée, la compilation échoue
	// > La classe mère est Throwable ou Exception
	// Les unchecked sont des Exceptions qui vont être captées au moment de l'exécution
	// > La classe mère est RuntimeException
	

	public static void main(String[] args) {
		// Demander à l'utilisateur de saisir un nombre
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Saisir un nombre : ");
		
		try {
			int saisie = sc.nextInt();
			
			if (saisie < 0) {
				// Pour lever une Exception, utiliser le mot-clé "throw"
//				throw new RuntimeException("La saisie est négative.");
				throw new ChiffreNegatifException(saisie);
			}
			
			// Afficher ce nombre
			System.out.println("Vous avez saisi : " + saisie);
			return;
		}
		
//		catch (InputMismatchException ime) {
//			System.out.println("Je fais la même chose.");
//		}
//		
//		catch (IllegalStateException ise) {
//			System.out.println("Je fais la même chose.");
//		}
		
		catch (InputMismatchException | IllegalStateException ex) {
			System.out.println("Je fais la même chose.");
		}
		
		catch (ChiffreNegatifException cne) {
			System.out.println("Le chiffre " + cne.getChiffre() + " doit être positif.");
		}
		
//		catch (Exception ex) { // Ici, j'attrape TOUTES les exceptions
//			System.out.println(ex.getMessage());
//			System.out.println("Je fais la même chose.");
//		}
		
		finally { // Optionnel
			System.out.println("S'exécute dans tous les cas");
			System.out.println("SI dans le try et/ou le catch, y'a un 'return', le finally va s'exécute JUSTE AVANT ce return");
			
			// On ferme le scanner
			sc.close();
		}
		
		System.out.println("FINI !");
		
		
		// Obligation de gérer l'exception
		try {
			demoCheckedException();			
		}
		
		catch (Exception e) {
			
		}
		
		// Pas obligation de gérer l'exception
		demoUncheckedException();
	}
	
	
	
	// Throws, dans la signature, permet de dire que la méthode PEUT lever une exception
	// Throws permet de déléguer au niveau supérieur l'exception qui a été jetée
	public static void demoCheckedException() throws Exception {
		throw new Exception();
	}

	
	public static void demoUncheckedException() {
		throw new RuntimeException();
	}
	
	
	
	
}
