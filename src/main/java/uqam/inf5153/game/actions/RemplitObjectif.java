package uqam.inf5153.game.actions;

import uqam.inf5153.game.Jeu;
import uqam.inf5153.game.Keyin;
import uqam.inf5153.game.Takenoko;
import uqam.inf5153.game.joueur.Joueur;
import uqam.inf5153.game.joueur.PlateauDeJoueur;
import uqam.inf5153.game.objectif.Objectif;
import uqam.inf5153.game.pioche.PiocheObjectifs;
import uqam.inf5153.game.plateau.PlateauDeJeu;

import java.util.List;

public class RemplitObjectif implements Action {

    private Jeu jeu;
    private boolean estDecision;

    public RemplitObjectif(Jeu jeu, boolean estDecision){
        this.jeu = jeu;
        this.estDecision = estDecision;
    }

    @Override
    public boolean executerAction(int numJoueur){
        if (estDecision)
            return remplirObjectifSurDecision(numJoueur);

        return traiterActionObjectif(numJoueur);
    }

    private boolean traiterActionObjectif(int numJoueur){
        System.out.println("==========================================================================");
        System.out.println("|   TAKENOKO MENU JOUEUR " +numJoueur+ " : Action Objectif                        ");
        System.out.println("==========================================================================");
        Objectif objectif = piocherObjectif(numJoueur);
        if (objectif == null){
            System.out.println("Vous ne pouvez pas piocher d'objectifs");
        }else {
            System.out.println("|        Cet objectif est maintenant pioché                                  ");
            System.out.println("         Et vous avez pioché: "+ objectif);
            System.out.println("|        Pouvez vous le remplir tout de suite (O/N)  ?         ");
            System.out.println("|        Si oui, appliquer l'objectif sur le plateau du joueur     ");
            int reponse = Keyin.inChar(" réponse (O/N) : ");
            if (reponse == 'o' || reponse == 'O') {
                return remplirUnObjectif(numJoueur, objectif);
            }
        }
        return true;
    }

    private boolean remplirObjectifSurDecision(int numJoueur){
        System.out.println("=========================================================================");
		System.out.println("|  TAKENOKO MENU JOUEUR " +numJoueur+ ": décide de remplir un objectif");
		System.out.println("=========================================================================");
		System.out.println("|        Afficher les objectifs du jour");
		jeu.afficherObjectifsPioches(numJoueur);
		List<Objectif> objectifsPioches = getObjectifsPioches(numJoueur);
		System.out.println("|        Choisir un objectif à remplir ");
		int objectifChoisi = Keyin.inInt(" Entrer le numéro de l'objectif choisi : ");
		while(objectifChoisi > objectifsPioches.size() || objectifChoisi < 1){
			System.out.println("Vous devez choisir entre la objectif 1 et "+ objectifsPioches.size());
			objectifChoisi = Keyin.inInt(" Entrer le numéro de l'objectif choisi : ");
		}
		Objectif objectif = selectionnerObjectif(objectifsPioches, objectifChoisi);
		System.out.println(" Vous avez choisi : "+objectif);

		return remplirUnObjectif(numJoueur,  objectif);
    }

    private boolean remplirUnObjectif(int numJoueur, Objectif objectif) {
        boolean estRempli = effectuerActionRemplirObjectif(numJoueur, objectif);
        if (estRempli)
            System.out.println("Félicitations! objectif rempli");
        else
            System.out.println("Objectif irréalisable pour le moment");

        return estRempli;
    }


    private Objectif prendreObjectif(PiocheObjectifs pioche, PlateauDeJoueur plateauDeJoueur){
        if (plateauDeJoueur.peutAjouterObjectif()){
            Objectif objectifPioche = pioche.piocher();
            plateauDeJoueur.ajouterObjectif(objectifPioche);
            return objectifPioche;
        }
        return null;
    }

    private Objectif selectionnerObjectif(List<Objectif> objectifsPioches, int indexObjectif){
        Objectif objSelectionne = objectifsPioches.remove(indexObjectif - 1);
        return objSelectionne;
    }

    private List<Objectif> getObjectifsPioches(int joueurIndex){
        Joueur joueur = jeu.getJoueurByIndex(joueurIndex);
        return joueur.getPlateauDeJoueur().getObjectifsPioches();
    }

    private Objectif piocherObjectif(int joueurIndex){
        Joueur joueur = jeu.getJoueurByIndex(joueurIndex);
        return prendreObjectif(jeu.getPiocheObjectifs(),joueur.getPlateauDeJoueur());
    }

    private boolean effectuerActionRemplirObjectif(int numJoueur, Objectif objectif){
        Joueur joueur = jeu.getJoueurByIndex(numJoueur);
        return joueur.remplirObjectif(objectif, jeu.getPlateauDeJeu());
    }
}
