package uqam.inf5153.game.tuile.parcelle;


import java.util.ArrayList;

public class ParcelleVerte extends Parcelle {
    public ParcelleVerte() {
        this.voisins=new ArrayList<Parcelle>();

    }

    @Override
    public Couleur getCouleur() {
        return Couleur.VERT;
    }
    @Override
    public int getNombreDeBambous () {
        return super.bambous.size();
    }




}
