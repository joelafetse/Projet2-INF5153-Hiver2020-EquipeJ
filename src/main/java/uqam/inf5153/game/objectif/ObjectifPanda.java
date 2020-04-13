package uqam.inf5153.game.objectif;

import uqam.inf5153.game.bambou.Bambou;
import uqam.inf5153.game.joueur.Joueur;
import uqam.inf5153.game.joueur.PlateauDeJoueur;
import uqam.inf5153.game.plateau.PlateauDeJeu;
import uqam.inf5153.game.tuile.parcelle.Couleur;

public class ObjectifPanda extends Objectif {



    //private Joueur joueur= new Joueur();


    public ObjectifPanda(int identifiant){
        super(identifiant);
    }

    @Override
    public int appliquerObjectif(PlateauDeJeu plateauDeJeu){ return 0;}

    @Override
    public int appliquerObjectif(PlateauDeJoueur plateauDeJoueur) {

        int nbrBambousVertPanda = 0;
        int nbrBambousJaunePanda = 0;
        int nbrBambousRosePanda = 0;

        for (Bambou bambou : plateauDeJoueur.getBambousPanda()) {
            if (bambou.getCouleur() == Couleur.VERT){
                nbrBambousVertPanda++;
            } else if (bambou.getCouleur() == Couleur.JAUNE){
                nbrBambousJaunePanda++;
            } else if (bambou.getCouleur() == Couleur.ROSE){
                nbrBambousRosePanda++;
            }
        }
        System.out.println("test1 nbrBambousVertPanda"+nbrBambousVertPanda);
        System.out.println("test2 nbrBambousJaunePanda"+nbrBambousJaunePanda);
        System.out.println("test3 nbrBambousRosePanda"+nbrBambousRosePanda);

        switch (identifiant) {
            case 31:
                if (nbrBambousVertPanda >= 2) return 3;
                break;
            case 32:
                if (nbrBambousJaunePanda >= 2) return 4;
                break;
            case 33:
                if (nbrBambousRosePanda >= 2) return 5;
                break;
            case 34:
                if (
                    nbrBambousVertPanda >= 1 &&
                    nbrBambousJaunePanda >= 1 &&
                    nbrBambousRosePanda >= 1
                    ) return 5;
                break;
        }
        return 0;
    }


    @Override
    public String toString() {

        switch (identifiant) {
            case 31:
                return "Objectif " + identifiant + " : Deux bambous vert mangés par le panda, Points: 3";
            case 32:
                return "Objectif " + identifiant + " : Deux bambous jaune mangés par le panda, Points: 4";

            case 33:
                return "Objectif " + identifiant + " : Deux bambous rose mangés par le panda, Points: 5";

            case 34:
                return "Objectif " + identifiant + " : trois bambous de couleurs différents mangés par le panda, Points: 6";


        }
        return " ";
    }


}

