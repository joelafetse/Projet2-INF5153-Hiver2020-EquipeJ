package uqam.inf5153.game;

import uqam.inf5153.game.actions.*;
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

	/**
	 * piocher une irrigation du joueur
	 */

	public static void placerIrrigation(int numJoueur, boolean estDecision){
		Joueur joueur = getJoueurByIndex(numJoueur);
		joueur.setActionCourante(new PlaceIrrigation(jeu,estDecision));
		joueur.effectuerAction(numJoueur);
	}

	/**
	 * objectifs
	 */

	public static void traiterActionObjectif(int numJoueur, boolean estDecision){
		Joueur joueur = getJoueurByIndex(numJoueur);
		joueur.setActionCourante(new RemplitObjectif(jeu,estDecision));
		joueur.effectuerAction(numJoueur);
	}

	/**
	 * jardinier
	 */
	public static void deplacerJardinier(int numJoueur){
		Joueur joueur = getJoueurByIndex(numJoueur);
		joueur.setActionCourante(new DeplaceJardinier(jeu));
		joueur.effectuerAction(numJoueur);
	}

	/**
	 * panda
	 */
	public static void deplacerPanda(int numJoueur){
		Joueur joueur = getJoueurByIndex(numJoueur);
		joueur.setActionCourante(new DeplacePanda(jeu));
		joueur.effectuerAction(numJoueur);
	}

	/**
	 * fin DE partie
	 */

	/*
	 * retourne true si la partie est terminé.
	 * Pour deux joueur une partie prend fin si un des joueur remplit son 9ème objectif
	 */
	public static boolean finPartie() {
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
		return jeu.annoncerGagnant();
	}



}






