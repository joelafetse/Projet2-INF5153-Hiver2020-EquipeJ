package uqam.inf5153.game.objectif;

import uqam.inf5153.game.joueur.PlateauDeJoueur;
import uqam.inf5153.game.plateau.PlateauDeJeu;
import uqam.inf5153.game.tuile.parcelle.Couleur;

public class ObjectifPanda extends Objectif {

    public ObjectifPanda(int identifiant){
        super(identifiant);
    }

    public int appliquerObjectif(PlateauDeJeu plateauDeJeu){return 0;};

    @Override
    public int appliquerObjectif(PlateauDeJoueur plateauDeJoueur) {

        int[] nbrBambousPanda = plateauDeJoueur.calculerNbrBambousPanda();
        int nbrBambousVertPanda = nbrBambousPanda[0];
        int nbrBambousJaunePanda = nbrBambousPanda[1];
        int nbrBambousRosePanda = nbrBambousPanda[2];


        if(identifiant>=31 && identifiant <36){
            if (nbrBambousVertPanda >= 2) {
                plateauDeJoueur.retirerBambousPanda(Couleur.VERT);
                plateauDeJoueur.retirerBambousPanda(Couleur.VERT);
                return 3;
            }
        } else {
            if(identifiant>=36 && identifiant <40){
                if (nbrBambousJaunePanda >= 2) {
                    plateauDeJoueur.retirerBambousPanda(Couleur.JAUNE);
                    plateauDeJoueur.retirerBambousPanda(Couleur.JAUNE);
                    return 4;
                }
            } else {
                if(identifiant>=40 && identifiant <43){
                    if (nbrBambousRosePanda >= 2) {
                        plateauDeJoueur.retirerBambousPanda(Couleur.ROSE);
                        plateauDeJoueur.retirerBambousPanda(Couleur.ROSE);
                        return 5;
                    }
                } else {
                    if(identifiant>=43 && identifiant <=45){
                        if (nbrBambousVertPanda >= 1 && nbrBambousJaunePanda >= 1 && nbrBambousRosePanda >= 1){
                            plateauDeJoueur.retirerBambousPanda(Couleur.VERT);
                            plateauDeJoueur.retirerBambousPanda(Couleur.JAUNE);
                            plateauDeJoueur.retirerBambousPanda(Couleur.ROSE);
                            return 6;
                        }
                    }
                }
            }
        }
        return 0;
    }

    @Override
    public String toString() {
            if(identifiant>=31 && identifiant <36)
                return "Objectif " + identifiant + " : Deux bambous verts mangés par le panda, Points: 3";
            if(identifiant>=36 && identifiant <40)
                return "Objectif " + identifiant + " : Deux bambous jaunes mangés par le panda, Points: 4";
            if(identifiant>=40 && identifiant <43)
                return "Objectif " + identifiant + " : Deux bambous roses mangés par le panda, Points: 5";
            if(identifiant>=43 && identifiant<=45)
                return "Objectif " + identifiant + " : trois bambous de couleurs différentes mangés par le panda, Points: 6";

            return "";
    }


}

