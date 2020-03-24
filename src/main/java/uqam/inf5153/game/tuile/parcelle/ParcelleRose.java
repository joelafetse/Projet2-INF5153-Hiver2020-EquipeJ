package uqam.inf5153.game.tuile.parcelle;

import java.util.ArrayList;

public class ParcelleRose extends Parcelle {
    public ParcelleRose() {
        super.voisins=new ArrayList<Parcelle>();
    }


    @Override
    public Couleur getCouleur() {
        return Couleur.ROSE;
    }

    @Override
    public int getNombreDeBambous () {
        return super.bambous.size();
    }



}
