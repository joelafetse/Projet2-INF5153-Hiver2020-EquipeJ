package uqam.inf5153.game.parcelle;

import uqam.inf5153.game.plateau.Coordonnees;

public class ParcelleEtang extends Parcelle {
    public ParcelleEtang(Coordonnees coordonnees) {
        super(coordonnees);
    }

    /* Parcelle Étang n'a pas de couleur */
    @Override
    public Couleur getCouleur(){
        return null;
    }
}