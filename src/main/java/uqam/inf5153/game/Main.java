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
	public static int nbrTotalJoueurs;
	private static Jeu jeu;
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
		nbrTotalJoueurs = choisirNbrJoueurs();
		jeu = new Jeu(nbrTotalJoueurs);
		boolean estFinPartie;
		int i = 1;
		do {
			while ( i <= nbrTotalJoueurs) {
				menuJoueur(jeu, i);
				i++;
			}
			i = 1;
			estFinPartie = Takenoko.finPartie(jeu);
		}while (!estFinPartie);
		System.out.println("Le gagnant est le joueur : "+ Takenoko.annoncerGagnant(jeu));
	}
	private static void menuJoueur(Jeu jeu, int numJoueur) {
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
				choixAction(jeu, numJoueur);
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
	private static void choixAction(Jeu jeu, int numJoueur) {
		int nbActions = NB_ACTIONS_PAR_TOUR;
		int swValue;
		afficherEnteteMenuAction(numJoueur);
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
					choixParcelle(jeu, numJoueur);
					break;
				case 2:
					System.out.println("\nPrendre une irrigation\n");
					prendreIrrigation(jeu, numJoueur);
					break;
				case 3:
					System.out.println("\nDéplacer le jardinier\n");
					deplacerJardinier(jeu, numJoueur);
					break;
				case 4:
					System.out.println("\nDéplacer le panda\n");
					deplacerPanda(jeu, numJoueur);
					break;
				case 5:
					System.out.println("\nPiocher une carte objectif\n");
					piocherObjectif(jeu, numJoueur);
					break;
				default:
					System.out.println("Selection invalide");
					nbActions = nbActions + 1;
					break;
			}
			nbActions = nbActions - 1;
		}
		autresDecisions(jeu, numJoueur);
	}
	private static void choixParcelle(Jeu jeu, int numJoueur) {
		Takenoko.placerParcelle(jeu, numJoueur);
	}
	private static void prendreIrrigation(Jeu jeu, int numJoueur) {
		Takenoko.placerIrrigation(jeu, numJoueur, false);
	}
	private static void deplacerJardinier(Jeu jeu, int numJoueur) {
		Takenoko.deplacerJardinier(jeu, numJoueur);
	}
	private static void deplacerPanda(Jeu jeu, int numJoueur) {
		Takenoko.deplacerPanda(jeu, numJoueur);
	}
	private static void piocherObjectif(Jeu jeu, int numJoueur) {
		Takenoko.traiterActionObjectif(jeu, numJoueur, false);
	}

	/*
	 * Décisions
	 */
	private static void autresDecisions(Jeu jeu, int numJoueur) {
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
					Takenoko.traiterActionObjectif(jeu, numJoueur, true);
					break;
				case 2:
					System.out.println("\nPlacer des irrigations\n");
					Takenoko.placerIrrigation(jeu, numJoueur, true);
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

	private static void afficherEnteteMenuAction(int numJoueur) {
		System.out.println("==========================================================================");
		System.out.println("|   TAKENOKO MENU JOUEUR " +numJoueur+ " : Actions                       ");
		System.out.println("==========================================================================");
		System.out.println("|     Le joueur effectue deux actions par tour parmi les                  ");
		System.out.println("|     5 actions disponibles                                                   ");
		System.out.println("==========================================================================");
	}

	private static int choisirNbrJoueurs(){
		int nbrDeJoueurs;
		nbrDeJoueurs = Keyin.inInt("Entrez le nombre de joueurs voulant jouer à la partie : ");
		while (nbrDeJoueurs < 2 || nbrDeJoueurs > 4){
			System.err.println("Le nombre de joueurs est invalide. Recommencez");
			nbrDeJoueurs = Keyin.inInt("Entrez le nombre de joueurs voulant jouer à la partie : ");
		}
		return nbrDeJoueurs;
	}

}
