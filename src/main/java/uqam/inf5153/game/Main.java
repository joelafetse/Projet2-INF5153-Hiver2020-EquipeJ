package uqam.inf5153.game;

import uqam.inf5153.game.objectif.Objectif;
import uqam.inf5153.game.tuile.parcelle.Parcelle;

import java.util.List;

/**
 * Crée par Imen Benzarti le 13/01/2020 et l'Équipe J
 *
 * Une classe qui joue le role de l'interface graphique du jeu.
 * Elle reçoit les actions des joueurs a partir de la ligne de commande.
 */
public class Main {

	public final static int NB_ACTIONS_PAR_TOUR = 2;
	public final static int NB_TOTAL_JOUEUR =  2 ;
	/* Une constante fictive pour représenter temporairement le dernier tour
	 * Sinon vous devez implémenter le jeu tel que la partie prend fin lorsqu’un joueur atteint
	 * son 9e objectif s
	 * La fin de partie est detecté à travers la méthode Partie
	 */
	public final static int nbTour = 3;
	/*
	 * numéro du tour actuel : vous avec le choix de garder ou non cette variable qui représente
	 * le numéro du tour actuel.
	 */
	static int tourActuel = 1;
	public static void main(String[] args) {
		jouerJeuTakenoko();
	}
	private static void jouerJeuTakenoko() {
		String swValue;
		System.out.println("==========================================================================");
		System.out.println("|   Bienvenu au jeu TAKENOKO                                             ");
		System.out.println("==========================================================================");
		System.out.println("| Pour commencer une nouvelle partie appuyer sur ENTREE:                 ");
		System.out.println("==========================================================================");
		do{
			swValue = Keyin.inString();
		}while (swValue.length() != 0 );
		boolean estFinPartie;
		int i = 1;
		do {
			while ( i <= NB_TOTAL_JOUEUR) {
				menuJoueur(i);
				i++;
			}
			i = 1;
			estFinPartie = Takenoko.finPartie();
		}while (!estFinPartie);
		System.out.println("Le gagnant est le joueur : "+ Takenoko.annoncerGagnant());
	}
	private static void menuJoueur(int numJoueur) {
		int swValue;
		System.out.println("==========================================================================");
		System.out.println("|   TAKENOKO -- MENU JOUEUR " +numJoueur+ "                              ");
		System.out.println("==========================================================================");
		System.out.println("| Options:                                                               ");
		System.out.println("|        1. Déterminer les condition Climatiques                         ");
		System.out.println("|        2. Effectuer des actions                                        ");
		System.out.println("|        3. Quitter le jeu                                        ");
		System.out.println("==========================================================================");
		swValue = Keyin.inInt(" Selectionner une option: ");
		switch (swValue) {
			case 1:
				System.out.println("Déterminer les condition Climatiques");
				System.out.println("Cette fonctionnalité sera réalisée dans la deuxième partie  du projet");
				break;
			case 2:
				System.out.println("\nEffectuer des actions\n");
				choixAction(numJoueur);
				break;
			case 3:
				System.out.println("\nFin du jeu\n");
				System.exit(0);
				break;
			default:
				System.out.println("Selection invalide");
				break;
		}
	}

	/*
	 * Actions
	 */
	private static void choixAction(int numJoueur) {
		int nbActions = NB_ACTIONS_PAR_TOUR;
		int swValue;
		System.out.println("==========================================================================");
		System.out.println("|   TAKENOKO MENU JOUEUR " +numJoueur+ " : Actions                       ");
		System.out.println("==========================================================================");
		System.out.println("|     Le joueur effectue deux actions par tour parmi les                  ");
		System.out.println("|     5 actions disponibles                                               ");
		System.out.println("==========================================================================");
		while (nbActions > 0) {
			System.out.println("\n--------------------------------------------------------------------------");
			System.out.println("| Choix de l'action "+ (NB_ACTIONS_PAR_TOUR-nbActions + 1  ) +" :                                              ");
			System.out.println("--------------------------------------------------------------------------\n");
			System.out.println("|        1. Parcelles                                                ");
			System.out.println("|        2. Canal irrigation                                         ");
			System.out.println("|        3. Jardinier                                                ");
			System.out.println("|        4. Panda                                                    ");
			System.out.println("|        5. Objectif                                                 ");
			System.out.println("======================================================================");
			swValue = Keyin.inInt(" Selectionner une option: ");
			switch (swValue) {
				case 1:
					System.out.println("\nPiocher 3 parcelles et en choisir une\n");
					choixParcelle(numJoueur);
					break;
				case 2:
					System.out.println("\nPrendre une irrigation\n");
					prendreIrrigation(numJoueur);
					break;
				case 3:
					System.out.println("\nDéplacer le jardinier\n");
					deplacerJardinier(numJoueur);
					break;
				case 4:
					System.out.println("\nDéplacer le panda\n");
					deplacerPanda(numJoueur);
					break;
				case 5:
					System.out.println("\nPiocher une carte objectif\n");
					piocherObjectif(numJoueur);
					break;
				default:
					System.out.println("Selection invalide");
					nbActions = nbActions + 1;
					break;
			}
			nbActions = nbActions - 1;
		}
		autresDecisions(numJoueur);
	}
	private static void choixParcelle(int numJoueur) {
		Takenoko.placerParcelle(numJoueur);
//		System.out.println("===========================================================================");
//		System.out.println("|   TAKENOKO MENU JOUEUR " +numJoueur+ " : Action Parcelle                        ");
//		System.out.println("===========================================================================");
//		System.out.println("Étape 1 - Piocher 3 parcelles ");
//		List<Parcelle> parcellesPiochees = Takenoko.piocherParcelles(3, numJoueur);
//
//		System.out.println("Étape 2 - Vous avez pioché les parcelles suivantes : \n");
//
//		Takenoko.afficherParcelles(parcellesPiochees);
//
//		System.out.println("\nÉtape 3 - Choisissez une");
//		int parcelleChosie = Keyin.inInt("Entrez le numéro de la parcelle choisie : ");
//		while(parcelleChosie > 3 || parcelleChosie < 1){
//			System.out.println("Vous devez choisir entre la parcelle 1 et 3");
//			parcelleChosie = Keyin.inInt("\nEntrez le numéro de la parcelle choisie : ");
//		}
//		System.out.println("Étape 4 - Replacer les deux autres sous la pioche");
//		Parcelle pSelectionnee = Takenoko.selectionnerParcelle(parcellesPiochees, parcelleChosie );
//		System.out.println("Étape 5 - Afficher les parcelles du plateau:\n");
//		Takenoko.afficherParcellesPlateau();
//		Takenoko.afficherPositionsDisponibles();
//		System.out.println("\nÉtape 6 - Placer une parcelle dans la position (x,y) \n");
//		int x = Keyin.inInt(" Entrer la position x : ");
//		int y = Keyin.inInt(" Entrer la position y : ");
//		boolean estPlacee = Takenoko.placerParcelleDansPlateau(pSelectionnee, x, y,  numJoueur);
//		while (!estPlacee){
//			System.out.println("La parcelle n'est pas placée. Veuillez choisir une autre position");
//			Takenoko.afficherPositionsDisponibles();
//			System.out.println("Étape 6 - Placer une parcelle dans la position (x,y) ");
//			x = Keyin.inInt(" Entrer la position x : ");
//			y = Keyin.inInt(" Entrer la position y : ");
//			estPlacee = Takenoko.placerParcelleDansPlateau(pSelectionnee, x, y,  numJoueur);
//		}
//		System.out.println("\nLa parcelle est bien placée ");

	}
	private static void prendreIrrigation(int numJoueur) {
		Takenoko.placerIrrigation(numJoueur, false);
//		System.out.println("===========================================================================");
//		System.out.println("|   TAKENOKO MENU JOUEUR " +numJoueur+ " : Action Irrigation                        ");
//		System.out.println("===========================================================================");
//		Takenoko.piocherUneIrrigation(numJoueur);
//		System.out.println("|        Une irrigation est prise                                 ");
//		System.out.println("|        Voulez-vous la placer   ?                             ");
//		int reponse = Keyin.inChar(" réponse (O/N) : ");
//		if (reponse == 'o' || reponse == 'O' ) {
//			placerIrrigation(numJoueur);
//		}else{
//			Takenoko.garderIrrigation(numJoueur);
//		}
	}
	private static void deplacerJardinier(int numJoueur) {
		Takenoko.deplacerJardinier(numJoueur);
//		System.out.println("==========================================================================");
//		System.out.println("|   TAKENOKO MENU JOUEUR " +numJoueur+ " : Action Jardiner                        ");
//		System.out.println("==========================================================================");
//		System.out.println("|        Afficher les parcelles du plateau (les positions):             \n");
//		//Takenoko.afficherParcellesPlateau();
//		System.out.println("\n|        Précisier la nouvelle parcelle (position x,y) du Jardinier      ");
//		int x = Keyin.inInt(" Entrer la position x : ");
//		int y = Keyin.inInt(" Entrer la position y : ");
//		boolean estDeplace = Takenoko.PlacerJardinier(x,y, numJoueur );
//		while (!estDeplace) {
//			System.out.println("Vous ne pouvez pas déplacer le jardinier sur cette parcelle");
//			System.out.println("|        Préciser la nouvelle parcelle (position x,y) du Jardinier      ");
//			x = Keyin.inInt(" Entrer la position x : ");
//			y = Keyin.inInt(" Entrer la position y : ");
//			estDeplace = Takenoko.PlacerJardinier(x, y, numJoueur);
//		}
//		System.out.println("Le Jardinier est bien déplacé.");

	}
	private static void deplacerPanda(int numJoueur) {
		Takenoko.deplacerPanda(numJoueur);
//		System.out.println("==========================================================================");
//		System.out.println("|   TAKENOKO MENU JOUEUR " +numJoueur+ " : Action Panda                         ");
//		System.out.println("==========================================================================");
//		System.out.println("|        Afficher les parcelles du plateau  (les positions)\n               ");
//		//Takenoko.afficherParcellesPlateau();
//		System.out.println("\n|        Préciser la nouvelle parcelle (position x,y) du Panda                   ");
//		int x = Keyin.inInt(" Entrer la position x : ");
//		int y = Keyin.inInt(" Entrer la position y : ");
//		boolean PandaEstDeplace = Takenoko.PlacerPanda(x,y, numJoueur );
//		while (!PandaEstDeplace){
//			System.out.println("Vous ne pouvez pas déplacer le panda sur cette parcelle");
//			System.out.println("|        Préciser la nouvelle parcelle (position x,y) du panda      ");
//			x = Keyin.inInt(" Entrer la position x : ");
//			y = Keyin.inInt(" Entrer la position y : ");
//			PandaEstDeplace = Takenoko.PlacerPanda(x,y, numJoueur );
//		}
//		System.out.println("Le Panda est bien déplacé.");

	}
	private static void piocherObjectif(int numJoueur) {
		Takenoko.traiterActionObjectif(numJoueur, false);
//		System.out.println("==========================================================================");
//		System.out.println("|   TAKENOKO MENU JOUEUR " +numJoueur+ " : Action Objectif                        ");
//		System.out.println("==========================================================================");
//		Objectif objectif = Takenoko.piocherObjectif(numJoueur);
//		if (objectif == null){
//			System.out.println("Vous ne pouvez pas piocher d'objectifs");
//		}else {
//			System.out.println("|        Cet objectif est maintenant pioché                                  ");
//			System.out.println("         Et vous avez pioché: "+ objectif);
//			System.out.println("|        Pouvez vous le remplir tout de suite (O/N)  ?         ");
//            System.out.println("|        Si oui, appliquer l'objectif sur le plateau du joueur     ");
//			int reponse = Keyin.inChar(" réponse (O/N) : ");
//			if (reponse == 'o' || reponse == 'O') {
//				remplirUnObjectif(numJoueur, objectif);
//			}
//		}
	}
	/*
	 * Décisions
	 */
	private static void autresDecisions(int numJoueur) {
		int swValue;
		System.out.println("\n");
		System.out.println("=========================================================================");
		System.out.println("|   TAKENOKO MENU JOUEUR " +numJoueur+ " : Autres Décisions       ");
		System.out.println("=========================================================================");
		System.out.println("|Pendant un tour un joueur peut prendre des décisions qui");
		System.out.println("|ne comptent pas pour des actions                            ");
		do{
			System.out.println("\n--------------------------------------------------------------------------");
			System.out.println("| Choix de décision                                      ");
			System.out.println("--------------------------------------------------------------------------\n");
			System.out.println("|        1. Remplir un objectif                          ");
			System.out.println("|        2. Placer des irrigations                       ");
			System.out.println("|        3. Fin du tour                                  ");
			swValue = Keyin.inInt(" Selectionner une option: ");
			switch (swValue) {
				case 1:
					System.out.println("\nRemplir un objectif\n");
					Takenoko.traiterActionObjectif(numJoueur, true);
					break;
				case 2:
					System.out.println("\nPlacer des irrigations\n");
					Takenoko.placerIrrigation(numJoueur, true);
					break;
				case 3:
					System.out.println("\n\nFin du tour\n\n");
					break;
				default:
					System.out.println("Selection invalide");
					break;
			}
		}while (swValue != 3);
	}
//	private static void placerIrrigation(int numJoueur) {
//		System.out.println("=========================================================================");
//		System.out.println("|  TAKENOKO MENU JOUEUR " +numJoueur+ ": décide de placer une irrigation ");
//		System.out.println("=========================================================================\n");
//		System.out.println("Les parcelles déposées sur le plateau de jeu sont: \n");
//		//Takenoko.afficherParcellesPlateau();
//		System.out.println("\n|        Préciser les deux parcelles (x1,y1) et (x2, y2) séparés par l'irrigation ");
//		int x1 = Keyin.inInt(" Entrer la position x1 : ");
//		int y1 = Keyin.inInt(" Entrer la position y1 : ");
//		int x2 = Keyin.inInt(" Entrer la position x2 : ");
//		int y2 = Keyin.inInt(" Entrer la position y2 : ");
//		boolean estPlacee = Takenoko.placerUneIrrigation( x1, y1, x2, y2, numJoueur);
//		while(!estPlacee){
//			System.out.println("l'irrigation n'est pas placée");
//			System.out.println("Vous devez entrer des positions valides");
//			x1 = Keyin.inInt(" Entrer la position x1 : ");
//			y1 = Keyin.inInt(" Entrer la position y1 : ");
//			x2 = Keyin.inInt(" Entrer la position x2 : ");
//			y2 = Keyin.inInt(" Entrer la position y2 : ");
//			estPlacee = Takenoko.placerUneIrrigation( x1, y1, x2, y2, numJoueur);
//		}
//			System.out.println("L'irrigation est bien placée");
//
//	}
//	private static void remplirObjectif(int numJoueur) {
//		System.out.println("=========================================================================");
//		System.out.println("|  TAKENOKO MENU JOUEUR " +numJoueur+ ": décide de remplir un objectif");
//		System.out.println("=========================================================================");
//		System.out.println("|        Afficher les objectifs du jour");
//		Takenoko.afficherObjectifsJoueur (numJoueur);
//		List<Objectif> objectifsPioches = Takenoko.objectifsPioches(numJoueur);
//		System.out.println("|        Choisir un objectif à remplir ");
//		int objectifChoisi = Keyin.inInt(" Entrer le numéro de l'objectif choisi : ");
//		while(objectifChoisi > objectifsPioches.size() || objectifChoisi < 1){
//			System.out.println("Vous devez choisir entre la objectif 1 et "+ objectifsPioches.size());
//			objectifChoisi = Keyin.inInt(" Entrer le numéro de l'objectif choisi : ");
//		}
//		Objectif objectif = Takenoko.selectionnerObjectifARemplir (objectifsPioches, objectifChoisi);
//		System.out.println(" Vous avez choisi : "+objectif);
//		remplirUnObjectif( numJoueur,  objectif);
//	}
//	private static void remplirUnObjectif(int numJoueur, Objectif objectif) {
//		boolean estRempli = Takenoko.remplirObjectif (objectif, numJoueur);
//		if (estRempli)
//			System.out.println("Félicitations! objectif rempli");
//		else
//			System.out.println("Objectif irréalisable pour le moment");
//	}

	private static void afficherEnteteMenuAction(int numJoueur) {
		System.out.println("==========================================================================");
		System.out.println("|   TAKENOKO MENU JOUEUR " +numJoueur+ " : Actions                       ");
		System.out.println("==========================================================================");
		System.out.println("|     Le joueur effectue deux actions par tour parmi les                  ");
		System.out.println("|     5 actions disponibles                                                   ");
		System.out.println("==========================================================================");
	}
}
