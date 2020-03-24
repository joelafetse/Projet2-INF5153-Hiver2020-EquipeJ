package uqam.inf5153.game.tuile.parcelle;

import uqam.inf5153.game.bambou.Bambou;

import java.util.ArrayList;
import java.util.List;

public class ParcelleJaune extends Parcelle {

        public ParcelleJaune() {
                super.voisins=new ArrayList<Parcelle>();
        }

        @Override
        public Couleur getCouleur() {
            return Couleur.JAUNE;
        }


        @Override
        public int getNombreDeBambous () {
                return super.bambous.size();
        }



}
