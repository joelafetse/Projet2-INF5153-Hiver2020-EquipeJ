package uqam.inf5153.game.objectif;

import uqam.inf5153.game.plateau.PlateauDeJeu;

public class ObjectifJardinier extends Objectif {

    //TODO Produit final
    public ObjectifJardinier(int identifiant){
        super(identifiant);
    }

    @Override
    public int appliquerObjectif(PlateauDeJeu plateauDeJeu){
        return 0;
    }
}
