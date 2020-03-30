package uqam.inf5153.game.tuile.parcelle;


import uqam.inf5153.game.bambou.Bambou;
import uqam.inf5153.game.bambou.BambouVert;

import java.util.ArrayList;
import java.util.List;

public class ParcelleVerte extends Parcelle {

    private final static int NB_SECTIONS_DE_BAMBOU_VERT = 36;
    private static int nbr_sections_bambou_vert = NB_SECTIONS_DE_BAMBOU_VERT;

    public ParcelleVerte() {
        this.voisins=new ArrayList<Parcelle>();
    }

    public void prendreBambou(){
        this.nbr_sections_bambou_vert--;
    }
    public int getNbSectionsDeBambou () {
        return nbr_sections_bambou_vert;
    }

    @Override
    public Couleur getCouleur() {
        return Couleur.VERT;
    }

    @Override
    public void fairePousserBambou() {
       if (this.irriguee) {
           if(nbr_sections_bambou_vert > 0 && bambous.size() < 4 ) {
               //super.bambous.add(new BambouVert());
               super.bambous.push(new BambouVert());
               prendreBambou();
           }
       }
    }

    @Override
    public int getNombreDeBambous () {
        return super.bambous.size();
    }



}
