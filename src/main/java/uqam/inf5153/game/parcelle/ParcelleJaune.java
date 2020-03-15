package uqam.inf5153.game.parcelle;

import uqam.inf5153.game.plateau.Coordonnees;

import java.util.ArrayList;

public class ParcelleJaune extends Parcelle {

        public ParcelleJaune() {
                super.voisins=new ArrayList<Parcelle>();
        }

        @Override
        public Couleur getCouleur() {
            return Couleur.JAUNE;
        }



}
