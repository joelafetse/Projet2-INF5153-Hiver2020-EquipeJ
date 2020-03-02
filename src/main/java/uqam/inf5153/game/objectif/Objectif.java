package uqam.inf5153.game.objectif;

import uqam.inf5153.game.parcelle.Couleur;
import uqam.inf5153.game.parcelle.Parcelle;
import uqam.inf5153.game.plateau.PlateauDeJeu;

public abstract class Objectif {

    protected int identifiant;

    public Objectif(){}
    public Objectif(int  identifiant){
        this.identifiant= identifiant;
    }

    //retourne le nombre de points de l'objectifs.
    public abstract int appliquerObjectif(PlateauDeJeu plateauDeJeu);


}
