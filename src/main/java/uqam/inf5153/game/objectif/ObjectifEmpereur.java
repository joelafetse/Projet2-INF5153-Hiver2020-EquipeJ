package uqam.inf5153.game.objectif;

import uqam.inf5153.game.joueur.PlateauDeJoueur;
import uqam.inf5153.game.plateau.PlateauDeJeu;

public class ObjectifEmpereur extends Objectif {

    public ObjectifEmpereur(){

    }

    @Override
    public int appliquerObjectif(PlateauDeJeu plateauDeJeu){
        return 0;
    }

    @Override
    public int appliquerObjectif(PlateauDeJoueur plateauDeJoueur) {
        return 0;
    }

}
