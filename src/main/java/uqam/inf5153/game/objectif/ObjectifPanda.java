package uqam.inf5153.game.objectif;

import uqam.inf5153.game.plateau.PlateauDeJeu;

public class ObjectifPanda extends Objectif {

    //TODO Produit final
    public ObjectifPanda(int identifiant){
        super(identifiant);
    }

    @Override
    public int appliquerObjectif(PlateauDeJeu plateauDeJeu){
        return 0;
    }
}
