// Programme taille
int taille(int[] tab) {
    return tab.length;
}

int taille(char[] tab) {
    return tab.length;
}

// Programme lecture d'un entier (saisie utilisateur)
int readInt() {
    Scanner sc = new Scanner(System.in);
    return sc.nextInt();
}

// Programme lecture d'une chaine de caractères (saisie utilisateur)
String read() {
    Scanner sc = new Scanner(System.in);
    return sc.nextLine();
}



// 1- Somme de deux nombres
int somme(int a, int b) {
    return a + b;
}

// 2- Multiplication (avec addition)
int multiplier(int a, int b) {
    int resultat = a;

    // Gestion des 0
    if (a == 0 || b == 0) {
        return 0; // Si le programme arrive ici, multiplier s'arrêtera
    }

    // Boucle Pour
    for (int i = 1; i < b; i++) {
        resultat += a;
    }

    return resultat;
}

// 3- Puissance
int puissance(int a, int puissance) {
    int resultat = 1;

    if (a == 0 && puissance == 0) {
        // TODO : lancer une erreur ...
    }

    if (a == 0) { // On peut le garder pour éviter les boucles non utiles
        return 0;
    }

    for (int i = 0; i < puissance; i++) {
        resultat *= a;
    }

    return resultat;
}


// 4- Créer un tableau de 5 entiers, tous initialisés à 0
int[] monTab = new int[5];

// Autre solution
int[] monTab = new int[] { 0, 0, 0, 0, 0 };


// 5- Calculer la somme d'un tableau d'entiers, tableau reçu en paramètre
int sommeTableau(int[] tab) {
    int resultat = 0;

    // Parcours du tableau pour tout additionner
    // for (int i = 0; i < taille(tab); i++) {
    for (int i = 0; i < tab.length; i++) {
        resultat = resultat + tab[i];
    }

    return resultat;
}

int[] testSommeTab = new int[] { 5, 8, 0, 14, 42 };
sommeTableau(testSommeTab);


// 6- Créer une variable capable de stocker la phrase suivante : « Mon premier algo »
// Solution #1
char[] phrase = new char[17];
phrase[0] = 'M';
phrase[1] = 'o';
phrase[2] = 'n'
phrase[3] = ' '
// ...

// Solution #2
char[] phrase = new char[] {  'M', 'o', 'n', ' ', ... };

// Solution #3
String phrase = "Mon premier algo";

// Solution #4 (on transforme la chaine de caractères en tableau de caractères, concrètement)
char[] phrase = "Mon premier algo".toCharArray();


// 7- Compter le nombre de caractères contenus dans un tableau de caractères
int compterCaracteres(char[] tab) {
    int nbCaracteres = 0;

    // Parcours du tableau de caractères
    for (int i = 0; i < tab.length; i++) {
        // Si différent d'un "non-caractère", on comptabilise un caractère de plus !
        if (tab[i] != ' ') {
            nbCaracteres++;
        }
    }

    return nbCaracteres;
}

char[] testComptageCaracteres = new char[] { 'T', 'e', 's', 't' };
compterCaracteres(testComptageCaracteres);


// Démonstration interaction utilisateur
void demoInteract() {
    // Demander l'age de l'utilisateur
    print("Saisir votre age svp : ");
    int age = readInt();

    // print("Votre age est : ");
    // println(age);

    // En utilisant la concaténation (+)
    println("Votre age est : " + age);
}

demoInteract();



// Demander l'age de l'utilisateur
// > Lui afficher son année de naissance
void demanderAge() {
    print("Saisir votre age : ");
    int age = readInt();

    int anneeNaissance = 2022 - age;
    println("Votre année de naissance est : " + anneeNaissance);
}

demanderAge();


// Demander 2 chiffres à l'utilisateur
// > Les soustraire et afficher le résultat
void demander2Nb() {
    print("Saisir chiffre 1 : ");
    int n1 = readInt();

    print("Saisir chiffre 2 : ");
    int n2 = readInt();

    // int resultat = n1 - n2;
    // println("Le résultat est : " + resultat);

    println("Le résultat est : " + (n1 - n2));
}

demander2Nb();


// Demander 3 chiffres à l'utilisateur
// > Les stocker dans un tableau (déjà créé, de 3 cases)
// > Soustraire et afficher le résultat
void demander3Nb() {
    int[] tab = new int[3];

    print("Saisir le chiffre 1 : ");
    tab[0] = readInt();

    print("Saisir le chiffre 2 : ");
    tab[1] = readInt();

    print("Saisir le chiffre 3 : ");
    tab[2] = readInt();

    int resultat = tab[0] - tab[1] - tab[2];
    println("Le résultat est : " + resultat);
}

demander3Nb();

void demander3NbBis() {
    int[] tab = new int[3];
    int resultat = 0;

    for (int i = 0; i < tab.lenght; i++) {
        print("Saisir le chiffre " + (i + 1) + " : ");
        tab[i] = readInt();

        if (i == 0) {
            resultat = tab[i];
        }

        else {
            resultat -= tab[i];
        }
    }

    println("Le résultat est : " + resultat);
}

demander3NbBis();

// Demander à l'utilisateur de saisir 2 nombres
// > Afficher le résultat de la puissance de ces 2 nombres
void demanderPuissance() {
    print("Saisir chiffre : ");
    int a = readInt();

    print("Saisir puissance : ");
    int puissance = readInt();

    int resultat = puissance(a, puissance);
    println("Le résultat = " + resultat);
}

demanderPuissance();


// Demander à l'utilisateur une suite de nombres
// > Tant que le nombre est > 0, on continue de demander
// > Dès que c'est 0 (ou moins), on s'arrête
// > On affiche la somme de tous les nombres saisis
void demanderSuite() {
    int nombre = 0;
    int resultat = 0;

    do {
        // On additionne le nombre au résultat déjà calculé
        resultat = resultat + nombre;

        print("Saisir un chiffre : ");
        nombre = readInt();
    } while(nombre > 0);

    println("Le résultat de tous les chiffres saisis = " + resultat);
}

demanderSuite();


void demanderSuiteBis() {
    int nombre = 0;
    int resultat = 0;

    while (true) {
        print("Saisir un chiffre : ");
        nombre = readInt();

        if (nombre < 0) {
            // On quitte la boucle
            break;
        }

        // On additionne le nombre au résultat déjà calculé
        resultat = resultat + nombre;
    }

    println("Le résultat de tous les chiffres saisis = " + resultat);
}

demanderSuite();


// Chercher le minimum dans un tableau d'entiers
// > Afficher la valeur min
void minimum() {
    int[] tab = new int[] { 14, 2, 85, 42, 10, 1, 9 };
    int mini = tab[0];

    // Parcours du tableau
    for (int i = 1; i < tab.length; i++) {
        // On compare, pour vérifier si la valeur est la "nouvelle" valeur mini
        if (tab[i] < mini) {
            mini = tab[i];
        }
    }

    println("La valeur mini est : " + mini);
}

minimum();


// 2 tableaux d'entiers (5 cases chaque tableau)
// 1 tableau d'entiers vide (5 cases aussi)
// Faire la somme des cases des deux premiers tableau, la mettre dans la case du troisième
int[] somme2Tabs() {
    int[] tab1 = new int[] { 5, 4, 42, 96, 8 };
    int[] tab2 = new int[] { 8, 0, 41, 5, 7 };
    int[] tabResultat = new int[5];

    // On parcours les tableaux
    for (int i = 0; i < tab1.length; i++) {
        tabResultat[i] = tab1[i] + tab2[i];
    }

    return tabResultat;
}

int[] tabResultat = somme2Tabs();

// On parcours pour afficher le résultat
for (int i = 0; i < tabResultat.length; i++) {
    print("[" + tabResultat[i] + "] ");
}


// Demander à l'utilisateur son prénom
// Afficher "Bonjour X !", sauf si son prénom est "Toto" ; dans ce cas, afficher "Très drole."
void demanderPrenom() {
    print("Saisir votre prénom : ");
    String prenom = read();

    if (prenom.equals("Toto")) {
        println("Très drole ...");
    }

    else {
        println("Bonjour " + prenom + " !");
    }
}

demanderPrenom();

// Afficher 1, 2, 3 .... jusqu'à 100
// Afficher "On est à la moitié" quand on atteint la moitié
void De1A100() {
    for (int i = 1; i <= 100; i++) {
        println(i);

        if (i == 50) {
            println("On est à la moitié !");
        }
    }
}

De1A100();


// Afficher "MENU" jusqu'à ce que l'utilisateur appuis sur 0 (attendre la saisie utilisateur entre chaque "MENU")
void menuSimple() {
    int choix = 0;

    do {
        println("MENU");
        choix = readInt();
    } while (choix != 0);
}

void menuSimpleBis() {
    do {
        println("MENU");
    } while (readInt() != 0);
}