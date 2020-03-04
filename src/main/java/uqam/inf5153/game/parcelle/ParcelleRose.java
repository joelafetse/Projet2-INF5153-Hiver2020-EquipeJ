package uqam.inf5153.game.parcelle;

import uqam.inf5153.game.plateau.Coordonnees;

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
    public int getParcelleId() {
        return parcelleId;
    }

}
