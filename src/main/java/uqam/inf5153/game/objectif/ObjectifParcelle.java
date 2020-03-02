package uqam.inf5153.game.objectif;

import uqam.inf5153.game.joueur.Joueur;
import uqam.inf5153.game.parcelle.Couleur;
import uqam.inf5153.game.parcelle.Parcelle;
import uqam.inf5153.game.plateau.PlateauDeJeu;

public class ObjectifParcelle extends Objectif {

    public ObjectifParcelle(int identifiant){
        super(identifiant);
    }

    @Override
    public String toString() {

        switch (identifiant){
            case 1:
                return "Objectif " + identifiant + " : Triangle vert, Points: 2";
            case 2:
                return "Objectif " + identifiant + " : Diamant vert, Points: 3";
            case 3:
                return "Objectif " + identifiant + " : Diamant jaune et rose, Points: 5";
            case 4:
                return "Objectif " + identifiant + " : Diamant rose et vert, Points: 4";
            case 5:
                return "Objectif " + identifiant + " : Diamant jaune et vert, Points: 3";
            case 6:
                return "Objectif " + identifiant + " : Ligne Jaune, Points: 3";
            case 7:
                return "Objectif " + identifiant + " : Diamant jaune, Points: 4";
            case 8:
                return "Objectif " + identifiant + " : Ligne courbé jaune, Points: 3";
            case 9:
                return "Objectif " + identifiant + " : Ligne vert, Points: 2";
            case 10:
                return "Objectif " + identifiant + " : Ligne courbé vert, Points: 2";
            case 11:
                return "Objectif " + identifiant + " : Ligne courbé rose, Points: 4";
            case 12:
                return "Objectif " + identifiant + " : Triangle rose, Points: 4";
            case 13:
                return "Objectif " + identifiant + " : Diamant rose, Points: 5";
            case 14:
                return "Objectif " + identifiant + " : Ligne rose, Points: 3";
            case 15:
                return "Objectif " + identifiant + " : Triangle jaune, Points: 3";
        }

         return " ";

    }



}
