package uqam.inf5153.game.parcelle;

import uqam.inf5153.game.plateau.Coordonnees;

import java.util.ArrayList;

public class ParcelleEtang extends Parcelle {

    public ParcelleEtang(Coordonnees coord) {
        super(coord);
        super.voisins=new ArrayList<Parcelle>();
    }

    /* Parcelle Étang n'a pas de couleur */
    @Override
    public Couleur getCouleur(){
        return null;
    }



    @Override
    public String toString(){
        return "Parcelle Étang ";
    }
}
