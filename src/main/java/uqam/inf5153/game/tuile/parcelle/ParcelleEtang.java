package uqam.inf5153.game.tuile.parcelle;

import uqam.inf5153.game.bambou.Bambou;
import uqam.inf5153.game.plateau.Coordonnees;

import java.util.ArrayList;
import java.util.List;

public class ParcelleEtang extends Parcelle {

    public ParcelleEtang(Coordonnees coord) {
        super(coord);
        super.voisins=new ArrayList<Parcelle>();
    }

    /* Parcelle Étang n'a pas de couleur */
    @Override
    public Couleur getCouleur(){
        return Couleur.NONE;
    }

    /* Faire pousser de bambou sur une parcelle Étang n'est pas possible. */
    @Override
    public void fairePousserBambou() {}

    @Override
    public void prendreBambou() {}

    @Override
    public int getNbSectionsDeBambou() {
        return 0;
    }

    /* Parcelle Étang n'a pas de bambou. */
    @Override
    public int getNombreDeBambous () {
        return 0;
    }


    @Override
    public String toString(){
        return "Parcelle Étang ";
    }
}
