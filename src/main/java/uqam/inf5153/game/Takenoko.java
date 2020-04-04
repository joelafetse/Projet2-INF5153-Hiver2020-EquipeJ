package uqam.inf5153.game;

import uqam.inf5153.game.actions.PlaceParcelle;
import uqam.inf5153.game.joueur.Joueur;
import uqam.inf5153.game.objectif.Objectif;
import uqam.inf5153.game.tuile.parcelle.Parcelle;

import java.util.List;

/**
 * Crée par Imen Benzarti le 13/01/2020 et par  équipe J
 *
 * une classe controlleur du jeu (voir le parton GRASP controlleur)
 * Elle n'implémente aucune des méthodes : elle oriente les actions envoyées par les joueurs
 * vers les classes responsable de les implémenter.
 */
public class Takenoko {

	private static Jeu jeu = new Jeu();

	public static Joueur getJoueurByIndex(int index){
		return jeu.getJoueurs().get(index - 1);
	}

	/**
	 * les parcelles
	 */

	public static void placerParcelle(int numJoueur){
		Joueur joueur = getJoueurByIndex(numJoueur);
		joueur.setActionCourante(new PlaceParcelle(jeu));
		joueur.effectuerAction(numJoueur);
	}
//	/*
//	 * Piocher nbrAPiocher parcelles de la pioche du joueur joueur
//	 */
//	public static List<Parcelle> piocherParcelles(int nbrAPiocher, int joueur) {
//		return jeu.effectuerActionPiocherParcelles(nbrAPiocher, joueur);
//	}
//	/*
//	 * selectionne uneParcelle parmi les parcelles piochés et retourne les autres à la pioche.
//	 */
//	//public static void selectionnerParcelle(String[] parcelles, String uneParcelle ) {}
//	public static Parcelle selectionnerParcelle(List<Parcelle>  parcelles, int indexParcelle ) {
//		return jeu.selectionnerParcelle(parcelles, indexParcelle);
//	}
//	/*
//	 * afficher un ensemble de parcelles
//	 */
//	/*public static void afficherParcelles(String[] parcelles) {}*/
//	public static void afficherParcelles( List<Parcelle> list) {
//        jeu.afficherParcelles(list);
//	}
//	/*
//	 * afficher les parcelles déposé dans le plateau du joueur joueur
//	 */
//	public static void afficherParcellesPlateau(){//int joueur) {
//		jeu.afficherParcellesDansPlateau();
//	}
//
//	public static void afficherPositionsDisponibles(){
//		jeu.getPlateauDeJeu().afficherLesPositionsDispo();
//	}
//	/*
//	 * placer une parcelle dans la position (x,y) dans le plateau du joueur joueur.
//	 * retourne true si la parcelle est bien placée, sinon elle retourne false.
//	 */
//	public static boolean placerParcelleDansPlateau(Parcelle parcelle, int x, int y, int joueur) {
//        return jeu.effectuerActionPlacerParcelleDansPlateau(parcelle,x,y,joueur);
//	}
	/**
	 * piocher une irrigation du joueur
	 */

	/*
	 * piocher une irrigation dans la pioche des irrigation du joueur
	 *
	 */
	public static void piocherUneIrrigation(int joueur) {
		jeu.effectuerActionPiocherIrrigation(joueur);
	}

	public static void garderIrrigation(int joueur){
        jeu.effectuerActionGarderIrrigation(joueur);
    }
	/*
	 * placer une irrigation entre les parcelles (x1,y1) et (x2, y2) dans le plateau du joueur joueur
	 * retourne true si l'irrigation est bien placée
	 */
	public static boolean placerUneIrrigation( int x1, int y1, int x2, int y2, int joueur) {
	    return jeu.effectuerActionPlacerIrrigation(x1,y1,x2,y2,joueur);
	}
	/**
	 * objectifs
	 */

	/*
	 * retourne tous les objectis piochées par le joueur
	 */
	public static void afficherObjectifsJoueur(int joueur) {
		jeu.afficherObjectifsPioches(joueur);
	}

	public static List<Objectif> objectifsPioches(int joueur){
		return jeu.getObjectifsPioches(joueur);
	}
	/*
	 * selectionner un objectif un remplir parmi un ensemble d'objectif piochés
	 * retourne l'objectif selectionné
	 */
	public static Objectif selectionnerObjectifARemplir(List<Objectif> objectifs, int indexObjectif) {
		return jeu.selectionnerObjectif(objectifs, indexObjectif);
	}

	/*
	 * le joueur rempli un objectif
	 * retourne true si l'objectif est rempli, sinon elle retourne false.
	 */
	public static boolean remplirObjectif(Objectif objectif, int joueur) {
		return jeu.effectuerActionRemplirObjectif(objectif, joueur);
	}

	/*
	 * piocher un objectif dans la pioche du joueur
	 */
	public static Objectif piocherObjectif(int joueur) {
		return jeu.piocherObjectif(joueur);
	}

	/**
	 * jardinier
	 */

	/*
	 * placer le jardinier du joueur dans la parcelle dans la position (x,y) de son plateau.
	 * retourne true si le jardinier est déplacé, sinon elle retourne false
	 */
	public static boolean PlacerJardinier(int x, int y, int joueur) {
		return jeu.effectuerActionDeplacerJardinier(x,y,joueur);
	}



	/**
	 * panda
	 */

	/*
	 * placer le panda du joueur dans la parcelle dans la position (x,y)  de son plateau.
	 * retourne true si le panda est déplacé, sinon elle retourne false
	 */
	public static boolean PlacerPanda(int x, int y, int joueur) {
		return jeu.effectuerActionDeplacerPanda(x,y,joueur);
	}

	/**
	 * fin DE partie
	 */

	/*
	 * retourne true si la partie est terminé.
	 * Pour deux joueur une partie prend fin si un des joueur remplit son 9ème objectif
	 */
	public static boolean finPartie() {
		// code temporaire
		return jeu.verifierFinPartie();
	}
	/**
	 *  Le gagnant
	 */

	/*
	 * annonce la gagnant à la fin de la partie.
	 * et ce en calclant le total des points des objectifs remplis.
	 */
	public static int annoncerGagnant() {

		return 1;
	}



}






