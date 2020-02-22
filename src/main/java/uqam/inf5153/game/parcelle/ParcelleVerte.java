package uqam.inf5153.game.parcelle;

import uqam.inf5153.game.plateau.Coordonnees;

public class ParcelleVerte extends Parcelle {
    public ParcelleVerte(Coordonnees coordonnees) {
        super(coordonnees);
    }

    @Override
    public Couleur getCouleur() {
        return Couleur.VERT;
    }

}
