package uqam.inf5153.game.parcelle;

import uqam.inf5153.game.plateau.Coordonnees;

public class ParcelleJaune extends Parcelle {

        public ParcelleJaune(Coordonnees coordonnees) {
            super(coordonnees);
        }

        @Override
        public Couleur getCouleur() {
            return Couleur.JAUNE;
        }

}
