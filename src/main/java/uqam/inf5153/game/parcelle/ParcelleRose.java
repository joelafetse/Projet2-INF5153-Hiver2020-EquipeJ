package uqam.inf5153.game.parcelle;

import uqam.inf5153.game.plateau.Coordonnees;

public class ParcelleRose extends Parcelle {
    public ParcelleRose(Coordonnees coordonnees) {
        super(coordonnees);
    }


    @Override
    public Couleur getCouleur() {
        return Couleur.ROSE;
    }

}
