// TOUTE VARIABLE UTILISEE DOIT ETRE DECLAREE
// LA DECLARATION C'EST TOUJOURS : Type nomVariable / Type nomParametre

int 
char
boolean
int[]
char[]
float
Personne


class Personne {
    // Attributs
    private int age = 0;
    private String prenom;
    private String nom;

    // Les méthodes / le comportement

    // "Implicitement", on a un paramètre qui s'appelle "this" qui fera référence à l'objet manipulé
    public void setAge(int nouvelAge) {
        if (nouvelAge > 0) {
            this.age = nouvelAge;
        }
    }

    public int getAge() {
        return this.age;
    }
}



class Animal {
    int age = 0;

    void setAge(int nouvelAge) {
        this.age = nouvelAge;
    }
}

Personne pers = new Personne();
Personne pers1 = new Personne();
Personne pers2 = new Personne();
Animal chat = new Animal();

// setAge(pers2, 42);
pers2.setAge(42);
pers.setAge(10);
chat.setAge(2);




// pers.age = 42 // PLUS VALIDE PARCE QUE C'EST PRIVE
pers.setAge(42); // CA C'EST OK
pers.setAge(-42); // CA C'EST OK, MAIS L'AGE NE SERA PAS MODIFIE
pers.getAge(); // ICI ON RECUPERE L'AGE

pers.setAge( pers.getAge() + 1 );



// pers2 = pers;

// pers.age = 42;
// pers2.age = 53;

// int a1 = 42;
// int a2 = 53;

// a1 = a2;
// a2 = 10;

// a2 = 10
// a1= 53



// Correction exercices

// Classe Carte
class Carte {
    private String nom;
    private int valeur;

    public String getNom() {
        return nom; // ou this.nom
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getValeur() {
        return this.valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
}

// Instancier une nouvelle Carte
Carte maCarte = new Carte();

// Affecter le nom, et la valeur
maCarte.setNom("As de Pique");
maCarte.setValeur(32);

// Afficher le nom de la carte, et sa valeur
System.out.println(maCarte.getNom() + ", " + maCarte.getValeur());


// Tableau de cartes
// Carte[] cartes = new Carte[32];

// Collection de type liste en tableau
// ArrayList<Carte> paquet = new ArrayList<Carte>();

// // Ajouter dans la collection : méthode add(la carte)
// // Récupérer un élément à un indice : méthode get(indice)
// // Récupérer la taille : méthode size()

// // Rappel pour les boucles "pour"
// for (int i = 0; i < maxi; i++) {

// }



// Créer une collection de 32 cartes
ArrayList<Carte> paquet = new ArrayList<Carte>(); // Création du paquet, pour l'instant vide

// Remplir le paquet
// 1- Créer les 32 cartes, et les ajouter au paquet
Carte laCarte = null;

for (int i = 0; i < 32; i++) {
    laCarte = new Carte();
    laCarte.setNom("Carte #" + i);
    laCarte.setValeur(i);

    // Ajouter la carte dans le paquet
    paquet.add(laCarte);
}


// Parcourir la collection pour afficher les cartes (pour classique)
for (int i = 0; i < paquet.size(); i++) {
    // paquet.get(i) donnera une Carte
    // System.out.println( paquet.get(i).getNom() + ", " + paquet.get(i).getValeur() );

    Carte laCarte = paquet.get(i);
    System.out.println( laCarte.getNom() + ", " + laCarte.getValeur() );
}


// Parcourir la collection pour afficher les cartes (pour chaque)
// Pour chaque Carte dans CollectionCarte
for (Carte uneCarte : paquet) {
    System.out.println( uneCarte.getNom() + ", " + uneCarte.getValeur() );
}


// Classe Joueur
class Joueur {
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}


// Classe Equipe
class Equipe {
    private String nom;

    private ArrayList<Joueur> joueurs = new ArrayList<Joueur>(); // Option Collection
    private Joueur[] tabJoueurs = new Joueur[2]; // Option Tableau

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(ArrayList<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public Joueur[] getTabJoueurs() {
        return tabJoueurs;
    }

    public void setTabJoueurs(Joueur[] tabJoueurs) {
        this.tabJoueurs = tabJoueurs;
    }
}




// Création de 2 joueurs
Joueur j1 = new Joueur();
Joueur j2 = new Joueur();

j1.setNom("J1");
j2.setNom("J2");


// Création de l'équipe
Equipe equipeBleue = new Equipe();

equipeBleue.setNom("Equipe Bleue");

// Association des joueurs à l'équipe

// Option Collection
// equipeBleue.getJoueurs().add(j1);
// equipeBleue.getJoueurs().add(j2);

ArrayList<Joueur> lesJoueurs = equipeBleue.getJoueurs();
lesJoueurs.add(j1);
lesJoueurs.add(j2);


// Option Tableau
// equipeBleue.getTabJoueurs()[0] = j1;
// equipeBleue.getTabJoueurs()[1] = j2;

Joueur[] lesTabJoueurs = equipeBleue.getTabJoueurs();
lesTabJoueurs[0] = j1;
lesTabJoueurs[1] = j2;


// Chercher le nom du joueur #1 dans l'équipe
equipeBleue.getJoueurs().get(0).getNom();

// Avec le tableau
equipeBleue.getTabJoueurs()[0].getNom();

// Liste des joueurs de l'équipe
for (Joueur j : equipeBleue.getJoueurs()) {
    System.out.println(j.getNom());
}



















